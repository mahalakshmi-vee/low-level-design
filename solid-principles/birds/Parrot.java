package birds;

public class Parrot extends Bird implements Flyable {

	public Parrot(String name) {
		super(name);
	}

	@Override
	public void eat() {
		System.out.println("Eat function in Parrot class");
	}

	@Override
	public void fly() {
		System.out.println("Fly function in Parrot class");
	}

}
