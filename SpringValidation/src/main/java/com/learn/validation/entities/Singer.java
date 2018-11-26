package com.learn.validation.entities;

import java.net.URL;
import java.text.SimpleDateFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.joda.time.DateTime;

public class Singer {
	@NotNull
	@Size(min = 2, max = 60)
	private String firstName;

	private String lastName;

	@NotNull
	private Genre genre;

//	Gender can be null as the can be either a male or female or a gay.
//	So no validation applied on this field.
	private String gender;

	/*
	 * private DateTime birthDate; 
	 * private URL personalSite;
	 * 
	 */

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
