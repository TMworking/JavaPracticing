package PasswordGenerator;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class Generator {
    private static final SecureRandom RANDOM = new SecureRandom();

    public String generatePassword(int length) {
        List<Character> password = new ArrayList<>();
        SecureRandom random = new SecureRandom();

        password.add(getRandomCharacter(SymbolSets.UPPERCASE));
        password.add(getRandomCharacter(SymbolSets.LOWERCASE));
        password.add(getRandomCharacter(SymbolSets.DIGITS));
        password.add(getRandomCharacter(SymbolSets.SPECIAL));

        for (int i = 4; i < length; i++) {
            password.add(getRandomCharacter(SymbolSets.ALL_SYMBOLS));
        }

        for (int i = 0; i < length-1; i++) {
            int newIndex = random.nextInt(i + 1);
            char tmp = password.get(i);
            password.set(i, password.get(newIndex));
            password.set(newIndex, tmp);
        }

        StringBuilder finalPassword = new StringBuilder();
        for (char c : password) {
            finalPassword.append(c);
        }

        return finalPassword.toString();
    }

    private char getRandomCharacter(String characters) {
        int index = RANDOM.nextInt(characters.length());
        return characters.charAt(index);
    }
}