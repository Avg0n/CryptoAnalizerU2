package com.javarush.goncharov;

public class Cipher {
    private static final char[] alphabet = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};
    public Cipher(char[] alphabet) {
        this.alphabet = alphabet;
    }
    public String encrypt(String pureText, int shift) {
        // Логика шифрования

    }
    public String decrypt(String encryptedText, int shift) {
        // Логика расшифровки
    }
}