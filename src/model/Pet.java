package model;

public class Pet {
	
	public final static char DOG = 'D';
	public final static char CAT = 'C';
	public final static char BIRD = 'B';
	public final static char OTHER = 'O';

	private String name;
	private char type;
	private double age;
	private double weight;
	private double height;
	
	private ClinicHistory clinicHistoryPet;
	
	/**
	 * Pet
	 * Pet constructor
	 * @param n : name of the pet
	 * @param a : age of the pet
	 * @param w : weight of the pet
	 * @param t : pet type
	 * @param h : pet height
	 */
	
	public Pet(String n, double a, double w, char t, double h) {
		name = n;
		age = a;
		weight = w;
		type = t;
		height = h;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public ClinicHistory getClinicHistoryPet() {
		return clinicHistoryPet;
	}
	
	public void setClinicHistoryPet(ClinicHistory clinicHistoryPet) {
		this.clinicHistoryPet = clinicHistoryPet;
	}
	
	public String getNameP() {
		return name;
	}

	public void setNameP(String name) {
		this.name = name;
	}

	public char getTypeP() {
		return type;
	}

	public void setTypeP(char type) {
		this.type = type;
	}

	public double getAgeP() {
		return age;
	}

	public void setAgeP(double age) {
		this.age = age;
	}

	public double getWeightP() {
		return weight;
	}

	public void setWeightP(double weight) {
		this.weight = weight;
	}
	
	/**
	*Description This method allows to calculate the body mass index for a pet.
	*post: The BMI is calculated.
	*@return The pet body mass index.
	*/
	
	public double bodyMassIndex() {
		double i = getWeightP()/(getHeight()*getHeight());
		return i;
	}
	
	/**
	 * reportPet
	 * Method that shows a message with all the information about the pet
	 * @return message
	 */
	
	public String reportPet() { //report method for Pet
		String msg = getNameP() + ", type: " + getTypeP() + ", weight: " + getWeightP() + ", height: " + getHeight() + ", age " + getAgeP();
		return msg;
	}

}
