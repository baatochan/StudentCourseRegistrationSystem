package MainApp;

import javax.xml.bind.DatatypeConverter;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User implements Serializable {
	private String login;
	private String password; //hashed
	
	public User (String login, String password) {
		this.login = login; // jakis pomysl na cos lepszego?
		setPassword(password);
	}
	
	public void setPassword(String password) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// do sth
		}
		md.update(password.getBytes());
		byte[] digest = md.digest();
		this.password = DatatypeConverter.printHexBinary(digest).toUpperCase();
	}
	
	public boolean checkPassword(String password) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// do sth
		}
		md.update(password.getBytes());
		byte[] digest = md.digest();
		String hash = DatatypeConverter.printHexBinary(digest).toUpperCase();

		return hash.equals(this.password);
	}

	public String getLogin() {
		return login;
	}
}
