package com.tka.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tka.dao.QuestionDAO;
import com.tka.entity.Answer;
import com.tka.entity.Question;
import com.tka.entity.User;

@Controller
public class LoginController{
@Autowired
SessionFactory factory;
@Autowired
QuestionDAO dao;
	
@RequestMapping("/")
public String login() {
	return"login";
}
@RequestMapping("saveToDB")
public ModelAndView saveToDB(User user,HttpServletRequest request) throws Exception{
	   Session  session=factory.openSession();
	   Transaction tx=session.beginTransaction();
	   user.setImagepath("/images/"+user.getImage().getOriginalFilename());
	   session.save(user);
	   tx.commit();
	 // image uploading code
	   MultipartFile image=user.getImage();
       String foldername=request.getServletContext().getRealPath("/images");	   
       image.transferTo(new File(foldername, image.getOriginalFilename()));
       ModelAndView mAV=new ModelAndView();
       mAV.setViewName("login");
       mAV.addObject("message" , "registration succesfull");
       
       return mAV;
       
} 
@RequestMapping("validate")       
public  ModelAndView  validate(String username, String password, String subject,HttpServletRequest request) {
	 ModelAndView modelAndView=new ModelAndView();
	         Session  session=factory.openSession();
	         User   userFromDB=session.get(User.class, username);
	         if(userFromDB==null) {
	        	 modelAndView.setViewName("login");
	        	  modelAndView.addObject("message" , "invalid username");
	         }
	         else if(password.equals(userFromDB.getPassword())){
	        	modelAndView.setViewName("question");
	      
	            	  List<Question>  list=dao.getAllQuestions(subject);
	        	      Question   question =list.get(0);
	        	     
	        	     HttpSession   httpSession=request.getSession();
	        	      httpSession.setAttribute("imagepath",userFromDB.getImagepath());
	        	     // get(0) will give first Question
                      httpSession.setAttribute("question", question);
                     // list of all question according to subject
	        	      httpSession.setAttribute("questions", list);
	        	      httpSession.setAttribute("qno", 0);
	        	      httpSession.setAttribute("score", 0);
	        	  HashMap<Integer, Answer> hashMaph=new HashMap<Integer, Answer>();
	        	  httpSession.setAttribute("submittedDetails", hashMaph);
	           }
	         else
	             { 
	        	 modelAndView.setViewName("login");
	        	 modelAndView.addObject("message" , "invalid password"); 
	             }
	         return modelAndView;
}



@RequestMapping("register")
public String register() {
	
	return "register";
	}



}