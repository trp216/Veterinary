package model;
import java.util.ArrayList;

/**
 * class Vet
 * @author Alejandra Diaz
 *
 */

public class Vet {

	private String name;
	private Room[] arrayRoom;
	private ArrayList <ClinicHistory> arrayClinicHistories;
	private ArrayList <Client> arrayClient;
	
	
	/**
	 * Vet constructor
	 * <b>post: </b>randomPet, randomRoom, randomClient, randomDate, randomDrug, randomDetail and randomCH are created. ArrayClient, arrayDrug, arrayRoom 
 and arrayClinicHistories are initialized. RandomClient is assigned to arrayClient. RandomPet and randomDrug are assigned to randomRoom. RandomRoom is assigned to position 2 on arrayRoom.
 RandomDate is assigned to randomDetail. RandomDetail is assigned to randomCH. RandomCH is assigned to arrayClinicHistories.
	 * @param n : name
	 */
	public Vet(String n) {
		name = n;
		Pet randomPet = new Pet("Pet", 5, 15.5, 'C', 25);
		Drug randomDrug = new Drug("Random drug", 150, 2, 2000);
		arrayRoom = new Room [8];
		Room randomRoom = new Room(2, randomPet);
		randomRoom.getArrayDrug().add(randomDrug);
		arrayRoom[2] = randomRoom;
		arrayRoom[2].getArrayDrug().add(randomDrug);
		arrayClinicHistories = new ArrayList <ClinicHistory>();
		arrayClient = new ArrayList <Client>();
		Client randomClient = new Client("Client", 567, "Random direction", 238642);
		arrayClient.add(randomClient);
		randomClient.getArrayPet().add(randomPet);
		Date randomDate = new Date(19, 3, 2018);
		Detail randomDetail = new Detail("Random symptoms", "Random diagnosis", randomDate);
		ClinicHistory randomCH = new ClinicHistory(00, randomPet, randomClient);
		randomCH.addDetailCH(randomDetail);
		arrayClinicHistories.add(randomCH);
	}
	
	/**
	 * massIndexV
	 * This method shows the body mass index of the pet
	 * <b>pre:</b>array of client must exist and must have an array of pets
	 * @param id identification of the client
	 * @param n name of the pet
	 * @return message showing the body mass index of the pet
	 */
	public String massIndexV(int id, String n) {
		String msg = "";
		if(clientExists(id)!=null && clientExists(id).getPet(n)!=null) {
			msg = "Body mass index: " + clientExists(id).getPet(n).bodyMassIndex();
		}
		return msg;
	}

/**
 * addDrugV
 * This method adds a new drug
 * <b>pre:</b>Array of rooms mmust've been created. 
 * <b>post:</b>A new drug is added 
 * @param nm name of the drug
 * @param dm dose of the drug
 * @param cm cost of the dose 
 * @param fm frequency of the drug
 * @param np name of the pet
 * @return boolean variable
 */
	public boolean addDrugV(String nm, double dm, double cm, double fm, String np){
		boolean x = false;
		boolean y = false;
		Drug d = new Drug(nm, dm, fm, cm);
			for(int i = 0; i<arrayRoom.length && !x; i++) {
				if(arrayRoom[i].getPetX().getNameP().equals(np)) {
					arrayRoom[i].addDrugR(d);
					y = arrayRoom[i].addDrugR(d);
					x = true;
				}
		}
		return y;
	}

	/**
	 * getNameV
	 * getNameV no-argument method returns attribute name
	 * @return name
	 */
	public String getNameV() {
		return name;
	}

	/**
	 * setNameV
	 * changes the name for the new one entered by parameters
	 * @param name :  new name
	 */
	public void setNamev(String name) {
		this.name = name;
	}
	
	/**
	 * addPetV
	 * Adds a pet
	 * <b>pre:</b> arrayClient must exist. np2 and w2 must be higher than 0.
	 * <b>post: </b> A new pet is added.
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
	
	/**
	 * hospitalizationV
	 * This method assigns a pet to a room
	 * <b> pre: </b> the array of rooms must've been created
	 * <b> post: </b> the pet is assigned to the room
	 * @param n : name of the pet
	 * @param id : identification of the client
	 * @return message notifying the success of the method
	 */
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
	
	/**
	 * hospitalizationCost
	 * This method calculates the cost of the hospitalization
	 * 
	 * @param en : entry date
	 * @param ex : exit date
	 * @param n : name of the pet
	 * @param id : identification of the client
	 * @param drug : drugs prescribed to the pet
	 * @return message indicating the cost of the hospitalization
	 */
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
	
	/**
	 * changeStateCV
	 * This method changes the state of the client
	 * <b> pre: </b> array of clients must exist.
	 * <b>post: </b> the state of the client is actualized
	 * @param id : identification of the client
	 * @param s : state to which you want to change
	 * @return message notifying the succes of the method
	 */
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
	
	/**
	 * searchPetV
	 * Shows information about a pet
	 * <b>pre:</b>Arraylist of pets must exist.
	 * @param n : name of the pet
	 * @param id : identification of the client
	 * @return message with all the information of the pet
	 */
	public String searchPetV(String n, int id) {
		String msg = "Couldn't find the pet";
		boolean z = false;
		for(int i = 0; i<arrayClient.size() && !z; i++) {
			if(clientExists(id)!=null){
				msg = clientExists(id).searchPetC(n);
			}
		}
		return msg;
	}
	
	/**
	 * clientExists
	 * This method searches if a client exists
	 * <b>pre: </b> The array of clients must've been created
	 * @param id : the id of the client
	 * @return object Client
	 */
	public Client clientExists(int id) {
		boolean y = false;
		Client c = null;
		for(int i = 0; i<arrayClient.size() && !y; i++) {
			Client aux = (Client)arrayClient.get(i);
			if(arrayClient.get(i).getIDC()==id) 
				c = aux;
				y = true;
		}
		return c;
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
			if(clientExists(id)!=null) 
				msg = clientExists(id).reportClient();
		}	
		return msg;
	}
	
	/**
	 * searchClinicHistory
	 * This method searches for a clinic history
	 * <b>pre: </b> The array of clinic histories must've been created
	 * @param id : identification number of the clinic history
	 * @return clinic history
	 */
	public ClinicHistory searchClinicHistory(int id) {
		boolean v = false;
		ClinicHistory ch = null;
		for(int i = 0; i<arrayClinicHistories.size() && !v;i++) {
			ClinicHistory aux = (ClinicHistory)arrayClinicHistories.get(i);
			if(arrayClinicHistories.get(i).getIDCH()==id) {
					ch = aux;
					v = true;
			}
		}
		return ch;
	}
	
	/**
	 * addSymptoms
	 * This method adds new symptoms
	 * @param id : identification number of the clinic history
	 * @param s : new symptoms
	 */
	public void addSymptomsV(int id, String s) {
		if(searchClinicHistory(id)!= null) {
			searchClinicHistory(id).addSymptomsCH(s);
		}
	}
	
	/**
	 * addDetailV
	 * This method adds a new detail to a clinic history
	 * @param id : identification number of the clinic history 
	 * @param s : symptoms
	 * @param d : diagnosis
	 * @param cd : consult date
	 * @return boolean variable
	 */
	public boolean addDetailV(int id, String s, String d, Date cd) {
		Detail dt = new Detail(s,d,cd);
		boolean x = false;
		if(searchClinicHistory(id)!=null) {
			searchClinicHistory(id).addDetailCH(dt);
			x = true;
		}
		return x;
	}
	
	/**
	 * newClinicHistoryV
	 * This method adds a clinic history
	 * <b>pre:</b>the arraylist of clinic histories must've been created
	 * <b>post:</b>a new clinic history is added
	 * @param idch id of the clinic history
	 * @param symNP symptoms of the pet
	 * @param diaNP diagnosis of the pet
	 * @param registerDatePet date of the register of the pet
	 * @param nameNP name of the pet
	 * @param ageNP age of the pet
	 * @param weightNP weight of the pet
	 * @param typeNP type of the pet
	 * @param heightNP height of the pet
	 * @param n name of the client
	 * @param id id of the client
	 * @param dir direction of the client
	 * @param ph phone number of the client
	 * @return message showing the success of the method
	 */
	public String newClinicHistoryV(int idch, String symNP,String diaNP, Date registerDatePet, String nameNP, double ageNP, double weightNP, char typeNP, double heightNP, String n, int id, String dir, int ph) {
		String msg = "Error";
		Client clientCH = new Client(n, id, dir, ph);
		Pet newPet = new Pet(nameNP, ageNP, weightNP, typeNP, heightNP);
		boolean x = false;
		for(int i = 0;i<arrayClinicHistories.size() && !x;i++){
			if(clientCH.getIDC() != (arrayClinicHistories.get(i).getClientCH().getIDC())) {
				arrayClinicHistories.add(new ClinicHistory(idch, newPet, clientCH));
				addDetailV(idch, symNP, diaNP, registerDatePet);
				arrayClient.add(clientCH);
				arrayClient.get(i).addPetC(nameNP, ageNP, weightNP, typeNP, heightNP);
				msg = "Clinic History added";
				x = true;
			}
			else if(clientCH.getIDC() == (arrayClinicHistories.get(i).getClientCH().getIDC())) {
				if(newPet.getNameP() != (arrayClinicHistories.get(i).getPetCH().getNameP())) {
					arrayClinicHistories.add(new ClinicHistory(id, newPet, clientCH));	
					addDetailV(idch, symNP, diaNP, registerDatePet);
					arrayClient.add(clientCH);
					arrayClient.get(i).addPetC(nameNP, ageNP, weightNP, typeNP, heightNP);
					msg = "Clinic history added";
					x = true;
				}
			}
		}
		return msg;
	}
	
	/**
	 * showClinicHistoryV 
	 * This method shows a clinic history
	 * @param id : identification of the client
	 * @return message showing the clinic history
	 */
	public String showClinicHistoryV(int id) {
		String msg = searchClinicHistory(id).reportCH();
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
			if(clientExists(id)!=null) {
				clientExists(id).setPhoneC(p);
				clientExists(id).setDirC(dir);
				msg = "Information succesfully updated";
			}
		}
		return msg;
	}
	
}
