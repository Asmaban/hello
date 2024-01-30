package com.example.demo;
import jakarta.persistence.*;

@Entity
public class Adress {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
    private String zipCode;
    
	public Adress(Long id, String street, String city, String zipCode) {
		super();
		this.id = id;
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
	}
	
	public Adress() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Adress [id=" + id + ", street=" + street + ", city=" + city + ", zipCode=" + zipCode + "]";
	}
	
	
    
    

}
