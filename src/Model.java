import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model {

	private final Service bmiService;

	private final IntegerProperty weightInKgProperty = new SimpleIntegerProperty();
	private final IntegerProperty sizeInCmProperty = new SimpleIntegerProperty();
	private final IntegerProperty ageProperty = new SimpleIntegerProperty();
	private final BooleanProperty isFemaleProperty = new SimpleBooleanProperty();
	private final DoubleProperty bmiProperty = new SimpleDoubleProperty();
	private final StringProperty bmiFullResultProperty = new SimpleStringProperty();

	public Model() {
		bmiService = new Service();

		sizeInCmProperty.addListener((observable, oldValue, newValue) -> {
			setChanged();
		});
		weightInKgProperty.addListener((observable, oldValue, newValue) -> {
			setChanged();
		});
		bmiProperty.addListener((observable, oldValue, newValue) -> {
			setChanged();
		});

		ageProperty.addListener((observable, oldValue, newValue) -> {
			setChanged();
		});
		isFemaleProperty.addListener((observable, oldValue, newValue) -> {
			setChanged();
		});
		bmiProperty.addListener((obs, ov, nv) -> setChanged());
	}

	private void setChanged() {
		System.out.println(sizeInCmProperty.get());
		System.out.println(weightInKgProperty.get());
		bmiProperty.set(bmiService.getBMI(sizeInCmProperty.get(), weightInKgProperty.get()));

		bmiFullResultProperty.set(bmiService.getBMIResult(sizeInCmProperty.get(), weightInKgProperty.get(),
				ageProperty.get(), this.isFemaleProperty.get()));
	}

	public IntegerProperty getWeightInKgProperty() {
		return weightInKgProperty;
	}

	public IntegerProperty getSizeInCmProperty() {
		return sizeInCmProperty;
	}

	public IntegerProperty getAgeProperty() {
		return ageProperty;
	}

	public BooleanProperty getIsFemaleProperty() {
		return isFemaleProperty;
	}

	public DoubleProperty getBMIProperty() {
		return bmiProperty;
	}

	public StringProperty getFullResultProperty() {
		return bmiFullResultProperty;
	}

	public double getBMI() {
		return this.bmiProperty.get();
	}

}
