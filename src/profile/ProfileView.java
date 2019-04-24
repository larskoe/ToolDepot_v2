package profile;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author larskoester
 * view that loads the product screen for the application
 */
public class ProfileView extends Application {
    
	/**
	 * start method for starting the scene that calls fxml file
	 */
    public void start(Stage primaryStage) {
    	try {
    		Parent root = FXMLLoader.load(getClass().getResource("/profile/Profile.fxml"));
            Scene scene = new Scene(root);
            
            //scene.getStylesheets().add(getClass().getResource("Login.css").toExternalForm());
        
            primaryStage.setTitle("Profile-ToolDepot"); 
            primaryStage.setScene(scene);
            primaryStage.show();
        
        } catch(Exception e) {
        	//System.out.println("in login view");
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
