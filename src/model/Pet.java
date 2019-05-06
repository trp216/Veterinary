package model;

/**
 * Class Pet
 * @author Alejandra Diaz
 *
 */

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
	 * <b>post: </b> an object pet is created.
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

	/**
	 * getHeight
	 * getHeight no-argument method returns height of the pet
	 * @return height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * setHeight
	 * changes the height of the pet for the new one entered by parameters
	 * @param height : new height
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	public ClinicHistory getClinicHistoryPet() {
		return clinicHistoryPet;
	}
	
	public void setClinicHistoryPet(ClinicHistory clinicHistoryPet) {
		this.clinicHistoryPet = clinicHistoryPet;
	}
	
	/**
	 * getNameP
	 * getNameP no-argument method returns name of the pet
	 * @return name
	 */
	public String getNameP() {
		return name;
	}

	/**
	 * setNameP
	 * changes the name of the pet for the new one entered by parameters
	 * @param name : new name
	 */
	public void setNameP(String name) {
		this.name = name;
	}

	/**
	 * getTypeP
	 * getTypeP no-argument method returns type of the pet
	 * @return type
	 */
	public char getTypeP() {
		return type;
	}

	/**
	 * setTypeP
	 * changes the type of the pet for the new one entered by parameters
	 * @param type : new type
	 */
	public void setTypeP(char type) {
		this.type = type;
	}

	/**
	 * getAgeP
	 * getAgeP no-argument method returns age of the pet
	 * @return age
	 */
	public double getAgeP() {
		return age;
	}

	/**
	 * setAgeP
	 * changes the age of the pet for the new one entered by parameters
	 * @param age : new age
	 */
	public void setAgeP(double age) {
		this.age = age;
	}

	/**
	 * getWeightP
	 * getWeightP no-argument method returns weight of the pet
	 * @return weight
	 */
	public double getWeightP() {
		return weight;
	}

	/**
	 * setWeightP
	 * changes the weight of the pet for the new one entered by parameters
	 * @param weight : new weight
	 */
	public void setWeightP(double weight) {
		this.weight = weight;
	}
	
	/**
	*Description This method allows to calculate the body mass index for a pet.
	*<b>post: </b> The BMI is calculated.
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
		String msg = "Name: " + getNameP() + ", type: " + getTypeP() + ", weight: " + getWeightP() + ", height: " + getHeight() + ", age " + getAgeP();
		return msg;
	}

}
