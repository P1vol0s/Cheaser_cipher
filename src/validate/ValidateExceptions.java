package validate;
import validate.exceptions.FileNotExist;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ValidateExceptions {
    private static final Path textDirPath = Path.of("src\\text_dir");

    private static boolean validateSwitchInput() {
        String yesOrNo;
        do {
            yesOrNo = IOtool.read();
            if (!Arrays.asList("Y", "N").contains(yesOrNo))
                System.err.print("Введено что-то странное. Пожалуйста, введите правильные значения (Y/N): ");
        } while (!Arrays.asList("Y", "N").contains(yesOrNo));
        return yesOrNo.equalsIgnoreCase("y");
    }

    public static String fileNotExistFix() {
        sendErrMessage(new FileNotExist());
        System.err.print("Создать новый файл данных? (Y/N): ");


        if (validateSwitchInput())
            return setNewFileName();
        System.err.println("Если вы не желаете создать новый файл, то либо введите \nновый путь к файлу (Y), либо завершите программу (N)");
        if (!validateSwitchInput())
            closeProgram();
        return null;
        /*todo: если пользователь выбрал ввести заново, то программа возвращает false, а метод, который вызывает
         *      делает все через do-while. В обработке исключений, если метод вернул false вызывается метод ввода файла
         *
         *todo: 1) отправить пользователь сообщение с ошибкой, и предложить создать новый пустой файл в text_dir
         *      2) если пользователь соглашается, то создаем новый файл
         *      3) если пользователь отказывается, то предлагаем ему ввести новое имя файла
         *      4) если пользователь выбрал ввести новое имя, то опять запускаем метод со вводом имени файла
         *      5) если пользователь отказался, то завершаем программу
         * */
    }

    private static String  setNewFileName(){
        System.err.print("Введите имя файла: ");
        var fileName = textDirPath.resolve(IOtool.read());
        try {
            Files.createFile(fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileName.toString();
    }

    public static void keyExceptionFix() {
        /*todo: 1) отправить пользователю сообщение с ошибкой
         *      2) предложить пользователю заново ввести ключ шифрования
         *      3) если он соглашается, то заменяем ключ на новый
         *      4) если пользователь отказывается, то завершить программу */
    }

    public static void inputLineExceptionFix() {
        /*todo: 1) отправить пользователю сообщение с ошибкой
         *      2) предложить пользователю заново значения для шифрования
         *      3) если он соглашается, то заменяем значение для шифрования на новое
         *      4) если пользователь отказался, то заверить программу*/
    }

    public static void fileContentUnreadable() {
        /*todo: 1) отправить пользователю сообщение с ошибкой
         *      2) предложить выбрать другой файл для работы
         *      3) если пользователь соглашается, то заменяем исходный файл на тот, который он прислал
         *      4) если он не соглашается, то завершаем программу*/
    }

    private static void sendErrMessage(Exception e) {
        System.err.println("Возникла некоторая ошибка: " + e.getMessage());
        /*todo: 1) отправляем сообщение с ошибкой */
    }

    private static void closeProgram() {

        System.exit(0);
        /*todo: 1) отправляет сообщение со словами "ЗАВЕРШЕНИЕ ПРОГРАМЫ"
                2)прерывает работу всей программы */
    }
}
