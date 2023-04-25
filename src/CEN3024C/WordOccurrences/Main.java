package CEN3024C.WordOccurrences;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This is the starting point for the Word Occurrences program.
 * Here the user is prompted to enter a URL to scan with the Analyzer class.
 */

public class Main extends Application {



    /**
     * The myURL variable is declared here and given a static type. The myURL is also made public for access by other classes.
     */
    //public static String myURL;

    /**
     * Within the Main class is the main method. This method asks the user to enter a URL into the console.
     * After the URL is provided, it is passed to the Analyzer class.
     * @param args - This parameter allows the class to accept user provided information to the program without hard coding the value.
     * @throws Exception - This statement was added to avoid errors when providing information to the Analyzer class.
     */
    public static void main(String[] args) throws Exception {
        launch(args);


        //Disable scanner functionality in place of getURL() method
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the URL to scan: ");
        myURL = scanner.nextLine();
        Analyzer.urlAnalyzer(myURL);
        */

    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
        primaryStage.setTitle("Word Occurrences");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}