package edu.depaul;


import java.util.*;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Patient> patients = new ArrayList<>();
		Scanner scans = new Scanner(System.in);
		/*
		 * ArrayList<Covid19Patient> covidpatient = new ArrayList<>();
		 * ArrayList<RegularPatient> Regpatient = new ArrayList<>(); ArrayList<Deases_X>
		 * Xpatient = new ArrayList<>();
		 */
		//System.out.println(" Select Your Option");
		System.out.println("1 Admit Patient");
		System.out.println("2 Patient Informtion");
		System.out.println("3 Submit a PCR test Result");
		System.out.println("4 Do rounds");
		System.out.println("5 Discharge Patient");
		System.out.println("6 Exit");
		
		
		int Select = 0;
		
		while (Select != 6) {
			System.out.println("Select your Option ::");
			Select  = scans.nextInt();
		
			switch(Select) {
				case 1:
					Admitpatient(scans, patients);
				
					break;
				case 2:
					PatientInf(scans, patients);
					break;
					
				case 3:
					PCRreport(scans, patients);
					break;
					

				case 4:
					Do_rounds(scans, patients);
					break;

				case 5:
					Discharge(scans, patients);
					break;

				case 6 :
					System.out.println("Exit");
					break;

				default:
					System.out.println("Invalid choice. Please try again.");
					break;
			}
		}
	}
	

	public static void Admitpatient(Scanner scans, ArrayList<Patient> patients) {
	  
		System.out.println("Enter the Patient Detail");
		//ID number
		System.out.print("Enter patient ID number :");
		if (!scans.hasNextInt()) {
		   System.out.println("Invalid input. Please enter a valid ID in number.");
		   scans.next();
		   return;

		}
		int id = scans.nextInt();
		try {
			for (Patient patient : patients) {
				if (patient.getId() == id) {
					System.out.println("Patient with ID " + id + " already exists.");
					return; 
				}
			}
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return;
		}
		//First Name
		System.out.print("Enter patients First Name :");
		String fname = scans.next();
		try{
			if ((fname == null) || (!fname.matches("[a-zA-Z]+")) ){
				throw new IllegalArgumentException("First Name cannot be null or must be in alphabets only.");
			}
		}
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return;
		}
		
		//Last Name
		System.out.print("Enter patients Last Name :");
		String lName = scans.next();
		try{
			if ((lName == null) || (!lName.matches("[a-zA-Z]+"))) {
				throw new IllegalArgumentException("Last Name cannot be null or must be in alphabets only.");
			}
		}
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return;
		}
		
		
		//Age
		System.out.print("Enter patients Age :");
		if (!scans.hasNextInt()) {
			System.out.println("Invalid input. Please enter a valid age in number.");
			scans.next();
			return;
		}
		int age = scans.nextInt();
		try {
			if (age <= 0) {
				throw new IllegalArgumentException("Age cannot be negative or zero");
			}
		}
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return;
		}
		
		
		
		


		
		//PCr
		System.out.print("Enter new PCR test result (positive/negative): ");
		String PCR = scans.next().toLowerCase(); 
		boolean Pcr;
		if (PCR.equals("positive")) {
			Pcr = true;
        } else if (PCR.equals("negative")) {
        	Pcr = false;
        } else {
        	System.out.println("Invalid input. Please enter 'positive' or 'negative'.");
			return;
        }
		
		
	
		
		if (PCR.equals("positive")) {
			//ANTIGEN
			System.out.print("Enter Antigen test result (positive/negative): ");
			String Antigen = scans.next().toLowerCase();

			boolean antigen;
			if (Antigen.equals("positive")) {
				antigen = true;
			} else if (Antigen.equals("negative")) {
				antigen = false;
			} else {
				System.out.println("Invalid input. Please enter 'positive' or 'negative'.");
				return; 
			}
			if (Antigen.equals("positive")) {
				
				patients.add(new Deases_X(id, fname, lName, age,Pcr, antigen));
			
				
				
				
				
			}
			else if(Antigen.equals("negative")) {
				System.out.print("Enter temperature :");
				double temp = scans.nextDouble();
				patients.add(new Covid19Patient(id, fname, lName, age, Pcr, temp));
				
			}
		}

		else if (PCR.equals("negative")) {
			System.out.print("Enter Mainsymptoms :");
			String mainSymptoms = scans.next();
			
			patients.add(new RegularPatient(id, fname, lName, age, Pcr,mainSymptoms));
		
		}
		
			
		System.out.println("Patient added successfully");
						
		
	}
		
	
	
	

		
		
			
	public static void PatientInf(Scanner scans,ArrayList<Patient> patients) {
		System.out.println("Patient Information enter the ID number :");
		
		if(!scans.hasNextInt()) {
			System.out.println("Invalid input. Please enter a valid ID in number.");
			scans.next();
			return;
		}
		
		int id = scans.nextInt();
		for (Patient patient : patients) {	
			if (patient.getId() == id) {
				System.out.println("Patient found with id: " + id);
				System.out.println("----------------------------------------");
				System.out.print("ID = " + patient.getId()+"\n");
				System.out.print("First name = " + patient.getFname()+"\n");
				System.out.print("Last Name = " + patient.getLName()+"\n");
				System.out.print("Age = "+ patient.getAge()+"\n");
				System.out.print("Pcr Detail ="+ patient.isPcr()+"\n");
				 
				System.out.println("----------------------------------------");
				patient.toString();
				
			}
		
			else if(patient.getId() != id) { 
					System.out.println("Patient not found with id: " + id);
					break;
			}
		break;
		}
	}
	
	public static void PCRreport(Scanner scans, ArrayList<Patient> patients) {
				// TODO Auto-generated method stub
		 	System.out.print("Enter ID Number :");
		  
			if (!scans.hasNextInt()) {
				  System.out.println("Invalid input. Please enter a valid ID in number.");
				  scans.next();
				  return;
			}
			int id = scans.nextInt();
			for (Patient patient : patients) {
				if (patient.getId() == id) {
					System.out.print("PCR test report is "+ patient.isPcr()+"\n");
					
					break;
				}
				if(patient.getId() != id)  
		        	System.out.println("Patient not found with id: " + id);
			    }
			}
		
		
	public static void Do_rounds(Scanner scans, ArrayList<Patient> patients) {
		// TODO Auto-generated method stub
		System.out.println("Enter the Patient ID number");
		if (!scans.hasNextInt()) {
		    System.out.println("Invalid input. Please enter a valid ID in number.");
		    scans.next();
		    return;
		}
		int id = scans.nextInt();
		for (Patient patient : patients) {
			if(patient.getId() == id) {
					if (patient instanceof Deases_X) {
						System.out.println("Select Gender (Male/Female):");
						String Gender = scans.next().toLowerCase();
						if(Gender.equals("female")) {
							System.out.println("Enter the patient pregnancy status (Yes/No): ");
							String Pregnant = scans.next().toLowerCase();
							
							if (Pregnant.equals("yes")) {
									System.out.println("Treating Patient with REGEN-COV");
							} 
							else if(Pregnant.equals("no")) {
									System.out.println("Treating Patient with REGEN-COV and need to take therapeuic dose of heparin");
							}
						}
						else {
							System.out.println("Treatment for patient with Deases X is REGEN-COV");
							break;
							}
							
					}
					
				
					else if(patient instanceof Covid19Patient) {
						
						System.out.println("Patient need the Treatment "+  ((Covid19Patient) patient).treat() );
						
						break;
					}
		
				
					else if (patient instanceof RegularPatient) {
					
					System.out.println("Patient need the Treatment "+ ((RegularPatient) patient).treat()	);
					 break;
					}
			}
		
			else  {
				System.out.println("Patient not found with id: " + id);
	        break;
				}
			
		}
		
			
	}
				
	

		
	

	public static void Discharge(Scanner scans, ArrayList<Patient> patients) {
		// TODO Auto-generated method stub
		System.out.print("Enter ID Number :");
		if (!scans.hasNextInt()) {
		    System.out.println("Invalid input. Please enter a valid ID in number.");
		    scans.next();
		    return;
		}
		int ID = scans.nextInt();
		
		System.out.print("Enter new PCR test result (positive/negative): ");
		String PCR = scans.next().toLowerCase(); 
		boolean Pcr;
		if (PCR.equals("positive")) {
			Pcr = true;
        } else if (PCR.equals("negative")) {
        	Pcr = false;
        } else {
        	System.out.println("Invalid input. Please enter 'positive' or 'negative'.");
            return; 
        }
			
		for (Patient patient : patients) {
			for (int i = 0; i < patients.size(); i++) {
				if(PCR.equals("negative")|| Pcr == false || patient.isPcr() == false)	{


					patients.remove(i);

					System.out.println("Patient with ID " + ID + " discharged successfully.");
					break;
				}
				else {
					System.out.println("Patient with ID " + ID + " cannot be discharged PCR is still Positive.");
					break;
				}
			}
			if (patient.getId() != ID) {  
	        	System.out.println("Patient not found with id: " + ID);
		}
			break;
		}

		 
			
			
	}
	
}
			
		
	

