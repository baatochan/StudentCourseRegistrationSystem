package MainApp;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;


@Categories.SuiteClasses({CourseTest.class,MainTest.class,StudentTest.class})
@RunWith(Categories.class)
@Categories.IncludeCategory(TestCategory1.class)
@Categories.ExcludeCategory(TestCategory3.class)
public class TestGroup3 {}
