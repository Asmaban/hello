package com.example.demo;

import jakarta.persistence.*;

@Entity
public class Movies {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	
	@ManyToOne
	@JoinColumn(name="peerson_id")
	private Peerson person;

	public Movies(Long id, String title, Peerson person) {
		super();
		this.id = id;
		this.title = title;
		this.person = person;
	}

	public Movies() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Peerson getPerson() {
		return person;
	}

	public void setPerson(Peerson person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Movies [id=" + id + ", title=" + title + ", person=" + person + "]";
	}
	
	

}
