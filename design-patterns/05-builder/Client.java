package withBuilderPattern;

public class Client {
	public static void main(String[] args) {
		StudentDirector directorObject1 = new StudentDirector(new EngineeringStudentBuilder());
		StudentDirector directorObject2 = new StudentDirector(new MBAStudentBuilder());

		Student engineeringStudent = directorObject1.createStudent();
		Student mBAStudent = directorObject2.createStudent();

		System.out.println(engineeringStudent.toString());

		System.out.println(mBAStudent.toString());
	}
}
