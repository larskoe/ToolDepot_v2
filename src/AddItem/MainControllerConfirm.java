package AddItem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainControllerConfirm {

	
	@FXML
	public Button confirm;
	@FXML
	public Button decline;
	
	
	public void confirmAdd(ActionEvent event) throws Exception {
		MainControllerAddItem.AddNew();
		MainAddItem.closeIt();
		Confirm.closeIt();
		
	}
	
	public void declineAdd(ActionEvent event) throws Exception {
		Confirm.closeIt();
	}
	
}
