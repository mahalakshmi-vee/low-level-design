package withBuilderPattern;

import java.util.List;

public class Student {
	private int rollNumber;
	private int age;
	private String name;
	private String fatherName;
	private String motherName;
	private List<String> subjects;
	private String mobileNumber;

	public Student(StudentBuilder studentBuilder) {
		this.rollNumber = studentBuilder.getRollNumber();
		this.age = studentBuilder.getAge();
		this.name = studentBuilder.getName();
		this.fatherName = studentBuilder.getFatherName();
		this.motherName = studentBuilder.getMotherName();
		this.subjects = studentBuilder.getSubjects();
		this.mobileNumber = studentBuilder.getMobileNumber();
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public List<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {

		return "[" + this.rollNumber + "]" + " [" + this.name + "]";
	}
}
