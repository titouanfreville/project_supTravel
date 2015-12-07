package com.supinfo.suptravel.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.supinfo.suptravel.bean.Trip;

public class TripDAO {

    public Long getNumberTrip() {
    	EntityManager entityManager = Persistence.createEntityManagerFactory("SupTravel").createEntityManager();
        Long countuser = (Long) entityManager.createQuery("select count (id) from Trip").getSingleResult();
        entityManager.close();
        return countuser;
    }
    
    public List<String> listTrips() {
    	EntityManager entityManager = Persistence.createEntityManagerFactory("SupTravel").createEntityManager();
        List<String> listName = entityManager.createQuery("select tripname from Trip").getResultList();
        entityManager.close();
        return listName;
    }
    
    public ArrayList<String> listTripsbyCampus(String campus) {
    	EntityManager entityManager = Persistence.createEntityManagerFactory("SupTravel").createEntityManager();
        ArrayList<String> listName = (ArrayList<String>) entityManager.createQuery("select tripname from Trip where campus=:campus").setParameter("campus", campus).getResultList();
        entityManager.close();
        return listName;
    }
    
    public Trip getTripObject(String name) {
    	EntityManager entityManager = Persistence.createEntityManagerFactory("SupTravel").createEntityManager();
    	try {
	        Trip info = (Trip)entityManager.createQuery("select u from User u where tripname=:name").setParameter("name",name).getSingleResult();
	        System.out.println("HERE INFO"+info+"-----------------------------------------------------\n");
	        return info;
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
            System.out.println("Fatal");
            return null;
    	}
    }
}
