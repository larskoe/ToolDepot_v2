package AddItem;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import DisplayTool.DisplayItem;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import itemDatabase.itemArray;
import itemDatabase.items;
import AddItem.MainAddItem;

/**@author tyler
 * The Class MainControllerAddItem.
 */
public class MainControllerAddItem implements Initializable{
	
	
	@FXML
	public ComboBox<String> category;
	@FXML
	public ComboBox<String> condition;
	@FXML
	public TextField toolName;
	@FXML
	public TextArea description;
	@FXML
	public TextField owner;
	@FXML
	public TextField price;
	@FXML
	public Label status;
	@FXML
	public Button post;
	
	
	ObservableList<String> categoryList = FXCollections.observableArrayList("tool", "basic tool", "power tool","ladder", "saw", "cement", "wood working", "motorized", "painting");
	ObservableList<String> conditionList = FXCollections.observableArrayList("Excellent", "Good", "Fair", "Poor");

	
	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			temp.initilizeArray();
			
			category.setItems(categoryList);
			condition.setItems(conditionList);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * reads the text fields and combo boxes into a new item
	 *
	 * @param event the event
	 * @throws Exception the exception
	 */
	public void add(ActionEvent event) throws Exception {
		
		addThisItem.setCategory(category.getValue());
		addThisItem.setToolName(toolName.getText());
		addThisItem.setDescription(description.getText());
		addThisItem.setOwner(owner.getText());
		addThisItem.setCondition(condition.getValue());
		addThisItem.setPrice(price.getText());
		addThisItem.setAvail("");
		String allInfo = addThisItem.getCategory() + addThisItem.getToolName() + addThisItem.getDescription() + 
				addThisItem.getOwner() + addThisItem.getCondition() + addThisItem.getPrice();
		
		if (allInfo.contains("null")) {
			status.setText("Please fill in all required feilds");
			/*
			Stage primaryStage = new Stage();
	    	Confirm Select = new Confirm();
	    	Select.start(primaryStage);
	    	*/
		}
		else {
		
		System.out.println(allInfo);
		int lastNum = temp.findLastItemNum();
		lastNum++;
		addThisItem.setItemNum(Integer.toString(lastNum));
		
		addThisItem.setImage("src/img/" + lastNum + ".png");
		
		
		Stage primaryStage = new Stage();
    	Confirm Select = new Confirm();
    	Select.start(primaryStage);
		
		//MainAddItem.closeIt();
		
		}
		
		
	}
	
	/**
	 * Adds the new item to the database
	 */
	public static void AddNew() {
		temp.AppendCSV(addThisItem);
	}
	
	
	/** The temp. 
	 * this is where the information from the itemdatabase is stored
	 **/
	private static itemArray temp = new itemArray();
	public static items addThisItem = new items();
	
	
}
