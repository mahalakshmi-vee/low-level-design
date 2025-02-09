package com.practice.stack_overflow_system;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostEntity {
	private long id;
	private User author;
	private LocalDateTime createdDateTime;
	private String content;

	public PostEntity(User author, String content) {
		this.id = IdGenerator.generateId();
		this.author = author;
		this.content = content;
		createdDateTime = LocalDateTime.now();
	}
}
