package validate;

import validate.exceptions.FileNotExist;
import validate.exceptions.KeyDoesNotFitTheTemplate;
import validate.exceptions.NothingEntered;

import java.nio.file.Files;
import java.nio.file.Path;

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
        if (inputData == null || inputData.equals("\n") || inputData.isEmpty()) throw new NothingEntered();
        return inputData;
    }
}
