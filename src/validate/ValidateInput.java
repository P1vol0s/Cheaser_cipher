package validate;

import validate.exceptions.FileNotExist;
import validate.exceptions.KeyDoesNotFitTheTemplate;

import java.nio.file.Files;
import java.nio.file.Path;

public class ValidateInput {
    public static String validateFilePath(){
        var tempFilePath = IOtool.read();
        if (tempFilePath == null || tempFilePath.equals("\n") || tempFilePath.isEmpty())
            throw new FileNotExist();
        if (!Files.exists(Path.of(tempFilePath)))
            throw new FileNotExist();
        return tempFilePath;
    }

    public static String validateKeyTerminalInput(){
        var tempTermInput = IOtool.read();
        if(!tempTermInput.matches("\\d+"))
            throw new KeyDoesNotFitTheTemplate();
        return tempTermInput;
    }

}
