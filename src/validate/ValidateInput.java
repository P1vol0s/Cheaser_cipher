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
            tempFilePath = ValidateExceptions.validateFileNotExist(e);
        }
        return tempFilePath;
    }

    public static String validateFilePathNotExists(){
        var tempFilePath = validateAllInput();
        if (Files.exists(Path.of(tempFilePath))) {
            System.err.println("Файл с таким именем уже существует. Введите другое имя");
            return validateFilePathNotExists();
        }
        return tempFilePath;
    }

    public static int validateKeyInput(){
        var tempTermInput = validateAllInput();
        try {
            if(!tempTermInput.matches("\\d+")) throw new KeyDoesNotFitTheTemplate();
        }catch (KeyDoesNotFitTheTemplate e){
            tempTermInput = ValidateExceptions.validateKeyException(e);
        }
        return Integer.parseInt(tempTermInput);
    }

    public static String validateAllInput(){
        Scanner sc = new Scanner(System.in);
        var inputData = sc.nextLine();
        try {
            if (inputData == null || inputData.equals("\n") || inputData.isEmpty() || inputData.equals(" ")) throw new NullInputException();
        }catch (NullInputException e){
            inputData = ValidateExceptions.validateNullInput(e);
        }
        return inputData;
    }

    protected static String validateSwitchInput(){
        var yesOrNo = validateAllInput();
        if(!Arrays.asList("Y", "N").contains(yesOrNo)){
            System.out.println("Ты ввел что-то кроме Y или N. Пожалуйста, введи нормальные значения, или я обижусь и не буду работать");
            yesOrNo = validateSwitchInput();
        }
        return yesOrNo;
    }
}
