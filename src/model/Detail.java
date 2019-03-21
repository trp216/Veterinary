package model;

public class Detail {
	
	public final static char OPEN = 'O';	
	public final static char CLOSED = 'C';

	private String symptoms;
	private String diagnosis;
	private char state;
	
	private Date consultDate;
	

	public Detail(String s, String d, char st, Date cd) {
		symptoms = s;
		diagnosis = d;
		state = st;
		consultDate = cd;
		
	}


	public String getSymptoms() {
		return symptoms;
	}


	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}


	public String getDiagnosis() {
		return diagnosis;
	}


	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}


	public char getStateCH() {
		return state;
	}


	public void setStateCH(char state) {
		this.state = state;
	}


	public Date getConsultDate() {
		return consultDate;
	}


	public void setConsultDate(Date consultDate) {
		this.consultDate = consultDate;
	}

}
