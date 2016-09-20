package com.kodeit.finalproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;



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

	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String searchQuestion(Model model, HttpServletRequest request) {

		String topic = request.getParameter("topic");
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/KodeIt", "Tracyd",
					"1W0rkB3nch6!");
			String command = "";
			if (topic == null || topic.isEmpty()) {
				command = "select topic, questionText from userQuestion";
			} else {
				command = "select topic, questionText from userQuestion where topic like '%" + topic + "%'";
			}
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

//	@RequestMapping(value = "java", method = RequestMethod.GET)
//	public String javaForum(HttpServletRequest request, Model model) {
//		boolean bullyWord = false;
//		try {
//
//			String input = request.getParameter("questionText");
//
//			String additionalWords = null;
//
//			if (input != null) {
//
//				// These code snippets use an open-source library.
//				// http://unirest.io/java
//				HttpResponse<JsonNode> response = Unirest
//						.post("https://neutrinoapi-bad-word-filter.p.mashape.com/bad-word-filter")
//						.header("X-Mashape-Key", "9x9UPSwwJfmshXaJAqvqhgE89xxKp1c691ujsnn0pcthgl2qo3")
//						.header("Content-Type", "application/x-www-form-urlencoded")
//						.header("Accept", "application/json").field("censor-character", "*").field("content", input)
//						.asJson();
//
//				int index = response.getBody().toString().indexOf("is-bad");
//				char bword = response.getBody().toString().substring(index + 8).charAt(0);
//
//				if (bword == 'f') {
//					String[] arr = input.split(" ");
//					BadWordList list = new BadWordList();
//
//					ArrayList<String> wordList = list.createList();
//
//					for (int x = 0; x < arr.length; x++) {
//						for (int y = 0; y < wordList.size(); y++) {
//							if (arr[x].equalsIgnoreCase(wordList.get(y))) {
//								input = "You have used words prohibited by our community";
//								bullyWord = true;
//							}
//						}
//					}
//
//					
//					if (bullyWord == false) {
//
//						String userID = "jj@jj.com";
//
//						String topic = request.getParameter("topic");
//
//						String txt = request.getParameter("questionText");
//
//						Class.forName("com.mysql.jdbc.Driver");
//						Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/KodeIt", "Tracyd",
//								"1W0rkB3nch6!");
//						PreparedStatement insertStatement = cnn.prepareStatement(
//								"INSERT INTO userQuestion (questiontext,userid,topic) Values (?,?,?)");
//						insertStatement.setString(1, txt);
//						insertStatement.setString(2, userID);
//						insertStatement.setString(3, topic);
//
//						// insertStatement.setString(1, x);
//
//						insertStatement.executeUpdate();
//
//						cnn.close();
//
//						
//						// add ability to save input and alert them they have
//						// used
//						}
//						}
//					
//
//						model.addAttribute("test", input);
//				
//					// model.addAttribute("test2",wordList.get(0));
//
//				} else {
//
//					model.addAttribute("test", "You have used words prohibited by our community");
//				}
//
//			}
//		return"java";}catch(Exception e)
//	{
//		return "UnderConstruction";
//	}
//	}

	@RequestMapping(value = { "CS", "C++", "Other", "Python", "JavaScript", "HTML/CSS" }, method = RequestMethod.GET)
	public String underConstruction(HttpServletRequest request, Model model) {
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
		}
		
		return "java";
	}

}
