package Chipher;

public class TTCipher extends BaseCipher {
    private static StringBuilder terminalIn, terminalOut;
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


    protected void toEncrypt() {
        for (var i : terminalIn.toString().toCharArray())
            terminalOut.append(change(i, key));
    }

}