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
        System.err.println("Возникла некоторая ошибка: " + e.getMessage());
        System.err.println("Пожалуйста, введите что-то, иначе я не могу работать");
        value = ValidateInput.validateAllInput();
        return value;
    }

    public static String validateFileNotExist(FileNotExist e) {
        System.err.println("Возникла некоторая ошибка: " + e.getMessage());
        System.err.println("Хотите, я создам для вас новый файл, с которым вы сможете работать?  (Y/N): ");
        var yesOrNo = ValidateInput.validateSwitchInput();
        if (yesOrNo.equals("Y")) {
            System.err.println("Введи имя, которым ты обзовешь файл: ");
            var nameTempFile = ValidateInput.validateFilePathNotExists();
            try {
                Files.createFile(Path.of("text_dir/" + nameTempFile));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            return nameTempFile;
            /*todo: 1) проверить, существует ли файл с таким именем в temp-дерективе
             *       2) если нету, то создать такой файл
             *       3) если есть, то просим написать еще раз
             * */
        } else {
            System.err.println("Хотите ввести имя пользователя заново? (Y/N)");
            yesOrNo = ValidateInput.validateSwitchInput();
            if (yesOrNo.equals("N")){
                System.err.println("Программа завершена");
                System.exit(1);
            }
            return ValidateInput.validateFilePathExists();
            /*todo: 1) предложить человеку написать заново имя файла
             *       2) если согласится, то выполняем заново validateFilePath
             *       3) если не согласится, то завершаем программу*/
        }
    }

    public static String validateKeyException(KeyDoesNotFitTheTemplate e){
        System.err.println("Возникла некоторая ошибка: " + e.getMessage());
        System.err.println("Введите ключ заново:");
        return String.valueOf(ValidateInput.validateKeyInput());
    }
}


