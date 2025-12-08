package validate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class ValidateExceptions {
    private static final Path textDirPath = Path.of("C:\\Users\\user\\IdeaProjects\\Cheaser_cipher\\src\\text_dir");

    private static int count = 0;

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
