package model;
import java.util.ArrayList;

public class Vet {

	private String name;
	private Room[] arrayRoom;
	private ArrayList <ClinicHistory> arrayClinicHistories;
	private ArrayList <Client> arrayClient;
	
	public Vet(String n) {
		name = n;
		Pet randomPet = new Pet("Pet", 5, 15.5, 'C');
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
		
	public void addPetV(String np2, double a2, double w2, char t2, String nc, int id2, String dir, int p) {
		
		boolean l = false;
		for(int i = 0;i<arrayClient.size() && !l ;i++) {
			if(arrayClient.get(i).getIDC() == id2) {
				arrayClient.get(i).addPetC(np2, a2, w2, t2);
				l = true;
			}
		}
			
		
		if(l == false) {
			Client cs = new Client(nc, id2, dir, p);
			cs.getArrayPet().add(new Pet(np2, a2, w2, t2));
			arrayClient.add(cs);
		}
	}
	
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
				for(int i = 0; i<arrayRoom.length && !v; i++) {
					if(arrayClient.get(i).getPet(n) != null) {
						if(!arrayRoom[i].stateR() == true) {
							arrayRoom[i].setPetX(arrayClient.get(i).getPet(n)); 
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
							if(arrayRoom[i].getPetX().getNameP().equalsIgnoreCase(n)) {
								msg = arrayRoom[i].hospitalizationCostR(en, ex) + " plus the cost of prescription medication, which is " + drug.drugCost();
								f = true;
							}
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
	
	public String searchClientV(int id) {
		String msg = "Couldn't find the client";
		boolean y = false;
		for(int i  = 0; i<arrayClient.size() && !y; i++) {
			if(arrayClient.get(i).getIDC() == id) {
				msg = arrayClient.get(i).reportClient();
				y = true;
			}
		}
		return msg;
	}
	
	public String newClinicHistoryV(Pet p, Detail d, String n, int id, String dir, int ph) {
		String msg = "Error";
		Client clientCH = new Client(n, id, dir, ph);
		boolean x = false;
		for(int i = 0;i<arrayClinicHistories.size() && !x;i++){
			if(clientCH.getIDC() != (arrayClinicHistories.get(i).getClientCH().getIDC())) {
				arrayClinicHistories.add(new ClinicHistory(p, clientCH, d));
				arrayClient.add(clientCH);
				msg = "Clinic History added";
				x = true;
			}
			else if(clientCH.getIDC() == (arrayClinicHistories.get(i).getClientCH().getIDC())) {
				if(p.getNameP() != (arrayClinicHistories.get(i).getPetCH().getNameP())) {
					arrayClinicHistories.add(new ClinicHistory(p, clientCH, d));	
					arrayClient.add(clientCH);
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
		
}
