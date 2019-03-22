package model;

public class Drug {

	private String name;
	private double dose;
	private double frequency;
	
	public Drug(String n, double d, double f) {
		name = n;
		dose = d;
		frequency = f;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDose() {
		return dose;
	}

	public void setDose(double dose) {
		this.dose = dose;
	}

	public double getFrequency() {
		return frequency;
	}

	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}

}
