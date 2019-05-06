package userInterface;
import java.util.Scanner;
import model.*;
/**
 * Class Main
 * @author Alejandra Diaz
 *@see model.Vet
 */

public class Main {
	private Vet theVeterinary;

	/**
	 * Main
	 * Main constructor
	 * <b>post</b> A veterinary is created.
	 */
	public Main() {
		theVeterinary = new Vet("The Veterinary");
	}

	/**
	 * main
	 * This method show the menu and creates a main
	 * @param args args
	 */
	public static void main(String[] args) {
		Main objMain = new Main();
		System.out.println("	Welcome to My Little Pet\n");
		objMain.menu();
	}
	
	/**
	 * menu
	 * This method is a navigation menu
	 */
	public void menu() {
		Scanner x = new Scanner(System.in);
		boolean end = true;
		String msg = "";
		while(end) {
			System.out.println("What do you want to do?\n");
			System.out.println("1- Add a Clinic History\n");
			System.out.println("2- Show client information\n");
			System.out.println("3- Show pet information\n");
			System.out.println("4- Erase pet\n");
			System.out.println("5- Change client's state\n");
			System.out.println("6- Add a pet\n");
			System.out.println("7- Search Clinic History\n");
			System.out.println("8- Hospitalize a pet\n");
			System.out.println("9- Search disponibility of a room\n");
			System.out.println("10- Update client information\n");
			System.out.println("11- Add new details to a clinic history\n");
			System.out.println("12- Add new symptoms to a clinic history\n");
			System.out.println("13- Add new drug to an hospitalized pet\n");
			System.out.println("14- Calculate the body mass index of a pet\n");
			System.out.println("15- Exit");
			int entry = x.nextInt();
			switch(entry){
				case 1: 
					msg = newClinicHistoryM();
					System.out.println(msg);
					break;
				case 2: 
					msg = searchClientM();
					System.out.println(msg);
					break;
				case 3:
					msg = searchPetM();
					System.out.println(msg);
					break;
				case 4: 
					msg = erasePet();
					System.out.println(msg);
					break;
				case 5:
					msg = changeStateCM();
					System.out.println(msg);
					break;
				case 6:
					addPetM();
					break;
				case 7:
					msg = showClinicHistoryM();
					System.out.println(msg);
					break;
				case 8:
					msg = newHospitalizationM();
					System.out.println(msg);
					break;
				case 9:
					msg = busyRoom();
					System.out.println(msg);
					break;
				case 10:
					msg = updateClient();
					System.out.println(msg);
					break;
				case 11:
					msg = addDetailM();
					System.out.println(msg);
					break;
				case 12:
					addSymptomsM();
					break;
				case 13:
					msg = addDrugs();
					System.out.println(msg);
					break;
				case 14:
					msg = massIndexM();
					System.out.println(msg);
					break;
				case 15:
					msg = "angalia hivi karibuni";
					System.out.println(msg);
					end = false;
					break;
				default:
					msg = "Error: this number can't be evaluated";
					System.out.println(msg);
			}
		}
		
	}
	
	/**
	 * massIndexM
	 * This method shows the body mass index of a pet
	 * @return message showing the body mass index of the pet
	 */
	public String massIndexM() {
		Scanner pet = new Scanner(System.in);
		
		System.out.println("Enter the name of the pet");
		String n = pet.next();
		
		System.out.println("Enter the id of its owner");
		int id = pet.nextInt();
		
		String msg = theVeterinary.massIndexV(id, n);
		return msg;
	}
	
	/**
	 * addDrugs 
	 * <b>post:</b>A new drug is added
	 * This method adds a drug to an hospitalized pet
	 * @return message showing the success of the method
	 */
	public String addDrugs() {
		String msg = "";
		Scanner drug = new Scanner(System.in);
		
		System.out.println("Enter the name of the medicine:");
		String nm = drug.next();
		
		System.out.println("Enter the dose of the medicine:");
		double dm = drug.nextDouble();
		
		System.out.println("Enter the cost of the dose:");
		double cm = drug.nextDouble();
		
		System.out.println("Enter the frequency of the medicine application:");
		double fm = drug.nextDouble();
		
		System.out.println("Enter the name of the pet that's hospitalized:");
		String np  = drug.next();
		
		theVeterinary.addDrugV(nm, dm, cm, fm, np);
		if(theVeterinary.addDrugV(nm, dm, cm, fm, np)==true)
			msg = "Drug added";
		else
			msg = "Error";
		return msg;
	}
	
	/**
	 * showClinicHistoryM
	 * This method shows a report of clinic history
	 * @return report of a clinic history
	 */
	public String showClinicHistoryM() {
		Scanner show = new Scanner(System.in);
		
		System.out.println("Enter the id of the clinic history");
		int id = show.nextInt();
		
		String msg = theVeterinary.showClinicHistoryV(id);
		return msg;
	}
	
	/**
	 * addDetailM
	 * <b>post:</b>New details are added to a clinic history
	 * This method adds new details to a clinic history
	 * @return message showing the success of the method
	 */
	public String addDetailM() {
		Scanner d = new Scanner(System.in);
		String msg = "";
		
		System.out.println("Enter the identification number of the clinic history");
		int id = d.nextInt();
		
		System.out.println("Enter the symptoms of the pet");
		String s = d.next();
		
		System.out.println("Enter the diagnosis");
		String dg = d.next();
		
		System.out.println("Enter the day of the last consult");
		int day = d.nextInt();
		
		System.out.println("Enter the month of the consult");
		int month = d.nextInt();
		
		System.out.println("Enter the year of the consult");
		int year = d.nextInt();
		
		Date cd = new Date(day, month, year);
		
		theVeterinary.addDetailV(id, s, dg, cd);
		if(theVeterinary.addDetailV(id, s, dg, cd)==true)
			msg = "New details succesfully added";
		else
			msg = "Error";
		return msg;
	}
	
	/**
	 * addSymptomsM
	 * <b>post:</b>New symptoms are added to a clinic history
	 * This method adds new symptoms to a clinic history
	 */
	public void addSymptomsM() {
		Scanner s = new Scanner(System.in);
		String msg = "";
		
		System.out.println("Enter the identification number of the clinic history");
		int id = s.nextInt();
		
		System.out.println("Enter the symptoms of the pet");
		String sy = s.next();
		
		theVeterinary.addSymptomsV(id, sy);
	}
	
	/**
	 * addPetM
	 * This method a pet to the database of the vet
	 * <b>post:</b>A new pet is added
	 */
	public void addPetM() {
		Scanner add = new Scanner(System.in);
		System.out.println("Enter the name of the pet: ");
		String nnp = add.next();
		
		System.out.println("Enter the age of the pet:");
		double anp = add.nextDouble();
		
		System.out.println("Enter the weight of the pet: ");
		double wnp = add.nextDouble();
		
		System.out.println("What kind of pet is it? (D for dog, C for cat, B for bird, O for other)");
		char tnp = add.next().charAt(0);
		
		System.out.println("Enter the height of the pet:");
		double hnp = add.nextDouble();
		
		System.out.println("Enter the name of the owner of the pet:");
		String nnc = add.next();
		
		System.out.println("Enter the ID of the owner:");
		int idnc = add.nextInt();
		
		System.out.println("Enter the direction of the owner:");
		String dirnc = add.next();
		
		System.out.println("Enter the phone of the owner:");
		int pnc = add.nextInt();
		
		theVeterinary.addPetV(nnp, anp, wnp, tnp, hnp, nnc, idnc, dirnc, pnc);
	}
	
	/**
	 * erasePetV
	 * Method that erases a pet
	 * @return message confirming that the pet has been erased
	 */
	public String erasePet() {
		Scanner erase  = new Scanner(System.in);
		
		System.out.println("Enter the id of the owner of the pet");
		int nce = erase.nextInt();
		System.out.println("Enter the name of the pet that you want to erase");
		String npe = erase.next();
		
		String msg = theVeterinary.erasePetV(nce, npe);
		return msg;
	}
	
	/**
	 * changeStateM
	 * <b>post:</b>The state of the client is changed
	 * This method changes the state of client
	 * @return message showing the success of the method
	 */
	public String changeStateCM() {
		Scanner state = new Scanner(System.in);
		
		System.out.println("Enter the id of the client whose state you want to consult");
		int idCS = state.nextInt();
		System.out.println(theVeterinary.searchClientV(idCS));
		System.out.println("Change state of client to (A for active; I for inactive): ");
		char stateChange = state.next().charAt(0);
		String msg = theVeterinary.changeStateCV(idCS, stateChange);
		return msg;
	}

	/**
	 * searchPetM
	 * This method shows the report of a pet
	 * @return message with the information of the pet
	 */
	public String searchPetM() {
		Scanner searchPet = new Scanner(System.in);
		
		System.out.println("Enter the pet's name:");
		String petNameSearch = searchPet.next();
		System.out.println("Enter the owner's id:");
		int id = searchPet.nextInt();
		String msg = theVeterinary.searchPetV(petNameSearch, id);
		return msg;
	}
	
	/**
	 * searchClientM
	 * This method shows the report of a client
	 * @return message with the information of the client
	 */
	public String searchClientM() {
		Scanner searchClient = new Scanner(System.in);
		System.out.println("Enter the identification of the client");
		int idSearch = searchClient.nextInt();
		String msg = theVeterinary.searchClientV(idSearch);
		return msg;
	}
	
	/**
	 * newHospitalizationM
	 * This method hospitalizes a pet
	 * <b>post:</b>A pet is hospitalized 
	 * @return a message showing the success of the method and, if the client wants it, the cost of the hospitalization
	 */
	public String newHospitalizationM() {
		Scanner newPetH = new Scanner(System.in);
		Scanner newRoomNumber = new Scanner(System.in);	
		Scanner drug = new Scanner(System.in);
		System.out.println("	Hospitalize a pet");
		
		System.out.println("Enter the name of the pet: ");
		String nameNPH = newPetH.next();
		
		System.out.println("Enter the id of its owner");
		int idNPH = newPetH.nextInt();
		
		System.out.println("Enter the day of entry of the pet: ");
		int dayNPH = newPetH.nextInt();
		
		System.out.println("Enter the month of entry of the pet: ");
		int monthNPH = newPetH.nextInt();
		
		System.out.println("Enter the year of entry of the pet: ");
		int yearNPH = newPetH.nextInt();
		
		System.out.println("Enter the day of exit of the pet: ");
		int dayNPHE = newPetH.nextInt();
		
		System.out.println("Enter the month of exit of the pet: ");
		int monthNPHE = newPetH.nextInt();
		
		System.out.println("Enter the year of exit of the pet: ");
		int yearNPHE = newPetH.nextInt();
	
		System.out.println("Enter the name of the prescription medication:");
		String med = drug.next();
		
		System.out.println("Enter the dose of the prescription medication:");
		double ds = drug.nextDouble();
		
		System.out.println("Enter the cost per dose:");
		double cs = drug.nextDouble();
		
		System.out.println("Enter the frequency of the prescription medication:");
		double fre = drug.nextDouble();
		
		Date registerDatePetH = new Date(dayNPH, monthNPH, yearNPH);
		Date exitDatePet = new Date(dayNPHE, monthNPHE, yearNPHE);
		
		Drug newDrug = new Drug(med, ds, fre, cs);
		
		String msg = theVeterinary.hospitalizationV(nameNPH, idNPH);
		
		System.out.println("Do you want to know the hospitalization cost? (1 for yes, 2 for no)");
		int answer = newPetH.nextInt();
		if(answer == 1) 
			msg = msg + theVeterinary.hospitalizationCost(registerDatePetH, exitDatePet, nameNPH, idNPH, newDrug);
		
		
		return msg;
		
	}
	
	/**
	 * newClinicHistoryM
	 * This method adds a new clinic history
	 * <b>post:</b> a new clinic history is added
	 * @return message showing the success of the method
	 */
	public String newClinicHistoryM() { //method to create a clinic history 
		Scanner newPet = new Scanner(System.in);
		Scanner newClient = new Scanner(System.in);
		Scanner newHistory = new Scanner(System.in);
		
		System.out.println("	New Clinic History");
		
		System.out.println("Enter the identification number of the clinic history");
		int idch = newHistory.nextInt();
		
		System.out.println("Enter the name of the pet: ");
		String nameNP = newPet.next();
		
		System.out.println("Enter the age of the pet:");
		double ageNP = newPet.nextDouble();
		
		System.out.println("Enter the weight of the pet: ");
		double weightNP = newPet.nextDouble();
		
		System.out.println("What kind of pet is it? (D for dog, C for cat, B for bird, O for other)");
		char typeNP = newPet.next().charAt(0);
		
		System.out.println("Enter the height of the pet:");
		double heightNP = newPet.nextDouble();
		
		System.out.println("Enter the day of entry of the pet: ");
		int dayNP = newPet.nextInt();
		
		System.out.println("Enter the month of entry of the pet: ");
		int monthNP = newPet.nextInt();
		
		System.out.println("Enter the year of entry of the pet: ");
		int yearNP = newPet.nextInt();
		
		Date registerDatePet = new Date(dayNP, monthNP, yearNP);
		
		System.out.println("Enter the name of the owner of the pet:");
		String nameNC = newClient.next();
		
		System.out.println("Enter the ID of the owner:");
		int idNC = newClient.nextInt();
		
		System.out.println("Enter the direction of the owner:");
		String dirNC = newClient.next();
		
		System.out.println("Enter the phone of the owner:");
		int phoneNC = newClient.nextInt();
		
		System.out.println("Enter the symptoms of the pet:");
		String symNP = newHistory.next();
		
		System.out.println("Enter the diagnosis of the pet:");
		String diaNP = newHistory.next();
		
		
		String message = theVeterinary.newClinicHistoryV(idch, symNP, diaNP, registerDatePet, nameNP, ageNP, weightNP, typeNP, heightNP, nameNC, idNC, dirNC, phoneNC);
		return message;
	}
	
	/**
	 * busyRoom
	 * This method confirms if a room is busy
	 * @return mmessage confirming if a room is busy
	 */
	public String busyRoom() {
		Scanner busy = new Scanner(System.in);
		
		System.out.println("Enter the number of the room:");
		int x = busy.nextInt();
		
		String message = theVeterinary.busyRoomV(x);
		return message;
	}
	
	/**
	 * updateClient
	 * This method updates the information of a client
	 * @return message confirming that the information is updated
	 */
	public String updateClient() {
		Scanner update = new Scanner(System.in);
		
		System.out.println("Enter the id of the client");
		int idc = update.nextInt();
		
		System.out.println("Enter the new phone number of the client");
		int pnc = update.nextInt();
		
		System.out.println("Enter the new direction of the client");
		String dirc = update.next();
		String msg = theVeterinary.updateClientV(idc, pnc, dirc);
		return msg;
	}
}
	
