package validate;

import validate.exceptions.FileNotExist;
import validate.exceptions.NullInputException;

import java.nio.file.Files;

public class ValidateExceptions {
    public static String validateNullInput(NullInputException e) {
        String value;
        sendExceptionMessages(e.getMessage());
        errMessage("Пожалуйста, введите что-то, иначе я не могу работать");
        value = ValidateInput.validateAllInput();
        return value;
    }

    public static String validateFileNotExist(FileNotExist e){
        sendExceptionMessages(e.getMessage());
        errMessage("Хотите, я создам для вас новый файл, с которым вы сможете работать?  (Y/N): ");
        var yesOrNo = ValidateInput.validateSwitchInput();
        if(yesOrNo.equals("Y")){
            errMessage("Введи имя, которым ты обзовешь файл: ");
            var nameTempFile= ValidateInput.validateAllInput();
            /*todo: 1) проверить, существует ли файл с таким именем в temp-дерективе
            *       2) если нету, то создать такой файл
            *       3) если есть, то просим написать еще раз
            * */
        }else {
            /*todo: 1) предложить человеку написать заново имя файла
            *       2) если согласится, то выполняем заново validateFilePath
            *       3) если не согласится, то завершаем программу*/
        }
    }

    private static void sendExceptionMessages(String message) {
        System.err.println("Возникла некоторая ошибка: " + message);

    }

    private static void errMessage(String message) {
        System.err.println(message);
    }
}


