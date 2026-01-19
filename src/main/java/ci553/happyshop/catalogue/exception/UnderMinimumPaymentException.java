package ci553.happyshop.catalogue.exception;

/**
 * @author Kalif Hameed Sally University of Brighton
 * @version 1.0
 * Custom exception is thrown if the order is < than £5.
 */

public class UnderMinimumPaymentException extends RuntimeException {
    public UnderMinimumPaymentException(String message){
        super(message);
    }
}