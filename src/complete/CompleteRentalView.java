package complete;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CompleteRentalView extends Application {
	
	public void start(Stage primaryStage) {
    	try {
            Parent root = FXMLLoader.load(getClass().getResource("CompleteRental.fxml"));
            Scene scene = new Scene(root);
            
            //scene.getStylesheets().add(getClass().getResource("Login.css").toExternalForm());
        
            primaryStage.setTitle("Complete-ToolDepot"); 
            primaryStage.setScene(scene);
            primaryStage.show();
        
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


