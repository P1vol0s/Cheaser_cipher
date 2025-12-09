package Chipher;

import java.nio.file.Path;

public class Cipher {

    private Cipher() {
    }

    public static String toCipher(Path filePathIn, Path filePathOut, int key) {
        FFCipher ffCipher = FFCipher.initialize(filePathIn, filePathOut, key);
        ffCipher.toEncrypt();
        return "Все зашифровано. Проверьте файл";
    }

    public static StringBuilder toCipher(Path filePathIn, StringBuilder terminalOut, int key) {
        FTCipher ftCipher = FTCipher.initialize(filePathIn, terminalOut, key);
        ftCipher.toEncrypt();
        return terminalOut;
    }

    public static String toCipher(StringBuilder terminalIn, Path filePathOut, int key) {
        TFCipher tfCipher = TFCipher.initialize(terminalIn, filePathOut, key);
        tfCipher.toEncrypt();
        return "Все зашифровано. Проверьте файл";
    }

    public static StringBuilder toCipher(StringBuilder terminalIn, StringBuilder terminalOut, int key) {
        TTCipher ttCipher = TTCipher.initialize(terminalIn, terminalOut, key);
        ttCipher.toEncrypt();
        return terminalOut;
    }

    public static void decode(Path filePathIn, Path filePathOut, int key) {
        toCipher(filePathIn, filePathOut, -1 * key);
    }

    public static void decode(Path filePathIn, StringBuilder terminalOut, int key) {
        toCipher(filePathIn, terminalOut, -1 * key);
    }

    public static void decode(StringBuilder terminalIn, Path filePathOut, int key) {
        toCipher(terminalIn, filePathOut, -1 * key);
    }

    public static void decode(StringBuilder terminalIn, StringBuilder terminalOut, int key) {
        toCipher(terminalIn, terminalOut, -1 * key);
    }







    /*todo: Задача написать публичный статический метод для вызова одного из сценариев шифрования.
     *       Сделать инициализацию метода с параметром typeOfCipher который будет задавать тип шифрования
     *       Сделать перегруженный метод encrypt, который в зависимости от переданных значений будет создавать
     *       различные экземпляры классов шифрования и выполнять метод toEncrypt у этих классов.
     *       Если метод был вызван повторно, то новый экземпляр класс не создается, а просто меняются данные внутри класса - шифровальщика.
     *  */


}
