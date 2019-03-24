package forth;

public class InvalidIndexException extends RuntimeException {

    public InvalidIndexException(String warning){
        super(warning);
    }

}
