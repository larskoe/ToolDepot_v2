
    
package loginRegister;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import productPage.ProductView;
import userDatabase.UserArray;

/**
 * @author larskoester
 * class that is the main controller for the Login/Registration process.
 */
public class MainController  {
    @FXML
    private Label lblStatus;
    
    @FXML
    private TextField txtUserName;
        
    @FXML
    private TextField txtPassword;
    
    @FXML
    private TextField txtFullName;
    
    @FXML
    private TextField txtEmail;
    
    @FXML
    private TextField txtCity;
   
    
    /**
     * Calls the login view from the Welcome screen
     * @param event once login button is clicked
     * @throws IOException throws an exception if it detects an error
     */
    public void WelcomeLogin (ActionEvent event) throws Exception {
    	
    	Stage primaryStage = new Stage();
    	LoginView login = new LoginView();
    	login.start(primaryStage);
    }
    
    /**
     * Once user enters username and password, it checks it with database and calls the main view if correct credentials
     * otherwise displays a message for user
     * @param event once login button is pressed it checks for correct credentials
     * @throws Exception throws an exception if it detects an error
     */
    public void Login(ActionEvent event) throws Exception {
    	temp.initilizeArray();
    	check = temp.searchLogin(txtUserName.getText(), txtPassword.getText());
    	
        if(check == true) {
            lblStatus.setText("Login Successful");
            
            Stage primaryStage = new Stage();
            ProductView products = new ProductView();
            products.start(primaryStage);
            //MainView main = new MainView();
            //main.start(primaryStage);
            
        }
        else if (txtUserName.getText().isEmpty() || txtPassword.getText().isEmpty()) 
        {
        	lblStatus.setText("Please enter username and password. Fields cannot be empty!");
        }
        else {
            lblStatus.setText("Login Failed. Please check username and password"); 
        }
    }
    
    /**
     * Calls the register view from the Welcome screen
     * @param event once register button is clicked
     * @throws IOException throws an exception if it detects an error
     */
    public void WelcomeRegister (ActionEvent event) throws Exception {
    	
    	Stage primaryStage = new Stage();
    	RegisterView register = new RegisterView();
    	register.start(primaryStage);
    }

    /**
     * method that handles registering an account. It checks if email or username are in use, and if all fields are 
     * filled out. Then it will add the user's data to the file and call the main view
     * @param event once the user clicks register it will fire
     * @throws Exception throws an exception if it detects an error
     */
    public void Register (ActionEvent event) throws Exception {  	
    	temp.initilizeArray();
    	check = temp.searchRegEmail(txtEmail.getText());
    	checkUser = temp.searchRegUser(txtUserName.getText());
    	
    	
    	if (check == true) {
    		lblStatus.setText("Email already in use. Please choose a different email");
    	}
    	else if (checkUser == true) {
    		lblStatus.setText("Username already in use. Please choose a different username");
    	}
    	else {
    		if (txtFullName.getText().isEmpty() || txtEmail.getText().isEmpty() || txtUserName.getText().isEmpty() || txtPassword.getText().isEmpty() || txtCity.getText().isEmpty()) {
    			lblStatus.setText("Please fill out all fields!");
    		}
    		else {
    			temp.AppendCSV(txtFullName.getText(), txtEmail.getText(), txtUserName.getText(), txtPassword.getText(), txtCity.getText());
    			temp.initilizeArray();
    			lblStatus.setText("Registered succesfully");
    			
                Stage primaryStage = new Stage();
                ProductView products = new ProductView();
                products.start(primaryStage);
                //MainView main = new MainView();
                //main.start(primaryStage);
    		}
    	}    	
    }
    
    private UserArray temp = new UserArray();
    private boolean check = false;
    private boolean checkUser = false;



    
}

