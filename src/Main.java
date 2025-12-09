import Chipher.Cipher;
import validate.IOtool;
import validate.ValidateExceptions;
import validate.ValidateInput;
import validate.exceptions.FileNotExist;
import validate.exceptions.InputIncludeNumbers;
import validate.exceptions.KeyDoesNotFitTheTemplate;
import validate.exceptions.NothingEntered;

import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        var inputType = IOtool.read();
        StringBuilder inData = new StringBuilder();
        StringBuilder outData = new StringBuilder();
        int key;
        try {
            switch (inputType) {
                case "FF": {
                    inData.append(ValidateInput.validateFilePath());
                    outData.append(ValidateInput.validateFilePath());
                    key = ValidateInput.validateKeyInput();
                    System.out.println(Cipher.toCipher(Path.of(inData.toString()), Path.of(outData.toString()), key));
                }
                case "FT": {
                    inData.append(ValidateInput.validateFilePath());
                    key = ValidateInput.validateKeyInput();
                    System.out.println(Cipher.toCipher(Path.of(inData.toString()), outData, key));
                }
                case "TF": {
                    inData.append(ValidateInput.validateAllInput());
                    outData.append(ValidateInput.validateFilePath());
                    key = ValidateInput.validateKeyInput();
                    System.out.println(Cipher.toCipher(inData, Path.of(outData.toString()), key));
                }
                case "TT": {
                    inData.append(ValidateInput.validateAllInput());
                    outData.append(ValidateInput.validateAllInput());
                    key = ValidateInput.validateKeyInput();
                    System.out.println(Cipher.toCipher(inData, outData, key));
                }
            }
        }catch (FileNotExist e){

        }catch (InputIncludeNumbers e){

        }catch (KeyDoesNotFitTheTemplate e){

        }catch (NothingEntered e){

        }
    }


}