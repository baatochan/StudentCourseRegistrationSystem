package MainApp;

import java.io.Serializable;
import java.util.ArrayList;

public class Group implements Serializable {
	private String name;
	private String groupID;
	private String lecturer;
	private String place;

	private Course course;

	private int slots;

	private ArrayList<Student> students;

	Group(String name, String groupID, String lecturer, String place, int slots, Course course) {
		this.name = name;
		this.groupID = groupID;
		this.lecturer = lecturer;
		this.place = place;
		this.slots = slots;
		this.course = course;
		this.students = new ArrayList<>();
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public void setSlots(int slots) {
		this.slots = slots;
	}

	public String getGroupID() {
		return groupID;
	}

	public Course getCourse() {
		return course;
	}

	public static boolean exists(String groupID) {
		for (Group group : Main.groups) {
			if (groupID.equals(group.getGroupID())) return true;
		}
		return false;
	}

	public boolean checkFreeSlots() {
		return slots > students.size();
	}

	public void addStudent(Student student) {
		students.add(student);
	}

	public void removeStudent(Student student) {
		students.remove(student);
	}

	public static void printHeader() {
		System.out.println("  ID   |           Nazwa            |       Prowadzacy        |  Sala   |Miejsca");
	}

	public String print(){
		StringBuilder output = new StringBuilder();
		output.append(groupID);
		for (int i = 0; i<(7-groupID.length()); i++) {
			output.append(" ");
		}
		output.append("|");
		output.append(name);
		for (int i = 0; i<(28-name.length()); i++) {
			output.append(" ");
		}
		output.append("|");
		output.append(lecturer);
		for (int i = 0; i<(25-lecturer.length()); i++) {
			output.append(" ");
		}
		output.append("|");
		output.append(place);
		for (int i = 0; i<(9-place.length()); i++) {
			output.append(" ");
		}
		output.append("|");
		output.append(students.size());
		output.append("/");
		output.append(slots);
		return output.toString();
	}
}
