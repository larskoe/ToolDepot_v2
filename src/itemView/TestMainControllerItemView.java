package itemView;


import java.io.IOException;
import org.junit.jupiter.api.Test;
import itemDatabase.itemArray;
import junit.framework.Assert;

/**
 * @author larskoester
 * class that tests the item view
 */
@SuppressWarnings("deprecation")
class TestMainControllerItemView {

	@Test
	void testInitialize() {
		System.out.println("run test item view initilize"); 
		
		itemArray temp = new itemArray();
		boolean test = false;
		try {
			temp.initilizeArrayRent();
			
			if (!temp.rentList.get(0).getToolName().isEmpty()) {
				test = true;
			}
			else {
				test = false;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(test);
	}

}
