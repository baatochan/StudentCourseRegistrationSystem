package MainApp;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
	private String login;
	private String password; //hashed
	
	public User (String login, String password) {
		this.login = login; // jakis pomysl na cos lepszego?
        try {
            setPassword(password);
        } catch (Exception e) {
            // do sth
        }
	}
	
	public void setPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        this.password = DatatypeConverter.printHexBinary(digest).toUpperCase();
	}
	
	public boolean checkPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String hash = DatatypeConverter.printHexBinary(digest).toUpperCase();

        return hash.equals(password);
	}
}
