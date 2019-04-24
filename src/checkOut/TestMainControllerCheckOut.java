package checkOut;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import itemDatabase.itemArray;
import junit.framework.Assert;

/**
 * @author larskoester
 * class that tests the checkout view
 */
@SuppressWarnings("deprecation")
class TestMainControllerCheckOut {

	@Test
	void testInitialize() {
System.out.println("run test check out view initilize"); 
		
		itemArray temp = new itemArray();
		boolean test = false;
		try {
			temp.initilizeArray();
			
			if (!temp.itemList.get(0).getToolName().isEmpty()) {
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
