package userDatabase;

/**
 * @author larskoester
 * class that handles the userdata fields. uses setters and getters
 */
public class users {

	/**
	 * method that gets the full name
	 * @return returns the string full name
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * method that sets the full name
	 * @param fullName string that user input
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * method that gets the email
	 * @return returns the string email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * method that sets the email
	 * @param email string that user input
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * method that gets the username
	 * @return returns the string username
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * method that sets the username
	 * @param userName string that user input
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * method that gets the password
	 * @return returns the string password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * method that sets the password
	 * @param passoword string that user input
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * method that gets the city
	 * @return returns the string city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * method that sets the city
	 * @param city string that user input
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * variables needed for class
	 */
    private String fullName;
    private String email;
    private String userName;
    private String password;
    private String city;
    
}
