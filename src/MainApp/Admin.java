package MainApp;

public class Admin extends User {

	private String firstName;
	private String lastName;
	
	public Admin (String login, String password, String firstName, String lastName) {
		super(login, password);
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public static boolean exists(String username) {
		for (Admin admin : Main.admins) {
			if (username.equals(admin.getLogin())) return true;
		}
		return false;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
