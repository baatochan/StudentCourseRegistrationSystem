package MainApp;

import javafx.stage.Stage;

import java.io.IOException;

public class StudentPanel extends Panel {

	private Student loggedStudent;

	public StudentPanel(Student student) {
		loggedStudent = student;
	}
	
	public void start() throws IOException {
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
				case 0:
					System.out.println("Zegnaj!");
					break;
				default:
					System.out.println("Bledny wybor!");
			}
		} while (chosenMenuPosition != 0);
	}

	private void printMyGroups() {
		System.out.println("ID     |Nazwa                       |Prowadzacy               |Sala     |Miejsca");
		for (Group g : loggedStudent.getGroups()) {
			System.out.println(g.toString());
		}
	}

	private void removeFromGroup() throws IOException {
		System.out.print("Podaj ID grupy: ");
		String groupID = Main.input.readLine();
		Group g = Main.findGroup(groupID);
		if (g == null) {
			System.out.println("Podana grupa nie istnieje.");
			return;
		}
		if(!loggedStudent.checkIfMemberOfGroup(g)) {
			System.out.println("Nie nalezyz do tej grupy.");
			return;
		}
		loggedStudent.removeGroup(g);
		g.removeStudent(loggedStudent);
		System.out.println("Wypisano.");
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
		if(g.checkFreeSlots()) {
			System.out.print("W grupie nie ma miejsc.");
			return;
		}
		loggedStudent.addGroup(g);
		g.addStudent(loggedStudent);
		System.out.println("Zapisano.");
	}

	private void printGroups() {
		System.out.println("ID     |Nazwa                       |Prowadzacy               |Sala     |Miejsca");
		for (Group g : Main.groups) {
			System.out.println(g.toString());
		}
	}

	private void showMenu() {
		System.out.println("MENU:");
		System.out.println("1. Wyswietl dostepne grupy");
		System.out.println("2. Zapis do grupy");
		System.out.println("3. Wypis z grupy");
		System.out.println("4. Grupy do ktorych jestem zapisany");
		System.out.println("0. Wyjdz");
		System.out.println("");
	}


	// wywietlenie okna i ukladu elementow w oknie
	/*@Override
	public void start(Stage primaryStage) throws Exception{
	
	}*/
	
	// funkcje odpawiadajace na kliknecia na obiekty w oknie
}
