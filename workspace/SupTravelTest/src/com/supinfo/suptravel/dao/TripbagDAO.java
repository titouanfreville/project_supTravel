package com.supinfo.suptravel.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.supinfo.suptravel.bean.*;

public class TripbagDAO {

	public void bookTrip(Trip trip, User user ) {
		EntityManager entityManager = Persistence.createEntityManagerFactory("SupTravel").createEntityManager();
        Tripbag bag = new Tripbag();
    	try {
            entityManager.getTransaction().begin();
            bag.setTripBean(trip);
            bag.setUserBean(user);
            entityManager.persist(bag);
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
	
	public ArrayList<String> tripByUser(int User) {
		EntityManager entityManager = Persistence.createEntityManagerFactory("SupTravel").createEntityManager();
        try {
        	ArrayList<Trip> trips = (ArrayList<Trip>)entityManager.createQuery("select DISTINCT tripBean from Tripbag where user=:id").setParameter("id",User).getResultList();        
        	ArrayList<String> res = new ArrayList<String>();
	        for (Trip t : trips) {
	        	res.add(t.getTripname());
	        }
	        return res;
        } catch (Exception e) {
        	System.out.println("Ca bug 1");
        	throw e;
        }

	}
}
//.setParameter("id",id_trip)
//try {
//	System.out.println("-------**********--------------\n"+id_trip+"\n----------------***********-------------------\n");
//    ArrayList<String> tripname= (ArrayList<String>)entityManager.createQuery("select tripname from Trip t left join fetch user u where id=1").getSingleResult();
//    return tripname;
//} catch (Exception e) {
//	System.out.println(e.getMessage());
//    System.out.println("Fatal");
//    return null;
//
//}
