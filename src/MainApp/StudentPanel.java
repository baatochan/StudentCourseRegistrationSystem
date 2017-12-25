package MainApp;

import java.io.IOException;

class StudentPanel extends Panel {
	private Student loggedStudent;

	StudentPanel(Student student) {
		loggedStudent = student;
	}

	@Override
	void start() throws IOException {
		int chosenMenuPosition;
		System.out.println("Zalogowano uzytkownika " + loggedStudent.getLogin() + " jako studenta.");
		System.out.println("");
		do {
			showMenu();
			System.out.print("Twoj wybor: ");
			Main.inputValue = Main.input.readLine();
			chosenMenuPosition = Integer.parseInt(Main.inputValue);
			switch (chosenMenuPosition) {
				case 1:
					printGroups();
					break;
				case 2:
					addToGroup();
					break;
				case 3:
					removeFromGroup();
					break;
				case 4:
					printMyGroups();
					break;
				case 5:
					changeMyPassword();
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
		System.out.println("1. Wyswietl dostepne grupy");
		System.out.println("2. Zapis do grupy");
		System.out.println("3. Wypis z grupy");
		System.out.println("4. Grupy do ktorych jestem zapisany");
		System.out.println("5. Zmiana hasla");
		System.out.println("0. Wyjdz");
		System.out.println("");
	}

	private void addToGroup() throws IOException {
		System.out.print("Podaj ID grupy: ");
		String groupID = Main.input.readLine();
		Group g = Main.findGroup(groupID);
		if (g == null) {
			System.out.println("Podana grupa nie istnieje.");
			return;
		}
		if(loggedStudent.checkIfAddedToAnotherGroupOfThisCourse(g.getCourse())) {
			System.out.println("Student dodany juz do innej grupy tego kursu.");
			return;
		}
		if(!(g.checkFreeSlots())) {
			System.out.print("W grupie nie ma miejsc.");
			return;
		}
		loggedStudent.addGroup(g);
		g.addStudent(loggedStudent);
		System.out.println("Zapisano.");
	}

	private void removeFromGroup() throws IOException {
		System.out.print("Podaj ID grupy: ");
		String groupID = Main.input.readLine();
		Group g = Main.findGroup(groupID);
		if (g == null) {
			System.out.println("Podana grupa nie istnieje.");
			return;
		}
		if(loggedStudent.checkIfNotMemberOfGroup(g)) {
			System.out.println("Nie nalezyz do tej grupy.");
			return;
		}
		loggedStudent.removeGroup(g);
		g.removeStudent(loggedStudent);
		System.out.println("Wypisano.");
	}

	private void printMyGroups() {
		Group.printHeader();
		for (Group g : loggedStudent.getGroups()) {
			System.out.println(g.toString());
		}
	}

	private void changeMyPassword() throws IOException {
		System.out.print("Podaj nowe haslo: ");
		String password = Main.input.readLine();
		System.out.print("Powtorz haslo: ");
		String password2 = Main.input.readLine();
		if (!(password.equals(password2))) {
			System.out.println("Podano rozne hasla! Nastepuje przerwanie.");
			return;
		}
		loggedStudent.setPassword(password);
		System.out.println("Zmieniono haslo");
	}
}
