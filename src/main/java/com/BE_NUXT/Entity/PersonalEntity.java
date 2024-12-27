package com.BE_NUXT.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "personal")
public class PersonalEntity {

	@Id
	private int id;
	@Column(length = 30)
	private String firstname;
	@Column(length = 30)
	private String lastname;
	@Column(length = 30)
	private String email;
	@Column(length = 14)
	private String phone;
	@Column(length = 30)
	private String adresse;
	@Column(length = 40)
	private String region;
	@Column(length = 50)
	private String pays;
	
	public PersonalEntity(int id, String firstname, String lastname, String email, String phone, String adresse,
			String region, String pays) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.adresse = adresse;
		this.region = region;
		this.pays = pays;
	}

	public PersonalEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}
	
	
	
}
