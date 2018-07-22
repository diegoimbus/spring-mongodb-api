package com.co.intrasoft.documents;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Asset {

	@Id
	private String id;
	private String name;
	private String description;
	private String type;
	private String serial;
	private String invNumber;
	private String weight;
	private String high;
	private String wide;
	private String length;
	private String value;
	private String color;
	private Assignment assignment;
	private String pDate; // yyyy-MM-dd
	private String dDate; // yyyy-MM-dd
	
	public Asset() {	
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@NotEmpty(message = "Name cannot be void")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotEmpty(message = "Description cannot be void")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@NotEmpty(message = "Type cannot be void")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@NotEmpty(message = "Serial cannot be void")
	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	@NotEmpty(message = "Internal inventory number cannot be void")
	public String getInvNumber() {
		return invNumber;
	}

	public void setInvNumber(String invNumber) {
		this.invNumber = invNumber;
	}

	@NotEmpty(message = "Weight cannot be void")
	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	@NotEmpty(message = "High cannot be void")
	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	@NotEmpty(message = "Wide cannot be void")
	public String getWide() {
		return wide;
	}

	public void setWide(String wide) {
		this.wide = wide;
	}

	@NotEmpty(message = "Length cannot be void")
	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	@NotEmpty(message = "Value of purchase cannot be void")
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@NotEmpty(message = "Date of purchase cannot be void")
	public String getpDate() {
		return pDate;
	}

	public void setpDate(String pDate) {
		this.pDate = pDate;
	}

	@NotEmpty(message = "Discharge date cannot be void")
	public String getdDate() {
		return dDate;
	}

	public void setdDate(String dDate) {
		this.dDate = dDate;
	}

	@NotEmpty(message = "Color cannot be void")
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}


	public Assignment getAssignment() {
		return assignment;
	}

	
	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}
}
