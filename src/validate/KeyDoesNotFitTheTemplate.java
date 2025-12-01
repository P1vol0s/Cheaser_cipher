package validate;

public class KeyDoesNotFitTheTemplate extends RuntimeException {
    public KeyDoesNotFitTheTemplate(String message) {
        super(message);
    }
}
