import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class BMIController {
	
	private BMIModel bmi = new BMIModel();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button calculateBMIButton;

    @FXML
    private TextArea resultTextarea;

    @FXML
    private TextField weightInKgTextfield;

    @FXML
    private TextField sizeInCmTextfield;

    @FXML
    private ComboBox<String> sexSelection;

    @FXML
    private Slider ageSlider;
    
    @FXML
    private TextField ageInputTextfield;

    @FXML
    private Label sexInputLabel;

    @FXML
    private Label weightInKgInputLabel;

    @FXML
    private Label sizeInCmInputLabel;

    @FXML
    void calculateBMI(ActionEvent event) { 
    	double weightInKg = Double.parseDouble(weightInKgTextfield.getText());
    	double sizeInCm = Double.parseDouble(sizeInCmTextfield.getText());
    	int age = (int)ageSlider.getValue();
    	boolean isFemale = (sexSelection.getSelectionModel().getSelectedItem() == "Female");
    	bmi.calculateBMI(weightInKg, sizeInCm, age, isFemale);
    	
    	String result = bmi.getBMIFullResult();
    	resultTextarea.setText(result);
    }

    @FXML
    void initialize() {
        assert calculateBMIButton != null : "fx:id=\"calculateBMIButton\" was not injected: check your FXML file 'BMIView.fxml'.";
        assert resultTextarea != null : "fx:id=\"resultTextarea\" was not injected: check your FXML file 'BMIView.fxml'.";
        assert weightInKgTextfield != null : "fx:id=\"weightInKgTextfield\" was not injected: check your FXML file 'BMIView.fxml'.";
        assert sizeInCmTextfield != null : "fx:id=\"sizeInCmTextfield\" was not injected: check your FXML file 'BMIView.fxml'.";
        assert sexSelection != null : "fx:id=\"sexSelection\" was not injected: check your FXML file 'BMIView.fxml'.";
        assert ageSlider != null : "fx:id=\"ageSlider\" was not injected: check your FXML file 'BMIView.fxml'.";
        assert ageInputTextfield != null : "fx:id=\"ageInputTextfield\" was not injected: check your FXML file 'BMIView.fxml'.";
        assert sexInputLabel != null : "fx:id=\"sexInputLabel\" was not injected: check your FXML file 'BMIView.fxml'.";
        assert weightInKgInputLabel != null : "fx:id=\"weightInKgInputLabel\" was not injected: check your FXML file 'BMIView.fxml'.";
        assert sizeInCmInputLabel != null : "fx:id=\"sizeInCmInputLabel\" was not injected: check your FXML file 'BMIView.fxml'.";

        fillSexEntries();
        connectFields();
    }

	private void connectFields() {
		StringConverter<Number> converter = new NumberStringConverter();
		Bindings.bindBidirectional(ageInputTextfield.textProperty(), ageSlider.valueProperty(), converter);

		sexInputLabel.textProperty().bind(sexSelection.valueProperty());
		weightInKgInputLabel.textProperty().bind(weightInKgTextfield.textProperty());
		sizeInCmInputLabel.textProperty().bind(sizeInCmTextfield.textProperty());
		
		weightInKgTextfield.setTextFormatter(new TextFormatter<>(change -> (change.getControlNewText().matches("([1-9][0-9]*)?")) ? change : null));
		sizeInCmTextfield.setTextFormatter(new TextFormatter<>(change -> (change.getControlNewText().matches("([1-9][0-9]*)?")) ? change : null));
		
	}

	private void fillSexEntries() {
		sexSelection.getItems().addAll("Male","Female");
		sexSelection.getSelectionModel().selectFirst();		
	}
}
