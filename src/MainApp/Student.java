package MainApp;

import java.util.ArrayList;

public class Student extends User {
	
	private String firstName;
	private String lastName;
	
	private String email;
	
	private ArrayList<Group> groups;
	
	
	public Student(String login, String password, String firstName, String lastName, String email) {
		super(login, password);
		this.firstName = firstName;
		this.lastName = lastName;
		setEmail(email);
		groups = new ArrayList<>();
	}
	
	// TODO: sprawdzenie czy podany email jest emailem
	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String firstName) {
		this.firstName = firstName;
	}

	public static boolean exists(String username) {
		for (Student student : Main.students) {
			if (username.equals(student.getLogin())) return true;
		}
		return false;
	}

	public boolean checkIfAddedToAnotherGroupOfThisCourse(Course course) {
		for (Group group : groups) {
			if (course == group.getCourse()) return true;
		}
		return false;
	}

	public boolean checkIfMemberOfGroup(Group g){
		for (Group group : groups) {
			if (g == group) return true;
		}
		return false;
	}

	public void addGroup(Group group) {
		groups.add(group);
	}

	public void removeGroup(Group group) {
		groups.remove(group);
	}

	public ArrayList<Group> getGroups() {
		return groups;
	}

}
