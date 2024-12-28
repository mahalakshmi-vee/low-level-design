package factory;

import button.IButton;
import textbox.ITextBox;

public interface IFactory {
	IButton createButton();

	ITextBox createTextBox();
}
