package model;

/**
 * 
 * Class Room
 * @author Alejandra Diaz
 *
 */

public class Room {
	
	
	private int number;
	private Pet petx;
	
	/**
	 * Room
	 * Room constructor
	 * Creates an object room
	 * <b>post: </b> a new room is created
	 * @param n : number of the room
	 * @param p : pet 
	 */
	public Room(int n, Pet p) {
		number = n;
		petx = p;
	}

	/**
	 * getNumber
	 * getNumber no-argument method returns number of the room
	 * @return number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * setNumber
	 * changes the number of the room for the new one entered by parameters
	 * @param number : new number
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * getPetX
	 * getPetX no-argument method returns the pet in the room
	 * @return pet
	 */
	public Pet getPetX() {
		return petx;
	}
	
	/**
	 * setPetX
	 * changes the pet in the room for the new one entered by parameters
	 * @param petx : new pet
	 */
	public void setPetX(Pet petx) {
		this.petx = petx;
	}
	
	/**
	 * stateR
	 * This method gives the state of the room
	 * @return the state of the room
	 */
	public boolean stateR() {
		boolean x = false;
		if(getPetX() == null)
			x = true;
		return x;
	}
	
	/**
	 * hospitalizationCostR
	 * This method calculates the cost o the hospitalization
	 * @param en : entry date
	 * @param ex : exit date
	 * @return the cost of the hospitalization
	 */
	public String hospitalizationCostR(Date en, Date ex) {
		String msg = "";
		boolean v = false;
		int c = 0;
		int m = ex.getMonth() - en.getMonth();
		int z = (m-2) * 30;
		int h = 12 - en.getMonth();
		int o = h + ex.getMonth();
		int d = 30 - en.getDay();
		int f = d + ex.getDay();
		int u = ex.getYear() - en.getYear();
		int k = ex.getDay() - en.getDay();
		
		
		if(getPetX().getTypeP() == Pet.CAT) {
			if(getPetX().getWeightP()>=1 && getPetX().getWeightP()<=3) {
				if(u >= 1) {
					int e = ((o-2) * 30) + f;
					int n = e*10000;
					msg = "The hospitalization cost is " + n;
				}
				else if(u == 0 && m>=1) {
					int w = z *10000;
					msg = "The hospitalization cost is " + w;
				}
				else if(m == 0 && ex.getDay()>en.getDay()){
					int t = k *10000;
					msg = "The hospitalization cost is " + t;
				}
			}
			else if(getPetX().getWeightP()>=3.1 && getPetX().getWeightP()<=10) {
				if(u >= 1) {
					int e = ((o-2) * 30) + f;
					int n = e*12000;
					msg = "The hospitalization cost is " + n;
				}
				else if(u == 0 && m>=1) {
					int w = z *12000;
					msg = "The hospitalization cost is " + w;
				}
				else if(m == 0 && ex.getDay()>en.getDay()){
					int t = k *12000;
					msg = "The hospitalization cost is " + t;
				}
			}
			else if(getPetX().getWeightP()>=10.1 && getPetX().getWeightP()<=20) {
				if(u >= 1) {
					int e = ((o-2) * 30) + f;
					int n = e*15000;
					msg = "The hospitalization cost is " + n;
				}
				else if(u == 0 && m>=1) {
					int w = z *15000;
					msg = "The hospitalization cost is " + w;
				}
				else if(m == 0 && ex.getDay()>en.getDay()){
					int t = k *15000;
					msg = "The hospitalization cost is " + t;
				}
			}
			else if(getPetX().getWeightP()>20) {
				if(u >= 1) {
					int e = ((o-2) * 30) + f;
					int n = e*20000;
					msg = "The hospitalization cost is " + n;
				}
				else if(u == 0 && m>=1) {
					int w = z *20000;
					msg = "The hospitalization cost is " + w;
				}
				else if(m == 0 && ex.getDay()>en.getDay()){
					int t = k *20000;
					msg = "The hospitalization cost is " + t;
				}
			}		
		}
		
		if(getPetX().getTypeP() == Pet.DOG) {
			if(getPetX().getWeightP()>=1 && getPetX().getWeightP()<=3) {
				if(u >= 1) {
					int e = ((o-2) * 30) + f;
					int n = e*15000;
					msg = "The hospitalization cost is " + n;
				}
				else if(u == 0 && m>=1) {
					int w = z *15000;
					msg = "The hospitalization cost is " + w;
				}
				else if(m == 0 && ex.getDay()>en.getDay()){
					int t = k *15000;
					msg = "The hospitalization cost is " + t;
				}
			}
			else if(getPetX().getWeightP()>=3.1 && getPetX().getWeightP()<=10) {
				if(u >= 1) {
					int e = ((o-2) * 30) + f;
					int n = e*17000;
					msg = "The hospitalization cost is " + n;
				}
				else if(u == 0 && m>=1) {
					int w = z *17000;
					msg = "The hospitalization cost is " + w;
				}
				else if(m == 0 && ex.getDay()>en.getDay()){
					int t = k *17000;
					msg = "The hospitalization cost is " + t;
				}
			}
			else if(getPetX().getWeightP()>=10.1 && getPetX().getWeightP()<=20) {
				if(u >= 1) {
					int e = ((o-2) * 30) + f;
					int n = e*20000;
					msg = "The hospitalization cost is " + n;
				}
				else if(u == 0 && m>=1) {
					int w = z *20000;
					msg = "The hospitalization cost is " + w;
				}
				else if(m == 0 && ex.getDay()>en.getDay()){
					int t = k *20000;
					msg = "The hospitalization cost is " + t;
				}
			}
			else if(getPetX().getWeightP()>20) {
				if(u >= 1) {
					int e = ((o-2) * 30) + f;
					int n = e*25000;
					msg = "The hospitalization cost is " + n;
				}
				else if(u == 0 && m>=1) {
					int w = z *25000;
					msg = "The hospitalization cost is " + w;
				}
				else if(m == 0 && ex.getDay()>en.getDay()){
					int t = k *25000;
					msg = "The hospitalization cost is " + t;
				}
		}		
		}
		
		if(getPetX().getTypeP() == Pet.BIRD) {
			if(getPetX().getWeightP()>=1 && getPetX().getWeightP()<=3) {
				if(u >= 1) {
					int e = ((o-2) * 30) + f;
					int n = e*10000;
					msg = "The hospitalization cost is " + n;
				}
				else if(u == 0 && m>=1) {
					int w = z *10000;
					msg = "The hospitalization cost is " + w;
				}
				else if(m == 0 && ex.getDay()>en.getDay()){
					int t = k *10000;
					msg = "The hospitalization cost is " + t;
				}
			}
			else if(getPetX().getWeightP()>=3.1 && getPetX().getWeightP()<=10) {
				if(u >= 1) {
					int e = ((o-2) * 30) + f;
					int n = e*12000;
					msg = "The hospitalization cost is " + n;
				}
				else if(u == 0 && m>=1) {
					int w = z *12000;
					msg = "The hospitalization cost is " + w;
				}
				else if(m == 0 && ex.getDay()>en.getDay()){
					int t = k *12000;
					msg = "The hospitalization cost is " + t;
				}
			}
			else if(getPetX().getWeightP()>=10.1 && getPetX().getWeightP()<=20) {
				if(u >= 1) {
					int e = ((o-2) * 30) + f;
					int n = e*20000;
					msg = "The hospitalization cost is " + n;
				}
				else if(u == 0 && m>=1) {
					int w = z *20000;
					msg = "The hospitalization cost is " + w;
				}
				else if(m == 0 && ex.getDay()>en.getDay()){
					int t = k *20000;
					msg = "The hospitalization cost is " + t;
				}
			}
			else if(getPetX().getWeightP()>20) {
				if(u >= 1) {
					int e = ((o-2) * 30) + f;
					int n = e*25000;
					msg = "The hospitalization cost is " + n;
				}
				else if(u == 0 && m>=1) {
					int w = z *25000;
					msg = "The hospitalization cost is " + w;
				}
				else if(m == 0 && ex.getDay()>en.getDay()){
					int t = k *25000;
					msg = "The hospitalization cost is " + t;
				}
		}		
		}
		
		if(getPetX().getTypeP() == Pet.OTHER) {
			if(getPetX().getWeightP()>=1 && getPetX().getWeightP()<=3) {
				if(u >= 1) {
					int e = ((o-2) * 30) + f;
					int n = e*10000;
					msg = "The hospitalization cost is " + n;
				}
				else if(u == 0 && m>=1) {
					int w = z *10000;
					msg = "The hospitalization cost is " + w;
				}
				else if(m == 0 && ex.getDay()>en.getDay()){
					int t = k *10000;
					msg = "The hospitalization cost is " + t;
				}
			}
			else if(getPetX().getWeightP()>=3.1 && getPetX().getWeightP()<=10) {
				if(u >= 1) {
					int e = ((o-2) * 30) + f;
					int n = e*17000;
					msg = "The hospitalization cost is " + n;
				}
				else if(u == 0 && m>=1) {
					int w = z *17000;
					msg = "The hospitalization cost is " + w;
				}
				else if(m == 0 && ex.getDay()>en.getDay()){
					int t = k *17000;
					msg = "The hospitalization cost is " + t;
				}
			}
			else if(getPetX().getWeightP()>=10.1 && getPetX().getWeightP()<=20) {
				if(u >= 1) {
					int e = ((o-2) * 30) + f;
					int n = e*30000;
					msg = "The hospitalization cost is " + n;
				}
				else if(u == 0 && m>=1) {
					int w = z *30000;
					msg = "The hospitalization cost is " + w;
				}
				else if(m == 0 && ex.getDay()>en.getDay()){
					int t = k *30000;
					msg = "The hospitalization cost is " + t;
				}
			}
			else if(getPetX().getWeightP()>20) {
				if(u >= 1) {
					int e = ((o-2) * 30) + f;
					int n = e*33000;
					msg = "The hospitalization cost is " + n;
				}
				else if(u == 0 && m>=1) {
					int w = z *33000;
					msg = "The hospitalization cost is " + w;
				}
				else if(m == 0 && ex.getDay()>en.getDay()){
					int t = k *33000;
					msg = "The hospitalization cost is " + t;
				}
		}		
		}
		
		return msg;
	}
}
