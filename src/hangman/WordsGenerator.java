package hangman;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WordsGenerator {
    private static final List<String> WORDS = Arrays.asList(
            "кокос",
            "компьютер",
            "телефон",
            "игра",
            "машина",
            "мышка",
            "школа",
            "математика",
            "город",
            "ковер"
    );

    private final Random random;

    public WordsGenerator() {
        random = new Random();
    }

    public String getRandomWord() {
        return WORDS.get(random.nextInt(WORDS.size()));
    }
}