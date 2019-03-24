package model;

public class Drug {

	private String name;
	private double dose;
	private double doseCost;
	private double frequency;
	
	public Drug(String n, double d, double f, double dc) {
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

	public double getDose() {
		return dose;
	}

	public void setDose(double dose) {
		this.dose = dose;
	}

	public double getDoseCost() {
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

	public double drugCost() {
		double d = getDoseCost() * getFrequency();
		return d;
	}
}
