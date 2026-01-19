package ci553.happyshop.catalogue.validation;

import ci553.happyshop.catalogue.Product;
import ci553.happyshop.catalogue.exception.UnderMinimumPaymentException;
import java.util.List;

/**
 * @author Kalif Hameed Sally University of Brighton
 * @version 1.0
 * This class runs the code for  the £5.00 minimum spend policy.
 * @throws UnderMinimumPaymentException if total price is less than £5.00
 */

public class MinimumSpendingRule implements OrderChecker {
    @Override
    public void validate(List<Product> trolley){
        double total = 0.0;
        for(int i=0; i <trolley.size(); i++ ){
            Product p = trolley.get(i);
            total += p.getUnitPrice() * p.getOrderedQuantity();
        }
        if (total<5.00){
            throw new UnderMinimumPaymentException(
                    "Total price of item is £"+ String.format("%.2f",total) + ".\nMinimum spend is £5.00"
            );
        }
    }
}
