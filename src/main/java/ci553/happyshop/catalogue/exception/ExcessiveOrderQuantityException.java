package ci553.happyshop.catalogue.exception;

/**
 * @author Kalif Hameed Sally University of Brighton
 * @version 1.0
 * Custom exception is thrown when ordered quantity is > than 50
 */


public class ExcessiveOrderQuantityException extends RuntimeException {
    public  ExcessiveOrderQuantityException(String message){
        super(message);
    }
}
