package com.example.demo;
import jakarta.persistence.*;
@Entity


public class Cycle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String model;
	
	@OneToOne
	@JoinColumn(name = "bicycle_id")
	private Bicycle bicycle;

	public Cycle(Long id, String model, Bicycle bicycle) {
		super();
		this.id = id;
		this.model = model;
		this.bicycle = bicycle;
	}

	public Cycle() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Bicycle getBicycle() {
		return bicycle;
	}

	public void setBicycle(Bicycle bicycle) {
		this.bicycle = bicycle;
	}

	@Override
	public String toString() {
		return "Cycle [id=" + id + ", model=" + model + ", bicycle=" + bicycle + "]";
	}
	
	
	

}
