package MainApp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MainTest {

	@Before
	public void setUp() throws Exception {
		Main.students.addAll(Arrays.asList(TestData.students));
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
		assertTrue(false);
	}

	@Test
	public void findGroup() {
		assertTrue(false);
	}

	@Test
	public void findAdmin() {
		assertTrue(false);
	}
}