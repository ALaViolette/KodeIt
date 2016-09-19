package com.kodeit.finalproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import badwords.BadWordList;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@RequestMapping(value = {"home", "/"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "about", method = RequestMethod.GET)
	public String about(Model model) {

		return "about";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(Model model) {

		return "login";
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(Model model) {

		return "login";

}
	@RequestMapping(value = "googlesignin", method = RequestMethod.GET)
	public String googlesignin(Model model) {

		return "googlesignin";

}
	
	@RequestMapping(value = "lang", method = RequestMethod.GET)
	public String pickLanguage(Model model) {
		return "lang";

	}

	@RequestMapping(value = "java" , method = RequestMethod.GET)
	public String javaForum(HttpServletRequest request, Model model){
		try{
			String input = request.getParameter("myTextBox");
			String additionalWords = null;
			if(input != null){
				
//		 These code snippets use an open-source library. http://unirest.io/java		
			HttpResponse<JsonNode> response = Unirest.post("https://neutrinoapi-bad-word-filter.p.mashape.com/bad-word-filter")
					.header("X-Mashape-Key", "9x9UPSwwJfmshXaJAqvqhgE89xxKp1c691ujsnn0pcthgl2qo3")
					.header("Content-Type", "application/x-www-form-urlencoded")
					.header("Accept", "application/json")
					.field("censor-character", "*")
					.field("content", input)
					.asJson();
			int index = response.getBody().toString().indexOf("is-bad");
			char bword = response.getBody().toString().substring(index+8).charAt(0);
			 if (bword =='f'){
			String[] arr = input.split(" ");
			BadWordList list = new BadWordList();
			ArrayList<String> bullyWordList = list.createList();
			
			//add ability to save input and alert them they have used 
			for(int x = 0; x<arr.length;x++){
			for(int y = 0; y < bullyWordList.size(); y++){
				if(arr[x].equalsIgnoreCase(bullyWordList.get(y))){
					 additionalWords = "You have used words prohibited by our community";
				}
				
				}
			}
			// remember to create database
//			if(bword == 'f' && additionalWords == null){
//				Class.forName("com.mysql.jdbc.Driver");
//				Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "root", "rita1234");
//				ResultSet rs = null;
//				 String setStmt =
//			}
			

			
			model.addAttribute("test", input);
//			model.addAttribute("test2",wordList.get(0));

			}
			else{

			model.addAttribute("test","You have used words prohibited by our community");
			 }
			
			}		
		 return "java";
		}catch(

	Exception e)
	{
		return "UnderConstruction";
	}
	}

	@RequestMapping(value = { "CS", "C++", "Other", "Python", "JavaScript", "HTML/CSS" }, method = RequestMethod.GET)
	public String underConstruction(HttpServletRequest request, Model model) {
		return "UnderConstruction";
	}

	
}
