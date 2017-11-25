package com.qbabor4.hibernate.model.user;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * TODO: generować uuid (jakiś błąd chyba jest) (uuid z usera jest inne od uuid
 * z group) (wywalić czerwony krzyzyk) zapisywac camelcase, ale do tabeli
 * dodawac inaczej group do user chyba bedzi wiele do wielu
 * 
 * @author Jakub Borówka
 */

@Entity
@Table(name = "USER") // , uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) }
public class User {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	// @Column(name = "ID", nullable = false, unique = true, length = 11)
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "UUID", nullable = false, columnDefinition = "BINARY(16)")
	private UUID id;
	@Column(name = "UNAME", nullable = false, unique = true, length = 40)
	private String uname;
	@Column(name = "PASSWD", nullable = false, length = 40)
	private String passwd;
	@Column(name = "EMAIL", nullable = false, unique = true, length = 40)
	private String email;
	@Column(name = "USER_PRIVILEGES", length = 6)
	private Integer userPrivileges;
	@Column(name = "ENABLED")
	private Boolean enabled;
	@Column(name = "LAPSE_PASS")
	private Boolean lapsePasswd;
	@Column(name = "LAPSE_TIME")
	private Integer lapseTime;
	@Temporal(TemporalType.DATE)
	@Column(name = "PASSWD_SET")
	private java.util.Date passwdSet;
	@Column(name = "FORCE_CHANGE")
	private Boolean forceChange;

	// łączenia tabel
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	private PersonalData personalData;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	private PasswdHistory passwdHistory;

	public Integer getUserPrivileges() {
		return userPrivileges;
	}

	public void setUserPrivileges(Integer userPrivileges) {
		this.userPrivileges = userPrivileges;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean getLapsePasswd() {
		return lapsePasswd;
	}

	public void setLapsePasswd(Boolean lapsePasswd) {
		this.lapsePasswd = lapsePasswd;
	}

	public Integer getLapseTime() {
		return lapseTime;
	}

	public void setLapseTime(Integer lapseTime) {
		this.lapseTime = lapseTime;
	}

	public java.util.Date getPasswdSet() {
		return passwdSet;
	}

	public void setPasswdSet(java.util.Date passwdSet) {
		this.passwdSet = passwdSet;
	}

	public Boolean getForceChange() {
		return forceChange;
	}

	public void setForceChange(Boolean forceChange) {
		this.forceChange = forceChange;
	}

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

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
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
