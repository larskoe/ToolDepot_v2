package Search;

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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import itemDatabase.itemArray;
import itemDatabase.items;

public class MainController implements Initializable {
	
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
	
	public void showAll(ActionEvent event) throws Exception {
		searchList.clear();
		searchList = temp.searchItemName("");
		for (int i = 0; i < searchList.size(); i++) {
			listview.getItems().add(searchList.get(i).getItemNum() + ":  " + searchList.get(i).getToolName());
		}
	}
	
	public void chooseCat(ActionEvent event) throws Exception {
		
		searchList.clear();
		listview.getItems().clear();
		searchList = temp.searchCategory(category.getValue());
		temp.PrintItems(searchList);
		for (int i = 0; i < searchList.size(); i++) {
			listview.getItems().add(searchList.get(i).getItemNum() + ":  " + searchList.get(i).getToolName());
		}
	}

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
	
	public void clear(ActionEvent event) throws Exception {
		listview.getItems().clear();
	}
	
	public void select(ActionEvent event) {
		try {
			name = listview.getSelectionModel().getSelectedItems();
			//System.out.println(name);
			Stage primaryStage = new Stage();
	    	DisplayItem Item = new DisplayItem();
	    	Item.start(primaryStage);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}

	}
	

	private itemArray temp = new itemArray();
	
	}
	