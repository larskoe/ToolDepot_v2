package profile;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import userDatabase.UserArray;

/**
 * @author larskoester
 * Class that is the main controller for the Profile which implements Initializable 
 *
 */
public class MainControllerProfile implements Initializable {

	/**
	 * initializes profile screen on startup as mainController implements Initializable
	 * @param location is the location of file
	 * @param ResourceBundle is where the resources are
	 */
	public void initialize(URL location, ResourceBundle resources) {
		try {
			temp.initilizeArray();
			temp.initilizeArraySession();
			
			Name.setText(temp.sessionList.get(0).getFullName());
			User.setText(temp.sessionList.get(0).getUserName());
			Email.setText(temp.sessionList.get(0).getEmail());
			City.setText(temp.sessionList.get(0).getCity());
			File file = new File(temp.sessionList.get(0).getImagePath().toString());
			Image image = new Image(file.toURI().toString());
		    Image.setImage(image);
		    
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * variables and FXML variables needed
	 */
	private UserArray temp = new UserArray();
	@FXML
	private Label Name;
	@FXML
	private Label User;
	@FXML
	private Label Email;
	@FXML
	private Label City;
	@FXML
	private ImageView Image;
}
