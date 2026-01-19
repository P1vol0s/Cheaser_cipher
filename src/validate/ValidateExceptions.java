package validate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ValidateExceptions {
    public static String validateNullInput() {
        String value;
        System.err.println("Пожалуйста, введи что-то, иначе я не могу работать");
        value = ValidateInput.validateAllInput();
        return value;
    }

    public static String validateFileNotExist() {
        System.err.print("Хотите, я создам для тебя новый файл, с которым ты сможете работать?  (Y/N): ");
        var yesOrNo = ValidateInput.validateSwitchInput("Y", "N");
        if (yesOrNo.equals("Y")) {
            System.err.print("Введи имя, которым ты обзовешь файл: ");
            var nameTempFile = ValidateInput.validateFilePathNotExists();
            try {
                System.out.println(Path.of(nameTempFile).toAbsolutePath());
                Files.createFile(Path.of("src\\text_dir\\" + nameTempFile));
                System.err.println("""
                        Твой файл успешно создан
                        напиши в этом файле сообщение, которое хочешь зашифровать и заново запускай меня""");
                System.exit(1);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            return Path.of("src\\text_dir\\" + nameTempFile).toAbsolutePath().toString();
        } else {
            System.err.print("Хочешь ввести путь к файлу заново? (Y/N): ");
            yesOrNo = ValidateInput.validateSwitchInput("Y", "N");
            if (yesOrNo.equals("N")) {
                System.err.print("Программа завершена");
                System.exit(1);
            }
            System.err.print("Введи путь к файлу: ");
            return ValidateInput.validateFilePathExists();
        }
    }

    public static String validateKeyException() {
        System.err.print("Введи ключ заново: ");
        return String.valueOf(ValidateInput.validateKeyInput());
    }

}


