package com.org.util;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class Address implements  Serializable
{
	
	public Address(int pincode, String district, String vilName, String doorNo) {
		super();
		this.pincode = pincode;
		District = district;
		this.vilName = vilName;
		this.doorNo = doorNo;
	}
	public Address()
	{
		
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getDistrict() {
		return District;
	}
	public void setDistrict(String district) {
		District = district;
	}
	public String getVilName() {
		return vilName;
	}
	public void setVilName(String vilName) {
		this.vilName = vilName;
	}
	public String getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	private int pincode;
	private String District;
	private String vilName;
	private String doorNo;

}
