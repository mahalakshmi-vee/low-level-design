package withPrototypePattern;

public class Client {
	public static void main(String[] args) {
		Student studentOrigial = new Student(22, 1, "sj");

		Student studentCopy = (Student) studentOrigial.clone();

		System.out.println("studentOriginal hashcode is " + studentOrigial.hashCode());
		System.out.println("studentCopy hashcode is " + studentCopy.hashCode());

		System.out.println(studentOrigial.toString());
		System.out.println(studentCopy.toString());

//		The problems are:
//		1. What if the Student class has more number of fields? It will be harder to build the copy of the existing object.
//		2. What if some of the variables are private and also you don't have public getter methods available to get the value to create the clone object? 
//		You will fail to create the complete correct clone object.

//		Requirement:
//		In some cases, we need to create the same copy of the existing object and make a clone of it on top of that existing object.
//		In this situation, we need a good way to make the cloned object.

//		In order to address these above problems and to give a solution to the above requirement, we will need to use Prototype Design Pattern.
	}
}
