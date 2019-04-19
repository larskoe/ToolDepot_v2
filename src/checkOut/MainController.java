package checkOut;

import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import itemDatabase.itemArray;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

public class MainController implements Initializable{
	

	public void rentComplete (ActionEvent event) {
		
		try {
			if (AgreeCheck.isSelected()) 
			{
				Status.setText("Selected Agreement!");
				
				//sets up alert box
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Thank you!");
				alert.setHeaderText("The renter will be in contact with you!");
				
				//sets up yes and no button
				ButtonType buttonTypeNo = new ButtonType("OK and close");
				ButtonType buttonTypeYes = new ButtonType("Ok and go back");
				alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
				Optional<ButtonType> result = alert.showAndWait();
				
				//if button is yes, log out, else do nothing
				if (result.get() == buttonTypeNo){
					Platform.exit();
					System.exit(0);
				} else {
				    //do nothing
				}
			}
			else 
			{
				Status.setText("Please accept the Terms and Conditions!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initialize(URL location, ResourceBundle resources) {
		try {
			temp.initilizeArrayRent();
			temp.PrintItems();
			Name.setText(temp.rentList.get(0).getToolName());
			Price.setText(temp.rentList.get(0).getPrice());
			Condition.setText(temp.rentList.get(0).getCondition());
			Renter.setText(temp.rentList.get(0).getOwner());
			
			File file1 = new File(temp.rentList.get(0).getImagePath().toString());
			Image image1 = new Image(file1.toURI().toString());
		    Image.setImage(image1);
			
		} catch (Exception e) {
			System.out.println("Fail here");
			e.printStackTrace();
		}
		
	}

	private itemArray temp = new itemArray();
	@FXML
	private Label Name;
	@FXML
	private Label Price;
	@FXML
	private Label Condition;
	@FXML
	private Label Renter;
	@FXML
	private CheckBox AgreeCheck;
	@FXML
	private ImageView Image;
	@FXML 
	private Label Status;
}
