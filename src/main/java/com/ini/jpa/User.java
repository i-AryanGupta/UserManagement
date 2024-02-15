package com.ini.jpa;

import javax.persistence.Id;


@javax.persistence.Entity
public class User {
	
	@Id
	private int ID;
	private String Name;
	private String Email;
	private String DOB;
	private String Country;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	
	
	@Override
	public String toString() {
		return "User [ID=" + ID + ", Name=" + Name + ", Email=" + Email + ", DOB=" + DOB + ", Country=" + Country + "]";
	}
	
	
	
	

}
