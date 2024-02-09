package edu.depaul;

public class Covid19Patient extends Patient {
	private Double temperature;		

	public Covid19Patient(int id, String fname, String lName, int age,boolean pcr,  double temperature) {
		super(id,fname,lName,age, pcr);
		this.temperature = temperature;
		
	}
	
	
	public Double getTemperature() {
		return temperature;
	}

	public   void setTemperature(Double temperature) {
		this.temperature = temperature;
	}
	
	
	public String treat() {
		if ( temperature > 36.5 && getAge() > 59 ){
			return "Paxlovid";
		}
		else if (temperature > 40) {
			return " Dexamethasone";
		
		}
		else {
			return "Fluid and Acetaminophen";
		}
	}
	
	@Override
	public String toString(){
		return super.toString() + "Temperature" + temperature+ "PCR test :" + isPcr() +"Treamtment :"+ treat();
	}
		
}

	

