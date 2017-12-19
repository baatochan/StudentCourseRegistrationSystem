package MainApp;

import java.util.ArrayList;

public class Course {

	private String name;
	private String courseID;

	private ArrayList<Group> groups;

	public Course (String name, String courseID) {
		this.name = name;
		this.courseID = courseID;
		this.groups = new ArrayList<>();
	}

}
