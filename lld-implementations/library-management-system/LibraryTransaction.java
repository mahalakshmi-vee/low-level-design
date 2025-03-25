package com.practice.library_management_system;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LibraryTransaction {
	private int transactionId;
	private TransactionType transactionType;
	private Book book;
	private LocalDate dueDate; // the date in which the user should return the book.
	private LocalDate returnDate;
	private User user;
}
