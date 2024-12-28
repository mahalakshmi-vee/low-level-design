package withBuilderPattern;

import java.util.List;

public abstract class StudentBuilder {
	private int rollNumber;
	private int age;
	private String name;
	private String fatherName;
	private String motherName;
	private List<String> subjects;
	private String mobileNumber;

	public int getRollNumber() {
		return rollNumber;
	}

	public StudentBuilder setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
		return this;
	}

	public int getAge() {
		return age;
	}

	public StudentBuilder setAge(int age) {
		this.age = age;
		return this;
	}

	public String getName() {
		return name;
	}

	public StudentBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public String getFatherName() {
		return fatherName;
	}

	public StudentBuilder setFatherName(String fatherName) {
		this.fatherName = fatherName;
		return this;
	}

	public String getMotherName() {
		return motherName;
	}

	public StudentBuilder setMotherName(String motherName) {
		this.motherName = motherName;
		return this;
	}

	public List<String> getSubjects() {
		return subjects;
	}

	public StudentBuilder setSubjects(List<String> subjects) {
		this.subjects = subjects;
		return this;
	}
	
	public abstract StudentBuilder setSubjects();

	public String getMobileNumber() {
		return mobileNumber;
	}

	public StudentBuilder setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
		return this;
	}

	public Student build() {
		return new Student(this);
	}
}
