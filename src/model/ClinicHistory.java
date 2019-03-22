package model;

public class ClinicHistory {
	
	private String id;
	
	private Pet clinicHistoryPet;
	private Client clinicHistoryClient;
	private Detail detailCH;
	
	public ClinicHistory(Pet p, Client c, Detail d) {
		clinicHistoryPet = p;
		clinicHistoryClient = c;
		detailCH = d;
	}
	
	public Detail getDetailCH() {
		return detailCH;
	}

	public void setDetailCH(Detail detailCH) {
		this.detailCH = detailCH;
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
	
	public String getIDCH() {
		return id;
	}

	public void setIDCH(String id) {
		this.id = id;
	}

	public String reportCH() {
		String msg = getClientCH().reportClient() + "\n" + getPetCH().reportPet() + "\n" + getDetailCH();
		return msg;
	}
}
