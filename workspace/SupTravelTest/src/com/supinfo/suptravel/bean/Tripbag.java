package com.supinfo.suptravel.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="tripbag")
public class Tripbag {
	@Id
	@GeneratedValue
	private int id;
//	Relation n:1 with User
//	@ManyToOne
//	private Set<User> users = new HashSet<User>();
//	public boolean addUser(User user) {
//        return users.add(user);
//    }
//
//    public Set<User> getUser() {
//        return users;
//    }
//    
//    @ManyToOne
//	private Set<Trip> trips = new HashSet<Trip>();
//	public boolean addTrip(Trip trip) {
//        return trips.add(trip);
//    }
//
//    public Set<Trip> getTrip() {
//        return trips;
//    }
}
