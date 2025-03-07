package com.practice.pub_sub_system;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PrintSubscriber implements Subscriber {
	private final String name;

	@Override
	public void onMessage(Message message) {
		System.out.println("Subscriber " + name + " received message: " + message.getContent());
	}

}
