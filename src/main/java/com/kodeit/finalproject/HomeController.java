package com.kodeit.finalproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//import com.FinalProject.APIController.HomeController;
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

	@RequestMapping(value = { "home", "/" }, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

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
	
	
	
	
	
	
	@RequestMapping(value = "languages", method = RequestMethod.GET)
	public String pickLanguage(HttpServletRequest request) {
		return "languages";

	}
	
	
	@RequestMapping(value = "submit", method = RequestMethod.POST)
	public String signup(HttpServletRequest request, Model model,HttpSession session) throws ClassNotFoundException, SQLException {
	String userID = request.getParameter("userID");

	String password = request.getParameter("password");


	Class.forName("com.mysql.jdbc.Driver");
	Connection cnn = DriverManager.getConnection("jdbc:mysql://aa1ifvmct381ixh.c9t4llbgq8j4.us-east-1.rds.amazonaws.com:3306/KodeIt", "KodeIt",
        "LLTA3456");
	PreparedStatement insertStatement = cnn.prepareStatement(
			"select count(*) from userInfo where userid=? and password=?");
	insertStatement.setString(1, userID);
	insertStatement.setString(2, password);

	// insertStatement.setString(1, x);

	ResultSet rs =insertStatement.executeQuery();
	rs.next();
	
	int res = rs.getInt(1);
	
	if (res==1)
	{  
		
		session.setAttribute("userName", userID);
		
		return "home";
		
	}
	else
	{  
		model.addAttribute("errormsg", "Wrong username or password!");
		return "login";
	}
	//cnn.close();
	
	//return "home";
}

	
	

@RequestMapping(value = "answer", method = RequestMethod.GET)
public String submitAnswers(Model model, HttpServletRequest request,HttpSession session) throws ClassNotFoundException, SQLException{
		String qid = request.getParameter("qid");
		String parameterQID = request.getParameter("questionid");
		String answer = request.getParameter("answer");
		String userID=session.getAttribute("userName").toString();
		String invalidInput = "You have used words prohibited by our community";
	try{	
		if(answer!= null && !answer.isEmpty()&&parameterQID!= null && !parameterQID.isEmpty()){
//			HttpResponse<JsonNode> response = Unirest
//			.post("https://neutrinoapi-bad-word-filter.p.mashape.com/bad-word-filter")
//			.header("X-Mashape-Key", "yQ6luxf7qwmsh1n2GfWvJfvYehWKp1x9r8ZjsnBous6Q8y19lC")
//			.header("Content-Type", "application/x-www-form-urlencoded")
//			.header("Accept", "application/json").field("censor-character", "*").field("content", answer)
//			.asJson();
//
//	int index = response.getBody().toString().indexOf("is-bad");
//	char bword = response.getBody().toString().substring(index + 8).charAt(0);
//
//	if (bword == 'f') {
		String[] arr = answer.split(" ");
		BadWordList list = new BadWordList();

		ArrayList<String> wordList = list.createList();

		
		if (bullyWord(arr,wordList) == false) {
			
			
		     Class.forName("com.mysql.jdbc.Driver");
		        Connection cnn = DriverManager.getConnection("jdbc:mysql://aa1ifvmct381ixh.c9t4llbgq8j4.us-east-1.rds.amazonaws.com:3306/KodeIt", "KodeIt",
		        "LLTA3456"); 
		  
		        PreparedStatement insertStatement = cnn.prepareStatement
		        		("INSERT INTO answer (questionID, userID, answer) Values (?,?,?)");
		        insertStatement.setString(1, parameterQID);
		        insertStatement.setString(2, userID);
		        insertStatement.setString(3,answer);
		        
		     
		       // insertStatement.setString(1, x);
		        insertStatement.executeUpdate();     
		        
		        cnn.close();
		        
		        model.addAttribute("ans", "Your answer has been submitted!");
				model.addAttribute("ans2", answer);
				
				 cnn = createAnswerTable(model, parameterQID);
					
			        model.addAttribute("qid", parameterQID);
				        
			        cnn.close();
			    
			        return "answer";
				}else{
				 model.addAttribute("ans", invalidInput);
				model.addAttribute("ans2", answer);
				}
//		}else{
//			 model.addAttribute("ans", invalidInput);
//			model.addAttribute("ans2", answer);
//		}
		
		
		}
		if(qid!= null && !qid.isEmpty()){
	  
	        Connection cnn = createAnswerTable(model, qid);
			
	        model.addAttribute("qid", qid);
		        
	        cnn.close();
	    
	        return "answer";
	        
		}
	
		}catch(Exception e){
	return "UnderConstruction";
		}
		return "answer";
	}

public Connection createAnswerTable(Model model, String qid) throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.jdbc.Driver");
	Connection cnn = DriverManager.getConnection("jdbc:mysql://aa1ifvmct381ixh.c9t4llbgq8j4.us-east-1.rds.amazonaws.com:3306/KodeIt", "KodeIt",
	"LLTA3456"); 
	String command = "select userID, answer from answer where questionid="+qid;
	Statement selectStatement = cnn.createStatement();
     
	ResultSet rs = selectStatement.executeQuery(command);

	String output = "<table border=1>";// opening table tag
	// fetch results from a resultset. checks if there is a new line to
	// read.
	while (rs.next() == true) {
		output += "<tr>";// go through the rows over and over
		output += "<td>" + rs.getString(1) + "</td>";
		output += "<td>" + rs.getString(2) + "</td>";
		output += "</tr>";

	}
	output += "</table>";
	
	
	model.addAttribute("atable", output);
	return cnn;
}




@RequestMapping(value = "search", method = RequestMethod.GET)
public String searchQuestion(Model model, HttpServletRequest request,HttpSession session) {

	String topic = request.getParameter("topic");
	try {
		Class.forName("com.mysql.jdbc.Driver");

		Connection cnn = DriverManager.getConnection("jdbc:mysql://aa1ifvmct381ixh.c9t4llbgq8j4.us-east-1.rds.amazonaws.com:3306/KodeIt", "KodeIt",
            "LLTA3456");
		String command = "";
		if (topic == null || topic.isEmpty()) {
			//command = "select topic, questionText, questionID from userQuestion";
		} else {
			command = "select topic, questionText, questionID, userID from userQuestion where topic like '%" + topic + "%'";
			// edit statment
//			command ="SELECT KodeIt.userQuestion.questionText, KodeIt.userQuestion.topic, "
//					+ "KodeIt.answer.answer from KodeIt.userQuestion left join KodeIt.answer on "
//					+ "KodeIt.userQuestion.questionID= KodeIt.answer.questionID where "
//					+ "userQuestion.topic like '%" + topic + "%'";
		}
		Statement selectStatement = cnn.createStatement();
		ResultSet rs = selectStatement.executeQuery(command);

		String output = "<table border=1><tr><td><b>Topic</td><td><b>User</td><td><b>Question</td></b></tr>";// opening table tag
		// fetch results from a resultset. checks if there is a new line to
		// read.
		while (rs.next() == true) {
			output += "<tr>";// go through the rows over and over
			output += "<td>" + rs.getString(1) + "</td>";
			output += "<td>" + rs.getString(4) + "</td>";
			output += "<td><a href =answer?qid="+rs.getString(3)+">" + rs.getString(2) + "</a></td>";
			output += "</tr>";
			
			
		}
		output += "</table>";
		
		
		model.addAttribute("ctable", output);

	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "java";
}






@RequestMapping(value = "lang", method = RequestMethod.GET)
public String pickLanguage(Model model) {
	return "lang";

}

@RequestMapping(value = "registerPage", method = RequestMethod.GET)
public String registerPage(HttpServletRequest request, Model model, HttpSession session) {
	try {
		
		String userID = request.getParameter("userID"); // email
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String password = request.getParameter("password");
		if (userID != null){
		
		Class.forName("com.mysql.jdbc.Driver");

		Connection cnn = DriverManager.getConnection("jdbc:mysql://aa1ifvmct381ixh.c9t4llbgq8j4.us-east-1.rds.amazonaws.com:3306/KodeIt", "KodeIt",
            "LLTA3456");
		
		PreparedStatement insertStatement = cnn.prepareStatement
				("Insert into userInfo (userID, firstName, lastName, password) Values(?,?,?,?)");
		
					insertStatement.setString(1, userID);
					insertStatement.setString(2, firstName);
					insertStatement.setString(3, lastName);
					insertStatement.setString(4, password);
					
					insertStatement.executeUpdate();
					
					cnn.close();
	
	} }
	catch (Exception e) 
	{
		return "UnderConstruction";
	}
	return "registerPage";
}








@RequestMapping(value = "java", method = RequestMethod.GET)
public String javaForum(HttpServletRequest request, Model model, HttpSession session) {
	try {
		String input = request.getParameter("questionText");
		String topic = request.getParameter("topic");
		String invalidInput = "You have used words prohibited by our community";
		
		String userID="";
		
		if (session.getAttribute("userName") == null)
			return "login";
		else
			userID=session.getAttribute("userName").toString();
		
		
		String output = createQuestiontable();
		
		
		model.addAttribute("ctable", output);
		
	
		if (input != null) {
	
		if (topic == null || topic.isEmpty()){
				model.addAttribute("test","Please include a topic");
				model.addAttribute("test2", input);
				return "java";
			}

			// These code snippets use an open-source library.
			// http://unirest.io/java
//			HttpResponse<JsonNode> response = Unirest
//					.post("https://neutrinoapi-bad-word-filter.p.mashape.com/bad-word-filter")
//					.header("X-Mashape-Key", "yQ6luxf7qwmsh1n2GfWvJfvYehWKp1x9r8ZjsnBous6Q8y19lC")
//					.header("Content-Type", "application/x-www-form-urlencoded")
//					.header("Accept", "application/json").field("censor-character", "*").field("content", input)
//					.asJson();
//
//			int index = response.getBody().toString().indexOf("is-bad");
//			char bword = response.getBody().toString().substring(index + 8).charAt(0);
//
//			if (bword == 'f') {
				String[] arr = input.split(" ");
				BadWordList list = new BadWordList();

				ArrayList<String> wordList = list.createList();

				
				if (bullyWord(arr,wordList) == false) {

					submitQuestion(input,userID,topic);
		
		
			model.addAttribute("test", "Your question has been submitted!");
			model.addAttribute("test2", input);
					
				}else{
					model.addAttribute("test",invalidInput);
					model.addAttribute("test2", input);
					}

//			} else {
//
//				model.addAttribute("test", invalidInput );
//			model.addAttribute("test2", input);
//			}
		}
		
		return "java";
	} 
	catch (Exception e) 
	{
		return "UnderConstruction";
	}
}

/**
 * @return
 * @throws ClassNotFoundException
 * @throws SQLException
 */
public String createQuestiontable() throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.jdbc.Driver");

	Connection cnn = DriverManager.getConnection("jdbc:mysql://aa1ifvmct381ixh.c9t4llbgq8j4.us-east-1.rds.amazonaws.com:3306/KodeIt", "KodeIt",
	    "LLTA3456");
	String command =  "select topic, questionText ,questionID, userID from userQuestion";
	
	Statement selectStatement = cnn.createStatement();
	ResultSet rs = selectStatement.executeQuery(command);

	String output = "<table border=1><tr><td><b>Topic</td><td><b>User</td><td><b>Question</td></b></tr>";// opening table tag
	// fetch results from a resultset. checks if there is a new line to
	// read.
	while (rs.next() == true) {
		output += "<tr>";// go through the rows over and over
		output += "<td>" + rs.getString(1) + "</td>";
		output += "<td>" + rs.getString(4) + "</td>";
		output += "<td> <a href =answer?qid="+rs.getString(3)+">" + rs.getString(2) + "</a></td>";
		output += "</tr>";

	}
	output += "</table>";
	return output;
}

public void submitQuestion(String input, String userID, String topic) throws ClassNotFoundException, SQLException{
    

  
        Class.forName("com.mysql.jdbc.Driver");
        Connection cnn = DriverManager.getConnection("jdbc:mysql://aa1ifvmct381ixh.c9t4llbgq8j4.us-east-1.rds.amazonaws.com:3306/KodeIt", "KodeIt",
        "LLTA3456"); 
  
        PreparedStatement insertStatement = cnn.prepareStatement
        		("INSERT INTO userQuestion (questionText,userId,topic) Values (?,?,?)");
        insertStatement.setString(1, input);
        insertStatement.setString(2, userID);
        insertStatement.setString(3 ,topic);
        
 
        insertStatement.executeUpdate();     
        
        cnn.close();
    
    

}


private boolean bullyWord (String arr[], ArrayList wordList){
for (int x = 0; x < arr.length; x++) {
	for (int y = 0; y < wordList.size(); y++) {
		String a = arr[x];
		String b = wordList.get(y).toString();
		if (a.equalsIgnoreCase(b)) {
			return true;
		}
	}
}
return false;
}

public void register(String userID, String firstName, String lastName, String password) throws ClassNotFoundException, SQLException{
    
    //System.out.println("hello");
        Class.forName("com.mysql.jdbc.Driver");
        Connection cnn = DriverManager.getConnection("jdbc:mysql://aa1ifvmct381ixh.c9t4llbgq8j4.us-east-1.rds.amazonaws.com:3306/KodeIt", "KodeIt",
        "LLTA3456"); 
       // System.out.println("hello2");
        PreparedStatement insertStatement = cnn.prepareStatement
        		("INSERT INTO userInfo (userID, userName, lastName, password) Values (?,?,?,?)");
        insertStatement.setString(1, userID);
        insertStatement.setString(2, firstName);
        insertStatement.setString(3, lastName);
        insertStatement.setString(4, password);
        
     
       // insertStatement.setString(1, x);
        insertStatement.executeUpdate();     
        
        cnn.close();
    
    

}




@RequestMapping(value = { "CS", "C++", "Other", "Python", "JavaScript", "HTML/CSS" }, method = RequestMethod.GET)
public String underConstruction(HttpServletRequest request, Model model) {
	return "UnderConstruction";
}

@RequestMapping(value = "education", method = RequestMethod.GET)
public String educationPage( Model model) {
	return "education";
}



	@RequestMapping(value = "test")
	public String justTest() {

		return "UnderConstruction";
	
	}


	@RequestMapping(value = "signIn")
	public String getLogin(@RequestParam(value = "id_token") String id_token) {
		
		System.out.println(id_token);



		/*GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
		    .setAudience(Arrays.asList(CLIENT_ID))
		    // If you retrieved the token on Android using the Play Services 8.3 API or newer, set
		    // the issuer to "https://accounts.google.com". Otherwise, set the issuer to
		    // "accounts.google.com". If you need to verify tokens from multiple sources, build
		    // a GoogleIdTokenVerifier for each issuer and try them both.
		    .setIssuer("https://accounts.google.com")
		    .build();

		// (Receive idTokenString by HTTPS POST)

		GoogleIdToken idToken = verifier.verify(idTokenString);
		if (idToken != null) {
		  Payload payload = idToken.getPayload();

		  // Print user identifier
		  String userId = payload.getSubject();
		  System.out.println("User ID: " + userId);

		  // Get profile information from payload
		  String email = payload.getEmail();
		  boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
		  String name = (String) payload.get("name");
		  String pictureUrl = (String) payload.get("picture");
		  String locale = (String) payload.get("locale");
		  String familyName = (String) payload.get("family_name");
		  String givenName = (String) payload.get("given_name");

		  // Use or store profile information
		  // ...

		} //else {
		  System.out.println("Invalid ID token.");*/
		//}
		
		return "java";
	}
	
	
	

}
