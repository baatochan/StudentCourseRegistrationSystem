package MainApp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

class AdminPanel extends Panel {
	private Admin loggedAdmin;

	AdminPanel(Admin admin) {
		loggedAdmin = admin;
	}

	@Override
	void start() throws IOException {
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
					manageAdmins();
					break;
				case 2:
					manageStudents();
					break;
				case 3:
					manageCourses();
					break;
				case 4:
					manageGroups();
					break;
				case 5:
					studentEnrollment();
					break;
				case 6:
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

	@Override
	void showMenu() {
		System.out.println("MENU:");
		System.out.println("1. Zarzadzanie administartorami");
		System.out.println("2. Zarzadzaj studentami");
		System.out.println("3. Zarzadzaj kursami");
		System.out.println("4. Zarzadzaj grupami");
		System.out.println("5. Administracyjne zapisy");
		System.out.println("6. Eksportuj dane");
		System.out.println("0. Wyjdz");
		System.out.println("");
	}

	private void manageAdmins() throws IOException {
		int chosenMenuPosition;
		do {
			showAddEditRemoveMenu("Zarzdzanie administartorami");
			System.out.print("Twoj wybor: ");
			Main.inputValue = Main.input.readLine();
			chosenMenuPosition = Integer.parseInt(Main.inputValue);
			switch (chosenMenuPosition) {
				case 1:
					printAdmins();
					break;
				case 2:
					addAdmin();
					break;
				case 3:
					editAdmin();
					break;
				case 4:
					removeAdmin();
					break;
				case 0:
					break;
				default:
					System.out.println("Bledny wybor!");
			}
		} while (chosenMenuPosition != 0);
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
					printStudents();
					break;
				case 2:
					addStudent();
					break;
				case 3:
					editStudent();
					break;
				case 4:
					removeStudent();
					break;
				case 0:
					break;
				default:
					System.out.println("Bledny wybor!");
			}
		} while (chosenMenuPosition != 0);
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
					printCourses();
					break;
				case 2:
					addCourse();
					break;
				case 3:
					editCourse();
					break;
				case 4:
					removeCourse();
					break;
				case 0:
					break;
				default:
					System.out.println("Bledny wybor!");
			}
		} while (chosenMenuPosition != 0);
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
					printGroups();
					break;
				case 2:
					addGroup();
					break;
				case 3:
					editGroup();
					break;
				case 4:
					removeGroup();
					break;
				case 0:
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

	private void exportData() throws IOException {
		FileOutputStream fosAdmins = new FileOutputStream("admins.bak");
		ObjectOutputStream oosAdmins = new ObjectOutputStream(fosAdmins);
		oosAdmins.writeObject(Main.admins);
		oosAdmins.close();
		FileOutputStream fosStudents = new FileOutputStream("students.bak");
		ObjectOutputStream oosStudents = new ObjectOutputStream(fosStudents);
		oosStudents.writeObject(Main.students);
		oosStudents.close();
		FileOutputStream fosCourses = new FileOutputStream("courses.bak");
		ObjectOutputStream oosCourses = new ObjectOutputStream(fosCourses);
		oosCourses.writeObject(Main.courses);
		oosCourses.close();
		FileOutputStream fosGroups = new FileOutputStream("groups.bak");
		ObjectOutputStream oosGroups = new ObjectOutputStream(fosGroups);
		oosGroups.writeObject(Main.groups);
		oosGroups.close();
	}

	private void showAddEditRemoveMenu(String info) {
		System.out.println(info + ": ");
		System.out.println("");
		System.out.println("1. Wyswietl");
		System.out.println("2. Dodaj");
		System.out.println("3. Edytuj");
		System.out.println("4. Usun");
		System.out.println("0. Wyjdz");
		System.out.println("");
	}

	private void addAdmin() throws IOException {
		System.out.print("Podaj login: ");
		String username = Main.input.readLine();
		if (Admin.exists(username)) {
			System.out.println("Podany uzytkownik juz istnieje! Nastepuje przerwanie.");
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
		Admin a = new Admin(username, password, firstName, lastName);
		Main.admins.add(a);
		System.out.println("Dodano uzytkownika.");
	}

	private void editAdmin() throws IOException {
		System.out.print("Podaj login: ");
		String username = Main.input.readLine();
		Admin a = Main.findAdmin(username);
		if (a == null) {
			System.out.println("Podany uzytkownik nie istnieje.");
			return;
		}
		int chosenMenuPosition;
		do {
			System.out.println("Edycja uzytkownika: " + a.getLogin());
			System.out.println("");
			System.out.println("1. Zmien haslo");
			System.out.println("2. Zmien imie");
			System.out.println("3. Zmien nazwisko");
			System.out.println("0. Wyjdz");
			System.out.print("Twoj wybor: ");
			Main.inputValue = Main.input.readLine();
			chosenMenuPosition = Integer.parseInt(Main.inputValue);
			switch (chosenMenuPosition) {
				case 1:
					System.out.print("Podaj nowe haslo: ");
					String password = Main.input.readLine();
					System.out.print("Powtorz haslo: ");
					String password2 = Main.input.readLine();
					if (!(password.equals(password2))) {
						System.out.println("Podano rozne hasla! Nastepuje przerwanie.");
						break;
					}
					a.setPassword(password);
					System.out.println("Zmieniono haslo");
					break;
				case 2:
					System.out.print("Podaj nowe imie: ");
					String firstName = Main.input.readLine();
					a.setFirstName(firstName);
					System.out.println("Zmieniono imie");
					break;
				case 3:
					System.out.print("Podaj nowe nazwisko: ");
					String lastName = Main.input.readLine();
					a.setLastName(lastName);
					System.out.println("Zmieniono nazwisko");
					break;
				case 0:
					break;
				default:
					System.out.println("Bledny wybor!");
			}
		} while (chosenMenuPosition != 0);
	}

	private void removeAdmin() throws IOException {
		System.out.print("Podaj login: ");
		String username = Main.input.readLine();
		Admin a = Main.findAdmin(username);
		if (a == null) {
			System.out.println("Podany uzytkownik nie istnieje.");
			return;
		}
		Main.admins.remove(a);
		System.out.println("Usunieto uzytkownika");
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
		System.out.println("Dodano studenta.");
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
					System.out.print("Powtorz haslo: ");
					String password2 = Main.input.readLine();
					if (!(password.equals(password2))) {
						System.out.println("Podano rozne hasla! Nastepuje przerwanie.");
						break;
					}
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
		System.out.println("Dodano kurs.");
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
		Main.courses.remove(c);
		System.out.println("Usunieto kurs");
	}

	private void addGroup() throws IOException {
		System.out.print("Podaj ID kursu do ktorego tworzysz grupe: ");
		String courseID = Main.input.readLine();
		Course c = Main.findCourse(courseID);
		if (c == null) {
			System.out.println("Podany kurs nie istnieje! Nastepuje przerwanie.");
			return;
		}
		System.out.print("Podaj ID grupy: ");
		String groupID = Main.input.readLine();
		if (Group.exists(groupID)) {
			System.out.println("Podana grupa juz istnieje! Nastepuje przerwanie.");
			return;
		}
		System.out.print("Podaj nazwe: ");
		String name = Main.input.readLine();
		System.out.print("Podaj prowadzacego: ");
		String lecturer = Main.input.readLine();
		System.out.print("Podaj sale: ");
		String place = Main.input.readLine();
		System.out.print("Podaj ilosc miejsc: ");
		String slotsString = Main.input.readLine();
		int slots = Integer.parseInt(slotsString);
		Group g = new Group(name, groupID, lecturer, place, slots, c);
		c.addGroup(g);
		Main.groups.add(g);
		System.out.println("Dodano grupe.");
	}

	private void editGroup() throws IOException {
		System.out.print("Podaj ID grupy: ");
		String groupID = Main.input.readLine();
		Group g = Main.findGroup(groupID);
		if (g == null) {
			System.out.println("Podana grupa nie istnieje.");
			return;
		}
		int chosenMenuPosition;
		do {
			System.out.println("Edycja grupy: " + g.getGroupID());
			System.out.println("");
			System.out.println("1. Zmien nazwe");
			System.out.println("2. Zmien prowadzacego");
			System.out.println("3. Zmien sale");
			System.out.println("4. Zmien ilosc miejsc");
			System.out.println("0. Wyjdz");
			System.out.print("Twoj wybor: ");
			Main.inputValue = Main.input.readLine();
			chosenMenuPosition = Integer.parseInt(Main.inputValue);
			switch (chosenMenuPosition) {
				case 1:
					System.out.print("Podaj nowa nazwe: ");
					String name = Main.input.readLine();
					g.setName(name);
					System.out.println("Zmieniono nazwe");
					break;
				case 2:
					System.out.print("Podaj nowa prowadzacego: ");
					String lecturer = Main.input.readLine();
					g.setLecturer(lecturer);
					System.out.println("Zmieniono prowadzacego");
					break;
				case 3:
					System.out.print("Podaj nowa sale: ");
					String place = Main.input.readLine();
					g.setPlace(place);
					System.out.println("Zmieniono sale");
					break;
				case 4:
					System.out.print("Podaj nowa ilosc miejsc: ");
					String slotsString = Main.input.readLine();
					int slots = Integer.parseInt(slotsString);
					g.setSlots(slots);
					System.out.println("Zmieniono ilosc miejsc");
					break;
				case 0:
					break;
				default:
					System.out.println("Bledny wybor!");
			}
		} while (chosenMenuPosition != 0);
	}

	private void removeGroup() throws IOException {
		System.out.print("Podaj ID grupy: ");
		String groupID = Main.input.readLine();
		Group g = Main.findGroup(groupID);
		if (g == null) {
			System.out.println("Podana grupa nie istnieje.");
			return;
		}
		Course c = g.getCourse();
		c.removeGroup(g);
		Main.groups.remove(g);
		System.out.println("Usunieto grupe");
	}

	private void addStudentToGroup() throws IOException {
		System.out.print("Podaj numer indeksu studenta: ");
		String index = Main.input.readLine();
		Student s = Main.findStudent(index);
		if (s == null) {
			System.out.println("Podany student nie istnieje.");
			return;
		}
		System.out.print("Podaj ID grupy: ");
		String groupID = Main.input.readLine();
		Group g = Main.findGroup(groupID);
		if (g == null) {
			System.out.println("Podana grupa nie istnieje.");
			return;
		}
		if(s.checkIfAddedToAnotherGroupOfThisCourse(g.getCourse())) {
			System.out.println("Student dodany juz do innej grupy tego kursu.");
			return;
		}
		if(!(g.checkFreeSlots())) {
			System.out.print("W grupie nie ma miejsc. Czy zapisac ponad stan [Y/n]?");
			String answer = Main.input.readLine();
			if (!(answer.equals("Y")) && !(answer.equals("y"))) {
				System.out.println("Przerwano.");
				return;
			}
		}
		s.addGroup(g);
		g.addStudent(s);
		System.out.println("Zapisano studenta.");
	}

	private void removeStudentFromGroup() throws IOException {
		System.out.print("Podaj numer indeksu studenta: ");
		String index = Main.input.readLine();
		Student s = Main.findStudent(index);
		if (s == null) {
			System.out.println("Podany student nie istnieje.");
			return;
		}
		System.out.print("Podaj ID grupy: ");
		String groupID = Main.input.readLine();
		Group g = Main.findGroup(groupID);
		if (g == null) {
			System.out.println("Podana grupa nie istnieje.");
			return;
		}
		if(s.checkIfNotMemberOfGroup(g)) {
			System.out.println("Student nie nalezy do tej grupy.");
			return;
		}
		s.removeGroup(g);
		g.removeStudent(s);
		System.out.println("Wypisano studenta.");
	}
}
