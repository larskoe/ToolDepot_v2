package itemDatabase;

/**
 * @author larskoester
 * @author tylersmith
 * item class that holds all variables for an item
 */
public class items {

		/**
		 * method that gets the item number
		 * @return returns the string item number
		 */
		public String getItemNum() {
			return itemNum;
		}

		/**
		 * method that sets the item number
		 * @param itemNum String that user input
		 */
		public void setItemNum(String itemNum) {
			this.itemNum = itemNum;
		}

		/**
		 * method that gets the owner
		 * @return returns the string owner
		 */
		public String getOwner() {
			return owner;
		}

		/**
		 * method that sets the owner
		 * @param owner string that user input
		 */
		public void setOwner(String owner) {
			this.owner = owner;
		}

		/**
		 * method that gets the category
		 * @return returns the string category
		 */
		public String getCategory() {
			return category;
		}

		/**
		 * method that sets the category
		 * @param category string that user input
		 */
		public void setCategory(String category) {
			this.category = category;
		}

		/**
		 * method that gets the tool name
		 * @return returns the string toolName
		 */
		public String getToolName() {
			return toolName;
		}

		/**
		 * method that sets the tool name
		 * @param toolName string that user input
		 */
		public void setToolName(String toolName) {
			this.toolName = toolName;
		}

		/**
		 * method that gets the condition
		 * @return returns the string condition
		 */
		public String getCondition() {
			return condition;
		}

		/**
		 * method that sets the condition
		 * @param condition string that user input
		 */
		public void setCondition(String condition) {
			this.condition = condition;
		}
		

		/**
		 * method that gets the price
		 * @return returns the string price
		 */
		public String getPrice() {
			return price;
		}

		/**
		 * method that sets the price
		 * @param price string that user input
		 */
		public void setPrice(String price) {
			this.price = price;
		}
		

		/**
		 * method that gets the image file location
		 * @return returns the string image file location
		 */
		public String getImage() {
			return image;
		}

		/**
		 * method that sets the image file location
		 * @param image file location string
		 */
		public void setImage(String image) {
			this.image = image;
		}
		
		/**
		 * method that gets the description
		 * @return returns the string description
		 */
		public String getDescription() {
			return description;
		}

	

		/**
		 * method that sets the tool description
		 * @param string description of the tool
		 */
		public void setDescription(String description) {
			this.description = description;
		}
		
		/**
		 * method that gets the availability of the tool
		 * @return returns the string image file location
		 */
		public String getAvail() {
			return avail;
		}


		/**
		 * method that sets the availability
		 * @param availability status string
		 */
		public void setAvail(String avail) {
			this.avail = avail;
		}
		
		
		/**
		 * variables needed for class
		 */
	    private String itemNum;
	    private String owner;
	    private String category;
	    private String toolName;
	    private String condition;
	    private String price;
	    private String image;
	    private String description;
	    private String avail;
	
}
