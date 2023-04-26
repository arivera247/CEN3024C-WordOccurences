package CEN3024C.WordOccurrences;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class Controller {
    @FXML
    private Label wordOccurrence;

    @FXML
    private TextArea urlTextArea;

    @FXML
    private TextArea consoleTextArea;

    public String getURL() {

        return urlTextArea.getText();
    }

    public void updateConsole(String message){

        consoleTextArea.appendText(message + "\n");
    }

    @FXML
    protected void onMainButtonClick() {
        String url = getURL();
        try{
            Analyzer.urlAnalyzer(url, this);
        }
        catch(Exception e){
            System.out.println("Error: " + e);
        }


        //wordOccurrence.setText("Test");
        //FIXME - add values to import console results from wordOccurrences class.
    }
}