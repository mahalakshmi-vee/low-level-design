package com.practice.library_management_system;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	private int id;
	private String name;
	private List<Book> borrowedBooks;

	public User(int id, String name) {
		this.id = id;
		this.name = name;
		borrowedBooks = new ArrayList<>();
	}

	public void printBorrowedBooks() {
		System.out.println(name + " borrowed books are as follow:");
		for (Book book : borrowedBooks) {
			System.out.println(book.getTitle());
		}
	}

	public void addBorrowedBook(Book book) {
		borrowedBooks.add(book);
	}

	public void removeBorrowedBook(Book book) {
		borrowedBooks.remove(book);
	}
}
