package Chipher;

import java.nio.file.Files;
import java.util.Set;

public class CeaserCipher {
    private static final Set<Character> ALPHABET_IGNORE = Set.of(
            '!', '"', '#', '$', '%', '&', '\'', '(', ')', '*',
            '+', ',', '-', '.', '/', ':', ';', '<', '=', '>',
            '?', '@', '[', '\\', ']', '^', '_', '`', '{', '|',
            '}', '~');

    private int key;
    private static byte count = 0;
    private Files firstFileName;
    private Files secondFileName;
    private String firstLine;
    private StringBuilder secondLine;
    private final String script;

    public StringBuilder getSecondLine() {
        return secondLine;
    }

    {
        firstFileName = null;
        secondFileName = null;
        firstLine = null;
        secondLine = new StringBuilder();
    }

    public CeaserCipher(Files firstFileName, Files secondFileName, int key) {
        this.firstFileName = firstFileName;
        this.secondFileName = secondFileName;
        this.key = key;
        script = "FF";
    }

    public CeaserCipher(String firstLine, int key) {
        this.firstLine = firstLine;
        this.key = key;
        script = "TT";
    }

    public CeaserCipher(Files firstFileName, int key) {
        this.firstFileName = firstFileName;
        this.key = key;
        script = "FT";
    }

    public CeaserCipher(String firstLine, Files secondFileName, int key) {
        this.firstLine = firstLine;
        this.secondFileName = secondFileName;
        this.key = key;
        script = "TF";
    }


    public void cipher() {
        switch (script) {
            case "FF" -> cipherFF();
            case "FT" -> cipherFT();
            case "TF" -> cipherTF();
            case "TT" -> cipherTT();
        }
    }

    private void cipherTT() {
        for (char letter : firstLine.toCharArray()) {
            if (!ALPHABET_IGNORE.contains(letter))
                secondLine.append(change(letter));
            else
                secondLine.append(letter);
        }
    }

    private void cipherTF() {
        /* todo:1) по одному символу записываем со сдвигом в файл из строки firstLine*/

    }

    private void cipherFT() {
        /* todo: 1) считываем по одному символу из файла
         *      2)по одному символу со сдвигом добавляется в secondLine*/
    }

    private void cipherFF() {
        /* todo:1) считываем по одному символу из файла firstFile
         *      2) записываем по одному символу со сдвигом в secondLine*/

    }

    private char change(char letter) {
        if (letter >= 1040 && letter <= 1071) {
            int offset = (letter - 1040 + key) % 32;
            return (char) (1040 + (offset < 0 ? offset + 32 : offset));
        }
        int offset = (letter - 1072 + key) % 32;
        return (char) (1072 + (offset < 0 ? offset + 32 : offset));

    }
}
