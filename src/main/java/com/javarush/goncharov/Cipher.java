package com.javarush.goncharov;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class Cipher {
    static final char[] alphabet = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»', '"', '\'', ':', ';', '!', '?', '-', '+', '=', ' '};

    //    public Cipher(char[] alphabet) {
//        this.alphabet = alphabet;
//    }
    private Cipher() {

    }
//    public String encrypt(String pureText, int shift) {
//        // Логика шифрования
//
//    }
//    public String decrypt(String encryptedText, int shift) {
//        // Логика расшифровки
//    }

    public static void caesarCipher(String input, String output, int key) throws IOException {
        Path inputPath = Path.of(input);
        Path outputPath = Path.of(output);
        if (Files.notExists(outputPath)) {
            Files.createFile(outputPath); // Создаст пустой файл
        }
        try (
                BufferedReader reader = Files.newBufferedReader(inputPath);
                BufferedWriter writer = Files.newBufferedWriter(outputPath)
        ) {
            int readedCharCode;
            while ((readedCharCode = reader.read()) != -1) {
                char readedChar = (char) readedCharCode;
                readedChar = Character.toLowerCase(readedChar);
                if (readedChar == '\n') {
                    writer.write(readedChar);
                } else {
                    for (int i = 0; i < alphabet.length; i++) {
                        if (alphabet[i] == readedChar) {
                            int j = (i + key + alphabet.length) % alphabet.length;
                            writer.write(alphabet[j]);
                        }
                    }
                }
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}