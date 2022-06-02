public class Service {

    public final static String RATING_UNDERWEIGHT = "underweight";
    public final static String RATING_NORMALWEIGHT = "normal weight";
    public final static String RATING_OVERWEIGHT = "overweight";
    public final static String RATING_OBESITY = "obesity";
    public final static String RATING_MASSIVEOBESITY = "massive obesity";
    public final static String RATING_UNDEFINED = "<undefined>";

    public double getBMI(double size, double weight) {
        double result = 0;
        double quotient = size * size / 10000;
        if (quotient > 0) {
            result = weight / quotient;
        }
        return result;
    }

    public String getBMIResult(double size, double weight, int age, boolean isFemale) {
        String personType = isFemale ? "woman" : " man";
        double bmiValue = this.getBMI(size, weight);
        return "You are a " + personType + " in the age of " + Integer.toString(age) + ".\n"
                + "You have a BMI of " + bmiValue + "\n" + getIsBMIRecommendedString(age, bmiValue) + "\n"
                + "BMI Classification (after 'DGE, Ernährungsbericht 1992'): "
                + getBMIClassification(isFemale, bmiValue);
    }

    private String getIsBMIRecommendedString(int age, double bmi) {
        Boolean isRecommended = getIsBMIRecommended(age, bmi);
        if (isRecommended == null) {
            return "There is no recommendation for the given data (BMI and age) ";
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
