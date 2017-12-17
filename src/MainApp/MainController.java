package MainApp;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class MainController {


    public Label helloWorld, checkLogin;
	public PasswordField passField;
	public TextField loginField;
	public Button btn;
	
	public void sayHelloWorld(ActionEvent actionEvent) {
		if (helloWorld.getText().equals("")) {
			helloWorld.setText("Hello World!");
		} else {
			helloWorld.setText("");
		}
	}

	public void loginToProgram(ActionEvent actionEvent)
    {
        String napis;
        napis = loginField.getText() + passField.getText();
        checkLogin.setText(napis);


    }

}
