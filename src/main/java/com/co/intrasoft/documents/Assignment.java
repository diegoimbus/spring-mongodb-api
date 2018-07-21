package com.co.intrasoft.documents;

import org.hibernate.validator.constraints.NotEmpty;

public class Assignment {

	public static final int ACTIVO = 1;
	public static final int DADO_DE_BAJA = 2;
	public static final int EN_REPARACION = 3;
	public static final int DISPONIBLE = 4;
	public static final int ASIGNADO = 5;
	private int state;
	private String personName;
	private Area area;
	
	public Assignment() {
	}

	@NotEmpty(message = "Actual state cannot be void")
	public int getState() {
		return state;
	}

	public void setState(int state) {
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
