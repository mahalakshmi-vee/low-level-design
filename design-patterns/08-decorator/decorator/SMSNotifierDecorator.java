package decorator;

import component.Notifier;

public class SMSNotifierDecorator extends NotifierDecorator {
	private String mobileNumber;

	public SMSNotifierDecorator(Notifier notifier, String mobileNumber) {
		super(notifier);
		this.mobileNumber = mobileNumber;
	}

	@Override
	public void send(String message) {
		super.send(message);
		System.out.println("Sent SMS to the mobile number: " + mobileNumber + " with the message: " + message);
	}
}
