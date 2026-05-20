package com.javarush.goncharov;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BruteForce {
    public static int decryptByBruteForce(String input) {

        Path inputPath = Path.of(input);
        int key;
        int readedCharCode;
        char mostUsedChar = ' ';
        int mostUsedCharIndex = 0;
        int charCount = 0;
        int maxCharIndex = 0;
        int maxCharCount = 0;

        try (BufferedReader reader = Files.newBufferedReader(inputPath)) {

            for (int i = 0; i < Cipher.letters; i++) {
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
            }
        } catch (IOException e) {
            throw new MyExceptions(e.getMessage(), e);
        }

        key = (maxCharIndex - mostUsedCharIndex + Cipher.letters) % Cipher.letters;

        return key;
    }
}