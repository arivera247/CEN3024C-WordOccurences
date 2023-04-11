import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class defines how the information provided the Main class will be handled and modified.
 */
public class Analyzer {
    /**
     * The URL provided by the user in the Main class is passed to the urlAnalyzer method creating a TPG object.
     * TPG is an initialism for The Project Gutenberg. It is a reference to the expected URL provided by the user.
     * The BufferedReader class is used to read the contents of the provided URL.
     * The value for the URL is then stored in the inputLine variable of type string.
     * A new object is created named StringBuilder, which stores the scanned content of the provided URL in a way that is editable.
     * After checking the inputLine variable is not empty, the contents of the inputLine variable is formatted to remove punctuation, headers, footers, and other HTML tags using regex.
     * The formatted text is then stored in the filteredText variable and HashMap array.
     * Finally, the HashMap array is sorted by greatest to least value and printed to the console.
     * @param args - This parameter allows the analyzer class to accept provided information from other classes.
     * @throws Exception - This statement was added to avoid errors when providing information to the console.
     */
    public static void urlAnalyzer(String args) throws Exception {


        //Reading Directly from a URL tutorial
        //https://docs.oracle.com/javase/tutorial/networking/urls/readingURL.html
        //URL TPG = new URL("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm");  //Modified URL from tutorial to reflect required URL
        URL TPG = new URL(Main.myURL);
        BufferedReader in = new BufferedReader
                (
                        new InputStreamReader(TPG.openStream())
                );

        String inputLine;


        StringBuilder htmlText = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            //FIXME - adjust parameters to skip text through first header tag "<h1> and after end of chapter comment tag "<!--end chapter-->"
            //System.out.println(inputLine);  //Contents of webpage successfully printed. Removing by comment for test-first development.
            htmlText.append(inputLine);
        }
        in.close();

        // Remove all HTML tags and store the cleaned text in a string
        //https://www.javatpoint.com/java-string-replaceall
        String filteredText = htmlText.toString().replaceAll("<[^>]*>", "");
        //FIXME - remove punctuation, header, and footer information using regular expressions.


        // Split the cleaned text into words
        String[] words = filteredText.split(" ");
        //FIXME - expand to include punctuation marks

        // HashMap counting word occurrences
        //https://www.geeksforgeeks.org/java-util-hashmap-in-java-with-examples/
        //FIXME - expand to provide only top 20 results
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        // Sort the word counts by frequency
        List<Map.Entry<String, Integer>> wordCountList = new ArrayList<>(wordCounts.entrySet());
        wordCountList.sort((entry1, entry2) -> entry2.getValue() - entry1.getValue());

        // Output the word counts as a two-column array
        for (Map.Entry<String, Integer> entry : wordCountList) {

            System.out.println(entry.getKey() + " - " + entry.getValue()); //Prints hash map with hyphen separated values

            //FIXME - add values to output to MainController
        }
    }
}
