package com.qbabor4.hibernate.model.user;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * TODO: jak bedia w mobile jakieś -, +, spacje to Parsowanie do intigera Czemu
 * w parameter ma być "user" Zobaczyc lazy i eadger
 * 
 * @author Jakub
 */
@Entity
public class PersonalData {

	@Id
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "user"))
	@GeneratedValue(generator = "generator")
	@Column(name = "UUID", nullable = false, columnDefinition = "BINARY(16)")
	private UUID Id; // uuid of User

	@Column(name = "NAME", length = 40)
	private String name;
	@Column(name = "SURNAME", length = 40)
	private String surname;
	@Column(name = "MOBILE", length = 40)
	private String mobile;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private User user;

	public UUID getId() {
		return Id;
	}

	public void setId(UUID id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
