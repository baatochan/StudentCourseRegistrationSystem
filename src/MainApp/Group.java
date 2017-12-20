package MainApp;

import java.util.ArrayList;

public class Group {
	private String name;
	private String groupID;
	private String lecturer;
	private String place;

	private int slots;

	private ArrayList<Student> students;

	public Group(String name, String groupID, String lecturer, String place, int slots) {
		this.name = name;
		this.groupID = groupID;
		this.lecturer = lecturer;
		this.place = place;
		this.slots = slots;
		this.students = new ArrayList<>();
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}

	public void setSlots(int slots) {
		this.slots = slots;
	}

	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}

	public void setPlace(String place) {
		this.place = place;
	}
}
