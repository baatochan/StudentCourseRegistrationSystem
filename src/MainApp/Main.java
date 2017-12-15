package MainApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {
	
	ArrayList<Admin> admins = new ArrayList<>();
	ArrayList<Student> students = new ArrayList<>();
	ArrayList<Course> courses = new ArrayList<>();
	ArrayList<Group> groups = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainApp.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    // do logowania, gdy zalogowany otwiera panel admina badz studenta w zaleznosci od zalogowanego uzytkownika
    public void logIn(String username, String password){
    
	}
	
	// do ladowania z pliku bazy studentow, kursow, grup, kont admina, itd.
	public void loadData() {
 
	}
	
	

    public static void main(String[] args) {
        launch(args);
    }
}
