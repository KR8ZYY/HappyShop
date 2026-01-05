package ci553.happyshop.catalogue.validation;
import ci553.happyshop.catalogue.Product;
import java.util.List;
/**
 * @author Kalif Hameed Sally University of Brighton
 * @version 1.0
 * Design Strategy interface that checks if order is valid
 * Meets the requirements for OCP by allowing rules to be added when needed
 * @throws RuntimeException if the customers order does not meet the rules in
 * the implementation being the custom exceptions
 */
// This interface checks if the order is valid otherwise an exception is thrown
public interface OrderChecker {
    void validate(List<Product> trolley) throws RuntimeException;
}
