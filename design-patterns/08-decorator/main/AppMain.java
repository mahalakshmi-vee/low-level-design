package main;

import component.EmailNotifier;
import component.Notifier;
import decorator.FacebookNotifierDecorator;
import decorator.SMSNotifierDecorator;

public class AppMain {
	public static void main(String[] args) {
		Notifier baseNotifier = new EmailNotifier("user@gmail.com");
		
		// Send only Email
		// baseNotifier.send("Hello, you have a new message!");
		
		// Send Email + SMS
		//baseNotifier = new SMSNotifierDecorator(baseNotifier, "1234567890");
		//baseNotifier.send("Hello, you have a new message!");
		
		// Send Email + Facebook
		//baseNotifier = new FacebookNotifierDecorator(baseNotifier, "user-fb-id");
		//baseNotifier.send("Hello, you have a new message!");
		
		// Send Email + SMS + Facebook
		baseNotifier = new SMSNotifierDecorator(baseNotifier, "1234567890");
		baseNotifier = new FacebookNotifierDecorator(baseNotifier, "user-fb-id");
		baseNotifier.send("Hello, You have a new message!");
	}
}
