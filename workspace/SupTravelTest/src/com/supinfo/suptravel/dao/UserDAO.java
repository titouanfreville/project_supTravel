package com.supinfo.suptravel.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
import com.supinfo.suptravel.bean.User;

public class UserDAO {

    public void addUser(String name, String lastname, String password, String email,int studentid, String campus) {
		EntityManager entityManager = Persistence.createEntityManagerFactory("SupTravel").createEntityManager();
    	try {
            entityManager.getTransaction().begin();
            User user = new User();
            user.setName(name);
            user.setLastname(lastname);
            user.setPassword(password);
            user.setEmail(email);
            user.setStudentid(studentid);
            user.setCampus(campus);
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
    
    public Long getNumberUser() {
    	EntityManager entityManager = Persistence.createEntityManagerFactory("SupTravel").createEntityManager();
        Long countuser = (Long) entityManager.createQuery("select count (id) from User").getSingleResult();
        entityManager.close();
        return countuser;
    }
    
    public int logIn(String name, String password) {
    	EntityManager entityManager = Persistence.createEntityManagerFactory("SupTravel").createEntityManager();
    	String spassword = null;
    	try {
	        spassword = (String) entityManager.createQuery("select password from User where name=:name").setParameter("name",name).getSingleResult();
	        System.out.println(spassword + "/////////" + password);
	        if (spassword != null && spassword.equals(password)) {
	        	int id = -9999;
	        	id = (int) entityManager.createQuery("select id from User where name=:name").setParameter("name",name).getSingleResult();
	        	return id;
	        }
	        return -9999;
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
            System.out.println("Fatal");
            return -9999;
    	}
    }
    
    public User getUserObject(int Id) {
    	EntityManager entityManager = Persistence.createEntityManagerFactory("SupTravel").createEntityManager();
    	System.out.println(Id);
    	try {
	        User info = (User)entityManager.createQuery("select u from User u where id=:id").setParameter("id",Id).getSingleResult();
	        System.out.println("HERE INFO"+info+"-----------------------------------------------------\n");
	        return info;
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
            System.out.println("Fatal");
            return null;
    	}
    }
}
