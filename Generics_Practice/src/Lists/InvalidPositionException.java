package Lists;

public class InvalidPositionException extends RuntimeException{
    InvalidPositionException(int upper) {
        super("Position must be between 1 and " + upper);
    }
}
