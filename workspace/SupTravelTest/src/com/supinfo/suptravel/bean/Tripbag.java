package com.supinfo.suptravel.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tripbag database table.
 * 
 */
@Entity
@Table(name="tripbag")
@NamedQuery(name="Tripbag.findAll", query="SELECT t FROM Tripbag t")
public class Tripbag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int quantity;

	//bi-directional many-to-one association to Trip
	@ManyToOne
	@JoinColumn(name="trip")
	private Trip tripBean;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user")
	private User userBean;

	public Tripbag() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Trip getTripBean() {
		return this.tripBean;
	}

	public void setTripBean(Trip tripBean) {
		this.tripBean = tripBean;
	}

	public User getUserBean() {
		return this.userBean;
	}

	public void setUserBean(User userBean) {
		this.userBean = userBean;
	}

}