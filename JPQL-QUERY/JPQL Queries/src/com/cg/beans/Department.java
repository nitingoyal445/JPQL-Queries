package com.cg.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department {

	@Id
	private int dept_code;
	
	private String dept_name;

	public int getDept_code() {
		return dept_code;
	}

	public void setDept_code(int dept_code) {
		this.dept_code = dept_code;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	
}
