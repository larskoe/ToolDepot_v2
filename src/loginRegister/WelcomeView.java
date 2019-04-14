package loginRegister;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author larskoester
 * view that loads the Welcome screen for the application
 */
public class WelcomeView extends Application {
	
    
    @Override
    public void start(Stage primaryStage) {
        try {
                  
        Parent root = FXMLLoader.load(getClass().getResource("/loginRegister/Welcome.fxml"));
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Welcome to ToolDepot");
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
