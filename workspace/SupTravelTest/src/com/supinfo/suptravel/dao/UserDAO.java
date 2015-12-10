package com.supinfo.suptravel.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

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
    
    public ArrayList<Integer> logIn(String name, String password) {
    	EntityManager entityManager = Persistence.createEntityManagerFactory("SupTravel").createEntityManager();
    	String spassword = null;
    	try {
	        spassword = (String) entityManager.createQuery("select password from User where name=:name").setParameter("name",name).getSingleResult();
	        System.out.println(spassword + "/////////" + password);
	        if (spassword != null && spassword.equals(password)) {
	        	ArrayList<Integer> res = new ArrayList<Integer>();
	        	res.add(0,(int) entityManager.createQuery("select id from User where name=:name").setParameter("name",name).getSingleResult());
	        	res.add(1,(int) entityManager.createQuery("select studentid from User where name=:name").setParameter("name",name).getSingleResult());
	        	System.out.println("UserDAO   " + res.get(0)+"    " + res.get(1) + "    " + res);
	        	return res;
	        }
	        return null;
    	} catch (Exception e) {
    		System.out.println("Exception"+e.getMessage());
            System.out.println("Fatal");
            return null;
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
    
    public void Update(User u, User nu){
    	EntityManager entityManager = Persistence.createEntityManagerFactory("SupTravel").createEntityManager();
    	entityManager.getTransaction().begin();
        System.out.println("In UPDATE");
    	String n = new String();
    	String o = new String();
    	try {
    		o=u.getCampus();
    		n=nu.getCampus();
    		if (!(n == null || (o.equals(n)))) {
                System.out.println("In Campus");
    			u.setCampus(n);
    		}
    		o=u.getEmail();
    		n=nu.getEmail();
    		if (!(n == null || (o.equals(n)))) {
                System.out.println("In Email");
    			u.setEmail(n);
    		}
    		o=u.getLastname();
    		n=nu.getLastname();
    		if (!(n == null || (o.equals(n)))) {
                System.out.println("In LastName");
    			u.setLastname(n);
    		}
    		o=u.getName();
    		n=nu.getName();
    		if (!(n == null || (o.equals(n)))) {
                System.out.println("In Name");
    			u.setName(n);
    		}
    		o=u.getPassword();
    		n=nu.getPassword();
    		if (!(n == null || (o.equals(n)))) {
                System.out.println("In Password");
    			u.setPassword(n);
    		}
        	entityManager.merge(u);
        	entityManager.flush();
            entityManager.getTransaction().commit();
            System.out.println("End");
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
            System.out.println("Fatal");
            entityManager.getTransaction().rollback();
    	}
    }
}
