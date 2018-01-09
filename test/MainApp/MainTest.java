package MainApp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MainTest {

	@BeforeClass
	public static void setUp() {
		Main.students.addAll(Arrays.asList(TestData.students));
		Main.admins.addAll(Arrays.asList(TestData.admins));
		Main.courses.addAll(Arrays.asList(TestData.courses));
		Main.groups.addAll(Arrays.asList(TestData.groups));
	}

	@Test
	public void findStudent() {
		for (int i = 0; i < 3; i++) {
			assertEquals(TestData.students[i], Main.findStudent(TestData.studentsData[i][0]));
		}
		assertNull(Main.findStudent(TestData.studentsData[3][0]));
		assertNull(Main.findStudent(TestData.studentsData[4][0]));
	}

	@Test
	public void findCourse() {
		for (int i = 0; i < 2; i++) {
			assertEquals(TestData.courses[i], Main.findCourse(TestData.coursesData[i][1]));
		}
		assertNull(Main.findCourse(TestData.coursesData[2][1]));
	}

	@Test
	public void findGroup() {
		for (int i = 0; i < 3; i++) {
			assertEquals(TestData.groups[i], Main.findGroup(TestData.groupsData[i][1]));
		}
		assertNull(Main.findGroup(TestData.groupsData[3][1]));
	}

	@Test
	public void findAdmin() {
		for (int i = 0; i < 2; i++) {
			assertEquals(TestData.admins[i], Main.findAdmin(TestData.adminsData[i][0]));
		}
		assertNull(Main.findAdmin(TestData.adminsData[2][0]));
	}
}