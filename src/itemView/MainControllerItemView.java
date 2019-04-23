package itemView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import checkOut.RentItemView;
import itemDatabase.itemArray;
import itemDatabase.items;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MainControllerItemView implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			temp.initilizeArrayRent();
			toolName.setText(temp.rentList.get(0).getToolName());
			price.setText(temp.rentList.get(0).getPrice());
			condition.setText(temp.rentList.get(0).getCondition());
			description.setText(temp.rentList.get(0).getDescription());
			avail.setText(temp.rentList.get(0).getAvail());
			
			File file1 = new File(temp.rentList.get(0).getImage().toString());
			Image image1 = new Image(file1.toURI().toString());
		    Pic.setImage(image1);
		    
		    if (temp.rentList.get(0).getCondition().equals("Excellent")) {
				condition.setStyle("-fx-text-fill: green");
			} else if (temp.rentList.get(0).getCondition().equals("Good")) {
				condition.setStyle("-fx-text-fill: blue");
			} else if (temp.rentList.get(0).getCondition().equals("Fair")) {
				condition.setStyle("-fx-text-fill: orange");
			} else if (temp.rentList.get(0).getCondition().equals("Poor")) {
				condition.setStyle("-fx-text-fill: red");
			}
			
			if (temp.rentList.get(0).getAvail().contains("Not")) {
				avail.setStyle("-fx-text-fill: red");
			} else {
				avail.setStyle("-fx-text-fill: green"); 
			}
			
			
		} catch (Exception e) {
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
	@FXML
	Label toolName;
	@FXML
	Label price;
	@FXML
	Label condition;
	@FXML
	Label owner;
	@FXML
	Label description;
	@FXML
	Label avail;
	@FXML
	ImageView Pic;
}
