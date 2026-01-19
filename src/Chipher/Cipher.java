package Chipher;

import java.nio.file.Path;

public class Cipher {

    private Cipher() {
    }

    public static String toCipher(Path filePathIn, Path filePathOut, int key) {
        FFCipher ffCipher = FFCipher.initialize(filePathIn, filePathOut, key);
        ffCipher.toEncrypt();
        return "Все готово. Проверьте файл";
    }

    public static void toCipher(Path filePathIn, StringBuilder terminalOut, int key) {
        FTCipher ftCipher = FTCipher.initialize(filePathIn, terminalOut, key);
        ftCipher.toEncrypt();
    }

    public static String toCipher(StringBuilder terminalIn, Path filePathOut, int key) {
        TFCipher tfCipher = TFCipher.initialize(terminalIn, filePathOut, key);
        tfCipher.toEncrypt();
        return "Все готово. Проверьте файл";
    }

    public static void toCipher(StringBuilder terminalIn, StringBuilder terminalOut, int key) {
        TTCipher ttCipher = TTCipher.initialize(terminalIn, terminalOut, key);
        ttCipher.toEncrypt();
    }

    public static String decode(Path filePathIn, Path filePathOut, int key) {
        toCipher(filePathIn, filePathOut, -1 * key);
        return "Все готово. Проверьте файл";
    }

    public static void decode(Path filePathIn, StringBuilder terminalOut, int key) {
        toCipher(filePathIn, terminalOut, -1 * key);
    }

    public static String decode(StringBuilder terminalIn, Path filePathOut, int key) {
        toCipher(terminalIn, filePathOut, -1 * key);
        return "Все готово. Проверьте файл";
    }

    public static void decode(StringBuilder terminalIn, StringBuilder terminalOut, int key) {
        toCipher(terminalIn, terminalOut, -1 * key);
    }
}
