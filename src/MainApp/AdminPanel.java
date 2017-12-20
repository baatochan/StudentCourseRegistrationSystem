package MainApp;

import javafx.stage.Stage;

import java.io.IOException;

public class AdminPanel extends Panel {

	private Admin loggedAdmin;

	public AdminPanel(Admin admin) {
		loggedAdmin = admin;
	}

	public void start () throws IOException {
		int chosenMenuPosition;
		System.out.println("Zalogowano uzytkownika " + loggedAdmin.getLogin() + " jako administartora.");
		System.out.println("");
		do {
			showMenu();
			System.out.print("Twoj wybor: ");
			Main.inputValue = Main.input.readLine();
			chosenMenuPosition = Integer.parseInt(Main.inputValue);
			switch (chosenMenuPosition) {
				case 1:
					manageStudents();
					break;
				case 2:
					manageCourses();
					break;
				case 3:
					manageGroups();
					break;
				case 4:
					studentEnrollment();
					break;
				case 5:
					exportData();
					break;
				case 0:
					System.out.println("Zegnaj!");
					break;
				default:
					System.out.println("Bledny wybor!");
			}
		} while (chosenMenuPosition != 0);
	}

	private void studentEnrollment() throws IOException {
		int chosenMenuPosition;
		do {
			System.out.println("Administarcyjne zapisy: ");
			System.out.println("");
			System.out.println("1. Zapisz");
			System.out.println("2. Wypisz");
			System.out.println("0. Wyjdz");
			System.out.println("");
			System.out.print("Twoj wybor: ");
			Main.inputValue = Main.input.readLine();
			chosenMenuPosition = Integer.parseInt(Main.inputValue);
			switch (chosenMenuPosition) {
				case 1:
					addStudentToGroup();
					break;
				case 2:
					removeStudentFromGroup();
					break;
				case 0:
					break;
				default:
					System.out.println("Bledny wybor!");
			}
		} while (chosenMenuPosition != 0);
	}

	private void addStudentToGroup() {

	}

	private void removeStudentFromGroup() {

	}

	private void exportData() {
		System.out.println("NOT YET IMPLEMENTED!");
	}

	private void manageGroups() throws IOException {
		int chosenMenuPosition;
		do {
			showAddEditRemoveMenu("Zarzdzanie grupami zajeciowymi");
			System.out.print("Twoj wybor: ");
			Main.inputValue = Main.input.readLine();
			chosenMenuPosition = Integer.parseInt(Main.inputValue);
			switch (chosenMenuPosition) {
				case 1:
					addGroup();
					break;
				case 2:
					editGroup();
					break;
				case 3:
					removeGroup();
					break;
				case 0:
					break;
				default:
					System.out.println("Bledny wybor!");
			}
		} while (chosenMenuPosition != 0);
	}

	private void addGroup() {

	}

	private void editGroup() {

	}

	private void removeGroup() {

	}

	private void manageCourses() throws IOException {
		int chosenMenuPosition;
		do {
			showAddEditRemoveMenu("Zarzdzanie kursami");
			System.out.print("Twoj wybor: ");
			Main.inputValue = Main.input.readLine();
			chosenMenuPosition = Integer.parseInt(Main.inputValue);
			switch (chosenMenuPosition) {
				case 1:
					addCourse();
					break;
				case 2:
					editCourse();
					break;
				case 3:
					removeCourse();
					break;
				case 0:
					break;
				default:
					System.out.println("Bledny wybor!");
			}
		} while (chosenMenuPosition != 0);
	}

	private void addCourse() throws IOException {
		System.out.print("Podaj ID kursu: ");
		String courseID = Main.input.readLine();
		if (Course.exists(courseID)) {
			System.out.println("Podany kurs juz istnieje! Nastepuje przerwanie.");
			return;
		}
		System.out.print("Podaj nazwe: ");
		String name = Main.input.readLine();
		System.out.print("Podaj ECTS: ");
		String ECTSString = Main.input.readLine();
		int ECTS = Integer.parseInt(ECTSString);
		Course c = new Course(name, courseID, ECTS);
		Main.courses.add(c);
		System.out.print("Dodano kurs.");
	}

	private void editCourse() throws IOException {
		System.out.print("Podaj ID kursu: ");
		String courseID = Main.input.readLine();
		Course c = Main.findCourse(courseID);
		if (c == null) {
			System.out.println("Podany kurs nie istnieje.");
			return;
		}
		int chosenMenuPosition;
		do {
			System.out.println("Edycja kursu: " + c.getCourseID());
			System.out.println("");
			System.out.println("1. Zmien nazwe");
			System.out.println("2. Zmien ilosc ECTS");
			System.out.println("0. Wyjdz");
			System.out.print("Twoj wybor: ");
			Main.inputValue = Main.input.readLine();
			chosenMenuPosition = Integer.parseInt(Main.inputValue);
			switch (chosenMenuPosition) {
				case 1:
					System.out.print("Podaj nowa nazwe: ");
					String name = Main.input.readLine();
					c.setName(name);
					System.out.println("Zmieniono nazwe");
					break;
				case 2:
					System.out.print("Podaj nowa ilosc ECTS: ");
					String ECTSString = Main.input.readLine();
					int ECTS = Integer.parseInt(ECTSString);
					c.setECTS(ECTS);
					System.out.println("Zmieniono ilosc ECTS");
					break;
				case 0:
					break;
				default:
					System.out.println("Bledny wybor!");
			}
		} while (chosenMenuPosition != 0);
	}

	private void removeCourse() throws IOException {
		System.out.print("Podaj ID kursu: ");
		String courseID = Main.input.readLine();
		Course c = Main.findCourse(courseID);
		if (c == null) {
			System.out.println("Podany kurs nie istnieje.");
			return;
		}
		Main.students.remove(c);
		System.out.println("Usunieto kurs");
	}

	private void manageStudents() throws IOException {
		int chosenMenuPosition;
		do {
			showAddEditRemoveMenu("Zarzdzanie studentami");
			System.out.print("Twoj wybor: ");
			Main.inputValue = Main.input.readLine();
			chosenMenuPosition = Integer.parseInt(Main.inputValue);
			switch (chosenMenuPosition) {
				case 1:
					addStudent();
					break;
				case 2:
					editStudent();
					break;
				case 3:
					removeStudent();
					break;
				case 0:
					break;
				default:
					System.out.println("Bledny wybor!");
			}
		} while (chosenMenuPosition != 0);
	}

	private void addStudent() throws IOException {
		System.out.print("Podaj indeks (login): ");
		String username = Main.input.readLine();
		if (Student.exists(username)) {
			System.out.println("Podany student juz istnieje! Nastepuje przerwanie.");
			return;
		}
		System.out.print("Podaj haslo: ");
		String password = Main.input.readLine();
		System.out.print("Powtorz haslo: ");
		String password2 = Main.input.readLine();
		if (!(password.equals(password2))) {
			System.out.println("Podano rozne hasla! Nastepuje przerwanie.");
			return;
		}
		System.out.print("Podaj imie: ");
		String firstName = Main.input.readLine();
		System.out.print("Podaj nazwisko: ");
		String lastName = Main.input.readLine();
		System.out.print("Podaj email: ");
		String email = Main.input.readLine();
		Student s = new Student(username, password, firstName, lastName, email);
		Main.students.add(s);
		System.out.print("Dodano studenta.");
	}

	private void editStudent() throws IOException {
		System.out.print("Podaj indeks (login): ");
		String username = Main.input.readLine();
		Student s = Main.findStudent(username);
		if (s == null) {
			System.out.println("Podany student nie istnieje.");
			return;
		}
		int chosenMenuPosition;
		do {
			System.out.println("Edycja studenta: " + s.getLogin());
			System.out.println("");
			System.out.println("1. Zmien haslo");
			System.out.println("2. Zmien imie");
			System.out.println("3. Zmien nazwisko");
			System.out.println("4. Zmien adres email");
			System.out.println("0. Wyjdz");
			System.out.print("Twoj wybor: ");
			Main.inputValue = Main.input.readLine();
			chosenMenuPosition = Integer.parseInt(Main.inputValue);
			switch (chosenMenuPosition) {
				case 1:
					System.out.print("Podaj nowe haslo: ");
					String password = Main.input.readLine();
					s.setPassword(password);
					System.out.println("Zmieniono haslo");
					break;
				case 2:
					System.out.print("Podaj nowe imie: ");
					String firstName = Main.input.readLine();
					s.setFirstName(firstName);
					System.out.println("Zmieniono imie");
					break;
				case 3:
					System.out.print("Podaj nowe nazwisko: ");
					String lastName = Main.input.readLine();
					s.setLastName(lastName);
					System.out.println("Zmieniono nazwisko");
					break;
				case 4:
					System.out.print("Podaj nowy email: ");
					String email = Main.input.readLine();
					s.setEmail(email);
					System.out.println("Zmieniono email");
					break;
				case 0:
					break;
				default:
					System.out.println("Bledny wybor!");
			}
		} while (chosenMenuPosition != 0);
	}

	private void removeStudent() throws IOException {
		System.out.print("Podaj indeks (login): ");
		String username = Main.input.readLine();
		Student s = Main.findStudent(username);
		if (s == null) {
			System.out.println("Podany student nie istnieje.");
			return;
		}
		Main.students.remove(s);
		System.out.println("Usunieto studenta");
	}

	private void showAddEditRemoveMenu(String info) {
		System.out.println(info + ": ");
		System.out.println("");
		System.out.println("1. Dodaj");
		System.out.println("2. Edytuj");
		System.out.println("3. Usun");
		System.out.println("0. Wyjdz");
		System.out.println("");
	}

	private void showMenu() {
		System.out.println("MENU:");
		System.out.println("1. Zarzadzaj studentami");
		System.out.println("2. Zarzadzaj kursami");
		System.out.println("3. Zarzadzaj grupami");
		System.out.println("4. Administracyjne zapisy");
		System.out.println("5. Eksportuj dane");
		System.out.println("0. Wyjdz");
		System.out.println("");
	}


	// wywietlenie okna i ukladu elementow w oknie
	/*@Override
	public void start(Stage primaryStage) throws Exception{
	
	}*/
	
	// funkcje odpawiadajace na kliknecia na obiekty w oknie
}
