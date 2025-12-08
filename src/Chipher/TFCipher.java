package Chipher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class TFCipher extends BaseCipher {
    private static StringBuilder terminalIn;
    private static Path filePathOut;
    private static int key;
    private static TFCipher tfCipher = null;

    private TFCipher() {
    }

    protected static TFCipher initialize(Path newFilePath, StringBuilder sb, int newKey) {
        if (tfCipher == null) tfCipher = new TFCipher();
        filePathOut = newFilePath;
        terminalIn = sb;
        key = newKey;
        return tfCipher;
    }


    protected static void toEncrypt() {
        try (var writer = Files.newBufferedWriter(filePathOut)) {
            Scanner sc = new Scanner(System.in);
            terminalIn.append(sc.nextLine());
            for (char i : terminalIn.toString().toCharArray())
                writer.write(change(i, key));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}