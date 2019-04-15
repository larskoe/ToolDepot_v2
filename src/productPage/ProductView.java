package productPage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProductView extends Application {

	@Override
    public void start(Stage primaryStage) {
    	try {
            Parent root = FXMLLoader.load(getClass().getResource("Product.fxml"));
            Scene scene = new Scene(root);
            
            //scene.getStylesheets().add(getClass().getResource("Login.css").toExternalForm());
        
            primaryStage.setTitle("Products-ToolDepot"); 
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


