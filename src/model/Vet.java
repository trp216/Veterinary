package model;
import java.util.ArrayList;

public class Vet {

	private String name;
	private Room[] arrayRoom;
	private ArrayList <ClinicHistory> arrayClinicHistories;
	private ArrayList <Client> arrayClient;
	
	public Vet(String n) {
		name = n;
		Pet randomPet = new Pet("Pet", 5, 15.5, 'C', 25);
		arrayRoom = new Room [8];
		Room randomRoom = new Room(2, randomPet);
		arrayRoom[2] = randomRoom;
		arrayClinicHistories = new ArrayList <ClinicHistory>();
		arrayClient = new ArrayList <Client>();
		Client randomClient = new Client("Client", 567, "Random direction", 238642);
		arrayClient.add(randomClient);
		randomClient.getArrayPet().add(randomPet);
		Date randomDate = new Date(19, 3, 2018);
		Detail randomDetail = new Detail("Random symptoms", "Random diagnosis", randomDate);
		ClinicHistory randomCH = new ClinicHistory(randomPet, randomClient, randomDetail);
		arrayClinicHistories.add(randomCH);
	}

	public String getNameV() {
		return name;
	}

	public void setNamev(String name) {
		this.name = name;
	}
	
	/**
	 * addPetV
	 * Adds a pet
	 * <b>pre:</b> arrayClient must exist. np2 and w2 must be higher than 0.
	 * @param np2 : name of the new pet
	 * @param a2 : age of the new pet
	 * @param w2 : weight of the new pet
	 * @param t2 : type of the new pet
	 * @param h2 : height of the new pet
	 * @param nc : name of the owner of the pet
	 * @param id2 : identification of the owner of the pet
	 * @param dir : direction of the owner of the pet
	 * @param p : phone number of the owner of the pet
	 */
		
	public void addPetV(String np2, double a2, double w2, char t2, double h2, String nc, int id2, String dir, int p) {
		
		boolean l = false;
		for(int i = 0;i<arrayClient.size() && !l ;i++) {
			if(arrayClient.get(i).getIDC() == id2) {
				arrayClient.get(i).addPetC(np2, a2, w2, t2, h2);
				l = true;
			}
		}
			
		
		if(l == false) {
			Client cs = new Client(nc, id2, dir, p);
			cs.getArrayPet().add(new Pet(np2, a2, w2, t2, h2));
			arrayClient.add(cs);
		}
	}
	
	/**
	 * erasePetV
	 * Method that erases a pet
	 * <b>pre:</b>arrayClient must exist. 
	 * <b>post:</b>the specified pet is deleted.
	 * @param nc : id of the owner of the pet
	 * @param np : name of the pet
	 * @return message confirming that the pet has been erased
	 */
	
	public String erasePetV(int nc, String np) {
		String msg = "";
		boolean k = false;
		for(int i = 0; i<arrayClient.size() && !k; i++) {
			if(nc == arrayClient.get(i).getIDC())
			arrayClient.get(i).erasePetC(np);
			msg = "The pet has been erased";
		}
		return msg;
	}
	
		public String hospitalizationV(String n, int id) {
		String msg = "Error";
		boolean v = false;
		
		for(int j = 0; j<arrayClient.size(); j++)	{
			if(arrayClient.get(j).getIDC() == id) {
				for(int i = 0; i<(arrayRoom.length-1) && !v; i++) {
					if(arrayClient.get(j).getPet(n) != null) {
						if(!arrayRoom[i].stateR() == true) {
							arrayRoom[i].setPetX(arrayClient.get(j).getPet(n)); 
							v = true;
							msg = "The pet has been assigned to a room ";
						}
					}
				}
			}
		}
		return msg;
	}
	
	public String hospitalizationCost(Date en, Date ex, String n, int id, Drug drug) {
		boolean f = false;
		String msg = "";
		for(int j = 0; j<arrayClient.size(); j++)	{
			if(arrayClient.get(j).getIDC() == id ) {
				for(int a = 0; a < arrayClient.get(a).getArrayPet().size() && !f; a++) {
					if(arrayClient.get(a).getArrayPet().get(a).getNameP().equalsIgnoreCase(n)) {
						for(int i = 0; i<arrayRoom.length && !f; i++) {
								msg = arrayRoom[i].hospitalizationCostR(en, ex) + " plus the cost of prescription medication, which is " + drug.drugCost();
								f = true;
							}
						}
					}
				}
			}
		return msg;
	}
	
	public String changeStateCV(int id, char s) {
		String msg = "";
		boolean w = false;
		for(int  i = 0; i<arrayClient.size() && !w; i++) {
			if(arrayClient.get(i).getIDC() == id) {
				arrayClient.get(i).setStateC(s);
				msg = "State actualized";
				w = true;
			}
		}
		return msg;
	}
	
	public String searchPetV(String n, int id) {
		String msg = "Couldn't find the pet";
		boolean z = false;
		for(int i = 0; i<arrayClient.size() && !z; i++) {
			if(arrayClient.get(i).getIDC() == id){
				msg = arrayClient.get(i).searchPetC(n);
			}
		}
		return msg;
	}
	
	/**
	 * clientExists
	 * This method searches if a client exists
	 * <b>pre: </b> The array of clients must've been created
	 * @param id : the id of the client
	 * @return boolean variable
	 */
	public boolean clientExists(int id) {
		boolean y = false;
		for(int i = 0; i<arrayClient.size() && !y; i++) {
			if(arrayClient.get(i).getIDC()==id) 
				y = true;
		}
		return y;
	}
	
	/**
	 * searchClientV
	 * This method shows the information of a client
	 * <b>pre: </b> The array of clients must've been created
	 * @param id : the identification of the client
	 * @return message showing all the information about the client
	 */
	public String searchClientV(int id) {
		String msg = "";
		for(int i = 0; i<arrayClient.size(); i++) {
			if(clientExists(id)==true) 
				msg = arrayClient.get(i).reportClient();
		}	
		return msg;
	}
	
	public String newClinicHistoryV(String nameNP, double ageNP, double weightNP, char typeNP, double heightNP, Detail d, String n, int id, String dir, int ph) {
		String msg = "Error";
		Client clientCH = new Client(n, id, dir, ph);
		Pet newPet = new Pet(nameNP, ageNP, weightNP, typeNP, heightNP);
		boolean x = false;
		for(int i = 0;i<arrayClinicHistories.size() && !x;i++){
			if(clientCH.getIDC() != (arrayClinicHistories.get(i).getClientCH().getIDC())) {
				arrayClinicHistories.add(new ClinicHistory(newPet, clientCH, d));
				arrayClient.add(clientCH);
				arrayClient.get(i).addPetC(nameNP, ageNP, weightNP, typeNP, heightNP);
				msg = "Clinic History added";
				x = true;
			}
			else if(clientCH.getIDC() == (arrayClinicHistories.get(i).getClientCH().getIDC())) {
				if(newPet.getNameP() != (arrayClinicHistories.get(i).getPetCH().getNameP())) {
					arrayClinicHistories.add(new ClinicHistory(newPet, clientCH, d));	
					arrayClient.add(clientCH);
					arrayClient.get(i).addPetC(nameNP, ageNP, weightNP, typeNP, heightNP);
					msg = "Clinic history added";
					x = true;
				}
			}
		}
		return msg;
	}
	
	public String showClinicHistoryV(int id, String np) {
		boolean h = false;
		String msg = "";
		for(int i = 0; i<arrayClinicHistories.size() && !h; i++) {
			if(arrayClinicHistories.get(i).getClientCH().getIDC() == id) {
				if(arrayClinicHistories.get(i).getPetCH().getNameP().equalsIgnoreCase(np)) {
					msg = arrayClinicHistories.get(i).reportCH();
					h = true;
				}
			}
		}
		return msg;
	}
	
	/**
	 * busyRoomV
	 * <b>pre: </b>The array of rooms must've been created
	 * This method searches if a room is occupied by a pet
	 * @param x : number of the room
	 * @return message confirming availability of the room

	 */
	public String busyRoomV(int x) {
		boolean u = false;
		String msg = "Couldn't find room";
		for(int i = 0; i<(arrayRoom.length-1) && !u; i++) {
			if(arrayRoom[i].getNumber() == x) {
				if(arrayRoom[i].getPetX() == null)
					msg = "Room available";
				else if(arrayRoom[i].getPetX() != null)
					msg = "Room busy";
				u = true;
			}
		}
		return msg;
	}

	/**
	*updateClientV 
	*This method allows to update the basic data of a veterinary client, these data include, address and phone number.
	*<b>pre: </b> The array of clients was created before.
	*<b>post: </b> The address and /or phone number of the client is updated.
	*@param id : The id of the client
	*@param dir : The new address of the client. This param could be empty.
	*@param p : The new phone number of the client. This param could be empty.
	*@return message confirming that the information is updated
	*/

	public String updateClientV(int id, int p, String dir){
		String msg = "";
		for(int i = 0; i<arrayClient.size(); i++) {
			if(clientExists(id)) {
				arrayClient.get(i).setPhoneC(p);
				arrayClient.get(i).setDirC(dir);
				msg = "Information succesfully updated";
			}
		}
		return msg;
	}
	
}
