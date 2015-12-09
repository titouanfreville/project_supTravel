package com.supinfo.suptravel.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the trip database table.
 * 
 */
@Entity
@Table(name="trip")
public class Trip implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String campus;

	private String tripname;

	//bi-directional many-to-one association to Tripbag
	@OneToMany(mappedBy="tripBean")
	private List<Tripbag> tripbags;

	public Trip() {
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

	public String getTripname() {
		return this.tripname;
	}

	public void setTripname(String tripname) {
		this.tripname = tripname;
	}

	public List<Tripbag> getTripbags() {
		return this.tripbags;
	}

	public void setTripbags(List<Tripbag> tripbags) {
		this.tripbags = tripbags;
	}

	public Tripbag addTripbag(Tripbag tripbag) {
		getTripbags().add(tripbag);
		tripbag.setTripBean(this);

		return tripbag;
	}

	public Tripbag removeTripbag(Tripbag tripbag) {
		getTripbags().remove(tripbag);
		tripbag.setTripBean(null);

		return tripbag;
	}

}