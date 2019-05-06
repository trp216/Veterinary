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
	
	/**
	 * addDetailCH
	 * This method add a new detail to the array of details
	 * <b>pre: </b>Array of details must've been created
	 * <b>post: </b>A new detail is added to the array of details
	 * @param d new detail that's going to be added
	 * @return boolean variable
	 */
	public boolean addDetailCH(Detail d) {
		boolean x = false;
		boolean a = detailCH.add(d);
		if(a == true)
			x = true;
		return x;
	}
	
	/**
	*addSymptomsCH
	*This method allows to add a new symptom presented during the hospitalization at the patient stories.
	*<b>pre:</b> The patient clinic story must not be null.
	*<b>post:</b> A new symptom is added to the patient clinic story.
	*@param s The new symptom presented
	*/
	public void addSymptomsCH(String s) {
		Detail objDet=detailCH.get(detailCH.size()-1);
		objDet.newSymptoms(s);
	}
	
	/**
	 * detailsReport
	 * This method shows a report of all the details of a clinic history
	 * <b>pre:</b>Arraylist of details must've been created
	 * @return a message with all the details of a clinic history
	 */
	public String detailsReport() {
		String msg = "";
		for(int i = 0; i<detailCH.size(); i++) {
			msg += detailCH.get(i).showDetail() + "\n";
		}
		return msg;
	}

	/*
	 * reportCH
	 * This method shows a report of the clinic history
	 * @return a message with the report of the clinic history
	 */
	public String reportCH() {
		String msg = "id of the clinic history: " + getIDCH() + "\n" + "Client: " + getClientCH().reportClient() + "\n" + "Pet: " + getPetCH().reportPet() + "\n" + detailsReport();
		return msg;
	}
}
