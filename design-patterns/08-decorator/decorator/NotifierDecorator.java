package decorator;

import component.Notifier;

public abstract class NotifierDecorator implements Notifier {
	private Notifier decoratedNotifier;

	public NotifierDecorator(Notifier notifier) {
		decoratedNotifier = notifier;
	}

	@Override
	public void send(String message) {
		decoratedNotifier.send(message);
	}
}
