package checkOut;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import complete.CompleteRentalView;
import itemDatabase.itemArray;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class MainController implements Initializable{
	

	public void rentComplete (ActionEvent event) {
		
		try {
			if (AgreeCheck.isSelected()) 
			{
				Status.setText("Selected Agreement!");
				
				Stage primaryStage = new Stage();
				CompleteRentalView complete = new CompleteRentalView();
				complete.start(primaryStage);
				
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
			Name.setText(temp.rentList.get(0).getToolName());
			Price.setText(temp.rentList.get(0).getPrice());
			Condition.setText(temp.rentList.get(0).getCondition());
			Renter.setText(temp.rentList.get(0).getOwner());
			
			File file1 = new File(temp.rentList.get(0).getImagePath().toString());
			Image image1 = new Image(file1.toURI().toString());
		    Image.setImage(image1);
			
		} catch (Exception e) {
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
