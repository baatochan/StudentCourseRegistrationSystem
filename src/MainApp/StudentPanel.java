package MainApp;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;

public class StudentPanel  implements Initializable , ControlledScreen {



	public TableView listOfAvailableGroupCourse ;

	ScreensController myController;


	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}
	// te 3 poniżej funkcje są tylkoto przechodzenia między oknami
	public void setScreenParent(ScreensController screenParent){
		myController = screenParent;
	}
	@FXML
	private void goToScreen1(ActionEvent event){
		myController.setScreen(Main.screenMainApp);
	}

	@FXML
	private void goToScreen3(ActionEvent event){myController.setScreen(Main.screenAdminPanel);	}

	// funkcja do wyswitlania dostępnych kursów ps nie zmianiaj nazwy bo już ją wrzuciłem do fxml'a
	private void displayListOfAvailableGroupCourse()
	{


		//listOfAvailableGroupCourse.setItems( lista dostępnych kursow);


	}


}
   