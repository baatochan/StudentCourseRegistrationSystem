package MainApp;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;


@Categories.SuiteClasses({CourseTest.class,MainTest.class,StudentTest.class})
@RunWith(Categories.class)
public class TestGroupAll {}
