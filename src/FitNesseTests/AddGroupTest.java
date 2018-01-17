package FitNesseTests;

import MainApp.Course;
import fit.ColumnFixture;
import MainApp.Main;

public class AddGroupTest extends ColumnFixture {
	private String data[];
	private Course lastCourse;

	public String addGroup() {
		String output = "";
		int numberBefore = numberOfGroups();

		try {
			lastCourse = Main.findCourse(data[0]);
			SetUp.panel.addGroupToDB(data[0], data[1], data[2], data[3], data[4], data[5]);
		} catch (Exception e) {
			output = "Wyjatek: " + e.getMessage();
		}

		if (numberOfGroups() == numberBefore + 1) {
			output = "dodano";
		}

		return output;
	}

	public int numberOfGroups() {
		return Main.groups.size();
	}

	public int numberOfGroupsOfTheCourse() {
		return lastCourse.getGroups().size();
	}
}
