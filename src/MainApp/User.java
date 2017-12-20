package MainApp;

public class User {
	private String login;
	private String password; //hashed
	
	public User (String Login, String password) {
		login = Login; // jakis pomysl na cos lepszego? -> nie
		changePassword(password);
	}
	
	public void changePassword(String newPassword) {
	
	}
	
	public boolean checkPassword(String password) {
		return false;
	}
}
