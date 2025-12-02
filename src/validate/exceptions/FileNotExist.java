package validate.exceptions;

public class FileNotExist extends RuntimeException {
    public FileNotExist(String message) {
        super(message);
    }

    public FileNotExist() {
    }

    @Override
    public String getMessage() {
        return "Не найден файл";
    }
}
