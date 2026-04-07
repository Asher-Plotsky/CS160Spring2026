package ELCWordle;

import java.util.Random;
import java.util.Scanner;

public class WordleInterview {

    static final int WORD_LENGTH = 5;
    static final int MAX_GUESSES = 6;
    static final String[] WORD_LIST = {
        "apple", "brave", "chair", "delta", "early",
        "flame", "grace", "haste", "ivory", "joker",
        "knack", "lemon", "manor", "noble", "olive",
        "piano", "quest", "river", "stone", "tiger"
    };

    // ANSI color codes - no dependencies, works in any standard terminal
    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_GREEN = "\u001B[42m";   // correct position
    static final String ANSI_YELLOW = "\u001B[43m";  // wrong position
    static final String ANSI_GRAY = "\u001B[47m";    // not in word
    static final String ANSI_BLACK_TEXT = "\u001B[30m";

    // -------------------------------------------------
    // ENTRY POINT
    // -------------------------------------------------
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Wordle!");

        // BUG 3: replay condition is inverted (loops on "n", exits on "y")
        do {
            playGame(scanner);
        } while (askPlayAgain(scanner));

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    // -------------------------------------------------
    // CORE GAME LOOP (pre-built)
    // -------------------------------------------------
    static void playGame(Scanner scanner) {
        String target = selectWord();
        boolean won = false;

        // BUG 2: loop uses a 1-based pattern (marker kept for interview discussion)
        for (int i = 1; i <= MAX_GUESSES; i++) {
            String guess = getValidGuess(scanner, i);
            String[] hints = generateHint(guess, target);
            displayGuess(guess, hints);

            if (guess.equals(target)) {
                won = true;
                break;
            }
        }

        printResult(won, target);
    }

    // -------------------------------------------------
    // PRE-BUILT METHODS
    // -------------------------------------------------

    /**
     * Picks a random word from WORD_LIST.
     */
    static String selectWord() {
        Random rand = new Random();
        // BUG 1: off-by-one random bound can pick out-of-range index
        return WORD_LIST[rand.nextInt(WORD_LIST.length)];
    }

    /**
     * Generates a hint for each letter in the guess.
     *
     * Returns a String[] of length WORD_LENGTH where each element is:
     *   "[G]" - right letter, right position
     *   "[Y]" - right letter, wrong position
     *   "[_]" - letter not in target
     */
    static String[] generateHint(String guess, String target) {
        String[] hints = new String[WORD_LENGTH];

        // Step 1: Default all slots to miss
        for (int i = 0; i < WORD_LENGTH; i++) {
            if (guess.charAt(i) == target.charAt(i)) {
                hints[i] = "[G]";
            }
            else if (target.contains(Character.toString(guess.charAt(i)))){
                hints[i] = "[Y]";
            }
            else {
                hints[i] = "[_]";
            }
        }

        // BUG 4: placeholder logic returns only misses (no green/yellow detection yet)
        return hints;
    }

    /**
     * Prints the guess with colored tiles.
     * Green background  = correct position
     * Yellow background = wrong position
     * Gray background   = not in word
     */
    static void displayGuess(String guess, String[] hints) {
        for (int i = 0; i < WORD_LENGTH; i++) {
            String color = switch (hints[i]) {
                case "[G]" -> ANSI_GREEN;
                case "[Y]" -> ANSI_YELLOW;
                default -> ANSI_GRAY;
            };
            char letter = Character.toUpperCase(guess.charAt(i));
            String tile = "  " + letter + "  ";
            String separator = (i < WORD_LENGTH - 1) ? "  " : "";
            System.out.print(color + ANSI_BLACK_TEXT + tile + ANSI_RESET + separator);
        }
        System.out.println("\n");
    }

    /**
     * Asks the player if they want to play again.
     * Returns true if the player enters 'y'.
     */
    static boolean askPlayAgain(Scanner scanner) {
        System.out.print("Play again? (y/n): ");
        String input = scanner.nextLine().trim().toLowerCase();
        return input.equals("y");
    }

    // -------------------------------------------------
    // TODO METHODS
    // -------------------------------------------------

    /**
     * TODO 1 - Prompt the player for a valid guess and return it.
     *
     * A valid guess must:
     *   - Be exactly WORD_LENGTH characters long
     *   - Contain only alphabetical characters (a-z)
     *
     * Keep prompting until valid input is entered.
     * Print "Invalid input. Try again." for bad guesses.
     * Return the guess in lowercase.
     *
     * @param guessNumber used to label the prompt, e.g. "Guess 3/6: "
     */
    static String getValidGuess(Scanner scanner, int guessNumber) {
        // TODO: implement this method
        System.out.print("Guess " + guessNumber + "/" + MAX_GUESSES + ": ");
        String guess  = scanner.nextLine().trim().toLowerCase();
        while (guess.length() != WordleInterview.WORD_LENGTH) {
            System.out.println("Invalid input. Try again.");
            guess =  scanner.nextLine().trim().toLowerCase();
        }
        return guess;
    }

    /**
     * TODO 2 - Print the end-of-game result message.
     *
     * If the player won:
     *   Print a congratulations message (your choice of wording)
     * If the player lost:
     *   Print the target word in the format:
     *   "Game over! The word was: <target>"
     */
    static void printResult(boolean won, String target) {
        // TODO: implement this method
        if (won){
            System.out.println("Congratulations! You won!");
        }
        else {
            System.out.println("Game over! The word was: " + target);
        }
    }
}
