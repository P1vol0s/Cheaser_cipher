package validate.exceptions;

public class KeyDoesNotFitTheTemplate extends RuntimeException {

    public KeyDoesNotFitTheTemplate() {
        System.err.println("Возникла некоторая ошибка: " + this.getMessage());
    }

    @Override
    public String getMessage() {
        return "Ключ содержит неподдерживаемые символы (что-то кроме цифр)";
    }
}
