package itemDatabase;

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
		
		public String getPrice() {
			return price;
		}
		
		public void setPrice(String price) {
			this.price = price;
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
	
}
