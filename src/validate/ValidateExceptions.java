package validate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class ValidateExceptions {
    private static final Path textDirPath = Path.of("C:\\Users\\user\\IdeaProjects\\Cheaser_cipher\\src\\text_dir");

    private static int count = 0;

    // todo: создаем статическую переменную счетчик, которая будет увеличиваться каждый раз, когда создается
    //      новый файл для записи


    private static boolean validateSwitchInput(Scanner sc) {
        String yesOrNo;
        do {
            yesOrNo = sc.nextLine();
            if (!(yesOrNo.equalsIgnoreCase("Y") || yesOrNo.equalsIgnoreCase("N"))) {
                System.out.println("Введено что-то странное. Пожалуйста, введите правильные значения");
            }
        } while (!(yesOrNo.equalsIgnoreCase("Y") || yesOrNo.equalsIgnoreCase("N")));
        return yesOrNo.equalsIgnoreCase("y");
    }

    public static boolean inputFileEqualNull() throws IOException {
        sendErrMessage(new InputFileNotExist());
        System.out.println("Создать новый файл для ввода данных? (Y/N)");
        try (Scanner sc = new Scanner(System.in)) {
            if (validateSwitchInput(sc)) {
                Files.createFile(textDirPath);
                return true;
            }
            System.out.println("Если вы не желаете создать новый файл, то либо введите \nновый путь к файлу (Y), либо завершите программу (N)");
            if (!validateSwitchInput(sc)) {
                closeProgram();
            }
            return false;
            /*todo: если пользователь выбрал ввести заново, то программа возвращает false, а метод, который вызывает
             *      делает все через do-while. В обработке исключений, если метод вернул false вызывается метод ввода файла*/
        }
        /*todo: 1) отправить пользователь сообщение с ошибкой, и предложить создать новый пустой файл в text_dir
         *      2) если пользователь соглашается, то создаем новый файл
         *      3) если пользователь отказывается, то предлагаем ему ввести новое имя файла
         *      4) если пользователь выбрал ввести новое имя, то опять запускаем метод со вводом имени файла
         *      5) если пользователь отказался, то завершаем программу
         * */
    }

    public static void outputFileEqualNull() {
        /*todo: 1) отправить пользователь сообщение с ошибкой, и предложить создать новый пустой файл в text_dir
                либо с названием, которое он предложит, либо с шаблонным названием
         *      2) если пользователь соглашается придумать, то создаем новый файл с его названием
         *      3) если пользователь отказался, то создаем файл с шаблонным названием
         * */
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
        System.out.println("Программа завершена.");
        System.exit(0);
        /*todo: 1) отправляет сообщение со словами "ЗАВЕРШЕНИЕ ПРОГРАМЫ"
                2)прерывает работу всей программы */
    }
}
