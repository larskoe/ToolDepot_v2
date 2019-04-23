package itemDatabase;

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

import itemDatabase.items;

/**
 * @author tylersmith2356
 * class that implements the item array for searching, adding, removing, etc. 
 */

public class itemArray {
	
	/**
	 * method that reads from the CSV file and initializes an array list for later use. uses CVSParser
	 * @throws IOException throws an IO exception if an error occurs
	 */
	
	public void initilizeArray () throws IOException {
        try (Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT))
        {
        	itemList.clear();
			for (CSVRecord csvRecord : csvParser) {
			          
				// Accessing values by the names assigned to each column
				String itemNum = csvRecord.get(0);
			    String owner = csvRecord.get(1);
			    String category = csvRecord.get(2);
			    String toolName = csvRecord.get(3);
			    String condition = csvRecord.get(4);
			    String price = csvRecord.get(5);
			    String image = csvRecord.get(6);
			    String description = csvRecord.get(7);
			    String avail = csvRecord.get(8);
			    if (avail.equals("")) avail = "Available";
			    else avail = "Not Available until " + avail;
	    
			    items newItem = new items();
			    newItem.setItemNum(itemNum);
			    newItem.setOwner(owner);
			    newItem.setCategory(category);
			    newItem.setToolName(toolName);
			    newItem.setCondition(condition);
			    newItem.setPrice(price);
			    newItem.setImage(image);
			    newItem.setDescription(description);
			    newItem.setAvail(avail);
			    itemList.add(newItem);           
	            }
	        }
        catch(Exception e) {
        	System.out.println("fail here");
        	e.printStackTrace();
        	}
        }
	
	/**
	 * method that initilizes the rent items array list from the rent items csv file
	 * @throws IOException if something goes wrong 
	 */
	public void initilizeArrayRent () throws IOException {
        try (Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH_RENT));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT))
        {
        	rentList.clear();
			for (CSVRecord csvRecord : csvParser) {
			          
				// Accessing values by the names assigned to each column
				String itemNum = csvRecord.get(0);
			    String owner = csvRecord.get(1);
			    String category = csvRecord.get(2);
			    String toolName = csvRecord.get(3);
			    String condition = csvRecord.get(4);
			    String price = csvRecord.get(5);
			    String image = csvRecord.get(6);
			    String description = csvRecord.get(7);
			    String avail = csvRecord.get(8);
	    
			    items newItem = new items();
			    newItem.setItemNum(itemNum);
			    newItem.setOwner(owner);
			    newItem.setCategory(category);
			    newItem.setToolName(toolName);
			    newItem.setCondition(condition);
			    newItem.setPrice(price);
			    newItem.setImage(image);
			    newItem.setDescription(description);
			    newItem.setAvail(avail);
			    rentList.add(newItem);           
	            }
	        }
        catch(Exception e) {
        	System.out.println("fail here in rent list");
        	e.printStackTrace();
        }
	    }
	
	/**
	 * prints the list of items for development purposes only
	 */
	public void PrintItems (List<items> searchList) {
		
		//for loop that prints all the users in the itemlist
		for (int i = 0; i < searchList.size(); i++)
		{
			System.out.print(searchList.get(i).getItemNum()+ " | ");
			System.out.print(searchList.get(i).getOwner()+ " | ");
			System.out.print(searchList.get(i).getCategory()+ " | ");
			System.out.print(searchList.get(i).getToolName()+ " | ");
			System.out.print(searchList.get(i).getCondition() + " | ");
			System.out.print(searchList.get(i).getPrice()+ " | ");
			System.out.print(searchList.get(i).getImage());
			System.out.print(searchList.get(i).getDescription());
			System.out.print(searchList.get(i).getAvail());
			
			System.out.println();
		}
	}
	
	
	/**
	 * method that appends a new user(register) in the csv file. It uses a FileWriter to append the file
	 * @param itemnum string from text field name
	 * @param owner string from text field email
	 * @param category string from text field username
	 * @param toolname string from text field password
	 * @param condition string from text field city
	 */
	public void AppendCSV (items temp) {
		
		FileWriter write;
		try {
			write = new FileWriter(CSV_FILE_PATH,true);
			
			//System.out.println("inside AppendCVS" + fullName);
			write.append("\n");
			write.append(temp.getItemNum());
			write.append(",");
			write.append(temp.getOwner());	
			write.append(",");
			write.append(temp.getCategory());
			write.append(",");
			write.append(temp.getToolName());
			write.append(",");
			write.append(temp.getCondition());
			write.append(",");
			write.append(temp.getPrice());
			write.append(",");
			write.append(temp.getImage());
			write.append(",");
			write.append(temp.getDescription());
			write.append(",");
			write.append(temp.getAvail());
			write.append(",");
			write.flush();
			write.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * method that appends a new user(register) in the csv file. It uses a FileWriter to append the file
	 * @param itemnum string from text field name
	 * @param owner string from text field email
	 * @param category string from text field username
	 * @param toolname string from text field password
	 * @param condition string from text field city
	 */
	public void AppendCSVRent (String itemNum, String owner, String category, String toolName, String condition, String price, String image, String description, String avail) {
		
		FileWriter write;
		try {
			write = new FileWriter(CSV_FILE_PATH_RENT);
			
			//System.out.println("inside AppendCVS" + fullName);
			write.write(itemNum);
			write.write(",");
			write.write(owner);	
			write.write(",");
			write.write(category);
			write.write(",");
			write.write(toolName);
			write.write(",");
			write.write(condition);
			write.write(",");
			write.write(price);
			write.write(",");
			write.write(image);
			write.write(",");
			write.write(description);
			write.write(",");
			write.write(avail);
			write.flush();
			write.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * method looks for items that match given category
	 * @param category string from text field
	 * @return list of items that had matching category
	 */
	public List<items> searchCategory (String category) 
	{
		searchList.clear();
		for (int i = 0; i < itemList.size(); i++)
		{
			if (itemList.get(i).getCategory().contains(category) )
			{
				items newItem = new items();
			    newItem.setItemNum(itemList.get(i).getItemNum());
			    newItem.setOwner(itemList.get(i).getOwner());
			    newItem.setCategory(itemList.get(i).getCategory());
			    newItem.setToolName(itemList.get(i).getToolName());
			    newItem.setCondition(itemList.get(i).getCondition());
			    newItem.setPrice(itemList.get(i).getPrice());
			    newItem.setImage(itemList.get(i).getImage());
			    newItem.setDescription(itemList.get(i).getDescription());
			    newItem.setAvail(itemList.get(i).getAvail());
			    searchList.add(newItem); 
				
			}
			
 		}
		return searchList;
	}
	
	/**
	 * method looks for tool names that contain given keyword
	 * @param keyword string from text field
	 * @return list of items that math a keyword
	 */
	public List<items> searchItemName (String keyword) 
	{
		searchList.clear();
		for (int i = 0; i < itemList.size(); i++)
		{
			if (itemList.get(i).getToolName().toLowerCase().contains(keyword) )
			{
				items newItem = new items();
			    newItem.setItemNum(itemList.get(i).getItemNum());
			    newItem.setOwner(itemList.get(i).getOwner());
			    newItem.setCategory(itemList.get(i).getCategory());
			    newItem.setToolName(itemList.get(i).getToolName());
			    newItem.setCondition(itemList.get(i).getCondition());
			    newItem.setPrice(itemList.get(i).getPrice());
			    newItem.setImage(itemList.get(i).getImage());
			    newItem.setDescription(itemList.get(i).getDescription());
			    newItem.setAvail(itemList.get(i).getAvail());
			    searchList.add(newItem); 
				
			}
 		}
		return searchList;
	}
	
	/**
	 * method looks for item number
	 * @param item num string from text field
	 * @return item that matches an item number
	 */
	public items searchItemNum (String num) 
	{
		searchList.clear();
		for (int i = 0; i < itemList.size(); i++)
		{
			if (itemList.get(i).getItemNum().equals(num) )
			{
			    item.setItemNum(itemList.get(i).getItemNum());
			    item.setOwner(itemList.get(i).getOwner());
			    item.setCategory(itemList.get(i).getCategory());
			    item.setToolName(itemList.get(i).getToolName());
			    item.setCondition(itemList.get(i).getCondition());
			    item.setPrice(itemList.get(i).getPrice());
			    item.setImage(itemList.get(i).getImage());
			    item.setDescription(itemList.get(i).getDescription());
			    item.setAvail(itemList.get(i).getAvail());
			}
 		}
		return item;
	}
	
	/**
	 * method looks for items that belong to an owner
	 * @param owner string from text field
	 * @return list of items that had match an owner
	 */
	public List<items> searchOwner (String owner) 
	{
		
		for (int i = 0; i < itemList.size(); i++)
		{
			if (itemList.get(i).getToolName().equals(owner) )
			{
				items newItem = new items();
			    newItem.setItemNum(itemList.get(i).getItemNum());
			    newItem.setOwner(itemList.get(i).getOwner());
			    newItem.setCategory(itemList.get(i).getCategory());
			    newItem.setToolName(itemList.get(i).getToolName());
			    newItem.setCondition(itemList.get(i).getCondition());
			    newItem.setPrice(itemList.get(i).getPrice());
			    newItem.setImage(itemList.get(i).getImage());
			    newItem.setDescription(itemList.get(i).getDescription());
			    newItem.setAvail(itemList.get(i).getAvail());
			    searchList.add(newItem); 
				return searchList;
			}
 		}
		return null;
	}
	
	/**
	 * Find last item num from the database
	 *
	 * @return the int last
	 */
	public int findLastItemNum() {
		String slast = itemList.get(itemList.size() - 1).getItemNum();
		int last = Integer.parseInt(slast);
		return last;
	}

	
		
	private static final String CSV_FILE_PATH = "resource/toollist.csv";
	private static final String CSV_FILE_PATH_RENT = "resource/rentItems.csv";
	public List<items> itemList = new ArrayList<items>();
	public List<items> searchList = new ArrayList<items>();
	public List<items> rentList = new ArrayList<items>();
	public List<items> viewList = new ArrayList<items>();
	private items item = new items();



}
