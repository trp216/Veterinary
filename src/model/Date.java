package model;

/**
 * Class Date
 * @author Alejandra Diaz
 *
 */

public class Date {
	int day;
	int month;
	int year;
	
	/**
	 * Date
	 * Date constructor
	 * Creates an object date
	 * <b>post:</b> a date is created
	 * @param d : the day
	 * @param m : the month
	 * @param y : the hour
	 */
	
	public Date(int d, int m, int y) {
		day = d;
		month = m;
		year = y;
	}
	
	/**
	 * getDay
	 * getDay no-argument method returns attribute day
	 * @return day
	 */
	
	public int getDay() {
		return day;
	}
	
	/**
	 * setDay
	 * changes the day for the new one entered by parameters
	 * @param day: new day  
	 */
	
	public void setDay(int day) {
		this.day = day;
	}
	
	/**
	 * getMonth
	 * getMonth no-argument method returns attribute month
	 * @return month
	 */
	
	public int getMonth() {
		return month;
	}
	
	/**
	 * setMonth
	 * changes the month for the new one entered by parameters
	 * @param month :  new month
	 */
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	/**
	 * getYear
	 * getYear no-argument method returns attribute year
	 * @return year
	 */
	
	public int getYear() {
		return year;
	}
	
	/**
	 * setYear
	 * changes the year for the new one entered by parameters
	 * @param year : new year
	 */
	
	public void setYear(int year) {
		this.year = year;
	}
	
	/**
	 * getString
	 * method that shows a message with the date in format DD/MM/YY
	 * @return message with the date
	 */
	
	public String getString(){
		String a = day+"/"+month+"/"+year;
		return a;
	}
}
