package com.example.demo;

import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Moviee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	
	@ManyToMany
	@JoinTable(name = "movie_person",
	joinColumns = @JoinColumn(name = "movie_id"),
	inverseJoinColumns = @JoinColumn (name = "person_id"))
	private Set<Peerson> person;

	public Moviee(Long id, String title, Set<Peerson> person) {
		super();
		this.id = id;
		this.title = title;
		this.person = person;
	}

	public Moviee() {
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

	public Set<Peerson> getPerson() {
		return person;
	}

	public void setPerson(Set<Peerson> person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Moviee [id=" + id + ", title=" + title + ", person=" + person + "]";
	}
	
	
	

}
