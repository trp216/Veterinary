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
	
	/**
	 * ClinicHistory
	 * ClinicHistory constructor
	 * Creates an object clinic history
	 * <b>post: </b> a clinic history is created. Array of details (detailCH) is initialized
	 * @param p : pet 
	 * @param c : client
	 * @param i : identification number of the clinic history
	 */
	public ClinicHistory(int i, Pet p, Client c) {
		id = i;
		clinicHistoryPet = p;
		clinicHistoryClient = c;
		detailCH = new ArrayList<Detail>();
	}
	
	/**
	 * getDetailCH
	 * getDetailCH no-argument method returns arraylist of details
	 * @return detailCH
	 */
	public ArrayList getDetailCH() {
		return detailCH;
	}

	/**
	 * getPetCH
	 * getPetCH no-argument method returns pet of the clinic history
	 * @return pet
	 */
	public  Pet getPetCH() {
		return clinicHistoryPet;
	}
	
	/**
	 * setPetCH
	 * changes the pet of the clinic history for the new one entered by parameters
	 * @param clinicHistoryPet : new pet
	 */
	public void setPetCH(Pet clinicHistoryPet) {
		this.clinicHistoryPet = clinicHistoryPet;
	}
	
	/**
	 * getClientCH
	 * getClientCH no-argument method returns client of the clinic history
	 * @return client
	 */
	public Client getClientCH() {
		return clinicHistoryClient;
	}
	
	/**
	 * setClientCH
	 * changes the client of the clinic history for the new one entered by parameters
	 * @param clinicHistoryClient : new client
	 */
	public void setClientCH(Client clinicHistoryClient) {
		this.clinicHistoryClient = clinicHistoryClient;
	}
	
	/**
	 * getIDCH
	 * getIDCH no-argument method returns identification number of the clinic history
	 * @return identification number
	 */
	public int getIDCH() {
		return id;
	}

	/**
	 * setIDCH
	 * changes the identification number of the clinic history for the new one entered by parameters
	 * @param id : new identification
	 */
	public void setIDCH(int id) {
		this.id = id;
	}
	
	public boolean addDetailCH(Detail d) {
		boolean x = false;
		boolean a = getDetailCH().add(d);
		if(a == true)
			x = true;
		return x;
	}
	
	public void addSymptomsCH(String s) {
		Detail objDet=detailCH.get(detailCH.size()-1);
		String aux=	objDet.getSymptoms();
		aux += ("\n" + "New symptoms: " + s);
		objDet.setSymptoms(aux);
		
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
