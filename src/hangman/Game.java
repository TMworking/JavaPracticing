package hangman;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Game {
    private static final int MAX_LIVES = 7;
    private int currentLives;
    private final String hiddenWord;
    private final Set<Character> guessedLetters;
    private final DrawMan drawMan;

    public static int getLives(){
        return MAX_LIVES;
    }

    public Game() {
        WordsGenerator wordsGenerator = new WordsGenerator();
        drawMan = new DrawMan();
        hiddenWord = wordsGenerator.getRandomWord().toLowerCase();
        guessedLetters = new HashSet<>();
        currentLives = MAX_LIVES;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n" + drawMan.getCurrentStage(currentLives));
            System.out.println("Слово: " + getMaskedWord());
            System.out.println("Оставшиеся жизни: " + currentLives);
            System.out.print("Введите букву: ");
            String input = scanner.nextLine().toLowerCase();

            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Введите одну букву.");
                continue;
            }

            char guess = input.charAt(0);
            if (guessedLetters.contains(guess)) {
                System.out.println("Вы уже угадывали эту букву.");
                continue;
            }

            guessedLetters.add(guess);

            if (hiddenWord.indexOf(guess) < 0) currentLives--;

            if (isWordGuessed()) {
                System.out.println("\nПобеда! Вы угадали слово: " + hiddenWord);
                break;
            }

            if (currentLives <= 0) {
                System.out.println("\nПроигрыш! Загаданное слово было: " + hiddenWord);
                System.out.println("\n" + drawMan.getCurrentStage(currentLives));
                break;
            }
        }
        scanner.close();
    }

    private String getMaskedWord() {
        StringBuilder masked = new StringBuilder();
        for (char a : hiddenWord.toCharArray()) {
            if (guessedLetters.contains(a)) {
                masked.append(a).append(' ');
            } else {
                masked.append("_ ");
            }
        }
        return masked.toString();
    }

    private boolean isWordGuessed() {
        for (char a : hiddenWord.toCharArray()) {
            if (!guessedLetters.contains(a)) {
                return false;
            }
        }

        return true;
    }
}