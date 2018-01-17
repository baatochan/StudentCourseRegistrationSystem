package FitNesseTests;

//import fit.Fixture;
import MainApp.Admin;
import MainApp.AdminPanel;

public class SetUp { //extends Fixture{
	static AdminPanel panel;
	static Admin admin;
	public SetUp() {
		admin = new Admin("root","toor","","");
		panel = new AdminPanel(admin);
	}
}