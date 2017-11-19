package com.qbabor4.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class PersonalData {

	@GenericGenerator(name = "generator", strategy = "foreign",parameters = @Parameter(name = "property", value = "emp1"))
	@Id
	@GeneratedValue(generator = "generator")
	private Integer Id; // id employee
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Employee1 emp1;
	
	private String username;
	private String email;

	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getUsername() {
		return username;
	}
	public Employee1 getEmp1() {
		return emp1;
	}
	public void setEmp1(Employee1 emp1) {
		this.emp1 = emp1;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
