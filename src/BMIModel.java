public class BMIModel  {
	
	private double weightInKg;
	private double sizeInCm;
	private int age;
	private boolean isFemale;
	private double bmi;
	
	public void calculateBMI(double weightInKg, double sizeInCm, int age, boolean isFemale)
	{
		this.weightInKg = weightInKg;
		this.sizeInCm = sizeInCm;
		this.age = age;
		this.isFemale = isFemale;

		this.bmi = this.weightInKg / (this.sizeInCm * this.sizeInCm / 10000); // cm umgerechnet in m
	}
	
	public double getBMI()
	{
		return this.bmi;
	}
	
	public String getBMIFullResult()
	{
		return "Sie haben einen BMI von " + this.bmi + "\n" +
	           getIsBMIRecommended() + "\n" +
		       "BMI-Klassifikation (nach DGE, Ernährungsbericht 1992): " + getBMIClassification(this.bmi);
	}

	private String getIsBMIRecommended()
	{
		Boolean isRecommended = getIsBMIRecommended(this.bmi, this.age);
		if (isRecommended == null) { return "Für diesen BMI/Alter ist kein Wunschbereich festgelegt";}
		if (isRecommended.booleanValue())
		{
			return "Dieser BMI ist optimal für das angegebene Alter!";
		} else {
			return "Dieser BMI ist nicht optimal für das angegebene Alter";
		}
	}
	
	private Boolean getIsBMIRecommended(double bmi, int age)
	{
		int bmiAsInt = (int)this.bmi;
		if ((age >= 19) && (age <= 25)) { return ((bmiAsInt >= 19) && (bmiAsInt <=24));}
		if ((age >= 25) && (age <= 34)) { return ((bmiAsInt >= 20) && (bmiAsInt <=25));}
		if ((age >= 35) && (age <= 44)) { return ((bmiAsInt >= 21) && (bmiAsInt <=26));}
		if ((age >= 45) && (age <= 54)) { return ((bmiAsInt >= 22) && (bmiAsInt <=27));}
		if ((age >= 55) && (age <= 64)) { return ((bmiAsInt >= 23) && (bmiAsInt <=28));}
		if (age > 64)                   { return ((bmiAsInt >= 24) && (bmiAsInt <=29));}
		return null;
	}

	private String getBMIClassification(double bmi)
	{
		if (this.isFemale)
		{
			if (bmi < 19) { return "Untergewicht";}
			if ((bmi >=19) && (bmi <=24)) {return "Normalgewicht"; }
			if ((bmi >=24) && (bmi <=30)) {return "Übergewicht"; }
		} else {
			if (bmi < 20) { return "Untergewicht";}
			if ((bmi >=20) && (bmi <=25)) {return "Normalgewicht"; }
			if ((bmi >=25) && (bmi <=30)) {return "Übergewicht"; }
		}
		
		if ((bmi >=30) && (bmi <=40)) {return "Adipositas"; }
		if (bmi > 40) { return "massive Adipositas";}
		return "<nicht definiert>";
	}
	
}

