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
//        String napis;
//        napis = loginField.getText() + passField.getText();
//        checkLogin.setText(napis);

        String login = loginField.getText(); // zmienne do logowania trzeba by je
        // porównać czy istnieje taki użytkownik następnie sprawdzić czy ma uprawnienia
        //studenta czy admina i w zależności od uprawnień wywołać odpowiednie okno(admin, student)
        String pass =passField.getText();


    }

}
