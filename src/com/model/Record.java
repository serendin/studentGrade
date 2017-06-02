package com.model;

import java.util.Date;

public class Record {
	private String carid;
	private String carType;
	private Date enter;
	private Date exit;
	private double cost;
	private double stopTime;

	public String getCarid() {
		return carid;
	}

	public void setCarid(String carid) {
		this.carid = carid;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public Date getEnter() {
		return enter;
	}

	public void setEnter(Date enter) {
		this.enter = enter;
	}

	public Date getExit() {
		return exit;
	}

	public void setExit(Date exit) {
		this.exit = exit;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getStopTime() {
		return stopTime;
	}

	public void setStopTime(double stopTime) {
		this.stopTime = stopTime;
	}

}
