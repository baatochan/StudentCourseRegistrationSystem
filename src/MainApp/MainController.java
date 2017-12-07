package MainApp;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class MainController {
	public Label helloWorld;
	
	public void sayHelloWorld(ActionEvent actionEvent) {
		if (helloWorld.getText().equals("")) {
			helloWorld.setText("Hello World!");
		} else {
			helloWorld.setText("");
		}
	}
}
