package com.practice.pub_sub_system;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import lombok.Getter;

@Getter
public class Topic {
	private String topicName;
	private Set<Subscriber> subscribers;

	public Topic(String topicName) {
		this.topicName = topicName;
		subscribers = new CopyOnWriteArraySet<>();
	}

	public void addSubscriber(Subscriber subscriber) {
		subscribers.add(subscriber);
	}

	public void removeSubscriber(Subscriber subscriber) {
		subscribers.remove(subscriber);
	}

	public void publish(Message message) {
		for (Subscriber subscriber : subscribers) {
			subscriber.onMessage(message);
		}
	}
}
