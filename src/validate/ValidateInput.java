package validate;

import validate.exceptions.FileNotExist;
import validate.exceptions.KeyDoesNotFitTheTemplate;
import validate.exceptions.NullInputException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class ValidateInput {
    public static String validateFilePathExists(){
        var tempFilePath = validateAllInput();
        try {
            if (!Files.exists(Path.of(tempFilePath))) throw new FileNotExist();
        }catch (FileNotExist e){
            tempFilePath = ValidateExceptions.validateFileNotExist();
        }
        return tempFilePath;
    }

    public static String validateFilePathNotExists(){
        var tempFilePath = validateAllInput();
        if (Files.exists(Path.of("src\\text_dir\\" + tempFilePath))) {
            System.err.println("Файл с таким именем уже существует. Введи другое имя: ");
            return validateFilePathNotExists();
        }
        return tempFilePath;
    }

    public static int validateKeyInput(){
        var tempTermInput = validateAllInput();
        try {
            if(!tempTermInput.matches("\\d+")) throw new KeyDoesNotFitTheTemplate();
        }catch (KeyDoesNotFitTheTemplate e){
            tempTermInput = ValidateExceptions.validateKeyException();
        }
        return Integer.parseInt(tempTermInput);
    }

    public static String validateAllInput(){
        Scanner sc = new Scanner(System.in);
        var inputData = sc.nextLine();
        try {
            if (inputData == null || inputData.equals("\n") || inputData.isEmpty() || inputData.equals(" ")) throw new NullInputException();
        }catch (NullInputException e){
            inputData = ValidateExceptions.validateNullInput();
        }
        return inputData;
    }

    public static String validateSwitchInput(String key1, String key2){
        var yesOrNo = validateAllInput();
        if(!Arrays.asList(key1, key2).contains(yesOrNo)){
            System.out.printf("Ты ввел что-то кроме %s или %s. Пожалуйста, введи нормальные значения, или я обижусь и не буду работать %n", key1, key2);
            yesOrNo = validateSwitchInput(key1, key2);
        }
        return yesOrNo;
    }
}


