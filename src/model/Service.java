package model;

public class Service {

	public final static char BATH_VET = 'B';
	public final static char BATH_DOM = 'D';
	public final static char MANICURE = 'M';
	public final static char PROF_DENT = 'P';
	public final static char VACCINE = 'V';
	
	private char type;
	private int cost;
	private Date date;
	
	public Service(char t, Date d) {
		type = t;
		date = d;
	}

	public char getTypeS() {
		return type;
	}

	public void setTypeS(char type) {
		this.type = type;
	}

	public Date getDateS() {
		return date;
	}

	public void setDateS(Date date) {
		this.date = date;
	}

	public int getCost() {
		int x = 0;
		if(type == BATH_DOM)
			cost = 30000;
		else if(type == BATH_VET)
			cost = 20000;
		else if(type == MANICURE)
			cost = 8000;
		else if(type == PROF_DENT)
			cost = 12000;
		else if(type == VACCINE)
			cost = 45000;
		return x;
	}
}
