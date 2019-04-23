package Search;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import itemDatabase.itemArray;
import itemDatabase.items;
import DisplayTool.DisplayItemView;


/**
 * @author tyler
 * class that implements searching for items in database 
 */


public class MainControllerSearch implements Initializable {
	
	@FXML
	public Button search;
	@FXML
	public Button clear;
	@FXML
	public Button select;
	@FXML
	public Button showAll;
	@FXML
	public ComboBox<String> category;
	@FXML
	public TextField keyword;
	@FXML
	public ListView<String> listview;
	
	public List<items> searchList = new ArrayList<items>();
	
	public static ObservableList<String> name;


	ObservableList<String> categoryList = FXCollections.observableArrayList("tool", "basic tool", "power tool","ladder", "saw", "cement", "wood working", "motorized", "painting");
	
	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 * 
	 * Initializes window
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		try {
			category.setItems(categoryList);
			temp.initilizeArray();
			searchList = temp.searchItemName("");
			for (int i = 0; i < searchList.size(); i++) {
				listview.getItems().add(searchList.get(i).getItemNum() + ":  " + searchList.get(i).getToolName());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Shows all items in database
	 * action on a button press called show all
	 *
	 * @param event the event
	 * @throws Exception the exception
	 */
	public void showAll(ActionEvent event) throws Exception {
		searchList.clear();
		searchList = temp.searchItemName("");
		for (int i = 0; i < searchList.size(); i++) {
			listview.getItems().add(searchList.get(i).getItemNum() + ":  " + searchList.get(i).getToolName());
		}
	}
	
	/**
	 * allows user to choose category and updates list of items
	 * action on a combobox.
	 *
	 * @param event the event
	 * @throws Exception the exception
	 */
	public void chooseCat(ActionEvent event) throws Exception {
		
		searchList.clear();
		listview.getItems().clear();
		searchList = temp.searchCategory(category.getValue());
		temp.PrintItems(searchList);
		for (int i = 0; i < searchList.size(); i++) {
			listview.getItems().add(searchList.get(i).getItemNum() + ":  " + searchList.get(i).getToolName());
		}
	}

	/**
	 * Searches item list for a keyword
	 * action on a button press that reads from a textfield
	 *
	 * @param event the event
	 * @throws Exception the exception
	 */
	public void searchKey(ActionEvent event) throws Exception {
		
		searchList.clear();
		listview.getItems().clear();
		searchList = temp.searchItemName(keyword.getText().toLowerCase());
		//temp.PrintItems(searchList);
		if (searchList.get(0).equals(null)) {
			System.out.println("please enter something");
		}
		else 
		{
			for (int i = 0; i < searchList.size(); i++) {
				listview.getItems().add(searchList.get(i).getItemNum() + ":  " + searchList.get(i).getToolName());
				}
		}
	}
	
	/**
	 * Clears list of items
	 *
	 * @param event the event
	 * @throws Exception the exception
	 */
	public void clear(ActionEvent event) throws Exception {
		listview.getItems().clear();
	}
	
	/**
	 * Selects the item and opens a new window to view item
	 *
	 * @param event the event
	 */
	public void select(ActionEvent event) {
		try {
			name = listview.getSelectionModel().getSelectedItems();
			//System.out.println(name);
			Stage primaryStage = new Stage();
	    	DisplayItemView Item = new DisplayItemView();
	    	Item.start(primaryStage);
			
		} catch (Exception e) {
			
			e.printStackTrace();	
		}
	}
	

	private itemArray temp = new itemArray();
	
}
	