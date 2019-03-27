package model;

public class Drug { 

	//atributes
	private String name;
	private double dose;
	private double doseCost;
	private double frequency;
	
	//methods
	public Drug(String n, double d, double f, double dc) {//builder method
		name = n;
		dose = d;
		frequency = f;
		doseCost = dc;
	}

	public String getNameD() {
		return name;
	}

	public void setNameD(String name) {
		this.name = name;
	}

	public double getDose() { //gets the quantity of dose
		return dose;
	}

	public void setDose(double dose) {
		this.dose = dose;
	}

	public double getDoseCost() {//gets the cost of the dose
		return doseCost;
	}
	
	public void setDoseCost(double doseCost) {
		this.doseCost = doseCost;
	}
	
	public double getFrequency() {
		return frequency;
	}

	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}

	public double drugCost() { //calculates the cost of the drug
		double d = getDoseCost() * getFrequency();
		return d;
	}
}
