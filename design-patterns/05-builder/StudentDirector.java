package withBuilderPattern;

// Creating Director class is optional and the Student object can be created through StudentBuilder from the client code as well.
public class StudentDirector {
	private StudentBuilder studentBuilder;

	public StudentDirector(StudentBuilder studentBuilder) {
		this.studentBuilder = studentBuilder;
	}

	public Student createStudent() {
		if (studentBuilder instanceof EngineeringStudentBuilder) {
			return createEngineeringStudent();
		} else if (studentBuilder instanceof MBAStudentBuilder) {
			return createMBAStudent();
		}
		return null;
	}

	private Student createEngineeringStudent() {
		return studentBuilder.setRollNumber(1).setAge(22).setName("sj").setSubjects().build();
	}

	private Student createMBAStudent() {
		return studentBuilder.setRollNumber(2).setAge(24).setName("sj").setFatherName("MyFatherName")
				.setMotherName("MyMotherName").setSubjects().setMobileNumber("1234567890").build();
	}
}
