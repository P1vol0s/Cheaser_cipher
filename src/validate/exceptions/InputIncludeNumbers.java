package validate.exceptions;

public class InputIncludeNumbers extends RuntimeException {
    public InputIncludeNumbers(String message) {
        super(message);
    }

    public InputIncludeNumbers() {
    }

    @Override
    public String getMessage() {
        return "Во входных данных присутствую числа";
    }
}
