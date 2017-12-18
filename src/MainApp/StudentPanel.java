package MainApp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class StudentPanel  implements Initializable , ControlledScreen {

	ScreensController myController;
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
	private void goToScreen1(ActionEvent event){
		myController.setScreen(Main.screenMainApp);
	}

	@FXML
	private void goToScreen3(ActionEvent event){
		myController.setScreen(Main.screenAdminPanel);
	}

	// wywietlenie okna i ukladu elementow w oknie

	
	// funkcje odpawiadajace na kliknecia na obiekty w oknie
}
   