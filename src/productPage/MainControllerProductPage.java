package productPage;

import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import AddItem.AddItemView;
import DisplayTool.DisplayItemView;
import Search.SearchView;
import checkOut.RentItemView;
import itemDatabase.itemArray;
import itemDatabase.items;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import profile.ProfileView;

/**
 * @author larskoester
 * @author TylerSmith
 * Main Controller for the Product page that implements Initializable and 
 * calls the method initialize on startup 
 */
public class MainControllerProductPage implements Initializable {

	/**
	 * Logout function with an alert box to confirm logout
	 * @param event event handler
	 * @throws Exception throws an exception if it detects an error
	 */
	public void logout (ActionEvent event) throws Exception {
		
		//sets up alert box
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Alert Logout");
		alert.setHeaderText("Are you sure you want to logout?");
		
		//sets up yes and no button
		ButtonType buttonTypeNo = new ButtonType("No");
		ButtonType buttonTypeYes = new ButtonType("Yes");
		alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
		Optional<ButtonType> result = alert.showAndWait();
		
		//if button is yes, log out, else do nothing
		if (result.get() == buttonTypeYes){
			temp.rentList.clear();
			Platform.exit();
			System.exit(0);
		} else {
		    //do nothing
		}
	}
	
	/**
	 * this method calls the search scene when clicked in the menu bar
	 * @param event event handler
	 */
	public void search (ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
            SearchView search = new SearchView();
            search.start(primaryStage);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void view (ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
            DisplayItemView display = new DisplayItemView();
            display.start(primaryStage);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void add (ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
            AddItemView add = new AddItemView();
            add.start(primaryStage);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * method that is called when rent
	 * @param event
	 */
	public void rent (ActionEvent event) {
		try {
			String name;
			String price;
			Button btn = (Button) event.getSource();
			String id = btn.getId();
			temp.rentList.clear();
			
			if (id.equals("Rent1")) {
				name = Name1.getText();
				price = Price1.getText();
			} else if (id.equals("Rent2")) {
				name = Name2.getText();
				price = Price2.getText();
			} else if (id.equals("Rent3")) {
				name = Name3.getText();
				price = Price3.getText();
			} else if (id.equals("Rent4")) {
				name = Name4.getText();
				price = Price4.getText();
			} else if (id.equals("Rent5")) {
				name = Name5.getText();
				price = Price5.getText();
			} else if (id.equals("Rent6")) {
				name = Name6.getText();
				price = Price6.getText();
			} else if (id.equals("Rent7")) {
				name = Name7.getText();
				price = Price7.getText();
			} else if (id.equals("Rent8")) {
				name = Name8.getText();
				price = Price8.getText();
			} else if (id.equals("Rent8")) {
				name = Name8.getText();
				price = Price8.getText();
			} else if (id.equals("Rent9")) {
				name = Name9.getText();
				price = Price9.getText();
			} else {
				name = Name10.getText();
				price = Price10.getText();
			}
			
			
			items rentItem = new items();
			rentItem.setToolName(name);
			rentItem.setPrice(price);
			temp.rentList.add(rentItem);
			
			
			for (int i = 0; i < temp.itemList.size(); i++)
			{
				if(temp.itemList.get(i).getToolName().equals(temp.rentList.get(0).getToolName()))
				{
					temp.AppendCSVRent(temp.itemList.get(i).getItemNum(), temp.itemList.get(i).getOwner(), 
							temp.itemList.get(i).getCategory(), name, temp.itemList.get(i).getCondition(), 
							price, temp.itemList.get(i).getImage(), temp.itemList.get(i).getDescription(), temp.itemList.get(i).getAvail());
				}
			}
			
			Stage primaryStage = new Stage();
	    	RentItemView rent = new RentItemView();
	    	rent.start(primaryStage);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void profile (ActionEvent event) {
		
		Stage primaryStage = new Stage();
        ProfileView profile = new ProfileView();
        profile.start(primaryStage);
	}
	

	/**
	 * initializes product screen on startup as mainController implements Initializable
	 * @param location is the location of file
	 * @param ResourceBundle is where the resources are
	 */
	public void initialize(URL location, ResourceBundle resources) {
		try {
			temp.initilizeArray(); 
			temp.initilizeArrayRent();
			
			//1st Pane
			Name1.setText(temp.itemList.get(0).getToolName());	
			Price1.setText("$" + temp.itemList.get(0).getPrice());
			File file1 = new File(temp.itemList.get(0).getImage().toString());
			Image image1 = new Image(file1.toURI().toString());
		    Image1.setImage(image1);
		    
		    //2nd Pane
			Name2.setText(temp.itemList.get(1).getToolName());
			Price2.setText("$" + temp.itemList.get(1).getPrice());
			File file2 = new File(temp.itemList.get(1).getImage().toString());
			Image image2 = new Image(file2.toURI().toString());
		    Image2.setImage(image2);
			
		    //3rd Pane
			Name3.setText(temp.itemList.get(2).getToolName());
			Price3.setText("$" + temp.itemList.get(2).getPrice());
			File file3 = new File(temp.itemList.get(2).getImage().toString());
			Image image3 = new Image(file3.toURI().toString());
		    Image3.setImage(image3);
		    
		    //4th Pane
			Name4.setText(temp.itemList.get(3).getToolName());
			Price4.setText("$" + temp.itemList.get(3).getPrice());
			File file4 = new File(temp.itemList.get(3).getImage().toString());
			Image image4 = new Image(file4.toURI().toString());
		    Image4.setImage(image4);
		    
		    //5th Pane
			Name5.setText(temp.itemList.get(4).getToolName());
			Price5.setText("$" + temp.itemList.get(4).getPrice());
			File file5 = new File(temp.itemList.get(4).getImage().toString());
			Image image5 = new Image(file5.toURI().toString());
		    Image5.setImage(image5);
		    
		    //6th Pane
			Name6.setText(temp.itemList.get(5).getToolName());
			Price6.setText("$" + temp.itemList.get(5).getPrice());
			File file6 = new File(temp.itemList.get(5).getImage().toString());
			Image image6 = new Image(file6.toURI().toString());
		    Image6.setImage(image6);
		    
		    //7th Pane
			Name7.setText(temp.itemList.get(6).getToolName());
			Price7.setText("$" + temp.itemList.get(6).getPrice());
			File file7 = new File(temp.itemList.get(6).getImage().toString());
			Image image7 = new Image(file7.toURI().toString());
		    Image7.setImage(image7);
		    
		    //8th Pane
			Name8.setText(temp.itemList.get(7).getToolName());
			Price8.setText("$" + temp.itemList.get(7).getPrice());
			File file8 = new File(temp.itemList.get(7).getImage().toString());
			Image image8 = new Image(file8.toURI().toString());
		    Image8.setImage(image8);
		    
		    //9th Pane
			Name9.setText(temp.itemList.get(8).getToolName());
			Price9.setText("$" + temp.itemList.get(8).getPrice());
			File file9 = new File(temp.itemList.get(8).getImage().toString());
			Image image9 = new Image(file9.toURI().toString());
		    Image9.setImage(image9);
		    
		    //10th Pane
			Name10.setText(temp.itemList.get(9).getToolName());
			Price10.setText("$" + temp.itemList.get(9).getPrice());
			File file10 = new File(temp.itemList.get(9).getImage().toString());
			Image image10 = new Image(file10.toURI().toString());
		    Image10.setImage(image10);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * variables and FXML variables needed
	 */
	private itemArray temp = new itemArray();
	@FXML
	private Label Name1;
	@FXML
	private Label Price1;
	@FXML
	private ImageView Image1;
	@FXML
	private Label Name2;
	@FXML
	private Label Price2;
	@FXML
	private ImageView Image2;
	@FXML
	private Label Name3;
	@FXML
	private Label Price3;
	@FXML
	private ImageView Image3;
	@FXML
	private Label Name4;
	@FXML
	private Label Price4;
	@FXML
	private ImageView Image4;
	@FXML
	private Label Name5;
	@FXML
	private Label Price5;
	@FXML
	private ImageView Image5;
	@FXML
	private Label Name6;
	@FXML
	private Label Price6;
	@FXML
	private ImageView Image6;
	@FXML
	private Label Name7;
	@FXML
	private Label Price7;
	@FXML
	private ImageView Image7;
	@FXML
	private Label Name8;
	@FXML
	private Label Price8;
	@FXML
	private ImageView Image8;
	@FXML
	private Label Name9;
	@FXML
	private Label Price9;
	@FXML
	private ImageView Image9;
	@FXML
	private Label Name10;
	@FXML
	private Label Price10;
	@FXML
	private ImageView Image10;
}
