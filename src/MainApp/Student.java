package MainApp;

import java.util.ArrayList;

public class Student extends User {
	
	private String firstName;
	private String lastNane;
	
	private String email;
	
	private ArrayList<Group> groups = new ArrayList<>();
	
	
	public Student(String Login, String password, String FirstName, String LastName, String email) {
		super(Login, password);
		firstName = FirstName;
		lastNane = LastName;
		setEmail(email);
	}
	
	// sprawdzenie czy podany email jest emailem
	private void setEmail(String Email) {
	
	}
	
	// nw czy jest sens to dzielic, moze?
	private void setName (String FirstName, String LastNane) {
	
	}
}
