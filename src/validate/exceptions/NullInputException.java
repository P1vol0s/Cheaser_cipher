package validate.exceptions;

public class NullInputException extends RuntimeException {

    public NullInputException() {
        System.err.println("Возникла некоторая ошибка: " + this.getMessage());
    }

    @Override
    public String getMessage() {
        return "Вы ничего не ввели";
    }
}
