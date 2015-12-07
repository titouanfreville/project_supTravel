package com.supinfo.suptravel.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.supinfo.suptravel.bean.*;

public class TripbagDAO {

	public void addUser(Trip trip, User user ) {
		EntityManager entityManager = Persistence.createEntityManagerFactory("SupTravel").createEntityManager();
        Tripbag bag = new Tripbag();
    	try {
            entityManager.getTransaction().begin();
            bag.addTrip(trip);
            bag.addUser(user);
            entityManager.persist(user);
        	entityManager.flush();
            entityManager.getTransaction().commit();
            System.out.println("\n\n Details Added \n");
 
        } catch (Exception e) {
        	entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
            System.out.println("error");
            throw e;
        }
 
    }
}
