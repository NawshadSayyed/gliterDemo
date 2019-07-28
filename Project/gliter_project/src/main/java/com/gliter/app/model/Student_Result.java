package com.gliter.app.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Student_Result")
public class Student_Result {
	private int total_fail;
	private int total_pass;
	private int total_student;

	public Student_Result() {
		// defalt
	}

	public Student_Result(int total_pass, int total_fail,int total_student) {
		super();
		this.total_pass = total_pass;
		this.total_fail = total_fail;
		this.total_student=total_student;
	}

	/**
	 * @return the total_student
	 */
	public int getTotal_student() {
		return total_student;
	}

	/**
	 * @param total_student the total_student to set
	 */
	@XmlElement
	public void setTotal_student(int total_student) {
		this.total_student = total_student;
	}

	/**
	 * @return the total_fail
	 */
	public int getTotal_fail() {
		return total_fail;
	}

	/**
	 * @return the total_pass
	 */
	public int getTotal_pass() {
		return total_pass;
	}

	/**
	 * @param total_fail
	 *            the total_fail to set
	 */
	@XmlElement
	public void setTotal_fail(int total_fail) {
		this.total_fail = total_fail;
	}

	/**
	 * @param total_pass
	 *            the total_pass to set
	 */
	@XmlElement
	public void setTotal_pass(int total_pass) {
		this.total_pass = total_pass;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student_Result [total_fail=" + total_fail + ", total_pass=" + total_pass + ", total_student="
				+ total_student + "]";
	}
 
}
