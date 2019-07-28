package com.gliter.app;

import java.awt.PageAttributes.MediaType;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.xml.ws.WebServiceProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
 import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import com.gliter.app.dao.logindao;
import com.gliter.app.daoimpl.logindaoimpl;
import com.gliter.app.model.Student_Result;
import com.gliter.app.model.loginmodel;
import com.gliter.app.serviceImpl.loginserviceimpl;
import com.test.cls_test;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController  {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}

	
	@RequestMapping(value= "LoginServlet", method= RequestMethod.POST)
	public ModelAndView getLogin(@ModelAttribute("loginmodel") loginmodel loginmodel){
		logindao lm=new  logindaoimpl();
		return lm.getlogin(loginmodel);
	}
	
	
	@RequestMapping(value= "/TaskTiming")
	public ModelAndView getTimeDetails(){
		return new ModelAndView("TaskTiming");
	}
	
	
	@RequestMapping(value= "/dashboard")
	public ModelAndView getdashboard(){
		
		return new ModelAndView("dashboard");
	}
	
/*	@RequestMapping(value= "/GetData", method = RequestMethod.GET , produces ={"application/xml"},consumes={"application/xml"})
	public Student_Result getUsers(){ 
	      return cls_test.getstudent_data(); 
	   }  */
	
	
	@RequestMapping(value = "/getinformation", method = RequestMethod.GET ,produces ={org.springframework.http.MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public  Student_Result processXMLJsonRequest() 
	{
		  return cls_test.getstudent_data();
	}
	public ModelAndView getResult(){
		
		return new ModelAndView("dashboard");
	}	
	@RequestMapping(value= "/Logout")
	public ModelAndView getLogout(){
		return new ModelAndView("home");
	}
	
/*	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}*/
	
}

