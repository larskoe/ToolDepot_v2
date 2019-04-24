package DisplayTool;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import itemDatabase.itemArray;
import itemDatabase.items;
import Search.MainControllerSearch;
import checkOut.RentItemView;


/**
 * The Class MainControllerDisplay.
 * @author tylersmith
 */
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
			choiceNum = MainControllerSearch.name.get(0).substring(0, 3);
			choice = temp.searchItemNum(choiceNum);
			choiceName = choice.getToolName();
			choiceOwner = choice.getOwner();
			choicePrice = choice.getPrice();
			choiceImage = choice.getImage(); 
			choiceCondition = choice.getCondition();
			choiceDescription = choice.getDescription();
			choiceAvail = choice.getAvail();
			
			choiceImageError = "resource/no_image.png";
			
			price.setText("$" + choicePrice);
			toolName.setText(choiceName);
			owner.setText(choiceOwner);
			description.setText(choiceDescription);
			condition.setText(choiceCondition);
			avail.setText(choiceAvail);
			
			if (choiceCondition.equals("Excellent")) {
				condition.setStyle("-fx-text-fill: green");
			} else if (choiceCondition.equals("Good")) {
				condition.setStyle("-fx-text-fill: blue");
			} else if (choiceCondition.equals("Fair")) {
				condition.setStyle("-fx-text-fill: orange");
			} else if (choiceCondition.equals("Poor")) {
				condition.setStyle("-fx-text-fill: red");
			}
			
			if (choiceAvail.contains("Not")) {
				avail.setStyle("-fx-text-fill: red");
			} else {
				avail.setStyle("-fx-text-fill: green"); 
			}
			
			File file = new File(choiceImage.toString());
			pic = new Image(file.toURI().toString());
			if (pic.isError()) {
				File fileErr = new File(choiceImageError.toString());
				pic = new Image(fileErr.toURI().toString());
			}
		    Pic.setImage(pic);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * method that opens the rent view and shows the applicable information
	 * @param event event handler for the button
	 */
	public void rent(ActionEvent event) throws Exception {
		try {
			temp.rentList.clear();
			
			String name = toolName.getText();
			String price1 = price.getText();
			
			items rentItem = new items();
			rentItem.setToolName(name);
			rentItem.setPrice(price1);
			temp.rentList.add(rentItem);
			
			
			for (int i = 0; i < temp.itemList.size(); i++)
			{
				if(temp.itemList.get(i).getToolName().equals(temp.rentList.get(0).getToolName()))
				{
					temp.AppendCSVRent(temp.itemList.get(i).getItemNum(), temp.itemList.get(i).getOwner(), 
							temp.itemList.get(i).getCategory(), name, temp.itemList.get(i).getCondition(), 
							price1, temp.itemList.get(i).getImage(), temp.itemList.get(i).getDescription(), 
							temp.itemList.get(i).getAvail());
				}
			}
			
			
			
			Stage primaryStage = new Stage();
	    	RentItemView rent = new RentItemView();
	    	rent.start(primaryStage);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	private itemArray temp = new itemArray();
	private String choiceNum;
	private String choiceName;
	private String choiceOwner;
	private String choicePrice;
	private String choiceImage;
	private String choiceImageError;
	private String choiceCondition;
	private String choiceDescription;
	private String choiceAvail;
	public items choice = new items();
}
