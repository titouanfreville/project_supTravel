package com.supinfo.suptravel.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.hibernate.exception.ConstraintViolationException;

import com.supinfo.suptravel.bean.User;

public class UserDAO {

    public int addUser(String name, String lastname, String password, String email,int studentid, String campus) {
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
            return 0;
        } catch (Exception e) {
        	entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        	if (e instanceof ConstraintViolationException) {
            	return 1;
        	}
            return 2;
        } 
 
    }
    
    public Long getNumberUser() {
    	EntityManager entityManager = Persistence.createEntityManagerFactory("SupTravel").createEntityManager();
        Long countuser = (Long) entityManager.createQuery("select count (id) from User").getSingleResult();
        entityManager.close();
        return countuser;
    }
    
    public User logIn(int s_id, String password) {
    	EntityManager entityManager = Persistence.createEntityManagerFactory("SupTravel").createEntityManager();
    	String spassword = null;
    	try {
	        spassword = (String) entityManager.createQuery("select password from User where studentid=:s_id").setParameter("s_id",s_id).getSingleResult();
	        if (spassword != null && spassword.equals(password)) {
	        	User res = new User();
	        	res = (User)entityManager.createQuery("select u from User u where studentid=:s_id").setParameter("s_id",s_id).getSingleResult();
	        	return res;
	        }
	        return null;
    	} catch (Exception e) {
    		System.out.println("Exception"+e.getMessage());
            return null;
    	}
    }
    
    public User getUserObject(int Id) {
    	EntityManager entityManager = Persistence.createEntityManagerFactory("SupTravel").createEntityManager();
    	System.out.println(Id);
    	try {
	        User info = (User)entityManager.createQuery("select u from User u where id=:id").setParameter("id",Id).getSingleResult();
	        return info;
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
            return null;
    	}
    }
    
    public void Update(User u, User nu){
    	EntityManager entityManager = Persistence.createEntityManagerFactory("SupTravel").createEntityManager();
    	entityManager.getTransaction().begin();
    	String n = new String();
    	String o = new String();
    	try {
    		o=u.getCampus();
    		n=nu.getCampus();
    		if (!(n == null || (o.equals(n)))) {
    			u.setCampus(n);
    		}
    		o=u.getEmail();
    		n=nu.getEmail();
    		if (!(n == null || (o.equals(n)))) {
    			u.setEmail(n);
    		}
    		o=u.getLastname();
    		n=nu.getLastname();
    		if (!(n == null || (o.equals(n)))) {
    			u.setLastname(n);
    		}
    		o=u.getName();
    		n=nu.getName();
    		if (!(n == null || (o.equals(n)))) {
    			u.setName(n);
    		}
    		o=u.getPassword();
    		n=nu.getPassword();
    		if (!(n == null || (o.equals(n)))) {
    			u.setPassword(n);
    		}
        	entityManager.merge(u);
        	entityManager.flush();
            entityManager.getTransaction().commit();
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
    	}
    }
}
