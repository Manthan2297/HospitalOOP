package edu.depaul;


public class Deases_X extends Patient {
	private boolean antigen;

	public Deases_X(int id, String fname, String lName, int age,boolean pcr, boolean antigen) {
		super(id, fname, lName, age, pcr);
		antigen = antigen;
	}

	public  boolean isantigen() {
		return antigen;
	}

	public static void setAntigen(boolean antigen) {
		antigen = antigen;
	}
	
	

	
	
	@Override
	public String toString() {
		return super.toString() + "Antigen" + antigen;
	}
}
