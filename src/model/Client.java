package model;
import java.util.ArrayList;

public class Client {

	public final static char ACTIVE = 'A';
	public final static char INACTIVE = 'I';
	
	private String name;
	private int id;
	private String dir;
	private int phone;
	private char state;
	private ArrayList <Pet> arrayPet;
	
	public Client(String n, int i, String d, int p, char s) {
		name = n;
		id = i;
		dir = d;
		phone = p;
		state = s;
		arrayPet = new ArrayList<Pet>();
	}

	public char getStateC() {
		return state;
	}
	
	public void setStateC(char state) {
		this.state = state;
	}
	
	public String getNameC() {
		return name;
	}

	public void setNameC(String name) {
		this.name = name;
	}

	public int getIDC() {
		return id;
	}

	public void setIDC(int id) {
		this.id = id;
	}

	public String getDirC() {
		return dir;
	}

	public void setDirC(String dir) {
		this.dir = dir;
	}

	public int getPhoneC() {
		return phone;
	}

	public void setPhoneC(int phone) {
		this.phone = phone;
	}
	
	public String addPetC(String n, double a, double w, char t) {
		Pet newPet = new Pet(n, a, w, t);
		arrayPet.add(newPet);
		String msg = "Pet added";
		return msg;
	}

	public String reportClient() {
		String msg = getNameC() + ", id: " + getIDC() + ", phone: " + getPhoneC() + ", direction: " + getDirC();
		return msg;
	}

	public char getState() {
		return state;
	}

	public void setState(char state) {
		this.state = state;
	}

}
