package validate;

import validate.exceptions.FileNotExist;
import validate.exceptions.KeyDoesNotFitTheTemplate;
import validate.exceptions.NullInputException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ValidateExceptions {
    public static String validateNullInput(NullInputException e) {
        String value;
        System.err.println("Пожалуйста, введите что-то, иначе я не могу работать");
        value = ValidateInput.validateAllInput();
        return value;
    }

    public static String validateFileNotExist(FileNotExist e) {
        System.err.print("Хотите, я создам для вас новый файл, с которым вы сможете работать?  (Y/N): ");
        var yesOrNo = ValidateInput.validateSwitchInput("Y", "N");
        if (yesOrNo.equals("Y")) {
            System.err.print("Введи имя, которым ты обзовешь файл: ");
            var nameTempFile = ValidateInput.validateFilePathNotExists();
            try {
                System.out.println(Path.of(nameTempFile).toAbsolutePath());
                Files.createFile(Path.of("src\\text_dir\\" + nameTempFile));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            return Path.of("src\\text_dir\\" + nameTempFile).toAbsolutePath().toString();
        } else {
            System.err.print("Хотите ввести путь к файлу заново? (Y/N): ");
            yesOrNo = ValidateInput.validateSwitchInput("Y", "N");
            if (yesOrNo.equals("N")){
                System.err.print("Программа завершена");
                System.exit(1);
            }
            System.err.print("Введите путь к файлу: ");
            return ValidateInput.validateFilePathExists();
        }
    }

    public static String validateKeyException(KeyDoesNotFitTheTemplate e){
        System.err.print("Введите ключ заново: ");
        return String.valueOf(ValidateInput.validateKeyInput());
    }

    //C:\Users\skude\IdeaProjects\Cheaser_cipher\src\text_dir
}


