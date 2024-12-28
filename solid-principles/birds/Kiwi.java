package birds;

/*
 * Kiwi bird will not fly and this class is not forced to provide implementation for the fly method.
 * This class follows Interface Segmentation principle.
 * 
 * In the future, when you call the fly method by using the instance of the bird type you 
 * can simply check whether this object is also a instance of Flyable or not.
 * This class follows Liskov Substitution principle.
 */
public class Kiwi extends Bird {

	public Kiwi(String name) {
		super(name);
	}

	@Override
	public void eat() {
		System.out.println("Eat function in Kiwi class");
	}

}
