package MainApp;

import java.util.ArrayList;

public class Student extends User {
	
	private String firstName;
	private String lastNane;
	
	private String email;
	
	private ArrayList<Group> groups = new ArrayList<>();
	
	
	public Student(String login, String password, String firstName, String lastName, String email) {
		super(login, password);
		this.firstName = firstName;
		this.lastNane = lastName;
		setEmail(email);
	}
	
	// sprawdzenie czy podany email jest emailem
	private void setEmail(String Email) {
	
	}
	
	// nw czy jest sens to dzielic, moze?
	private void setName (String FirstName, String LastNane) {
	
	}


}
