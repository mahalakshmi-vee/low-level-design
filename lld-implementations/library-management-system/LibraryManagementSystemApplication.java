package com.practice.library_management_system;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryManagementSystemApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(LibraryManagementSystemApplication.class, args);

			LibraryManagementSystem library = LibraryManagementSystem.getInstance();

			User debina = new User(1, "Debina");
			User maha = new User(2, "Maha");
			library.addUser(debina);
			library.addUser(maha);

			Book book1 = new Book(1, "Book 1 Title", Arrays.asList("Book 1 Author 1", "Book 1 Author 2"),
					Arrays.asList("Book 1 Publisher 1", "Book 1 Publisher 2"), 1, false);
			Book book2 = new Book(2, "Book 2 Title", Arrays.asList("Book 2 Author 1", "Book 2 Author 2"),
					Arrays.asList("Book 2 Publisher 1", "Book 2 Publisher 2"), 2, false);
			library.addBook(book1);
			library.addBook(book2);

			library.borrowBook(debina, 1);
			library.borrowBook(debina, 2);
			library.borrowBook(maha, 1);
			library.returnBook(debina, 1);
			library.borrowBook(maha, 1);
			library.borrowBook(debina, 2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
