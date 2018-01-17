package FitNesseTests;

import fit.Fixture;
import MainApp.Admin;
import MainApp.AdminPanel;
import MainApp.Main;

public class SetUp extends Fixture {
	static Main app;
	static Admin admin;
	static AdminPanel panel;

	public SetUp() {
		app = new Main();
		admin = Main.findAdmin("root");
		panel = new AdminPanel(admin);
	}
}
