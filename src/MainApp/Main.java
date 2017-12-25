package MainApp;

import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.util.ArrayList;

public class Main {

	public static ArrayList<Admin> admins = new ArrayList<>();
    public static ArrayList<Student> students = new ArrayList<>();
    public static ArrayList<Course> courses = new ArrayList<>();
    public static ArrayList<Group> groups = new ArrayList<>();

	public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	public static String inputValue;

	private Main() {
		Admin root = new Admin("root", "toor", "", "");
		admins.add(root);
	}

	private void start() throws IOException {
		int chosenMenuPosition;
		System.out.println("Witamy w systemie rejestracji studentow PWr :)");
		System.out.println("");
		do {
			showLoginPanel();
			System.out.print("Twoj wybor: ");
			inputValue = input.readLine();
			chosenMenuPosition = Integer.parseInt(inputValue);
			switch (chosenMenuPosition) {
				case 1:
					System.out.print("Podaj nazwe uzytkownika: ");
					String username = input.readLine();
					System.out.print("Podaj haslo: ");
					String password = input.readLine();
					logIn(username, password);
					break;
				case 2:
					try {
						loadData();
					} catch (Exception e) {
						// do sth
					}
					break;
				case 0:
					System.out.println("Zegnaj!");
					break;
				default:
					System.out.println("Bledny wybor!");
			}
		} while (chosenMenuPosition != 0);
	}

	private void showLoginPanel() {
		System.out.println("MENU:");
		System.out.println("1. Zaloguj sie");
		System.out.println("2. Wczytaj dane z pliku");
		System.out.println("0. Wyjdz");
		System.out.println("");
	}

	// do logowania, gdy zalogowany otwiera panel admina badz studenta w zaleznosci od zalogowanego uzytkownika
	private void logIn(String username, String password) {
		boolean loggedIn = false;
		String loggedInType = "";
		Admin loggedAdmin = new Admin("","","","");
		Student loggedStudent = new Student("", "", "", "", "");
		for (Admin admin : admins) {
			if (username.equals(admin.getLogin())) {
				if (admin.checkPassword(password)) {
					loggedIn = true;
					loggedInType = "admin";
					loggedAdmin = admin;
				}
				break;
			}
		}
		if (!loggedIn) {
			for (Student student : students) {
				if (username.equals(student.getLogin())) {
					if (student.checkPassword(password)) {
						loggedIn = true;
						loggedInType = "student";
						loggedStudent = student;
					}
					break;
				}
			}
		}
		if (loggedIn) {
			switch (loggedInType) {
				case "admin":
					AdminPanel ap = new AdminPanel(loggedAdmin);
                    try {
                        ap.start();
                    } catch (IOException e) {
                        // do sth
                    }
                    //System.out.println("Zalogowano admina");
					break;
				case "student":
					StudentPanel sp = new StudentPanel(loggedStudent);
                    try {
                        sp.start();
                    } catch (IOException e) {
                        // do sth
                    }
                    break;
				default:
					System.out.println("Wystapil blad...");
			}
		} else {
			System.out.println("Bledne haslo!");
		}
	}

	@Nullable
	public static Student findStudent(String username) {
		for(Student student : students) {
			if (username.equals(student.getLogin())) return student;
		}
		return null;
	}

	// do ladowania z pliku bazy studentow, kursow, grup, kont admina, itd.
	private void loadData() throws IOException, ClassNotFoundException {
		FileInputStream fosAdmins = new FileInputStream("admins.bak");
		ObjectInputStream oosAdmins = new ObjectInputStream(fosAdmins);
		admins = (ArrayList<Admin>) oosAdmins.readObject();
		oosAdmins.close();
		FileInputStream fosStudents = new FileInputStream("students.bak");
		ObjectInputStream oosStudents = new ObjectInputStream(fosStudents);
		students = (ArrayList<Student>) oosStudents.readObject();
		oosStudents.close();
		FileInputStream fosCourses = new FileInputStream("courses.bak");
		ObjectInputStream oosCourses = new ObjectInputStream(fosCourses);
		courses = (ArrayList<Course>) oosCourses.readObject();
		oosCourses.close();
		FileInputStream fosGroups = new FileInputStream("groups.bak");
		ObjectInputStream oosGroups = new ObjectInputStream(fosGroups);
		groups = (ArrayList<Group>) oosGroups.readObject();
		oosGroups.close();
	}


	public static void main(String[] args) {
		//launch(args);
		Main app = new Main(); //TODO: zmienic na statyczna kiedys
		try { // HOW NOT TO HANDLE EXCEPTIONS IN JAVA XDDDD
			app.start();
		} catch (Exception e) {
			// do sth
		}
	}

	@Nullable
	public static Course findCourse(String courseID) {
		for(Course course : courses) {
			if (courseID.equals(course.getCourseID())) return course;
		}
		return null;
	}

	@Nullable
	public static Group findGroup(String groupID) {
		for(Group group : groups) {
			if (groupID.equals(group.getGroupID())) return group;
		}
		return null;
	}

	@Nullable
	public static Admin findAdmin(String username) {
		for(Admin admin : admins) {
			if (username.equals(admin.getLogin())) return admin;
		}
		return null;
	}
}
