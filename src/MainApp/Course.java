package MainApp;

import java.util.ArrayList;

public class Course {

	private String name;
	private String courseID;
	private int ECTS;

	private ArrayList<Group> groups;

	public Course (String name, String courseID, int ECTS) {
		this.name = name;
		this.courseID = courseID;
		this.ECTS = ECTS;
		this.groups = new ArrayList<>();
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public void setECTS(int ECTS) {
		this.ECTS = ECTS;
	}
}
