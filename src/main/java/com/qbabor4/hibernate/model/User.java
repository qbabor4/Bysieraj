package com.qbabor4.hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * TODO: generować uuid (jakiś błąd chyba jest) (uuid z usera jest inne od uuid
 * z group) (wywalić czerwony krzyzyk) zapisywac camelcase, ale do tabeli
 * dodawac inaczej group do user chyba bedzi wiele do wielu
 * 
 * @author Jakub Borówka
 */

@Entity
@Table(name = "USER") // moze sie da bez tego //, uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) }
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true, length = 11)
	// @GeneratedValue(generator = "uuid2")
	// @GenericGenerator(name = "uuid2", strategy = "uuid2")
	// @Column(columnDefinition = "BINARY(16)")
	private long id;

	@Column(nullable = false, unique = true, length = 40)
	private String uname;
	@Column(nullable = false, length = 40)
	private String passwd;
	@Column(nullable = false, unique = true, length = 40)
	private String email;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	private PersonalData personalData;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	private PasswdHistory passwdHistory;

	
	public PersonalData getPersonalData() {
		return personalData;
	}

	public void setPersonalData(PersonalData personalData) {
		this.personalData = personalData;
	}

	public PasswdHistory getPasswdHistory() {
		return passwdHistory;
	}

	public void setPasswdHistory(PasswdHistory passwdHistory) {
		this.passwdHistory = passwdHistory;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
