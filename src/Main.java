import Chipher.Cipher;
import validate.ValidateExceptions;
import validate.ValidateInput;
import validate.exceptions.FileNotExist;
import validate.exceptions.KeyDoesNotFitTheTemplate;
import validate.exceptions.NullInputException;

import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        StringBuilder inData = new StringBuilder();
        StringBuilder outData = new StringBuilder();
        int key;
        var allIsOk = false;
        System.out.println("Привет. Я твой криптоанализатор шрифтом цезаря\n" +
                "Для начала работы введи то, откуда я буду брать данные и куда записывать их\n" +
                "FF - из файла в файл\n" +
                "FT - из файла в терминал\n" +
                "TF - из терминала в файл\n" +
                "TT - из терминала в терминал");
        do {
            try {
                var inputType = ValidateInput.validateAllInput();
                switch (inputType) {
                    case "FF": {
                        System.out.print("Введи полный путь к файлу, откуда я буду брать данные: ");
                        inData.append(ValidateInput.validateFilePath());
                        System.out.print("Введи полный путь к файлу, куда я буду записывать сообщение: ");
                        outData.append(ValidateInput.validateFilePath());
                        System.out.print("Введи ключ: ");
                        key = ValidateInput.validateKeyInput();
                        System.out.println(Cipher.toCipher(Path.of(inData.toString()), Path.of(outData.toString()), key));
                        allIsOk = true;
                        break;
                    }
                    case "FT": {
                        System.out.print("Введи полный путь к файлу, откуда я буду брать данные: ");
                        inData.append(ValidateInput.validateFilePath());
                        System.out.print("Введи ключ: ");
                        key = ValidateInput.validateKeyInput();
                        Cipher.toCipher(Path.of(inData.toString()), outData, key);
                        System.out.println(outData);
                        allIsOk = true;
                        break;
                    }
                    case "TF": {
                        System.out.print("Введи текст: ");
                        inData.append(ValidateInput.validateAllInput());
                        System.out.print("Введи полный путь к файлу, куда я буду записывать сообщение: ");
                        outData.append(ValidateInput.validateFilePath());
                        System.out.print("Введи ключ: ");
                        key = ValidateInput.validateKeyInput();
                        System.out.println(Cipher.toCipher(inData, Path.of(outData.toString()), key));
                        allIsOk = true;
                        break;
                    }
                    case "TT": {
                        System.out.print("Введи текст: ");
                        inData.append(ValidateInput.validateAllInput());
                        System.out.print("Введи ключ: ");
                        key = ValidateInput.validateKeyInput();
                        Cipher.toCipher(inData, outData, key);
                        System.out.println(outData);
                        allIsOk = true;
                        break;
                    }
                    default:
                        System.err.println("Ты ввел некорректный ключ. Введи его заново пожалуйста");
                }
            } catch (FileNotExist e) {
                e.printStackTrace();
            } catch (KeyDoesNotFitTheTemplate e) {
                e.printStackTrace();
            }
        } while (!allIsOk);
    }


}