package withBuilderPattern;

import java.util.ArrayList;
import java.util.List;

// We can also extend the StudentBuilder to build more different type of studetBuilder objects.
public class EngineeringStudentBuilder extends StudentBuilder {

	@Override
	public StudentBuilder setSubjects() {
		List<String> subjects = new ArrayList<String>();
		subjects.add("DSA");
		subjects.add("OS");
		subjects.add("Computer Architecture");
		this.setSubjects(subjects);
		return this;
	}
}
