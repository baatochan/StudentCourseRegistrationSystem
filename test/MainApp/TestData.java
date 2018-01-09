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

	static String adminsData[][] = new String[][] {
			{"barto","zzz","Bartosz","Rodziewicz"}, {"root","toor","ROOT",""}, {"adam123","haslo123","Adam","Guzik"}
	};

	static Admin admins[] = {
			new Admin("barto","zzz","Bartosz","Rodziewicz"),
			new Admin("root","toor","ROOT","")
	};

	static String coursesData[][] = new String[][] {
			{"Test Tset","A","1"}, {"Inzynieria Oprogramowania","C","111"}, {"XXX","B","2"}
	};

	static Course courses[] = {
			new Course("Test Tset","A",1),
			new Course("Inzynieria Oprogramowania","C",111)
	};

	static String groupsData[][] = new String[][] {
			{"test 123","AA","marcin jakistam","c13 1.12", "10"}, {"Inzynieria Oprogramowania L","CA","Jedrzej","C 244","1"},
			{"Inzynieria Oprogramowania L","CB","Marek","C2 24","5"}, {"test 321","AB","jerzy przyjaciel mlodziezy","c1 112","20"}
	};

	static Group groups[] = {
			new Group("test 123","AA","marcin jakistam","c13 1.12", 10, courses[0]),
			new Group("Inzynieria Oprogramowania L","CA","Jedrzej","C 244",1, courses[1]),
			new Group("Inzynieria Oprogramowania L","CB","Marek","C2 24",5, courses[1])
	};
}
