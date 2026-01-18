package validate;

import validate.exceptions.FileNotExist;
import validate.exceptions.KeyDoesNotFitTheTemplate;
import validate.exceptions.NullInputException;

import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class ValidateInput {
    public static String validateFilePath(){
        var tempFilePath = validateAllInput();
        if (!Files.exists(Path.of(tempFilePath))) throw new FileNotExist();
        return tempFilePath;
    }

    public static int validateKeyInput(){
        var tempTermInput = validateAllInput();
        if(!tempTermInput.matches("\\d+")) throw new KeyDoesNotFitTheTemplate();
        return Integer.parseInt(tempTermInput);
    }

    public static String validateAllInput(){
        var inputData = IOtool.read();
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
