package com.vinay.spring;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mail_send {
	@Autowired
	private JavaMailSender sendMail;
	
	@RequestMapping(value="/sendEmail",method=RequestMethod.GET)
	@ResponseBody
	
	private String sendEmail(@RequestParam("name") String name,@RequestParam("email") String mail,@RequestParam("message") String mess) throws Exception{
		MimeMessage message = sendMail.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		helper.setTo("vinaykurmadas@gmail.com");
		helper.setText("NAME:"+name+"\n"+"Email:"+mail+"\n"+"Message:"+mess);
		helper.setSubject("Feedback should be resolved");
		
		sendMail.send(message);
		
		return "mail sent";
	}

}

