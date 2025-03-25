package com.practice.library_management_system;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Book {
	private int id;
	private String title;
	private List<String> authors;
	private List<String> publishers;
	private int bookCopyId;
	private boolean borrowed;

	@Override
	public String toString() {
		return "[" + this.title + "], [" + bookCopyId + "], [Available: " + (borrowed ? "Y" : "N") + "]";
	}
}
