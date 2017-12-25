package MainApp;

import java.io.IOException;

abstract class Panel {

	abstract void start() throws IOException;

	abstract void showMenu();

	void printGroups() {
		Group.printHeader();
		for (Group g : Main.groups) {
			System.out.println(g.print());
		}
	}

	void printCourses() {
		Course.printHeader();
		for (Course c : Main.courses) {
			System.out.println(c.print());
		}
	}

	void printAdmins() {
		Admin.printHeader();
		for (Admin a : Main.admins) {
			System.out.println(a.print());
		}
	}

	void printStudents() {
		Student.printHeader();
		for (Student s : Main.students) {
			System.out.println(s.print());
		}
	}

}
