package MainApp;

import java.io.Serializable;

public class Admin extends User implements Serializable {
	private String firstName;
	private String lastName;
	
	Admin(String login, String password, String firstName, String lastName) {
		super(login, password);
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public static boolean exists(String username) {
		for (Admin admin : Main.admins) {
			if (username.equals(admin.getLogin())) return true;
		}
		return false;
	}

	public static void printHeader() {
		System.out.println("  Login  |          Imie           |                  Nazwisko");
	}

	public String print(){
		StringBuilder output = new StringBuilder();
		output.append(getLogin());
		for (int i = 0; i<(9-getLogin().length()); i++) {
			output.append(" ");
		}
		output.append("|");
		output.append(firstName);
		for (int i = 0; i<(25-firstName.length()); i++) {
			output.append(" ");
		}
		output.append("|");
		output.append(lastName);
		for (int i = 0; i<(44-lastName.length()); i++) {
			output.append(" ");
		}
		return output.toString();
	}
}
