package com.sammas.garage.dto;

public enum Colors {

	RED("Red"),
	WHITE("White"),
	YELLOW("Yellow"),
	BLUE("Blue"),
	BROWN("Brown"),
	PINK("Pink"),
	PURPLE("Purple"),
	BLACK("Black");
	
	private String value;
	
	Colors(String colorValue) {
		this.value = colorValue;
	}

	public String getValue() {
		return value;
	}
	
}
