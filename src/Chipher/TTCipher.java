package Chipher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class TTCipher extends BaseCipher {
    private static StringBuilder terminalIn;
    private static StringBuilder terminalOut;
    private static int key;
    private static TTCipher ttCipher = null;

    private TTCipher() {
    }

    protected static TTCipher initialize(StringBuilder sbIn, StringBuilder sbOut, int newKey) {
        if (ttCipher == null) ttCipher = new TTCipher();
        terminalIn = sbIn;
        terminalOut = sbOut;
        key = newKey;
        return ttCipher;
    }


    protected static void toEncrypt() {
        Scanner sc = new Scanner(System.in);
        terminalIn.append(sc.nextLine());
        for (var i : terminalIn.toString().toCharArray())
            terminalOut.append(change(i, key));
    }

    public static StringBuilder getTerminalOut() {
        return terminalOut;
    }
}