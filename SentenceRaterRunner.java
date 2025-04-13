public class SentenceRaterRunner {
    public static void main(String[] args) {
        // Instantiates the SentenceRater object
        SentenceRater rater = new SentenceRater("word_difficulty.txt");

        // Prompts the user for input
        rater.prompt();

        // Prints a sentence rating summary
        rater.printSummary();
    }
}
