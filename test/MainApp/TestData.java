package MainApp;

public final class TestData {
	private TestData() {}

	static String studentsData[][] = new String[][] {
			{"226105","xxx","Bartosz","Rodziewicz","baato@chan.com"}, {"123456","test","Adam","Kowalski","adam.kowalski@gmail.com"},
			{"234567","zzz","Damian","Nowak","damiannowak@wp.pl"}, {"111","password","Maciek","Brzeczyszczykiewicz","maciekbrz@onet.pl"},
			{"123","haslo1","Adam","Nowak","adam@nowak.pl"}
	};

	static Student students[] = {
			new Student("226105","xxx","Bartosz","Rodziewicz","baato@chan.com"),
			new Student("123456","test","Adam","Kowalski","adam.kowalski@gmail.com"),
			new Student("234567","zzz","Damian","Nowak","damiannowak@wp.pl")
	};
}
