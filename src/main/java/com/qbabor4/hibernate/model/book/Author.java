package com.qbabor4.hibernate.model.book;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
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
	@Column(name = "DEATH", length = 40)
	private Integer death;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="Book_Author_many_to_many", joinColumns = @JoinColumn(name="AUTHOR_UUID"), inverseJoinColumns=@JoinColumn(name="Book_UUID"))
	private List<Book> bookEntities = new ArrayList<>();

	public List<Book> getBookEntities() {
		return bookEntities;
	}

	public void setBookEntities(List<Book> bookEntities) {
		this.bookEntities = bookEntities;
	}

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
