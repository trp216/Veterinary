package model;
import java.util.ArrayList;

public class Vet {

	private String name;
	private Room[] arrayRoom;
	private ArrayList <ClinicHistory> arrayClinicHistories;
	private ArrayList <Client> arrayClient;
	
	public Vet(String n) {
		name = n;
		arrayRoom = new Room [8];
		arrayClinicHistories = new ArrayList <ClinicHistory>();
		arrayClient = new ArrayList <Client>();
	}

	public String getNameV() {
		return name;
	}

	public void setNamev(String name) {
		this.name = name;
	}

	public boolean addPetIfClientExists(String np, double a, double w, char t, int id) {
		boolean l = false;
		for(int i = 0;i<arrayClient.size() || !l ;i++) {
			if(arrayClient.get(i).getIDC() == id) {
				arrayClient.get(i).addPetC(np, a, w, t);
				l = true;
			}
			}
		return l;
	}
		
	public void addPetV(String np2, double a2, double w2, char t2, String nc, int id2, String dir, int p, char s) {
		boolean l = false;
		addPetIfClientExists(np2, a2, w2, t2, id2);
		if(addPetIfClientExists(np2, a2, w2, t2, id2) == false) {
			arrayClient.add(new Client(nc, id2, dir, p, s));
			for(int i = 0;i<arrayClient.size();i++) {
					arrayClient.get(i).addPetC(np2, a2, w2, t2);
				}
		}
	}
	
	public String erasePetV(int nc, String np) {
		String msg = "";
		boolean k = false;
		
	}
	
	public String hospitalizationV(int nr, String n, double a, double w, char t) {
		String msg = "No rooms available";
		boolean v = false;
		Pet np = new Pet(n, a , w, t);
		for(int i = 0; i<arrayRoom.length || !v; i++) {
			if(!arrayRoom[nr].stateR() == true) {
				arrayRoom[nr].setPetX(np); //QUE PONGO OME
				v = true;
				msg = "The pet has been assigned to the room " + nr;
			}
		}
		return msg;
	}
	
	public String changeStateCV(int id, char s) {
		String msg = "";
		boolean w = false;
		for(int  i = 0; i<arrayClient.size() || !w; i++) {
			if(arrayClient.get(i).getIDC() == id) {
				arrayClient.get(i).setStateC(s);
				msg = "State actualized";
				w = true;
			}
		}
		return msg;
	}
	
	public String searchPetV(String n) {
		String msg = "Couldn't find the pet";
		boolean z = false;
		for(int i = 0; i<arrayClinicHistories.size() || !z; i++) {
			if(arrayClinicHistories.get(i).getPetCH().getNameP().equalsIgnoreCase(n)) {
				msg = arrayClinicHistories.get(i).getPetCH().reportPet();
				z = true;
			}
		}
		return msg;
	}
	
	public String searchClientV(int id) {
		String msg = "Couldn't find the client";
		boolean y = false;
		for(int i  = 0; i<arrayClient.size() || !y; i++) {
			if(arrayClient.get(i).getIDC() == id) {
				msg = arrayClient.get(i).reportClient();
				y = true;
			}
		}
		return msg;
	}
	
	public String newClinicHistoryV(Pet p, Detail d, String n, int id, String dir, int ph, char s) {
		String msg = "";
		Client clientCH = new Client(n, id, dir, ph, s);
		boolean x = false;
		for(int i = 0;i<arrayClinicHistories.size() || !x;i++){
			if(clientCH.getIDC() != (arrayClinicHistories.get(i).getClientCH().getIDC())) {
				arrayClinicHistories.add(new ClinicHistory(p, clientCH, d));
				arrayClient.add(clientCH);
				x = true;
			}
			else if(clientCH.getIDC() == (arrayClinicHistories.get(i).getClientCH().getIDC())) {
				if(p.getNameP() != (arrayClinicHistories.get(i).getPetCH().getNameP())) {
					arrayClinicHistories.add(new ClinicHistory(p, clientCH, d));
					arrayClient.add(clientCH);
				x = true;
				}
				else
					msg = "The clinic history for this pet already exists";
			}
		}
		return msg;
	}
}
