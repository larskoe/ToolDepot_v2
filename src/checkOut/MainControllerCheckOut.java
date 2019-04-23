package checkOut;

import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import itemDatabase.itemArray;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import productPage.ProductView;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

/**
 * @author larskoester
 * This class is the main controller for the checkout process that implements Initializable, which
 * means that it automatically calls the method initialize and loads the screen
 */
public class MainControllerCheckOut implements Initializable{
	
	/**
	 * method that is called when the complete rental button is clicked, it checks if agreement is
	 * checked and gives an error message if not. It loads a Information window if agreement is checked
	 * @param event event parameter on the button
	 */
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
				if (result.get() == buttonTypeYes){
					
					Stage primaryStage = new Stage();
			    	ProductView product = new ProductView();
			    	product.start(primaryStage);
			    	
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
	
	/**
	 * initializes product screen on startup as mainController implements Initializable
	 * @param location is the location of file
	 * @param ResourceBundle is where the resources are
	 */
	public void initialize(URL location, ResourceBundle resources) {
		try {
			temp.initilizeArrayRent();
			//temp.PrintItems(temp.rentList);
			Name.setStyle("-fx-stroke-width: 3");
			Name.setText(temp.rentList.get(0).getToolName());
			Price.setText(temp.rentList.get(0).getPrice());
			Condition.setText(temp.rentList.get(0).getCondition());
			Renter.setText(temp.rentList.get(0).getOwner());
			Description.setText(temp.rentList.get(0).getDescription());
			Avail.setText(temp.rentList.get(0).getAvail());
			
			
			if (temp.rentList.get(0).getCondition().equals("Excellent")) {
				Condition.setStyle("-fx-text-fill: green");
			} else if (temp.rentList.get(0).getCondition().equals("Good")) {
				Condition.setStyle("-fx-text-fill: blue");
			} else if (temp.rentList.get(0).getCondition().equals("Fair")) {
				Condition.setStyle("-fx-text-fill: orange");
			} else if (temp.rentList.get(0).getCondition().equals("Poor")) {
				Condition.setStyle("-fx-text-fill: red");
			}
			
			if (temp.rentList.get(0).getAvail().contains("Not")) {
				Avail.setStyle("-fx-text-fill: red");
			} else {
				Avail.setStyle("-fx-text-fill: green"); 
			}
			
			
			File file1 = new File(temp.rentList.get(0).getImage().toString());
			Image image1 = new Image(file1.toURI().toString());
		    Image.setImage(image1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * all variables and FXML variables needed
	 */
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
	@FXML 
	private Label Description;
	@FXML
	private Label Avail;
}
