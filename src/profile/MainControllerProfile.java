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

public class MainControllerProfile implements Initializable {

	
	public void initialize(URL location, ResourceBundle resources) {
		try {
			temp.initilizeArray();
			Name.setText(temp.sessionList.get(0).getFullName());
			User.setText(temp.sessionList.get(0).getUserName());
			Email.setText(temp.sessionList.get(0).getEmail());
			City.setText(temp.sessionList.get(0).getCity());
			File file = new File(temp.sessionList.get(0).getImagePath().toString());
			Image image = new Image(file.toURI().toString());
		    Image.setImage(image);
		    
		    System.out.println(temp.sessionList.get(0).getFullName());
		    
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

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
