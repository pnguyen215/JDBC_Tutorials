package com.phuocnguyen003.MSSQLServer;

import java.io.Serializable;

public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private double gpa;
	private String major;

	public Student() {
	}

	public Student(int id, String name, double gpa, String major) {
		super();
		this.id = id;
		this.name = name;
		this.gpa = gpa;
		this.major = major;
	}

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

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return "Id: " + getId() + " " + "Name: " + getName() + " " + "Gpa: " + getGpa() + " " + "Major: " + getMajor();
	}
}
