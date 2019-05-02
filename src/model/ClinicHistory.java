package model;
import java.util.ArrayList;

/**
 * Class ClinicHistory
 * @author Alejandra Diaz
 *
 */
public class ClinicHistory {

	private int id;
	
	private Pet clinicHistoryPet;
	private Client clinicHistoryClient;
	private ArrayList<Detail> detailCH;
	
	public ClinicHistory(Pet p, Client c) {
		clinicHistoryPet = p;
		clinicHistoryClient = c;
		detailCH = new ArrayList<Detail>();
	}
	
	public ArrayList getDetailCH() {
		return detailCH;
	}

	public  Pet getPetCH() {
		return clinicHistoryPet;
	}
	
	public void setPetCH(Pet clinicHistoryPet) {
		this.clinicHistoryPet = clinicHistoryPet;
	}
	
	public Client getClientCH() {
		return clinicHistoryClient;
	}
	
	public void setClientCH(Client clinicHistoryClient) {
		this.clinicHistoryClient = clinicHistoryClient;
	}
	
	public int getIDCH() {
		return id;
	}

	public void setIDCH(int id) {
		this.id = id;
	}
	
	public String detailsReport() {
		String msg = "";
		for(int i = 0; i<detailCH.size(); i++) {
			msg += detailCH.get(i).showDetail() + "\n";
		}
		return msg;
	}

	public String reportCH() {
		String msg = "id of the clinic history: " + getIDCH() + "\n" + getClientCH().reportClient() + "\n" + getPetCH().reportPet() + "\n" + detailsReport();
		return msg;
	}
}
