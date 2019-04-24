package checkOut;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author larskoester
 * view that loads the rental screen for the application
 */
public class RentItemView extends Application {
	
	/**
	 * start method for starting the scene that calls fxml file
	 */
	public void start(Stage primaryStage) {
    	try {
            Parent root = FXMLLoader.load(getClass().getResource("/checkOut/Rent.fxml"));
            Scene scene = new Scene(root);
            
            //scene.getStylesheets().add(getClass().getResource("Login.css").toExternalForm());
        
            primaryStage.setTitle("Rent-ToolDepot"); 
            primaryStage.setScene(scene);
            primaryStage.show();
            
            primaryStage.focusedProperty().addListener((ov, onHidden, onShown) -> {
                if(!primaryStage.isFocused())
                    Platform.runLater(() -> primaryStage.close());
            });
        
        } catch(Exception e) {
            e.printStackTrace();
        } 
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}


