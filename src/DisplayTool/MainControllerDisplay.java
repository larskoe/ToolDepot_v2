package DisplayTool;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import application.MainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.TextFlow;
import itemDatabase.itemArray;
import itemDatabase.items;

public class MainControllerDisplay implements Initializable{
	
	@FXML
	public Button rent;
	@FXML
	private Label price;
	@FXML
	private Label toolName;
	@FXML
	private Label condition;
	@FXML
	private Label owner;
	@FXML
	private Label description;
	@FXML
	private Label avail;
	@FXML
	private ImageView Pic;
	private Image pic;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			temp.initilizeArray();
			choiceNum = MainController.name.get(0).substring(0, 3);
			choice = temp.searchItemNum(choiceNum);
			choiceName = "Tool Name: " + choice.getToolName();
			choiceOwner = "Current Owner: " + choice.getOwner();
			choicePrice = "Price Per Day: $" + choice.getPrice();
			choiceImage = choice.getImage();
			choiceCondition = "Current Condition: " + choice.getCondition();
			choiceDescription = "Product Description: \n" + choice.getDescription();
			choiceAvail = "Availability Status: \n" + choice.getAvail();
			
			price.setText(choicePrice);
			toolName.setText(choiceName);
			owner.setText(choiceOwner);
			description.setText(choiceDescription);
			condition.setText(choiceCondition);
			avail.setText(choiceAvail);
			
			File file = new File(choiceImage.toString());
			pic = new Image(file.toURI().toString());
		    Pic.setImage(pic);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void rent(ActionEvent event) throws Exception {
		System.out.println("you want to rent this");
	}
	
	public void print () {
		System.out.println(choiceImage);
		//temp.PrintItems(temp.itemList);
	}

	private itemArray temp = new itemArray();
	private String choiceNum;
	private String choiceName;
	private String choiceOwner;
	private String choicePrice;
	private String choiceImage;
	private String choiceCondition;
	private String choiceDescription;
	private String choiceAvail;
	//public List<items> choice = new ArrayList<items>();
	public items choice = new items();
}
