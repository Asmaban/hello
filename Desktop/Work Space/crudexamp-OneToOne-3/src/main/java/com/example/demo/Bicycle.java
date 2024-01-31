package com.example.demo;

import jakarta.persistence.*;
@Entity
public class Bicycle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String brand;
	
	@OneToOne(mappedBy = "bicycle" , cascade = CascadeType.ALL)
	private Cycle cycle;

	public Bicycle(Long id, String brand, Cycle cycle) {
		super();
		this.id = id;
		this.brand = brand;
		this.cycle = cycle;
	}

	public Bicycle() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Cycle getCycle() {
		return cycle;
	}

	public void setCycle(Cycle cycle) {
		this.cycle = cycle;
	}

	@Override
	public String toString() {
		return "Bicycle [id=" + id + ", brand=" + brand + ", cycle=" + cycle + "]";
	}
	
	

}
