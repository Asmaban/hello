package com.example.demo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity

public class Studeent {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String dob;
	private String classes;
	private String division;
	private String gender;

	@OneToOne
	private Address address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Studeent [id=" + id + ", name=" + name + ", dob=" + dob + ", classes=" + classes + ", division="
				+ division + ", gender=" + gender + ", address=" + address + "]";
	}

	public Studeent(int id, String name, String dob, String classes, String division, String gender, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.classes = classes;
		this.division = division;
		this.gender = gender;
		this.address = address;
	}
	
	public Studeent() {
		
	}

}
