package itemView;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ItemView extends Application {

	@Override
    public void start(Stage primaryStage) {
    	try {
            Parent root = FXMLLoader.load(getClass().getResource("/itemView/Item.fxml"));
            Scene scene = new Scene(root);
            
            //scene.getStylesheets().add(getClass().getResource("product.css").toExternalForm());
        
            primaryStage.setTitle("Item-ToolDepot"); 
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



