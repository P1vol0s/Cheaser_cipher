package validate.exceptions;

public class NullInputException extends RuntimeException {

    public NullInputException(){}

    public NullInputException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Вы ничего не ввели";
    }
}
