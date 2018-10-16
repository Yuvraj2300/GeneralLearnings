package com.learn.mvc.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "singer")
public class Singer implements Serializable {

	private static final long serialVersionUID = -7499015218586134948L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Version
	@Column(name = "VERSION")
	private int version;
	@NotEmpty(message = "{validation.firstname.NotEmpty.message}")
	@Size(min = 3, max = 60, message = "{validation.firstname.Size.message}")
	@Column(name = "FIRST_NAME")
	private String firstName;
	@NotEmpty(message = "{validation.lastname.NotEmpty.message}")
	@Size(min = 1, max = 40, message = "{validation.lastname.Size.message}")
	@Column(name = "LAST_NAME")
	private String lastName;
	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTH_DATE")
	private Date birthDate;
	@Column(name = "DESCRIPTION")
	private String description;

	@Basic(fetch = FetchType.LAZY)
	@Lob
	@Column(name = "PHOTO")
	private byte[] photo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	@Transient
	public String getBirthDateString() {
		String birthDateString = "";
		if (birthDate != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			birthDateString = sdf.format(birthDate);
		}
		return birthDateString;
	}

	@Override
	public String toString() {
		return "Singer - Id: " + id + ", First name: " + firstName + ", Last name: " + lastName + ", Birthday: "
				+ birthDate + ", Description: " + description;
	}
}
