package MainApp;

import java.io.Serializable;
import java.util.ArrayList;

public class Student extends User implements Serializable {
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
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// TODO: sprawdzenie czy podany email jest emailem
	public void setEmail(String email) {
		this.email = email;
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

	public boolean checkIfNotMemberOfGroup(Group g){
		for (Group group : groups) {
			if (g == group) return false;
		}
		return true;
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

	public static void printHeader() {
		System.out.println("Indeks|       Imie        |     Nazwisko      |            E-mail");
	}

	public String print(){
		StringBuilder output = new StringBuilder();
		output.append(getLogin());
		for (int i = 0; i<(6-getLogin().length()); i++) {
			output.append(" ");
		}
		output.append("|");
		output.append(firstName);
		for (int i = 0; i<(19-firstName.length()); i++) {
			output.append(" ");
		}
		output.append("|");
		output.append(lastName);
		for (int i = 0; i<(19-lastName.length()); i++) {
			output.append(" ");
		}
		output.append("|");
		output.append(email);
		for (int i = 0; i<(30-email.length()); i++) {
			output.append(" ");
		}
		return output.toString();
	}
}
