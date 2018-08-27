package com.Test.RestDB.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "student")
public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4549017058514053780L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_gen")
	@SequenceGenerator(name = "student_gen", sequenceName = "student_seq", initialValue = 1, allocationSize = 1)
	private int id;

	/*
	 * @Id
	 * 
	 * @GenericGenerator( name = "assigned-sequence", strategy =
	 * "com.vladmihalcea.book.hpjp.hibernate.identifier.StringSequenceIdentifier",
	 * parameters = {
	 * 
	 * @org.hibernate.annotations.Parameter( name = "sequence_name", value =
	 * "hibernate_sequence"),
	 * 
	 * @org.hibernate.annotations.Parameter( name = "sequence_prefix", value =
	 * "CTC_"), } )
	 * 
	 * @GeneratedValue( generator = "assigned-sequence", strategy =
	 * GenerationType.SEQUENCE) private String id;
	 * 
	 */

	private String name;

	private String rollnumber;

	@Transient
	private String version;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRollnumber() {
		return rollnumber;
	}

	public void setRollnumber(String rollnumber) {
		this.rollnumber = rollnumber;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}