package MainApp;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.Arrays;

import static org.junit.Assert.*;

@Category({TestCategory1.class, TestCategory2.class})
public class CourseTest {

	@BeforeClass
	public static void setUp() throws Exception {
		Main.students.addAll(Arrays.asList(TestData.students));
		Main.admins.addAll(Arrays.asList(TestData.admins));
		Main.courses.addAll(Arrays.asList(TestData.courses));
		Main.groups.addAll(Arrays.asList(TestData.groups));
	}

	@Test
	public void exists() {
		for (int i = 0; i < 2; i++) {
			assertTrue(Course.exists(TestData.coursesData[i][1]));
		}
		assertFalse(Course.exists(TestData.coursesData[2][1]));
	}

	@Test
	public void print() {
		int i = 0;
		for (Course c: Main.courses) {
			assertEquals(TestData.coursesPrintOutput[i], c.print());
			i++;
		}
	}
}