package model;

/**
 * 
 * Class Drug
 * @author Alejandra Diaz
 *
 */

public class Drug { 

	private String name;
	private double dose;
	private double doseCost;
	private double frequency;
	
	/**
	 * Drug constructor
	 * Creates an object drug
	 * <b>post:</b> an object drug is created
	 * @param n name 
	 * @param d dose
	 * @param f frequency
	 * @param dc cost of the dose
	 */
	
	public Drug(String n, double d, double f, double dc) {//builder method
		name = n;
		dose = d;
		frequency = f;
		doseCost = dc;
	}

	/**
	 * getNameD
	 * getNameD no-argument method returns name of the drug
	 * @return name
	 */
	
	public String getNameD() {
		return name;
	}

	public void setNameD(String name) {
		this.name = name;
	}

	/**
	 * getDose
	 * getDose no-argument method returns dose of the drug
	 * @return dose
	 */
	
	public double getDose() { //gets the quantity of dose
		return dose;
	}

	public void setDose(double dose) {
		this.dose = dose;
	}
	
	/**
	 * getDoseCost
	 * getDoseCost no-argument method returns cost of the dose of the drug
	 * @return doseCost
	 */

	public double getDoseCost() {
		return doseCost;
	}
	
	/**
	 * setDoseCost
	 * changes the cost of the dose of the drug for the one entered by parameters
	 */
	
	public void setDoseCost(double doseCost) {
		this.doseCost = doseCost;
	}
	
	/**
	 * getFrequency
	 * getFrequency no-argument method returns frequency of the drug
	 * @return frequency
	 */
	
	public double getFrequency() {
		return frequency;
	}

	/**
	 * setFrequency
	 * changes the frequency of the drug for the one entered by parameters
	 */
	
	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}
	
	/**
	 * drugCost
	 * Calculates the cost of the drug
	 * @return cost of the drug
	 */

	public double drugCost() { //calculates the cost of the drug
		double d = getDoseCost() * getFrequency();
		return d;
	}
}
