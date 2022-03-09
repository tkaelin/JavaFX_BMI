import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;

public class BMIGraphController {

	private BMIModel bmiModel;

	public void setModel(BMIModel model) {
		bmiModel = model;
		bmiModel.getFullResultProperty().addListener((observable, oldValue, newValue) -> {
			setChanged();
		});
	}

	private void setChanged() {
		final PhongMaterial theMaterial = new PhongMaterial();
		Boolean isRecommended = BMIModel.getIsBMIRecommended(bmiModel.getAgeProperty().get(), bmiModel.getBMI());
		if (isRecommended == null) {
			theMaterial.setDiffuseColor(Color.YELLOW);
		} else if (isRecommended) {
			theMaterial.setDiffuseColor(Color.GREEN);
		} else {
			theMaterial.setDiffuseColor(Color.ORANGE);
		}

		sphere.setRadius(bmiModel.getBMI());
		sphere.setMaterial(theMaterial);

		cylinder.setHeight(bmiModel.getSizeInCmProperty().get());
		cylinder.setRadius(bmiModel.getWeightInKgProperty().get());
		cylinder.setMaterial(theMaterial);
	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Sphere sphere;

	@FXML
	private Cylinder cylinder;

	@FXML
	void initialize() {
		assert sphere != null : "fx:id=\"sphere\" was not injected: check your FXML file 'BMIGraphView.fxml'.";
		assert cylinder != null : "fx:id=\"cylinder\" was not injected: check your FXML file 'BMIGraphView.fxml'.";

	}

}
