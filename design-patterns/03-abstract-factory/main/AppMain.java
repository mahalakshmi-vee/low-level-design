package main;

import button.IButton;
import factory.GUIFactory;
import factory.IFactory;
import textbox.ITextBox;

public class AppMain {
	public static void main(String[] args) {
		String osType = "mac";
		try {
			IFactory iFactory = GUIFactory.getFactory(osType);
			IButton iButton = iFactory.createButton();
			ITextBox iTextBox = iFactory.createTextBox();
			iButton.pressButton();
			iTextBox.showTextBox();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
