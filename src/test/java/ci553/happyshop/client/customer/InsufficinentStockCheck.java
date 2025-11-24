package ci553.happyshop.client.customer;

import ci553.happyshop.catalogue.Product;
import ci553.happyshop.storageAccess.DatabaseRW;
import org.junit.jupiter.api.Test;


import javax.xml.crypto.Data;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class InsufficinentStockCheck {

    @Test
    void testInsufficientStockRemovalAtCheckout() throws SQLException, IOException {
        CustomerModel model = new CustomerModel();



        Product NoStockPrd = new Product("0235", "FakeApple", "fakeapple.jpg", 2.0, 100);
        Product InStockPrd = new Product("0335","FakeWaffles","fakewaffles.jpg",5.0,100);

        model.getTrolley().add(NoStockPrd);
        model.getTrolley().add(InStockPrd);




        DatabaseRW testDatabase = new DatabaseRW() {
            @Override
            public ArrayList<Product> searchProduct(String keyword) throws SQLException {
                return null;
            }

            @Override
            public Product searchByProductId(String productId) throws SQLException {
                return null;
            }

            @Override
            public ArrayList<Product> purchaseStocks(ArrayList<Product> proList) throws SQLException {
                ArrayList<Product> testInsufficientList = new ArrayList<>();
                testInsufficientList.add(NoStockPrd);
                return testInsufficientList;
            }

            @Override
            public void updateProduct(String id, String des, double price, String imageName, int stock) throws SQLException {

            }

            @Override
            public void deleteProduct(String id) throws SQLException {

            }

            @Override
            public void insertNewProduct(String id, String des, double price, String image, int stock) throws SQLException {

            }

            @Override
            public boolean isProIdAvailable(String productId) throws SQLException {
                return false;
            }
        };

        model.databaseRW = testDatabase;
        model.noStockWarning =  new FakeNotifier();
        model.cusView = new FakeCustomerView();

        model.checkOut();
        assertEquals(1, model.getTrolley().size());// 1 is the expected trolley size after it removes
        // out of stock and .size() gets the actual value and
        // the whole line compares them abd if the two are not the same the test fails
        assertEquals(InStockPrd, model.getTrolley().get(0));//check if the remaining item is actually in InstockPrd

    }

}
//helper classes
         class FakeNotifier extends RemoveProductNotifier {
              @Override
              public void showRemovalMsg(String message) {
                  System.out.println("Warning message here in test: " + message);
              }
         }
         class FakeCustomerView extends CustomerView{
              @Override
              public void update(String imageName, String searchResult, String trolley, String receipt) {
                  System.out.println(" View updated successfully");
              }
        }