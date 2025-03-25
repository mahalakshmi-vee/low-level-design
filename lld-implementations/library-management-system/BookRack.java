package com.practice.library_management_system;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRack {
	private int rackid;
	private Book book;
	private boolean bookAvailable;

	public BookRack(int id) {
		rackid = id;
	}
}
