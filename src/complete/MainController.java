package complete;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import itemDatabase.itemArray;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class MainController implements Initializable{

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			temp.initilizeArrayRent();
			System.out.println("Complete rental");
			temp.PrintItems();
			Renter.setText(temp.rentList.get(0).getOwner());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private itemArray temp = new itemArray();
	@FXML
	private Label Renter;
}
