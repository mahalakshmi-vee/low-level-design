package withPrototypePattern;

public class Student implements IPrototype {
	private int age;
	private int rollNumber;
	private String name;

	public Student() {

	}

	public Student(int age, int rollNumber, String name) {
		this.age = age;
		this.rollNumber = rollNumber;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "[" + this.age + "] [" + this.rollNumber + "] [" + this.name + "]";
	}

	@Override
	public IPrototype clone() {
//		return (Student) super.clone();
		return new Student(age, rollNumber, name);
	}
}
