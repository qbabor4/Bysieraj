package com.qbabor4.hibernate.model.book;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

public class Author {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "UUID", nullable = false, columnDefinition = "BINARY(16)")
	private UUID id;
	@Column(name = "NAME", nullable = false, length = 40)
	private String name;
	@Column(name = "SURNAME", nullable = false, length = 40)
	private String surname;
	@Column(name = "BIRTH", nullable = false, length = 40)
	private int birth;
	@Column(name = "DEATH", nullable = false, length = 40)
	private Integer death;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	public int getBirth() {
		return birth;
	}

	public void setBirth(int birth) {
		this.birth = birth;
	}

	public Integer getDeath() {
		return death;
	}

	public void setDeath(Integer death) {
		this.death = death;
	}

}
