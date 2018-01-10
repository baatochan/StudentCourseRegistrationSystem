package MainApp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

@Category(TestCategory2.class)
public class StudentTest {
	private static Student s1 = TestData.students[0];
	private static Student s2 = TestData.students[1];
	private static Group g1 = TestData.groups[0];
	private static Group g2 = TestData.groups[1];
	private static Group g3 = TestData.groups[2];

	@BeforeClass
	public static void setUp() throws Exception {
		Main.students.addAll(Arrays.asList(TestData.students));
		Main.admins.addAll(Arrays.asList(TestData.admins));
		Main.courses.addAll(Arrays.asList(TestData.courses));
		Main.groups.addAll(Arrays.asList(TestData.groups));
		s1.addGroup(g1);
		g1.addStudent(s1);
		s1.addGroup(g2);
		g2.addStudent(s1);
		s2.addGroup(g3);
		g3.addStudent(s2);

	}

	@Test
	public void checkIfAddedToAnotherGroupOfThisCourse() {
		assertFalse(s2.checkIfAddedToAnotherGroupOfThisCourse(g1.getCourse()));
		assertTrue(s1.checkIfAddedToAnotherGroupOfThisCourse(g3.getCourse()));
	}

	@Test
	public void getGroups() {
		ArrayList<Group> g = new ArrayList<>();
		g.add(g1);
		g.add(g2);

		assertEquals(g, s1.getGroups());
	}
}