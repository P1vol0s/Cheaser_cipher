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
        switch (inputType) {
            case "FF": {
                System.out.print("Введи полный путь к файлу, откуда я буду брать данные: ");
                inData.append(ValidateInput.validateFilePathExists());
                System.out.print("Введи полный путь к файлу, куда я буду записывать сообщение: ");
                outData.append(ValidateInput.validateFilePathExists());
                System.out.print("Введи ключ: ");
                key = ValidateInput.validateKeyInput();
                System.out.println(Cipher.toCipher(Path.of(inData.toString()), Path.of(outData.toString()), key));
                break;
            }
            case "FT": {
                System.out.print("Введи полный путь к файлу, откуда я буду брать данные: ");
                inData.append(ValidateInput.validateFilePathExists());
                System.out.print("Введи ключ: ");
                key = ValidateInput.validateKeyInput();
                Cipher.toCipher(Path.of(inData.toString()), outData, key);
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
                System.out.println(Cipher.toCipher(inData, Path.of(outData.toString()), key));
                break;
            }
            case "TT": {
                System.out.print("Введи текст: ");
                inData.append(ValidateInput.validateAllInput());
                System.out.print("Введи ключ: ");
                key = ValidateInput.validateKeyInput();
                Cipher.toCipher(inData, outData, key);
                System.out.println(outData);
                break;
            }
            default:
                System.err.println("Ты ввел некорректный ключ. Введи его заново пожалуйста");
        }
    }

    /*Сделать так, чтобы вся валидация полностью проходила в файлах папки exceptions и выглядела примерно так:
     * все, что надо проверить изначально попадает в файл ValidateInput и в нем проверятся. Если все хорошо, то
     * данные из файла ValidateInput отправляются обратно. Если же что-то не так, то метод, который производил
     * проверку, выдает ошибку, которая тут же ловится блоком catch. В этом блоке вызывается метод из файла
     * ValidatExceptions, который устраняет эту ошибку. */
}