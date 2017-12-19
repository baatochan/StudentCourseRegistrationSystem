package MainApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main { //extends Application {

	private static ArrayList<Admin> admins = new ArrayList<>();
	private static ArrayList<Student> students = new ArrayList<>();
	private static ArrayList<Course> courses = new ArrayList<>();
	private static ArrayList<Group> groups = new ArrayList<>();

	public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	public static String inputValue;

	public Main() {
		Admin root = new Admin("root", "toor", "", "");
		admins.add(root);
	}

	/*@Override
	public void start(Stage primaryStage) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("MainApp.fxml"));
		primaryStage.setTitle("Hello World");
		primaryStage.setScene(new Scene(root, 300, 275));
		primaryStage.show();
	}*/

	public void start() throws IOException {
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
					loadData();
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
	public void logIn(String username, String password) {
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
					//StudentPanel sp = new StudentPanel();
					//sp.start();
					break;
				default:
					System.out.println("Wystapil blad...");
					return;
			}
		} else {
			System.out.println("Bledne haslo!");
		}
	}

	// do ladowania z pliku bazy studentow, kursow, grup, kont admina, itd.
	public void loadData() {
		System.out.println("NOT YET IMPLEMENTED!");
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
}
