import Chipher.Cipher;
import validate.ValidateInput;

import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        StringBuilder inData = new StringBuilder();
        StringBuilder outData = new StringBuilder();
        int key;
        System.out.println("""
                Привет. Я твой криптоанализатор шрифтом цезаря
                Для начала работы введи то, откуда я буду брать данные и куда записывать их
                FF - из файла в файл
                FT - из файла в терминал
                TF - из терминала в файл
                TT - из терминала в терминал""");
        var inputType = ValidateInput.validateAllInput();
        System.out.println("""
                Теперь давай определимся, надо мне зашифровать данные или расшифровать?
                Введите 1 или -1 для выбора режима работы
                1 - шифрование
                -1 - расшифровка""");
        var workType = ValidateInput.validateSwitchInput("-1", "1");
        switch (inputType) {
            case "FF": {
                System.out.print("Введи полный путь к файлу, откуда я буду брать данные: ");
                inData.append(ValidateInput.validateFilePathExists());
                System.out.print("Введи полный путь к файлу, куда я буду записывать сообщение: ");
                outData.append(ValidateInput.validateFilePathExists());
                System.out.print("Введи ключ: ");
                key = ValidateInput.validateKeyInput();
                System.out.println(Cipher.toCipher(Path.of(inData.toString()), Path.of(outData.toString()), key * Integer.parseInt(workType)));
                break;
            }
            case "FT": {
                System.out.print("Введи полный путь к файлу, откуда я буду брать данные: ");
                inData.append(ValidateInput.validateFilePathExists());
                System.out.print("Введи ключ: ");
                key = ValidateInput.validateKeyInput();
                Cipher.toCipher(Path.of(inData.toString()), outData, key * Integer.parseInt(workType));
                System.out.println(outData);
                break;
            }
            case "TF": {
                System.out.print("Введи текст: ");
                inData.append(ValidateInput.validateAllInput());
                System.out.print("Введи полный путь к файлу, куда я буду записывать сообщение: ");
                outData.append(ValidateInput.validateFilePathExists());
                System.out.print("Введи ключ: ");
                key = ValidateInput.validateKeyInput();
                System.out.println(Cipher.toCipher(inData, Path.of(outData.toString()), key * Integer.parseInt(workType)));
                break;
            }
            case "TT": {
                System.out.print("Введи текст: ");
                inData.append(ValidateInput.validateAllInput());
                System.out.print("Введи ключ: ");
                key = ValidateInput.validateKeyInput();
                Cipher.toCipher(inData, outData, key * Integer.parseInt(workType));
                System.out.println(outData);
                break;
            }
        }
    }
}