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
@Table(name = "User", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) }) // moze sie da bez tego
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
	private PersonalData2 personalData2;

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

	public PersonalData2 getPersonalData2() {
		return personalData2;
	}

	public void setPersonalData2(PersonalData2 personalData2) {
		this.personalData2 = personalData2;
	}

}
