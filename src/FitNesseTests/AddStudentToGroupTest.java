package FitNesseTests;

import MainApp.Group;
import MainApp.Student;
import fit.ColumnFixture;
import MainApp.Main;

public class AddStudentToGroupTest extends ColumnFixture {
	private String data[];
	private Group lastGroup;
	private Student lastStudent;

	public String addStudentToGroup() {
		String output = "dodano";

		try {
			lastGroup = Main.findGroup(data[1]);
			lastStudent = Main.findStudent(data[0]);
			SetUp.panel.addStudentToGroupForReal(data[0], data[1], data[2]);
		} catch (Exception e) {
			output = "Wyjatek: " + e.getMessage();
		}

		return output;
	}

	public int numberOfStudentsInTheGroup() {
		return lastGroup.getStudents().size();
	}

	public int numberOfGroupsWhereStudentIsEnrolled() {
		return lastStudent.getGroups().size();
	}
}
