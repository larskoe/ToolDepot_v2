package productPage;

import java.util.Optional;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import loginRegister.LoginView;

/**
 * @author larskoester
 * Main Controller for the Product page
 */
public class MainController {

	
	void logout (ActionEvent event) throws Exception {
		
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Alert Logout");
		alert.setHeaderText("Are you sure you want to logout?");
		alert.setContentText("Are you sure?");
		
		ButtonType buttonTypeNo = new ButtonType("No");
		ButtonType buttonTypeYes = new ButtonType("Yes");
		
		alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonTypeYes){
			Platform.exit();
			System.exit(0);
		} else {
		    //do nothing
		}
		
	}

}
