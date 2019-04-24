package profile;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import junit.framework.Assert;
import userDatabase.UserArray;
/**
 * @author larskoester
 * Junit test that tests the profile view 
 */
@SuppressWarnings("deprecation")
class TestMainControllerProfile {

	@Test
	void testInitialize() {
		System.out.println("run test profile view initilize"); 
		
		UserArray temp = new UserArray();
		boolean test = false;
		try {
			temp.initilizeArraySession();
			
			if (!temp.sessionList.get(0).getFullName().isEmpty()) {
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
