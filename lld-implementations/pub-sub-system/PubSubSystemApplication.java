package com.practice.pub_sub_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PubSubSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PubSubSystemApplication.class, args);

		Topic topic1 = new Topic("Topic 1");
		Topic topic2 = new Topic("Topic 2");

		Subscriber subscriber1 = new PrintSubscriber("Subscriber 1");
		Subscriber subscriber2 = new PrintSubscriber("Subscriber 2");

		topic1.addSubscriber(subscriber1);
		topic2.addSubscriber(subscriber1);
		
		topic2.addSubscriber(subscriber2);

		Publisher publisher1 = new Publisher("Publisher 1", topic2,
				new Message("Message Title 1", "Message Content 1"));
		publisher1.publish();
	}

}
