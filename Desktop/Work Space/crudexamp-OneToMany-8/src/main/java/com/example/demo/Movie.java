package com.example.demo;
import java.util.Set;

import jakarta.persistence.*;

@Entity

public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;

	@ManyToOne
	@JoinColumn(name = "person_id")
	private Pperson person;

	public Movie(Long id, String title, Pperson person) {
		super();
		this.id = id;
		this.title = title;
		this.person = person;
	}

	public Movie() {
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

	public Pperson getPerson() {
		return person;
	}

	public void setPerson(Pperson person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", person=" + person + "]";
	}
	
	
	

}
