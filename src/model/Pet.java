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
	
	private ClinicHistory clinicHistoryPet;
	
	public Pet(String n, double a, double w, char t) {
		name = n;
		age = a;
		weight = w;
		type = t;
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
	
	
	public String reportPet() { //report method for Pet
		String msg = getNameP() + ", type: " + getTypeP() + ", weight: " + getWeightP() + ", age " + getAgeP();
		return msg;
	}

}
