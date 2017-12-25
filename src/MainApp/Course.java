package MainApp;

import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable {

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

	public void setECTS(int ECTS) {
		this.ECTS = ECTS;
	}

	public String getCourseID() {
		return courseID;
	}

	public static boolean exists(String courseID) {
		for (Course course : Main.courses) {
			if (courseID.equals(course.getCourseID())) return true;
		}
		return false;
	}

	public void addGroup(Group group) {
		groups.add(group);
	}

	public void removeGroup(Group group) {
		groups.remove(group);
	}

	public String print(){
		StringBuilder output = new StringBuilder();
		output.append(courseID);
		for (int i = 0; i<(10-courseID.length()); i++) {
			output.append(" ");
		}
		output.append("|");
		output.append(name);
		for (int i = 0; i<(57-name.length()); i++) {
			output.append(" ");
		}
		output.append("|");
		String ECTSString = Integer.toString(ECTS);
		output.append(ECTSString);
		for (int i = 0; i<(4-ECTSString.length()); i++) {
			output.append(" ");
		}
		output.append("|");
		output.append(groups.size());
		return output.toString();
	}

	public static void printHeader() {
		System.out.println("    ID    |                          Nazwa                          |ECTS|Il.gr.");
	}

}
