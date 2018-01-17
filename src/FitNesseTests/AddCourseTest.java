package FitNesseTests;

import fit.ColumnFixture;
import MainApp.Main;

public class AddCourseTest extends ColumnFixture {
	private String data[];

	public String addCourse() {
		String output = "";
		int numberBefore = numberOfCourses();

		try {
			SetUp.panel.addCourseToDB(data[0], data[1], data[2]);
		} catch (Exception e) {
			output = "Wyjatek: " + e.getMessage();
		}

		if (numberOfCourses() == numberBefore + 1) {
			output = "dodano";
		}

		return output;
	}

	public int numberOfCourses() {
		return Main.courses.size();
	}
}
