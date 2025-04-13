import java.util.ArrayList;
import java.util.Scanner;

/**
 * SentenceRater class analyzes and rates the given sentence complexity.
 */
public class SentenceRater {
    private ArrayList<String> easyWords;
    private ArrayList<String> mediumWords;
    private ArrayList<String> hardWords;
    private String userSentence;
    private int complexityScore;

    /**
     * This constructor initializes the difficulty word lists from the text file.
     * @param filename The file containing word difficulty levels.
     */
    public SentenceRater(String filename) {
        TextProcessor processor = new TextProcessor(filename);
        easyWords = new ArrayList<>();
        mediumWords = new ArrayList<>();
        hardWords = new ArrayList<>();
        parseWordDifficulty(processor.getTextList());
    }

    /**
     * This method parses the word difficulty file and fills the lists.
     * @param textList The lines read from the file.
     */
    private void parseWordDifficulty(ArrayList<String> textList) {
        for (String line : textList) {
            if (line.startsWith("easy: ")) {
                addWordsToList(line.substring(6), easyWords);
            } else if (line.startsWith("medium: ")) {
                addWordsToList(line.substring(8), mediumWords);
            } else if (line.startsWith("hard: ")) {
                addWordsToList(line.substring(6), hardWords);
            }
        }
    }

    /**
     * Adds the words to its respective difficulty list.
     * @param wordsStr The string containing words separated by commas.
     * @param list The ArrayList to store words.
     */
    private void addWordsToList(String wordsStr, ArrayList<String> list) {
        String[] words = wordsStr.split(", ");
        for (String word : words) {
            list.add(word.trim().toLowerCase());
        }
    }

    /**
     * Prompts the user for a sentence and then processes it.
     */
    public void prompt() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a sentence to analyze:");
        userSentence = input.nextLine();
        input.close();

        calculateComplexity();
    }

    /**
     * Uses word difficulty in the given sentence to calculate complexity.
     */
    private void calculateComplexity() {
        String[] words = userSentence.split(" ");
        complexityScore = 0;

        for (String word : words) {
            String lowerWord = word.toLowerCase().replaceAll("[^a-z]", ""); // Remove punctuation
            if (hardWords.contains(lowerWord)) {
                complexityScore += 3;
            } else if (mediumWords.contains(lowerWord)) {
                complexityScore += 2;
            } else {
                complexityScore += 1;
            }
        }
    }

    /**
     * Prints a summary of the sentence complexity rating.
     */
    public void printSummary() {
        System.out.println("Sentence: " + userSentence);
        System.out.println("Complexity Score: " + complexityScore);
        System.out.println("Complexity Level: " + getComplexityLevel());
    }

    /**
     * Determines the complexity level based on the score.
     * @return A string representing the complexity level.
     */
    private String getComplexityLevel() {
        if (complexityScore > 20) {
            return "Very Complex";
        } else if (complexityScore > 10) {
            return "Moderately Complex";
        } else {
            return "Simple";
        }
    }
}
