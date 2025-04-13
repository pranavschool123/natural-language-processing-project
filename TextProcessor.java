import java.util.ArrayList;

/**
 * Analyzes and processes text from a file.
 */
public class TextProcessor {
    private String filename;
    private ArrayList<String> textList;

    /**
     * Constructor to create a TextProcessor with the specified filename.
     * @param filename The text file containing word data.
     */
    public TextProcessor(String filename) {
        this.filename = filename;
        textList = FileReader.toStringList(filename);
    }

    /**
     * Accessor method for filename.
     * @return The name of the text file.
     */
    public String getFileName() {
        return filename;
    }

    /**
     * Accessor method for textList.
     * @return The ArrayList containing lines read from the text file.
     */
    public ArrayList<String> getTextList() {
        return textList;
    }

    /**
     * Changes the file and updates textList.
     * @param filename New filename to process.
     */
    public void changeFile(String filename) {
        this.filename = filename;
        textList = FileReader.toStringList(filename);
    }

    /**
     * Returns an ArrayList of individual words from textList.
     * @return A list of words from the text file.
     */
    public ArrayList<String> textToWords() {
        ArrayList<String> wordList = new ArrayList<>();
        for (String line : textList) {
            String[] words = line.split(" ");
            for (String word : words) {
                wordList.add(word);
            }
        }
        return wordList;
    }

    /**
     * Converts textList to a formatted string.
     * @return The textList content as a string.
     */
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (String value : textList) {
            text.append(value).append("\n");
        }
        return text.toString();
    }
}
