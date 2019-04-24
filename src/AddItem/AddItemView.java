package AddItem;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

import AddItem.MainControllerAddItem;


public class AddItemView extends Application {
	

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
	
	public static void closeIt() {
		primaryStageC.close();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private static Stage primaryStageC;
}