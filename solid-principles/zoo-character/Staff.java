package zooCharacter;

public abstract class Staff extends ZooCharacter {
	private String designation;
	private double salary;

	public Staff(String name) {
		super(name);
	}

	public abstract void cleanPremises();

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
