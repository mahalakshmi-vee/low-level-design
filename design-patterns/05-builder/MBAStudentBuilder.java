package withBuilderPattern;

import java.util.ArrayList;
import java.util.List;

public class MBAStudentBuilder extends StudentBuilder {

	@Override
	public StudentBuilder setSubjects() {
		List<String> subjects = new ArrayList<String>();
		subjects.add("Micro Economics");
		subjects.add("Business Studies");
		subjects.add("Operations Management");
		this.setSubjects(subjects);
		return this;
	}
}
