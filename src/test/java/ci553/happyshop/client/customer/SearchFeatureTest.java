package ci553.happyshop.client.customer;


import ci553.happyshop.storageAccess.DerbyRW;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.SQLException;

/**
 * @author Kalif Hameed Sally University of Brighton
 * @version 1.0
 * This file is the JUnit test for the unified search feature and checks name or ID.
 */

class SearchFeatureTest{

    @Test
    void search() throws SQLException {
        CustomerModel model = new CustomerModel();
        model.databaseRW = new DerbyRW();
        //search by ID
        System.out.println("test part 1 - search by the correct ID of 0002");
        model.setTestSearchId("0002");
        model.search();

        //uses getter from customermodel to check by id
        assertTrue(model.getSearchResult().contains("Product_Id: 0002"),
                "Should find product by ID matching 0002");

        //Search by Name if not found by id
        System.out.println("test part 2 - search by the correct product name of Radio");
        System.out.println("Will see 'not found' for the first ID search");
        model.setTestSearchId("Radio");
        model.search();

        //uses getter from customermodel to check by name after
        assertTrue(model.getSearchResult().contains("Radio"),
                "Should find product by Name if not found by id");
        System.out.println("Success - resorts to a name check and finds 'Radio' by name.");
    }
}