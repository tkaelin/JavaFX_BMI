import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class BMIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField SizeInCm;

    @FXML
    private TextField WeightInKG;

    @FXML
    private Button CalcBMI;

    @FXML
    private TextArea Output;

    @FXML
    void initialize() {
        assert SizeInCm != null : "fx:id=\"SizeInCm\" was not injected: check your FXML file 'BMI.fxml'.";
        assert WeightInKG != null : "fx:id=\"WeightInKG\" was not injected: check your FXML file 'BMI.fxml'.";
        assert CalcBMI != null : "fx:id=\"CalcBMI\" was not injected: check your FXML file 'BMI.fxml'.";
        assert Output != null : "fx:id=\"Output\" was not injected: check your FXML file 'BMI.fxml'.";

        CalcBMI.setOnAction(e -> CalcTheBMI());
               
        
    }
    
    private void CalcTheBMI()
    {
    	int size = Integer.parseInt( SizeInCm.getText());
    	int weight = Integer.parseInt(WeightInKG.getText());
    	double BMI = size * weight;
    	
    	Output.setText(String.valueOf(BMI));
    }
    
}