package pac;

public class Singleton {
	// Step1: We have created a private constructor of Singleton class & it can only
	// be instantiated within this class.
	private Singleton() {

	}

	// Step2: Create static variable to hold one instance of Singleton class.
	private static Singleton instance;

	// Step3: Create a static getInstance() method to instantiate this class & also
	// return an instance of it.
	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}

		return instance;
	}
}
