package com.supinfo.suptravel.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String campus;

	private String email;

	private String lastname;

	private String name;

	private String password;

	private int studentid;

	//bi-directional many-to-one association to Tripbag
	@OneToMany(mappedBy="userBean")
	private List<Tripbag> tripbags;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCampus() {
		return this.campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStudentid() {
		return this.studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public List<Tripbag> getTripbags() {
		return this.tripbags;
	}

	public void setTripbags(List<Tripbag> tripbags) {
		this.tripbags = tripbags;
	}

	public Tripbag addTripbag(Tripbag tripbag) {
		getTripbags().add(tripbag);
		tripbag.setUserBean(this);

		return tripbag;
	}

	public Tripbag removeTripbag(Tripbag tripbag) {
		getTripbags().remove(tripbag);
		tripbag.setUserBean(null);

		return tripbag;
	}

}