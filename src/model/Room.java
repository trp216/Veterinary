package model;

public class Room {
	
	private int number;
	private Pet petx;

	public Room(int n, Pet p) {
		number = n;
		petx = p;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Pet getPetX() {
		return petx;
	}
	
	public void setPetX(Pet petx) {
		this.petx = petx;
	}
	
	public boolean stateR() {
		boolean x = false;
		if(getPetX() == null)
			x = true;
		return x;
	}
}
