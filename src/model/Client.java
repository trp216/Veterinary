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
	
	public Client(String n, int i, String d, int p) {
		name = n;
		id = i;
		dir = d;
		phone = p;
		state = ACTIVE;
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
	
	public void addPetC(String n, double a, double w, char t) {
		Pet newPet = new Pet(n, a, w, t);
		arrayPet.add(newPet);
	}
	
	public void erasePetC(String n) {
		boolean u = false;
		for(int i = 0; i<arrayPet.size() || !u; i++) {
			if(arrayPet.get(i).getNameP().equalsIgnoreCase(n)) {
				arrayPet.remove(i);
				u = true;
			}
		}
	}

	public ArrayList<Pet> getArrayPet() {
		return arrayPet;
	}

	public void setArrayPet(ArrayList<Pet> arrayPet) {
		this.arrayPet = arrayPet;
	}

	public String reportClient() {
		String msg = getNameC() + ", id: " + getIDC() + ", phone: " + getPhoneC() + ", direction: " + getDirC() + ", state: " + getStateC();
		return msg;
	}
	
	public String searchPetC(String n) {
		String msg = "";
		boolean y = false;
		for(int i = 0; i<arrayPet.size() && !y; i++) {
		if(arrayPet.get(i).getNameP().equalsIgnoreCase(n)) {
			msg = arrayPet.get(i).reportPet();
			y = true;
		}
		}
		return msg;
	}
	
	public boolean trueName(String n) { 
		boolean v = false;
		for(int i = 0; i<arrayPet.size(); i++) {
			if(arrayPet.get(i).getNameP().equalsIgnoreCase(n))
				v = true;
		}
		return v;
	}
	
	public Pet getPet(String n) {//method that evaluates if a pet with the given name exists in the array of pet's of this client.
		Pet x = null;
		for(int i = 0; i<arrayPet.size(); i++) {
			Pet aux = (Pet)arrayPet.get(i);
			if(aux.getNameP().equalsIgnoreCase(n))
				x = aux;
		}
	return x;
	}
}
