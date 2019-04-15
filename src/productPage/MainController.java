package productPage;

import java.util.Optional;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

/**
 * @author larskoester
 * Main Controller for the Product page
 */
public class MainController {
	@FXML

	/**
	 * Logout function with an alert box to confirm logout
	 * @param event event handler
	 * @throws Exception throws an exception if it detects an error
	 */
	void logout (ActionEvent event) throws Exception {
		
		//sets up alert box
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Alert Logout");
		alert.setHeaderText("Are you sure you want to logout?");
		alert.setContentText("Are you sure?");
		
		//sets up yes and no button
		ButtonType buttonTypeNo = new ButtonType("No");
		ButtonType buttonTypeYes = new ButtonType("Yes");
		alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
		Optional<ButtonType> result = alert.showAndWait();
		
		//if button is yes, log out, else do nothing
		if (result.get() == buttonTypeYes){
			Platform.exit();
			System.exit(0);
		} else {
		    //do nothing
		}
	}
	
	void search (ActionEvent event) throws Exception { 
		
	}

}
