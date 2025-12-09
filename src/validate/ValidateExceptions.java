package validate;

import validate.exceptions.NothingEntered;

public class ValidateExceptions {
    public static String validateNullInput() {
        String value = null;
        sendExceptionMessages("Вы ничего не ввели, пожалуйста, введите что-то ");
        try {
            value =  ValidateInput.validateAllInput();
        }catch (NothingEntered e){
            value = validateNullInput();
        }
        return value;
    }

    private static void sendExceptionMessages(String message) {
        System.err.println("Возникла нектоорая ошибка: " + message);

    }

    private static void errMessage(String message) {
        System.err.println(message);
    }
}


