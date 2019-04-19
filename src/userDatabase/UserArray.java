package userDatabase;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 * @author larskoester
 * class that implements the user array for searching, adding, removing, etc. 
 */
public class UserArray {
	
	/**
	 * method that reads from the CSV file and initializes an array list for later use. uses CVSParser
	 * @throws IOException throws an IO exception if an error occurs
	 */
	public void initilizeArray () throws IOException {
        try (Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT))
        {
        	userList.clear();
			for (CSVRecord csvRecord : csvParser) {
			          
				// Accessing values by the names assigned to each column
				String fullName = csvRecord.get(0);
			    String email = csvRecord.get(1);
			    String username = csvRecord.get(2);
			    String password = csvRecord.get(3);
			    String city = csvRecord.get(4);
	    
			    users newUser = new users();
			    newUser.setFullName(fullName);
			    newUser.setEmail(email);
			    newUser.setUserName(username);
			    newUser.setPassword(password);
			    newUser.setCity(city);
			    userList.add(newUser);           
	            }
	        }
	    }
	
	/**
	 * prints the list of users for development purposes only
	 */
	public void PrintUsers () {
		
		//for loop that prints all the users in the userlist
		for (int i = 0; i < userList.size(); i++)
		{
			System.out.print(userList.get(i).getFullName()+ " | ");
			System.out.print(userList.get(i).getEmail()+ " | ");
			System.out.print(userList.get(i).getUserName()+ " | ");
			System.out.print(userList.get(i).getPassword()+ " | ");
			System.out.print(userList.get(i).getCity()+ " | ");
			System.out.println();
		}
	}
	
	
	/**
	 * method that appends a new user(register) in the csv file. It uses a FileWriter to append the file
	 * @param fullName string from text field name
	 * @param email string from text field email
	 * @param username string from text field username
	 * @param password string from text field password
	 * @param city string from text field city
	 */
	public void AppendCSV (String fullName, String email, String username, String password, String city) {
		
		FileWriter write;
		try {
			write = new FileWriter(CSV_FILE_PATH,true);
			
			//System.out.println("inside AppendCVS" + fullName);
			write.append("\n");
			write.append(fullName);
			write.append(",");
			write.append(email);	
			write.append(",");
			write.append(username);
			write.append(",");
			write.append(password);
			write.append(",");
			write.append(city);			
			write.flush();
			write.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * method that checks if username and password are a correct match
	 * @param username string from text field username
	 * @param password string from text field password
	 * @return true if username and password match, false if they do not match
	 */
	public boolean searchLogin (String username, String password) 
	{
		
		for (int i = 0; i < userList.size(); i++)
		{
			if (userList.get(i).getUserName().equals(username) && userList.get(i).getPassword().equals(password))
			{
				return true;
			}
 		}
		return false;
	}
	
	/**
	 * method that searches if the email is already in use
	 * @param email string from the text field email
	 * @return true if the email already exists, false if it does not exist
	 */
	public boolean searchRegEmail (String email) {
		
		for (int i = 0; i < userList.size(); i++)
		{
			if (userList.get(i).getEmail().equals(email))
			{
				return true;
			}
 		}
		return false;
	}
	
	/**
	 * method that checks if the username is already in use
	 * @param username string from the text field username
	 * @return true if the username already exists, false if it does not exist
	 */
	public boolean searchRegUser (String username) {
		
		for (int i = 0; i < userList.size(); i++)
		{
			if (userList.get(i).getUserName().equals(username))
			{
				return true;
			}
 		}
		return false;
	}
		
	private static final String CSV_FILE_PATH = "src/resource/users.csv";
	public List<users> userList = new ArrayList<users>();


}
