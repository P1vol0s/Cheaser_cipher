package validate;

public class OutputFileNotExist extends RuntimeException {
    public OutputFileNotExist(String message) {
        super(message);
    }

    public OutputFileNotExist() {
    }

    @Override
    public String getMessage() {
        return "Не найден файл для записи";
    }
}
