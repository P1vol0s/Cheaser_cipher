package Chipher;

class BaseCipher {

    protected static char change(char letter, int key) {
        if (letter >= 1040 && letter <= 1071) return math(letter, key, 1040, 32);
        else if (letter >= 1072 && letter <= 1103) return math(letter, key, 1072, 32);
        else if (letter >= 65 && letter <= 90) return math(letter, key, 65, 24);
        else if (letter >= 97 && letter <= 122) return math(letter, key, 97, 24);
        return letter;
    }

    private static char math(char letter, int key, int minLetter, int alphabetLen) {
        int offset = (letter - minLetter + key) % alphabetLen;
        return (char) (minLetter + (offset < 0 ? offset + alphabetLen : offset));
    }


}
