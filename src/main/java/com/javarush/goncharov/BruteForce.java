package com.javarush.goncharov;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BruteForce {
    public static int decryptByBruteForce(String input) {

        Path inputPath = Path.of(input);
        int selectedKey;
        int readedCharCode;
        char mostUsedChar = ' ';
        int mostUsedCharIndex = 0;
        int charCount;
        int maxCharIndex = 0;
        int maxCharCount = 0;



            for (int i = 0; i < Cipher.letters; i++) {

                charCount = 0;

                try (BufferedReader reader = Files.newBufferedReader(inputPath)) {

                    while ((readedCharCode = reader.read()) != -1) {
                        char readedChar = (char) readedCharCode;
                        readedChar = Character.toLowerCase(readedChar);

                        if (Cipher.alphabet[i] == readedChar) {
                            charCount++;
                        }
                        if (Cipher.alphabet[i] == mostUsedChar) {
                            mostUsedCharIndex = i;
                        }
                    }
                    if (maxCharCount < charCount) {
                        maxCharCount = charCount;
                        maxCharIndex = i;
                    }

                } catch (IOException e) {
                    throw new MyExceptions(e.getMessage(), e);
                }
            }

        selectedKey = (maxCharIndex - mostUsedCharIndex + Cipher.letters) % Cipher.letters;

        System.out.println("Selected key: " + selectedKey);
        System.out.println("maxCharIndex: " + maxCharIndex);
        System.out.println("mostUsedCharIndex: " + mostUsedCharIndex);


        return selectedKey;
    }
}