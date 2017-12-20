package MainApp;

import java.util.ArrayList;

public class Student extends User {
	
	private String firstName;
	private String lastName;
	
	private String email;
	
	private ArrayList<Group> groups = new ArrayList<>();
	
	
	public Student(String login, String password, String firstName, String lastName, String email) {
		super(login, password);
		this.firstName = firstName;
		this.lastName = lastName;
		setEmail(email);
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


}
