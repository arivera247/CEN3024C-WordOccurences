import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


        import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.net.URL;
        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

public class Analyzer {
    public static void main(String[] args) throws Exception {
        //Reading Directly from a URL tutorial
        //https://docs.oracle.com/javase/tutorial/networking/urls/readingURL.html
        URL TPG = new URL("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm");  //Modified URL from tutorial to reflect required URL
        BufferedReader in = new BufferedReader
                (
                        new InputStreamReader(TPG.openStream())
                );

        String inputLine;


        StringBuilder htmlText = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {  //FIXME - adjust parameters to skip text through first header tag "<h1> and after end of chapter comment tag "<!--end chapter-->"
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
