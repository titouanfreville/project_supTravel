package com.supinfo.suptravel.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.supinfo.suptravel.bean.*;

public class TripbagDAO {

	public void bookTrip(Trip trip, User user, int quant ) {
		EntityManager entityManager = Persistence.createEntityManagerFactory("SupTravel").createEntityManager();
        Tripbag bag = new Tripbag();
    	try {
            entityManager.getTransaction().begin();
            bag.setTripBean(trip);
            bag.setUserBean(user);
            bag.setQuantity(quant);
            entityManager.persist(bag);
        	entityManager.flush();
            entityManager.getTransaction().commit(); 
        } catch (Exception e) {
        	entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
            System.out.println("error");
            throw e;
        }
 
    }
	
	public ArrayList<Object[]>  tripByUser(int User) {
		EntityManager entityManager = Persistence.createEntityManagerFactory("SupTravel").createEntityManager();
        try {
        	ArrayList<Object[]> trips = (ArrayList<Object[]>) entityManager.createQuery("select DISTINCT t.tripBean, t.quantity from Tripbag t where user=:id").setParameter("id",User).getResultList();        

	        return trips;
        } catch (Exception e) {
        	throw e;
        }

	}
}
