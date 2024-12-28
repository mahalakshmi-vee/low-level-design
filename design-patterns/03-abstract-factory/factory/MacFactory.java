package factory;

import button.IButton;
import button.MacButton;
import textbox.ITextBox;
import textbox.MacTextBox;

public class MacFactory implements IFactory {
	@Override
	public IButton createButton() {

		return new MacButton();
	}

	@Override
	public ITextBox createTextBox() {

		return new MacTextBox();
	}
}
