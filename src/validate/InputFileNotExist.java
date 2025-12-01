package validate;

public class InputFileNotExist extends RuntimeException {
    public InputFileNotExist(String message) {
        super(message);
    }
}
