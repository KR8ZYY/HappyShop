package ci553.happyshop.catalogue.validation;

import ci553.happyshop.catalogue.Product;
import ci553.happyshop.catalogue.exception.ExcessiveOrderQuantityException;
import java.util.List;
/**
 * @author Kalif Hameed Sally University of Brighton
 * @version 1.0
 * This class iterates through all active strategies to validate the trolley.
 * @throws ExcessiveOrderQuantityException immediately and throws the exception if any rule fails.
 */

public class MaximumQuantRule implements OrderChecker {
    @Override
    public  void validate(List<Product>trolley){
        for (int i=0; i< trolley.size(); i++){
            Product p =trolley.get(i);


            //below will check actual stored amount of said product to ensure it checks for 50 or more in the trolley
            if (p.getOrderedQuantity() > 50) {
                throw new ExcessiveOrderQuantityException(
                        "The " + p.getProductDescription() + " has been added " + p.getOrderedQuantity() +
                                " times " + ".\nMaximum allowed quantity is 50"
                );
            }
        }
    }
}