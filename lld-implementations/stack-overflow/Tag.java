package com.practice.stack_overflow_system;

import lombok.Getter;

@Getter
public class Tag {
	private long id;
	private String name;

	public Tag(String name) {
		id = IdGenerator.generateId();
		this.name = name;
	}
}
