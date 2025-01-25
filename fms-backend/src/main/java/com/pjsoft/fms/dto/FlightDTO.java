package com.pjsoft.fms.dto;

import java.math.BigInteger;



public class FlightDTO {

    private Long id;

    private BigInteger flightNo;

    private String carrierName;

    private String flightModel;

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
