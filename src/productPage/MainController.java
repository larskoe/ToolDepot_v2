package productPage;

import java.io.File;
import java.net.URL;
import java.util.ListIterator;
import java.util.Optional;
import java.util.ResourceBundle;

import itemDatabase.itemArray;
import itemDatabase.items;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author larskoester
 * Main Controller for the Product page
 */
public class MainController implements Initializable {
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
	private Label Name3;
	@FXML
	private Label Price3;
	@FXML
	private Label Name4;
	@FXML
	private Label Price4;

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
	
	public void search (ActionEvent event) throws Exception {
		//System.out.println("Search called!");
		temp.initilizeArray();
		//System.out.println("Initialize called!");
		temp.PrintUsers();
		//System.out.println("print called!");
	}
	
	public void InitilizeScreen (ActionEvent event) {
		
		try {
			temp.initilizeArray(); 
			temp.PrintUsers();
			
			Name1.setText(temp.itemList.get(0).getToolName());	
			Price1.setText(temp.itemList.get(0).getPrice());
			Name2.setText(temp.itemList.get(1).getToolName());
			Price2.setText(temp.itemList.get(1).getPrice());
			Name3.setText(temp.itemList.get(2).getToolName());
			Price3.setText(temp.itemList.get(2).getPrice());	
			Name4.setText(temp.itemList.get(3).getToolName());
			Price4.setText(temp.itemList.get(3).getPrice());
		} catch (Exception e) {
			System.out.println("in initilizeScreen");
			e.printStackTrace();
		}
		
		
		//System.out.println(temp.itemList.get(0).getToolName());
		
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			temp.initilizeArray(); 
			temp.PrintUsers();
			String filename = "src/resources/" + temp.itemList.get(0).getItemNum() + ".jpg";
		    //File file = new File("src/resources/" + temp.itemList.get(0).getItemNum() + ".jpg");
			File file = new File("src/resources/101.jpg");
			File file = new File("src/resources/﻿101.jpg");
			//File file = new File(filename.toString());
		    System.out.println(file);
		    Image image = new Image(file.toURI().toString());
		    Image1.setImage(image);
		    
			Name1.setText(temp.itemList.get(0).getToolName());	
			Price1.setText(temp.itemList.get(0).getPrice());
			Name2.setText(temp.itemList.get(1).getToolName());
			Price2.setText(temp.itemList.get(1).getPrice());
			Name3.setText(temp.itemList.get(2).getToolName());
			Price3.setText(temp.itemList.get(2).getPrice());	
			Name4.setText(temp.itemList.get(3).getToolName());
			Price4.setText(temp.itemList.get(3).getPrice());
			
		} catch (Exception e) {
			System.out.println("in initilize");
			e.printStackTrace();
		}
		
	}


	private itemArray temp = new itemArray();
}
