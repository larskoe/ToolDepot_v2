package AddItem;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * The Class AddItemView.
 * @author tylersmith
 */
public class AddItemView extends Application {
	
	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	//@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("AddNew.fxml"));
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Add New Item");
			primaryStage.setScene(scene);
			primaryStage.show();
			//primaryStage.close();
			primaryStageC = primaryStage;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Close it.
	 * closes window
	 */
	public static void closeIt() {
		primaryStageC.close();
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	/** The primary stage C. */
	private static Stage primaryStageC;
}