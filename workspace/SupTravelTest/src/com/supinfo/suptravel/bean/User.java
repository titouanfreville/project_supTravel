package com.supinfo.suptravel.bean;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue
	private int id;
	@Basic(optional = false)
    private String name;
	@Basic(optional = false)
	@Column(name = "lastname", length = 200, nullable = false, unique = true)
    private String lastname;
	@Basic(optional = false)
	@Column(name = "password", length = 200, nullable = false, unique = true)
    private String password;
	@Basic(optional = false)
	@Column(name = "email", length = 200, nullable = false, unique = true)
    private String email;
	@Basic(optional = false)
	@Column(name = "studentid", length = 6, nullable = false, unique = true)
    private int studentid;
	@Basic(optional = false)
	@Column(name = "campus", length = 100, nullable = false, unique = true)
    private String campus;
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}  
	
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

}
