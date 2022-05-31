
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class BMIController {

	private final String SEX_FEMALE = "Female";
	private final String SEX_MALE = "Male";

	private BMIModel bmi = new BMIModel();
	private BMIGraphController graphController;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private VBox baseVBox;

	@FXML
	private GridPane baseGridPane;

	@FXML
	private TextArea resultTextarea;

	@FXML
	private Slider weightSlider;

	@FXML
	private TextField weightInKgTextfield;

	@FXML
	private Slider sizeSlider;

	@FXML
	private TextField sizeInCmTextfield;

	@FXML
	private ComboBox<String> sexSelection;

	@FXML
	private Slider ageSlider;

	@FXML
	private TextField ageInputTextfield;

	@FXML
	private Button showGraphButton;

	@FXML
	void initialize() {
		assert baseVBox != null : "fx:id=\"baseVBox\" was not injected: check your FXML file 'BMIView.fxml'.";
		assert baseGridPane != null : "fx:id=\"baseGridPane\" was not injected: check your FXML file 'BMIView.fxml'.";
		assert weightSlider != null : "fx:id=\"weightSlider\" was not injected: check your FXML file 'BMIView.fxml'.";
		assert weightInKgTextfield != null
				: "fx:id=\"weightInKgTextfield\" was not injected: check your FXML file 'BMIView.fxml'.";
		assert sizeSlider != null : "fx:id=\"sizeSlider\" was not injected: check your FXML file 'BMIView.fxml'.";
		assert sizeInCmTextfield != null
				: "fx:id=\"sizeInCmTextfield\" was not injected: check your FXML file 'BMIView.fxml'.";
		assert sexSelection != null : "fx:id=\"sexSelection\" was not injected: check your FXML file 'BMIView.fxml'.";
		assert ageSlider != null : "fx:id=\"ageSlider\" was not injected: check your FXML file 'BMIView.fxml'.";
		assert ageInputTextfield != null
				: "fx:id=\"ageInputTextfield\" was not injected: check your FXML file 'BMIView.fxml'.";
		assert showGraphButton != null
				: "fx:id=\"showGraphButton\" was not injected: check your FXML file 'BMIView.fxml'.";
		assert resultTextarea != null
				: "fx:id=\"resultTextarea\" was not injected: check your FXML file 'BMIView.fxml'.";

		fillSelectableEntries();
		connectFields();

	}

	@FXML
	void onShowGraph(ActionEvent event) {
		System.out.println("Show Subwindow");

		try {
			showGraphView();
		} catch (IOException e) {
			e.printStackTrace(); // If there is an error, we don't show this window. It doesn't matter
		}
	}

	private void connectFields() {
		static final String regexpression = "([1-9][0-9]*.*)?";
		/* Validation of input data */
		weightInKgTextfield.setTextFormatter(
				new TextFormatter<>(change -> (change.getControlNewText().matches(regexpression)) ? change : null));
		sizeInCmTextfield.setTextFormatter(
				new TextFormatter<>(change -> (change.getControlNewText().matches(regexpression)) ? change : null));
		ageInputTextfield.setTextFormatter(
				new TextFormatter<>(change -> (change.getControlNewText().matches(regexpression)) ? change : null));

		StringConverter<Number> numberStringConverter = new NumberStringConverter();

		/* Bindings inside View */
		Bindings.bindBidirectional(weightInKgTextfield.textProperty(), weightSlider.valueProperty(),
				numberStringConverter);
		Bindings.bindBidirectional(sizeInCmTextfield.textProperty(), sizeSlider.valueProperty(), numberStringConverter);
		Bindings.bindBidirectional(ageInputTextfield.textProperty(), ageSlider.valueProperty(), numberStringConverter);

		/* Bindings from View to Model */
		bmi.getWeightInKgProperty().bind(weightSlider.valueProperty());
		bmi.getSizeInCmProperty().bind(sizeSlider.valueProperty());
		bmi.getAgeProperty().bind(ageSlider.valueProperty());
		sexSelection.getSelectionModel().selectedItemProperty().addListener((obs, ov, nv) -> {
			bmi.getIsFemaleProperty().set(nv == SEX_FEMALE);
		});
		bmi.getFullResultProperty().addListener((obs, ov, nv) -> {
			resultTextarea.setText(bmi.getFullResultProperty().get());
		});

	}

	private void fillSelectableEntries() {
		sexSelection.getItems().addAll(SEX_MALE, SEX_FEMALE);
		sexSelection.getSelectionModel().selectFirst();
	}

	private void showGraphView() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("BMIGraphView.fxml"));
		Parent root = loader.load();
		graphController = (BMIGraphController) loader.getController();
		graphController.setModel(bmi);

		if (false) {
			this.baseVBox.getChildren().add(root);
		} else {
			Stage stage = new Stage();
			stage.initModality(Modality.NONE);
			stage.initOwner(baseGridPane.getScene().getWindow());
			Scene scene = new Scene(root);
			stage.setScene(scene);
			scene.getStylesheets().add(getClass().getResource("BMISettings.css").toExternalForm());

			stage.show();
		}
	}

}
