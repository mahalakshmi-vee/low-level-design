package birds;

public class Peacock extends Bird implements Flyable {

	public Peacock(String name) {
		super(name);
	}

	@Override
	public void eat() {
		System.out.println("Eat function in Peacock class");
	}

	@Override
	public void fly() {
		System.out.println("Fly function in Peacock class");
	}

}
