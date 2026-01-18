package validate.exceptions;

public class FileNotExist extends RuntimeException {


    @Override
    public String getMessage() {
        return "Не найден файл";
    }

    public FileNotExist() {
        System.err.println("Возникла некоторая ошибка: " + this.getMessage());
    }


}
