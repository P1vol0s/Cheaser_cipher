package validate;

public class InputFileNotExist extends RuntimeException {
    public InputFileNotExist(String message) {
        super(message);
    }

    public InputFileNotExist() {
    }

    @Override
    public String getMessage() {
        return "Не найден файл для чтения";
    }
}
