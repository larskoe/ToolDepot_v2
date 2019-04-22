package AddItem;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

import AddItem.MainControllerAddItem;


public class ConfirmView extends Application {


//@Override
public void start(Stage primaryStage) {
	try {
		Parent root = FXMLLoader.load(getClass().getResource("ConfirmBox.fxml"));
		Scene scene = new Scene(root, 300, 200);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setTitle("Add New Item Confirmation");
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