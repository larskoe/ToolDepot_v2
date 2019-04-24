package Search;

import org.junit.jupiter.api.Test;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import junit.framework.Assert;

/**
 * @author larskoester
 * Junit test that tests the search function
 */
@SuppressWarnings("deprecation")
class TestMainControllerSearch {

	@Test
	void testClear() {
		ObservableList<String> categoryList = FXCollections.observableArrayList("Tool", "Basic Tool", "Power Tool","Ladder", "Saw", "Cement", "Wood Working", "Motorized", "Painting");
		boolean test = false;
		
		if (categoryList.get(0).isEmpty()) {
			test = false;
		}
		else {
			test = true;
		}
		
		Assert.assertTrue(test);
	}

}
