package com.practice.library_management_system;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class LibraryManagementSystem {
	private static volatile LibraryManagementSystem instance;
	private Map<Integer, User> users;
	private Map<Integer, BookRack> bookRacks;
	private Map<Integer, Book> books;
	private Map<Integer, BookRack> bookRackMap;
	private Queue<Integer> availableRacks;
	private Map<String, List<Book>> titleIndex;
	private Map<String, List<Book>> authorIndex;
	private Map<Integer, LibraryTransaction> borrowTransactions;
	private Map<Integer, LibraryTransaction> returnTransactions;
	private ReentrantLock lock = new ReentrantLock();
	private AtomicInteger libraryTransactionId = new AtomicInteger(0);
	private final int maxDaysToHoldABook = 5;

	private LibraryManagementSystem() {
		users = new ConcurrentHashMap<>();
		bookRacks = new ConcurrentHashMap<>();
		books = new ConcurrentHashMap<>();
		bookRackMap = new ConcurrentHashMap<>();
		availableRacks = new ConcurrentLinkedDeque<>();
		titleIndex = new ConcurrentHashMap<>();
		authorIndex = new ConcurrentHashMap<>();
		borrowTransactions = new ConcurrentHashMap<>();
		returnTransactions = new ConcurrentHashMap<>();
		initializeBookRacks();
	}

	public static LibraryManagementSystem getInstance() {
		if (instance == null) {
			synchronized (LibraryManagementSystem.class) {
				if (instance == null)
					instance = new LibraryManagementSystem();
			}
		}
		return instance;
	}

	public void addUser(User user) {
		users.put(user.getId(), user);
	}

	public void removeUser(int userId) {
		users.remove(userId);
	}

	public void updateUser(User user) {
		users.put(user.getId(), user);
	}

	public User getUser(int userId) {
		return users.get(userId);
	}

	private void initializeBookRacks() {
		int numOfRacks = 10;
		for (int i = 1; i <= numOfRacks; i++) {
			BookRack bookRack = new BookRack(i);
			bookRack.setBookAvailable(false);
			availableRacks.add(bookRack.getRackid());
			bookRacks.put(bookRack.getRackid(), bookRack);
		}
	}

	public void addBook(Book book) {
		int bookAddedRackId = addToRack(book);
		if (bookAddedRackId == -1) {
			return;
		}
		books.put(book.getBookCopyId(), book);
		String titleIndexKey = book.getTitle().toLowerCase();
		titleIndex.put(titleIndexKey, titleIndex.getOrDefault(titleIndexKey, new ArrayList<>()));
		titleIndex.get(titleIndexKey).add(book);
	}

	public void removeBook(Book book) {
		removeFromRack(book);
		books.remove(book.getBookCopyId());
		String titleIndexKey = book.getTitle().toLowerCase();
		List<Book> listBook = titleIndex.get(titleIndexKey);
		listBook.remove(book);
		if (listBook.isEmpty()) {
			titleIndex.remove(titleIndexKey);
		}
		for (String author : book.getAuthors()) {
			String authorIndexKey = author.toLowerCase();
			listBook = authorIndex.get(authorIndexKey);
			listBook.remove(book);
			if (listBook.isEmpty())
				authorIndex.remove(authorIndexKey);
		}
	}

	public Book getBook(int bookCopyId) {

		return books.get(bookCopyId);
	}

	public List<Book> searchBooks(String title, String author) {
		List<Book> titleResults = titleIndex.get(title.toLowerCase());
		List<Book> authorResults = authorIndex.get(author.toLowerCase());

		List<Book> results = new ArrayList<>();
		if (titleResults != null)
			results.addAll(titleResults);
		if (authorResults != null)
			results.addAll(authorResults);
		return results;
	}

	private int addToRack(Book book) {
		Integer firstAvailableRack = availableRacks.poll();
		if (firstAvailableRack == null) {
			System.out.println("There are no available racks to add books");
			return -1;
		}
		BookRack bookRack = bookRacks.get(firstAvailableRack);
		bookRack.setBook(book);
		bookRack.setBookAvailable(true);
		bookRackMap.put(book.getBookCopyId(), bookRack);
		return bookRack.getRackid();
	}

	private boolean removeFromRack(Book book) {
		BookRack bookRack = bookRacks.get(book.getBookCopyId());
		bookRack.setBook(null);
		bookRack.setBookAvailable(false);
		availableRacks.offer(bookRack.getRackid());
		bookRackMap.remove(book.getBookCopyId());
		return true;
	}

	public void borrowBook(User user, int bookCopyId) {
		lock.lock();
		try {
			LibraryTransaction libraryTransaction = createTransaction(TransactionType.BORROW, user, bookCopyId);
			borrowTransactions.put(libraryTransaction.getTransactionId(), libraryTransaction);
			libraryTransaction.setDueDate(LocalDate.now().plusDays(maxDaysToHoldABook));
			Book bookToBorrow = books.get(bookCopyId);
			if (bookToBorrow.isBorrowed()) {
				System.out.println(bookToBorrow.getTitle() + " is already borrowed and not available in the library");
				return;
			}
			bookToBorrow.setBorrowed(true);
			removeFromRack(bookToBorrow);
			user.addBorrowedBook(bookToBorrow);
			user.printBorrowedBooks();
		} finally {
			lock.unlock();
		}
	}

	public void returnBook(User user, int bookCopyId) {
		Book bookToReturn = books.get(bookCopyId);
		lock.lock();
		try {
			LibraryTransaction libraryTransaction = createTransaction(TransactionType.RETURN, user, bookCopyId);
			returnTransactions.put(libraryTransaction.getTransactionId(), libraryTransaction);
			libraryTransaction.setReturnDate(LocalDate.now());

			bookToReturn.setBorrowed(false);
			addToRack(bookToReturn);
			user.removeBorrowedBook(bookToReturn);
			user.printBorrowedBooks();
		} finally {
			lock.unlock();
		}
	}

	private LibraryTransaction createTransaction(TransactionType transactionType, User user, int bookCopyId) {
		Book book = books.get(bookCopyId);
		LibraryTransaction libraryTransaction = new LibraryTransaction();
		libraryTransaction.setTransactionId(libraryTransactionId.incrementAndGet());
		libraryTransaction.setTransactionType(transactionType);
		libraryTransaction.setUser(user);
		libraryTransaction.setBook(book);
		return libraryTransaction;
	}
}
