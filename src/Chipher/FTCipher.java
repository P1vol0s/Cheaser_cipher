package Chipher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FTCipher extends BaseCipher {
    private static Path filePathIn;
    private static StringBuilder terminalOut;
    private static int key;
    private static FTCipher ftCipher = null;

    private FTCipher() {}

    protected static FTCipher initialize(Path newFilePath, StringBuilder sb, int newKey) {
        if (ftCipher == null) ftCipher = new FTCipher();
        filePathIn = newFilePath;
        terminalOut = sb;
        key = newKey;
        return ftCipher;
    }


    protected void toEncrypt() {
        try (var read = Files.newBufferedReader(filePathIn)) {
            int c;
            while ((c = read.read()) != -1)
                terminalOut.append(change((char) c, key));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
