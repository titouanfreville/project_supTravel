package com.supinfo.suptravel.bean;

import javax.persistence.*;

@Entity
@Table(name="campus")
public class Campus {
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
	@Column(name = "campusname", length = 200, nullable = false, unique = true)
    private String campusname;

	public String getCampusname() {
		return campusname;
	}
	public void setCampusname(String tripname) {
		this.campusname = tripname;
	}

}
