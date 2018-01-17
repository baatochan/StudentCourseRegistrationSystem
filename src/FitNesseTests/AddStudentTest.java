package FitNesseTests;

import fit.ColumnFixture;
import MainApp.Main;

public class AddStudentTest extends ColumnFixture {
	private String data[];

	public String addStudent() {
		String output = "";
		int numberBefore = numberOfStudents();

		try {
			SetUp.panel.addStudentToDB(data[0], data[1], data[2], data[3], data[4], data[5]);
		} catch (Exception e) {
			output = "Wyjatek: " + e.getMessage();
		}

		if (numberOfStudents() == numberBefore + 1) {
			output = "dodano";
		}

		return output;
	}

	public int numberOfStudents() {
		return Main.students.size();
	}
}
