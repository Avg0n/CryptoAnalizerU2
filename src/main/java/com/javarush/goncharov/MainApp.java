package com.javarush.goncharov;

import java.io.IOException;
import java.util.Scanner;
import com.javarush.goncharov.Constants.*;
import com.javarush.goncharov.Cipher.*;


public class MainApp {
    public static void main(String[] args) throws IOException {
        int mode;
        String inputPath;
        String outputPath;
        int key;

        Scanner console = new Scanner(System.in);

        System.out.println(Constants.MODE);
        mode = Integer.parseInt(console.nextLine());

        System.out.println(Constants.PATH_TO_INPUT_FILE);
        inputPath = console.nextLine();

        System.out.println(Constants.PATH_TO_OUTPUT_FILE);
        outputPath = console.nextLine();

        System.out.println(Constants.KEY_VALUE_LIMIT + (Cipher.letters - 1));
        key = Integer.parseInt(console.nextLine());

        if (mode == 2) {
            key = -key;
        }


        Cipher.caesarCipher(inputPath, outputPath, key);

    }
}