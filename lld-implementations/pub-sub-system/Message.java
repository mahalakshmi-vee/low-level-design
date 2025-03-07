package com.practice.pub_sub_system;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class Message {
	private String title;
	private String content;
	private LocalDateTime createdDateTime;

	public Message(String title, String content) {
		this.title = title;
		this.content = content;
		createdDateTime = LocalDateTime.now();
	}

}
