package model;
import java.util.ArrayList;

/**
 * class Client
 * @author Alejandra Diaz
 *
 */

public class Client {

	public final static char ACTIVE = 'A';
	public final static char INACTIVE = 'I';
	
	private String name;
	private int id;
	private String dir;
	private int phone;
	private char state;
	private ArrayList <Pet> arrayPet;
	
	/**
	 * 
	 * @param n : name
	 * @param i : identification
	 * @param d : direction
	 * @param p : phone number
	 * state of the client is setted to active
	 * arrayPet : arraylist of pets is initialized
	 */
	
	public Client(String n, int i, String d, int p) {
		name = n;
		id = i;
		dir = d;
		phone = p;
		state = ACTIVE;
		arrayPet = new ArrayList<Pet>();
	}

	/**
	 * getStateC
	 * getStateC no-argument method returns attribute state
	 * @return state
	 */
	
	public char getStateC() {
		return state;
	}
	
	/**
	 * setStateC
	 * changes the state for the new one entered by parameters
	 * @param state :  new state
	 */
	
	public void setStateC(char state) {
		this.state = state;
	}
	
	/**
	 * getNameC
	 * getNameC no-argument method returns attribute name
	 * @return name
	 */
	
	public String getNameC() {
		return name;
	}
	
	/**
	 * setNameC
	 * changes the name for the new one entered by parameters
	 * @param name :  new name
	 */

	public void setNameC(String name) {
		this.name = name;
	}
	
	/**
	 * getIDC
	 * getIDC no-argument method returns attribute id
	 * @return id
	 */

	public int getIDC() {
		return id;
	}
	
	/**
	 * setIDC
	 * changes the identification for the new one entered by parameters
	 * @param id :  new id
	 */

	public void setIDC(int id) {
		this.id = id;
	}
	
	/**
	 * getDirC
	 * getDirC no-argument method returns attribute dir
	 * @return dir
	 */

	public String getDirC() {
		return dir;
	}
	
	/**
	 * setDirection
	 * changes the direction for the new one entered by parameters
	 * @param dir :  new direction
	 */

	public void setDirC(String dir) {
		this.dir = dir;
	}
	
	/**
	 * getPhoneC
	 * getPhoneC no-argument method returns attribute phone
	 * @return phone
	 */

	public int getPhoneC() {
		return phone;
	}
	
	/**
	 * setPhoneC
	 * changes the phone number for the new one entered by parameters
	 * @param phone :  new phone number
	 */

	public void setPhoneC(int phone) {
		this.phone = phone;
	}
	
	public void addPetC(String n, double a, double w, char t, double h) {
		Pet newPet = new Pet(n, a, w, t, h);
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
	
	/**
	 * getArrayPet
	 * getArrayPet no-argument method returns arraylist of pets
	 * @return arrayPet
	 */

	public ArrayList<Pet> getArrayPet() {
		return arrayPet;
	}
	
	/**
	 * reportClient
	 * Method that shows a message with all the information about the client
	 * @return message
	 */

	public String reportClient() {
		String msg = getNameC() + ", id: " + getIDC() + ", phone: " + getPhoneC() + ", direction: " + getDirC() + ", state: " + getStateC();
		return msg;
	}
	
	/**
	 * searchPetC
	 * Checks the information about the pet
	 * <b>pre:</b>Arraylist of pets must exist.
	 * @param n : name of the pet
	 * @return message with all the information of the pet
	 */
	
	public String searchPetC(String n) {
		String msg = "Couldn't find the pet";
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
