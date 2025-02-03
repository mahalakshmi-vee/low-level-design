package decorator;

import component.Notifier;

public class FacebookNotifierDecorator extends NotifierDecorator {
	private String facebookId;

	public FacebookNotifierDecorator(Notifier notifier, String facebookId) {
		super(notifier);
		this.facebookId = facebookId;
	}

	@Override
	public void send(String message) {
		super.send(message);
		System.out.println("Sent Facebook to the facebook-id: " + facebookId + " with the message: " + message);
	}
}
