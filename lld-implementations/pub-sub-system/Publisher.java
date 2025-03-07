package com.practice.pub_sub_system;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Publisher {
	private final String name;
	private final Topic topic;
	private final Message message;

	public void publish() {
		topic.publish(message);
	}

}
