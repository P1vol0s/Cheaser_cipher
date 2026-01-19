package Chipher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class FFCipher extends BaseCipher {
    private static Path filePathIn, filePathOut;
    private static int key;
    private static FFCipher ffCipher = null;

    private FFCipher() {}

    protected static FFCipher initialize(Path newFilePath1, Path newFilePath2, int newKey) {
        if (ffCipher == null) ffCipher = new FFCipher();
        filePathIn = newFilePath1;
        filePathOut = newFilePath2;
        key = newKey;
        return ffCipher;
    }

    protected void toEncrypt() {
        try (var read = Files.newBufferedReader(filePathIn);
             var write = Files.newBufferedWriter(filePathOut)) {
            int c;
            while ((c = read.read()) != -1)
                write.write(change((char) c, key));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
