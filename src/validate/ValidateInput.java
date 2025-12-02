package validate;

import validate.exceptions.FileNotExist;
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
}
