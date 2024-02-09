package edu.depaul;

abstract  class Patient {
	private int id;
	private String fname;
	private String lName;
	private int age;
	private boolean pcr;
	
	
	
	
	
	public Patient(int id, String fname, String lName, int age, boolean pcr) {
		this.id = id;
		this.fname = fname;
		this.lName = lName;
		this.age = age;
		this.pcr = pcr;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLName() {
		return lName;
	}
	public void setLName(String lName) {
		this.lName = lName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isPcr() {
		return pcr;
	}
	public void setPcr(boolean pcr) {
		this.pcr = pcr;
	}
	
	
	public interface treat {
		public String treat();
		
	}

	public String toString() {
		return "ID =" + id + "First name =" + fname + "Last Name =" + lName + "Age =" + age + "Pcr Detail =" + pcr;
	}
}
	
	
	
