package com.example.demo;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Peerson {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String movieName;
	private String seatNo;
	
	@OneToMany(mappedBy = "peerson", cascade = CascadeType.ALL)
	private List<Movies> movies;

	public Peerson(Long id, String name, String movieName, String seatNo, List<Movies> movies) {
		super();
		this.id = id;
		this.name = name;
		this.movieName = movieName;
		this.seatNo = seatNo;
		this.movies = movies;
	}

	public Peerson() {
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

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public List<Movies> getMovies() {
		return movies;
	}

	public void setMovies(List<Movies> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "Peerson [id=" + id + ", name=" + name + ", movieName=" + movieName + ", seatNo=" + seatNo + ", movies="
				+ movies + "]";
	}
	
	
	

}
