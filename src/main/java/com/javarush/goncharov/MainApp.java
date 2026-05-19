package com.javarush.goncharov;

import java.io.IOException;
import java.util.Scanner;

import static com.javarush.goncharov.Cipher.*;


public class MainApp {
    public static void main(String[] args) throws IOException {
        // Логика для выбора режима работы, вызов соответствующих методов
        int mode;
        String inputPath;
        String outputPath;
        int key;
        final String MODE = "Введите номер для выбора режима работы: \n1 - Шифровать \n2 - Расшифровать";
        final String PATH_TO_INPUT_FILE = "Введите путь к исходному файлу";
        final String PATH_TO_OUTPUT_FILE = "Введите путь к файлу с результатом шифрования";
        final String KEY_VALUE_LIMIT = "Введите ключ шифрования от 1 до ";
        Scanner console = new Scanner(System.in);

        System.out.println(MODE);
        mode = Integer.parseInt(console.nextLine());

        System.out.println(PATH_TO_INPUT_FILE);
        inputPath = console.nextLine();

        System.out.println(PATH_TO_OUTPUT_FILE);
        outputPath = console.nextLine();

        System.out.println(KEY_VALUE_LIMIT + (Cipher.letters - 1));
        key = Integer.parseInt(console.nextLine());

        if (mode == 2) {
            key = -key;
        }


        caesarCipher(inputPath, outputPath, key);

    }
}