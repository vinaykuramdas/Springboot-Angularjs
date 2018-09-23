package com.vinay.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller

public class Home {
	
	@RequestMapping(value = "/home")
	public String gethome(){
		return "home.html";
	}
	
	@RequestMapping(value = "/pricing" ,method=RequestMethod.GET)
	public String getpricing(){
		return "hotel.html";
	}
	
	@RequestMapping(value="/contact",method=RequestMethod.GET)
	public String getcontact(){
		return "contact.html";
	}
	
	@RequestMapping(value="/gallery",method=RequestMethod.GET)
	public String getGallery(){
		return "gallery.html";
	}


}
