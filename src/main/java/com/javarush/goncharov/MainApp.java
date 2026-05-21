package com.javarush.goncharov;

import java.io.IOException;
import java.util.Scanner;

import com.javarush.goncharov.Constants.*;
import com.javarush.goncharov.Cipher.*;
import com.javarush.goncharov.BruteForce.*;


public class MainApp {
    public static void main(String[] args) throws IOException {
        int mode;
        String inputPath;
        String outputPath;
        int key = 0;
        Scanner console = new Scanner(System.in);

        System.out.println(Constants.MODE);
        mode = Integer.parseInt(console.nextLine());

        System.out.println(Constants.PATH_TO_INPUT_FILE);
        inputPath = console.nextLine();

        System.out.println(Constants.PATH_TO_OUTPUT_FILE);
        outputPath = console.nextLine();

        if (mode == 1 || mode == 2) {
            System.out.println(Constants.KEY_VALUE_LIMIT + Cipher.letters);
            key = Integer.parseInt(console.nextLine()) % Cipher.letters;
        }
        if (mode == 3) {
            key = BruteForce.decryptByBruteForce(inputPath);
        }
        if (mode == 2 || mode == 3) {
            key = -key;
        }

        Cipher.caesarCipher(inputPath, outputPath, key);
    }
}