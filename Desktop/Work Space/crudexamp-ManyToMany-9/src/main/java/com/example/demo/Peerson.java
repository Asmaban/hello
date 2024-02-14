package com.example.demo;

import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Peerson {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String seatNo;
	private String ticketPrice;
	private String movieName;
	
	@ManyToMany(mappedBy = "person")
	private Set<Moviee> moviee;

	public Peerson(Long id, String name, String seatNo, String ticketPrice, String movieName, Set<Moviee> moviee) {
		super();
		this.id = id;
		this.name = name;
		this.seatNo = seatNo;
		this.ticketPrice = ticketPrice;
		this.movieName = movieName;
		this.moviee = moviee;
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

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public String getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(String ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Set<Moviee> getMoviee() {
		return moviee;
	}

	public void setMoviee(Set<Moviee> moviee) {
		this.moviee = moviee;
	}

	@Override
	public String toString() {
		return "Peerson [id=" + id + ", name=" + name + ", seatNo=" + seatNo + ", ticketPrice=" + ticketPrice
				+ ", movieName=" + movieName + ", moviee=" + moviee + "]";
	}
	
	
	

}
