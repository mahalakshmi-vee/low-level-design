package factory;

public class GUIFactory {
	public static IFactory getFactory(String osType) throws Exception {
		if (osType.equalsIgnoreCase("windows")) {
			return new WindowsFactory();
		} else if (osType.equalsIgnoreCase("mac")) {
			return new MacFactory();
		} else {
			throw new Exception("Please pass the valid osType parameter value");
		}
	}
}
