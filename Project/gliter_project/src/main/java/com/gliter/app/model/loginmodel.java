package com.gliter.app.model;


public class loginmodel {
private int id;
private String u_name;
private String u_pass;
private String u_type;
/**
 * @return the id
 */


loginmodel(){
	
}
public int getId() {
	return id;
}
/**
 * @param id the id to set
 */
public void setId(int id) {
	this.id = id;
}
public loginmodel(int id, String u_name, String u_pass, String u_type) {
	super();
	this.id = id;
	this.u_name = u_name;
	this.u_pass = u_pass;
	this.u_type = u_type;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "loginmodel [id=" + id + ", u_name=" + u_name + ", u_pass=" + u_pass + ", u_type=" + u_type + "]";
}
/**
 * @return the u_name
 */
public String getU_name() {
	return u_name;
}
/**
 * @param u_name the u_name to set
 */
public void setU_name(String u_name) {
	this.u_name = u_name;
}
/**
 * @return the u_pass
 */
public String getU_pass() {
	return u_pass;
}
/**
 * @param u_pass the u_pass to set
 */
public void setU_pass(String u_pass) {
	this.u_pass = u_pass;
}
/**
 * @return the u_type
 */
public String getU_type() {
	return u_type;
}
/**
 * @param u_type the u_type to set
 */
public void setU_type(String u_type) {
	this.u_type = u_type;
}
	
}
