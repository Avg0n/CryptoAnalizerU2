package com.javarush.goncharov;

import java.util.Scanner;

import static com.javarush.goncharov.Cipher.alphabet;
import static com.javarush.goncharov.Cipher.cezarCipher;


public class MainApp {
    public static void main(String[] args) {
        // Логика для выбора режима работы, вызов соответствующих методов
        int mode;
        String inputPath;
        String outputPath;
        int key;
        Scanner console = new Scanner(System.in);

        System.out.println("Введите номер для выбора режима работы: \n1 - Шифровать \n2 - Расшифровать");
        mode = Integer.parseInt(console.nextLine());

        System.out.println("Введите путь к исходному файлу");
        inputPath = console.nextLine();

        System.out.println("Введите путь к файлу с результатом шифрования");
        outputPath = console.nextLine();

        System.out.println("Введите ключ шифрования от 1 до " + (alphabet.length - 1));
        key = Integer.parseInt(console.nextLine());

        if (mode == 2) {
            key = - key;
        }


         cezarCipher(inputPath, outputPath, key);

    }
}