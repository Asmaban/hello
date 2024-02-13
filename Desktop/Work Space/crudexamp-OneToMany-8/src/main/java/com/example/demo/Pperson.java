package com.example.demo;

import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Pperson {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String movieName;

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
	private Set<Movie> movie;

	public Pperson(Long id, String name, String movieName, Set<Movie> movie) {
		super();
		this.id = id;
		this.name = name;
		this.movieName = movieName;
		this.movie = movie;
	}

	public Pperson() {
		super();
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

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Set<Movie> getMovie() {
		return movie;
	}

	public void setMovie(Set<Movie> movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "Pperson [id=" + id + ", name=" + name + ", movieName=" + movieName + ", movie=" + movie + "]";
	}
	
	
	

}
