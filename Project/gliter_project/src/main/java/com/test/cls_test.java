package com.test;

 
import com.gliter.app.model.Student_Result;
 

import DBconnectpkg.ConnectionProvider;
 import static DBconnectpkg.ConnectionProvider.rs;
public class cls_test 
{
	public static Student_Result  getstudent_data(){
	Student_Result result;
		try{
		
		 rs = ConnectionProvider.SelectData("SELECT * FROM get_total");
		 if(rs.next())
		 {
			
			 System.out.println(rs.getString("totlPass"));
			 System.out.println(rs.getString("total_fail"));
			 
			 result =new Student_Result();
			result.setTotal_pass(rs.getInt("totlPass"));
			result.setTotal_fail(rs.getInt("total_fail"));
			result.setTotal_student(rs.getInt("total_fail")+rs.getInt("totlPass"));
			 return result;
			 
			/*myfile="<?xml version='1.0' encoding='UTF-8'?><web-app version='2.5' xmlns='http://java.sun.com/xml/ns/javaee'	"
			+"xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' "+
			"xsi:schemaLocatio='http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd'> "+
			"<!-- The definition of the Root Spring Container shared by all Servlets and Filters -->	"
			+ "<student-result>		"
			+ "<student id='pass'> "
			+ "<value>"+rs.getInt(0)+"</value>  "
			+ "</student> <student id='fail'> "
			+ "<value>"+rs.getInt(1)+"</value> "
			+ "</student></student-result> "
			+ "</web-app>";
			 
			 System.out.println(rs.getString(1));*/
		 }
		 
	}catch (Exception e) 
	{
		// TODO: handle exception
	}
	return null;
	}

	
/*	 public static void main(String[] args) {
		System.out.println("hellow");
System.out.println(getstudent_data().getTotal_pass());		 ;
	}
*/	
}
