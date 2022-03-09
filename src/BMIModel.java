
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BMIModel {

	public final static String RATING_UNDERWEIGHT = "underweight";
	public final static String RATING_NORMALWEIGHT = "normal weight";
	public final static String RATING_OVERWEIGHT = "overweight";
	public final static String RATING_OBESITY = "obesity";
	public final static String RATING_MASSIVEOBESITY = "massive obesity";
	public final static String RATING_UNDEFINED = "<undefined>";

	private final IntegerProperty weightInKgProperty = new SimpleIntegerProperty();
	private final IntegerProperty sizeInCmProperty = new SimpleIntegerProperty();
	private final IntegerProperty ageProperty = new SimpleIntegerProperty();
	private final BooleanProperty isFemaleProperty = new SimpleBooleanProperty();
	private final DoubleProperty bmiProperty = new SimpleDoubleProperty();
	private final StringProperty bmiFullResultProperty = new SimpleStringProperty();

	public BMIModel() {
		// bmiProperty.bind(weightInKgProperty.divide(sizeInCmProperty.multiply(sizeInCmProperty).divide(10000)));

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
		double result = 0;
		System.out.println(sizeInCmProperty.get());
		System.out.println(weightInKgProperty.get());
		double quotient = sizeInCmProperty.get() * sizeInCmProperty.get() / 10000;
		if (quotient > 0) {
			result = weightInKgProperty.get() / quotient;
		}
		bmiProperty.set(result);

		bmiFullResultProperty.set(getBMIFullResult());
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

	private String getBMIFullResult() {
		String personType = this.isFemaleProperty.get() ? "woman" : " man";
		return "You are a " + personType + " in the age of " + Integer.toString(ageProperty.get()) + ".\n"
				+ "You have a BMI of " + this.getBMI() + "\n" + getIsBMIRecommended() + "\n"
				+ "BMI Classification (after 'DGE, Ernährungsbericht 1992'): "
				+ getBMIClassification(this.isFemaleProperty.get(), this.getBMI());
	}

	private String getIsBMIRecommended() {
		Boolean isRecommended = getIsBMIRecommended(this.ageProperty.get(), this.getBMI());
		if (isRecommended == null) {
			return "There is no recommandation for the given data (BMI and age) ";
		}
		if (isRecommended.booleanValue()) {
			return "This BMI is perfect for the given age!";
		} else {
			return "The calculated BMI is unsuitable for the given age";
		}
	}

	public static Boolean getIsBMIRecommended(int age, double bmi) {
		int bmiAsInt = (int) bmi;
		if ((age >= 19) && (age <= 25)) {
			return ((bmiAsInt >= 19) && (bmiAsInt <= 24));
		}
		if ((age >= 25) && (age <= 34)) {
			return ((bmiAsInt >= 20) && (bmiAsInt <= 25));
		}
		if ((age >= 35) && (age <= 44)) {
			return ((bmiAsInt >= 21) && (bmiAsInt <= 26));
		}
		if ((age >= 45) && (age <= 54)) {
			return ((bmiAsInt >= 22) && (bmiAsInt <= 27));
		}
		if ((age >= 55) && (age <= 64)) {
			return ((bmiAsInt >= 23) && (bmiAsInt <= 28));
		}
		if (age > 64) {
			return ((bmiAsInt >= 24) && (bmiAsInt <= 29));
		}
		return null;
	}

	public static String getBMIClassification(boolean isFemale, double bmi) {
		if (isFemale) {
			if (bmi < 19) {
				return RATING_UNDERWEIGHT;
			}
			if ((bmi >= 19) && (bmi <= 24)) {
				return RATING_NORMALWEIGHT;
			}
			if ((bmi >= 24) && (bmi <= 30)) {
				return RATING_OVERWEIGHT;
			}
		} else {
			if (bmi < 20) {
				return RATING_UNDERWEIGHT;
			}
			if ((bmi >= 20) && (bmi <= 25)) {
				return RATING_NORMALWEIGHT;
			}
			if ((bmi >= 25) && (bmi <= 30)) {
				return RATING_OVERWEIGHT;
			}
		}

		if ((bmi >= 30) && (bmi <= 40)) {
			return RATING_OBESITY;
		}
		if (bmi > 40) {
			return RATING_MASSIVEOBESITY;
		}
		return RATING_UNDEFINED;
	}

}
