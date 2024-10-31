package hangman;

public class DrawMan {
    private final String[] hangmanStages = {
            " +---+\n |   |\n O   |\n/|\\  |\n/ \\  |\n     |\n",
            " +---+\n |   |\n O   |\n/|\\  |\n/    |\n     |\n",
            " +---+\n |   |\n O   |\n/|\\  |\n     |\n     |\n",
            " +---+\n |   |\n O   |\n/|   |\n     |\n     |\n",
            " +---+\n |   |\n O   |\n |   |\n     |\n     |\n",
            " +---+\n |   |\n O   |\n     |\n     |\n     |\n",
            " +---+\n |   |\n     |\n     |\n     |\n     |\n",
            " ",
    };

    public String getCurrentStage(int lives) {
        int index = hangmanStages.length - 1 - (Game.getLives() - lives);
        if (index < 0) index = 0;
        if (index >= hangmanStages.length) index = hangmanStages.length -1;
        return hangmanStages[index];
    }
}