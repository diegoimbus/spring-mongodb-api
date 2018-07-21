package com.co.intrasoft.documents;

import org.hibernate.validator.constraints.NotEmpty;

public class Assignment {
	
	private String state;
	private String personName;
	private Area area;
	
	public Assignment() {
	}

	@NotEmpty(message = "Actual state cannot be void")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

}
