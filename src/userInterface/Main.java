package userInterface;
import java.util.Scanner;

import model.*;

public class Main {
	private String message;
	private Vet theVeterinary;

	public Main() {
		theVeterinary = new Vet("The Veterinary");
	}

	public static void main(String[] args) {
		Main objMain = new Main();
		System.out.println("	Welcome to My Little Pet\n");
		objMain.menu();
	}
	
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
			System.out.println("10- Exit");
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
					msg = "sib ntsib dua";
					System.out.println(msg);
					end = false;
					break;
				default:
					msg = "Error: this number can't be evaluated";
					System.out.println(msg);
			}
		}
		
	}
	
	public String showClinicHistoryM() {
		Scanner show = new Scanner(System.in);
		
		System.out.println("Enter the id of the owner of the pet");
		int id = show.nextInt();
		System.out.println("Enter the name of the pet");
		String np = show.next();
		
		String msg = theVeterinary.showClinicHistoryV(id, np);
		return msg;
	}
	
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
		
		System.out.println("Enter the name of the owner of the pet:");
		String nnc = add.next();
		
		System.out.println("Enter the ID of the owner:");
		int idnc = add.nextInt();
		
		System.out.println("Enter the direction of the owner:");
		String dirnc = add.next();
		
		System.out.println("Enter the phone of the owner:");
		int pnc = add.nextInt();
		
		theVeterinary.addPetV(nnp, anp, wnp, tnp, nnc, idnc, dirnc, pnc);
	}
	
	public String erasePet() {
		Scanner erase  = new Scanner(System.in);
		
		System.out.println("Enter the id of the owner of the pet");
		int nce = erase.nextInt();
		System.out.println("Enter the name of the pet that you want to erase");
		String npe = erase.next();
		
		String msg = theVeterinary.erasePetV(nce, npe);
		return msg;
	}
	
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

	public String searchPetM() {
		Scanner searchPet = new Scanner(System.in);
		
		System.out.println("Enter the pet's name:");
		String petNameSearch = searchPet.next();
		System.out.println("Enter the owner's id:");
		int id = searchPet.nextInt();
		String msg = theVeterinary.searchPetV(petNameSearch, id);
		return msg;
	}
	
	public String searchClientM() {
		Scanner searchClient = new Scanner(System.in);
		System.out.println("Enter the identification of the client");
		int idSearch = searchClient.nextInt();
		String msg = theVeterinary.searchClientV(idSearch);
		return msg;
	}
	
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
	
	public String newClinicHistoryM() { //method to create a clinic history 
		Scanner newPet = new Scanner(System.in);
		Scanner newClient = new Scanner(System.in);
		Scanner newHistory = new Scanner(System.in);
		
		System.out.println("	New Clinic History");
		
		System.out.println("Enter the name of the pet: ");
		String nameNP = newPet.next();
		
		System.out.println("Enter the age of the pet:");
		double ageNP = newPet.nextDouble();
		
		System.out.println("Enter the weight of the pet: ");
		double weightNP = newPet.nextDouble();
		
		System.out.println("What kind of pet is it? (D for dog, C for cat, B for bird, O for other)");
		char typeNP = newPet.next().charAt(0);
		
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
		
		Detail petDetailCH = new Detail(symNP, diaNP, registerDatePet);
		
		String message = theVeterinary.newClinicHistoryV(nameNP, ageNP, weightNP, typeNP, petDetailCH, nameNC, idNC, dirNC, phoneNC);
		return message;
	}
	
	public String busyRoom() {
		Scanner busy = new Scanner(System.in);
		
		System.out.println("Enter the number of the room:");
		int x = busy.nextInt();
		
		String message = theVeterinary.busyRoomV(x);
		return message;
	}
}
	
