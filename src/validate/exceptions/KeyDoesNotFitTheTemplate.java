package validate.exceptions;

public class KeyDoesNotFitTheTemplate extends RuntimeException {
    public KeyDoesNotFitTheTemplate(String message) {
        super(message);
    }

    public KeyDoesNotFitTheTemplate() {
    }

    @Override
    public String getMessage() {
        return "Ключ содержит неподдерживаемые символы (что-то кроме цифр)";
    }
}
