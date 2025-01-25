package com.pjsoft.fms.model;

import com.pjsoft.fms.exception.ResourceNotFoundException;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
public class Airport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Size(min = 3,message = "Code should be more than 3 chars")
	@Column(nullable = false)
	private String code;
	
	@NotNull(message="Airport name cannot be null")
	@Column(nullable = false)
	private String name;
	
	@NotNull(message="City name cannot be null")
	@Column(nullable = false)
	private String city;
	
	@NotNull(message="Country name cannot be null")
	@Column(nullable = false)
	private String country;
	
	@NotNull(message="Latitude cannot be null")
	@Column(nullable = false)
	private double latitude;
	
	@NotNull(message="Longitude cannot be null")
	@Column(nullable = false)
	private double longitude;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
		
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	
	

}
