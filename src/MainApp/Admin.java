package MainApp;

public class Admin extends User {

	private String firstName;
	private String lastNane;
	
	public Admin (String login, String password, String firstName, String lastName) {
		super(login, password);
		this.firstName = firstName;
		this.lastNane = lastName;
	}
}
