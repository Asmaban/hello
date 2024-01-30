package com.example.demo;

import jakarta.persistence.*;

@Entity
public class Person {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Adress adress;

	public Person(Long id, String name, Adress adress) {
		super();
		this.id = id;
		this.name = name;
		this.adress = adress;
	}
    
    public Person() {
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", adress=" + adress + "]";
	}
    
    


}
