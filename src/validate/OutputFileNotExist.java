package validate;

public class OutputFileNotExist extends RuntimeException {
    public OutputFileNotExist(String message) {
        super(message);
    }
}
