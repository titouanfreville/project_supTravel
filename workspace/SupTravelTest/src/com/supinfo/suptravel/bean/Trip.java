package com.supinfo.suptravel.bean;

import javax.persistence.*;

@Entity
@Table(name="trip")
public class Trip {
	@Id
	@GeneratedValue
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Basic(optional = false)
	@Column(name = "tripname", length = 200, nullable = false, unique = true)
    private String tripname;

	public String getTripname() {
		return tripname;
	}
	public void setTripname(String tripname) {
		this.tripname = tripname;
	}
	
	@Column(name = "campus", length = 200, nullable = false, unique = true)
    private String campus;

	public String getCampus() {
		return campus;
	}
	public void setCampus(String campus) {
		this.campus = campus;
	}
	
	
////	Relation n:1 with Campus
//	@ManyToOne(cascade = "campus")
//	private Set<Campus> campus = new HashSet<Campus>();
//	public boolean addCampus(Campus camp) {
//        return campus.add(camp);
//    }
//
//    public Set<Campus> getCampus() {
//        return campus;
//    }
}
