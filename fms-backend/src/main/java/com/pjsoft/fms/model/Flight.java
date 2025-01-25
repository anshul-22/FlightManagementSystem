package com.pjsoft.fms.model;

import java.math.BigInteger;

import org.hibernate.validator.constraints.UniqueElements;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message="Flight No cannot be null")
    @Column(nullable = false, unique = true)
    private BigInteger flightNo;

    @NotNull(message="Carrier Name cannot be null")
    @Column(nullable = false)
    private String carrierName;

    @NotNull(message="Flight Model cannot be null")
    @Column(nullable = false)
    private String flightModel;

    @NotNull(message="Seat Capacity cannot be null")
    @Column(nullable = false)
    private int seatCapacity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigInteger getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(BigInteger flightNo) {
		this.flightNo = flightNo;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public String getFlightModel() {
		return flightModel;
	}

	public void setFlightModel(String flightModel) {
		this.flightModel = flightModel;
	}

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}
    

}