package com.lpzpassgen.lpzpassgen;

import java.security.SecureRandom;

public class Generator {

    private final boolean numbers;
    private final boolean letters;
    private final boolean characters;
    private final int length;

    public Generator(boolean numbers, boolean letters, boolean characters, int length) {
        this.numbers = numbers;
        this.letters = letters;
        this.characters = characters;
        this.length = length;
    }

    public String generatePassword() {
        String numbersPool = "0123456789";
        String lettersPool = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String charactersPool = "!@#$%^&*()_+{}[];:?><";
        StringBuilder pool = new StringBuilder();

        if (numbers) pool.append(numbersPool);
        if (letters) pool.append(lettersPool);
        if (characters) pool.append(charactersPool);

        if (pool.isEmpty()) {
            throw new IllegalArgumentException("No character types selected for password generation.");
        }
        if (length <= 0) {
            throw new IllegalArgumentException("Password length must be greater than 0.");
        }

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        // Ensure diversity: at least one of each selected type
        if (numbers) password.append(numbersPool.charAt(random.nextInt(numbersPool.length())));
        if (letters) password.append(lettersPool.charAt(random.nextInt(lettersPool.length())));
        if (characters) password.append(charactersPool.charAt(random.nextInt(charactersPool.length())));

        // Fill the rest of the password
        while (password.length() < length) {
            password.append(pool.charAt(random.nextInt(pool.length())));
        }

        // Shuffle to avoid predictable placement of guaranteed characters
        return shuffleString(password.toString(), random);
    }

    private String shuffleString(String input, SecureRandom random) {
        char[] chars = input.toCharArray();
        for (int i = chars.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }
}
