package edu.depaul;

public class RegularPatient extends  Patient{
		private String mainSymptoms;
		
		


		public RegularPatient(int id, String fname, String lName, int age,boolean pcr,String mainSymptoms) {
			super(id,fname,lName,age, pcr);
			mainSymptoms = mainSymptoms;
		}
		

		public String getMainSymptoms() {
			return mainSymptoms;
		}

		public static void setMainSymptoms(String mainSymptoms) {
			mainSymptoms = mainSymptoms;
		}
		
		public String treat() {
			if (mainSymptoms == "coughing" || mainSymptoms == "runny nose" || mainSymptoms == "stuffy nose" ) {
				return "Amoxicillin" ;
			}
			else if (mainSymptoms == "hypertension") {
				return "ACE inibitors";
				
			}
			else {
				return "IV Fluids";
			}
		};




		@Override
		public String toString() {
			return super.toString() + "mainSymptoms=" + mainSymptoms + isPcr()+ ", Treatment=" + treat() ; 
		}
		

	}


