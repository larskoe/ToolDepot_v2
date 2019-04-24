package AddItem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * The Class MainControllerConfirm.
 * @author tylersmith
 * this function confirms or declines add item
 */
public class MainControllerConfirm {

	/** The confirm. */
	@FXML
	public Button confirm;
	
	/** The decline. */
	@FXML
	public Button decline;
	
	
	/**
	 * Confirm add.
	 * adds item to itemDatabase by calling the AddNew() function from AddItem
	 * closes both windows
	 *
	 * @param event the event
	 * @throws Exception the exception
	 */
	public void confirmAdd(ActionEvent event) throws Exception {
		MainControllerAddItem.AddNew();
		AddItemView.closeIt();
		ConfirmView.closeIt();
		
	}
	
	/**
	 * Decline add.
	 * this function returns to previous window and closes current window
	 *
	 * @param event the event
	 * @throws Exception the exception
	 */
	public void declineAdd(ActionEvent event) throws Exception {
		ConfirmView.closeIt();
	}
	
}
