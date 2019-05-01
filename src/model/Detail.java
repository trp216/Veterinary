package model;
import java.util.ArrayList;

/**
 *Class Detail
 * @author Alejandra Diaz
 *
 */

public class Detail {
	
	//constants
	public final static char OPEN = 'O';	
	public final static char CLOSED = 'C';

	
	//atributes
	private String symptoms;
	private String diagnosis;
	private char state;
	
	private Date consultDate; //relation with class Date
	
	//methods
	
	/**
	 * Detail constructor
	 * Creates an object Detail
	 * <b>post:</b> a detail is created
	 * @param s : symptoms 
	 * @param d : diagnosis
	 * @param cd : date of consult
	 * state is set to open
	 */
	
	public Detail(String s, String d, Date cd) { //builder method
		symptoms = s;
		diagnosis = d;
		state = OPEN;
		consultDate = cd;
		
	}

	/**
	 * getSymptoms
	 * getSymptoms no-argument method returns attribute symptoms
	 * @return symptoms
	 */
	
	public String getSymptoms() {
		return symptoms;
	}

	/**
	 * setSymptoms
	 * changes the symptoms for the new ones entered by parameters
	 * @param symptoms :  new symptoms
	 */

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	/**
	 * getDiagnosis
	 * getDiagnosis no-argument method returns attribute diagnosis
	 * @return diagnosis
	 */
	
	public String getDiagnosis() {
		return diagnosis;
	}

	/**
	 * setDiagnosis
	 * changes the diagnosis for the new one entered by parameters
	 * @param diagnosis :  new diagnosis
	 */

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	
	/**
	 * getStateCH
	 * getStateCH no-argument method returns the state of the clinic history
	 * @return state
	 */

	public char getStateCH() {
		return state;
	}

	/**
	 * setStateCH
	 * changes the state of the clinic history for the new one entered by parameters
	 * @param state :  new state
	 */

	public void setStateCH(char state) {
		this.state = state;
	}

	/**
	 * getConsultDate
	 * getConsultDate no-argument method returns attribute consultDate
	 * @return consultDate
	 */

	public Date getConsultDate() {
		return consultDate;
	}
	
	/**
	 * setConsultDate
	 * changes the date of consult for the new one entered by parameters
	 * @param consultDate :  new consultDate
	 */

	public void setConsultDate(Date consultDate) {
		this.consultDate = consultDate;
	}
	
	/**
	 * showDetail
	 * Method that shows a message with all the details of the clinic history
	 * @return message
	 */

	public String showDetail() { //report method for Detail
		String msg = "Symptoms: " + getSymptoms() + ", Diagnosis: " + getDiagnosis() + ", state: " + getStateCH();
		return msg;
	}
}
