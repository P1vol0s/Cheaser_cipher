package validate.exceptions;

public class NothingEntered extends RuntimeException {

    public NothingEntered (){}

    public NothingEntered(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Вы ничего не ввели";
    }
}
