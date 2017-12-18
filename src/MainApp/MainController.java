package MainApp;


import javafx.event.ActionEvent;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;



public class MainController  implements Initializable , ControlledScreen {


    public Label helloWorld, checkLogin;
	public PasswordField passField;
	public TextField loginField;
	public Button btn;

	private ScreensController myController;
	/**
	 * Initializes the controller class.
	 */

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}

	public void setScreenParent(ScreensController screenParent){
		myController = screenParent;
	}

	@FXML
	private void goToScreen2(ActionEvent event){
		myController.setScreen(Main.screenStudentPanel);
	}

	@FXML
	private void goToScreen3(ActionEvent event){
		myController.setScreen(Main.screenAdminPanel);
	}

	public void sayHelloWorld(ActionEvent actionEvent) {
		if (helloWorld.getText().equals("")) {
			helloWorld.setText("Hello World!");
		} else {
			helloWorld.setText("");
		}
	}

	public void loginToProgram(ActionEvent actionEvent)
    {
//        String napis;
//        napis = loginField.getText() + passField.getText();
//        checkLogin.setText(napis);

        String login = loginField.getText(); // zmienne do logowania trzeba by je
        // porównać czy istnieje taki użytkownik następnie sprawdzić czy ma uprawnienia
        //studenta czy admina i w zależności od uprawnień wywołać odpowiednie okno(admin, student)
        String pass =passField.getText();

        StudentPanel studentPanel = new StudentPanel();
        //studentPanel;


    }

}
