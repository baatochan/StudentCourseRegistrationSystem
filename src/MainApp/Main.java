package MainApp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;

import java.util.ArrayList;

public class Main extends Application {
	
	ArrayList<Admin> admins = new ArrayList<>();
	ArrayList<Student> students = new ArrayList<>();
	ArrayList<Course> courses = new ArrayList<>();
	ArrayList<Group> groups = new ArrayList<>();

    public static String screenMainApp = "main";
    public static String screenMainAppFile = "MainApp.fxml";
    public static String screenStudentPanel = "screen2";
    public static String screenStudentPanelFile = "StudentPanel.fxml";
    public static String screenAdminPanel = "screen3";
    public static String screenAdminPanelFile = "AdminPanel.fxml";


    @Override
    public void start(Stage primaryStage) {

        ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(Main.screenMainApp, Main.screenMainAppFile);
        mainContainer.loadScreen(Main.screenStudentPanel, Main.screenStudentPanelFile);
        mainContainer.loadScreen(Main.screenAdminPanel, Main.screenAdminPanelFile);

        mainContainer.setScreen(Main.screenMainApp);

        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // do logowania, gdy zalogowany otwiera panel admina badz studenta w zaleznosci od zalogowanego uzytkownika
    public void logIn(String username, String password){
    
	}
	
	// do ladowania z pliku bazy studentow, kursow, grup, kont admina, itd.
	public void loadData() {
 
	}
	
	

    public static void main(String[] args)
    {
        launch(args);
    }
}
