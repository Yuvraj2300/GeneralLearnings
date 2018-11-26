package com.learn.validation.entities;

public enum Gender {
	MALE("M"), FEMALE("F");
	private String code;

	Gender(String code) {
		this.code = code;
	}

	public String toString() {
		return this.code;
	}
}
