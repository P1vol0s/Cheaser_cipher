import Chipher.CeaserCipher;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //String fileName = sc.nextLine();
        String line = sc.nextLine();
        //Path path = Path.of(fileName);
        CeaserCipher ceaserCipher = new CeaserCipher(line, 4);
        ceaserCipher.cipher();
        System.out.println(ceaserCipher.getSecondLine());

    }
}