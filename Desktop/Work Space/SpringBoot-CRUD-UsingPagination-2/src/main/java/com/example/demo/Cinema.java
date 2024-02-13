package com.example.demo;

import jakarta.persistence.*;

@Entity
public class Cinema{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String seatNo;
	private String movieName;
	
	
	public Cinema(Long id, String name, String seatNo, String movieName) {
		super();
		this.id = id;
		this.name = name;
		this.seatNo = seatNo;
		this.movieName = movieName;
	}


	public Cinema() {
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


	public String getMovieName() {
		return movieName;
	}


	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}


	@Override
	public String toString() {
		return "Cinema [id=" + id + ", name=" + name + ", seatNo=" + seatNo + ", movieName=" + movieName + "]";
	}
	
	
	
	

}
