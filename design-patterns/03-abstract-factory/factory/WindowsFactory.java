package factory;

import button.IButton;
import button.WindowsButton;
import textbox.ITextBox;
import textbox.WindowsTextBox;

public class WindowsFactory implements IFactory {
	@Override
	public IButton createButton() {

		return new WindowsButton();
	}

	@Override
	public ITextBox createTextBox() {

		return new WindowsTextBox();
	}
}
