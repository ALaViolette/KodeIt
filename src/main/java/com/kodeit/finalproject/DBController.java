package com.kodeit.finalproject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.sql.*;
/**
 * Handles requests for the application home page.
 */
@Controller
public class DBController {
   /* private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
  @RequestMapping(value="formPage", method = RequestMethod.GET)
    public String processForm(HttpServletRequest request,Model model)
    {
    
        String id = request.getParameter("id");
        
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        
        
        String password = request.getParameter("password");
        
        
        String question = request.getParameter("question");
        
        
        String answer = request.getParameter("answer");
        
        
        String comment = request.getParameter("comment");
        
        
        model.addAttribute("id", id);
        
        model.addAttribute("email", email);
        
        model.addAttribute("name", name);
        
        model.addAttribute("password", password);
        
        model.addAttribute("question", question);
        
        model.addAttribute("answer", answer);
        
        model.addAttribute("comment", comment);
        
        
        return "success";
        
    }
  */
  /*  @RequestMapping(value="myForm", method = RequestMethod.GET)
    public String processForm()
    {
        return "myForm";
    }*/
    
    
    
/*    @RequestMapping(value = "question", method = RequestMethod.GET)
    public String processSuccessfulLogin(HttpServletRequest request,
            HttpServletResponse response, Model model) {
        
        try {
            String Question = request.getParameter("question");
            model.addAttribute("question", Question);
            HttpSession session = request.getSession();
            session.setAttribute("Question", Question);
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/StackForUs","lily","lily123");
            String query1 = "INSERT INTO stack" + "(question) VALUES"
                    + "(?)";
            
            
            java.sql.PreparedStatement updateemail = conn
                    .prepareStatement(query1);
            updateemail.setString(1, Question);
            updateemail.execute();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return "java";
    }*/
    

	
    
    
    @RequestMapping(value="insertQuestion", method= RequestMethod.GET)
    //listCustomers is just a name, if you put it in the browser you can see it
    public String submitQuestion(Model model, HttpServletRequest request) throws ClassNotFoundException, SQLException{
        
        String userID="jj@jj.com";
        
        String topic = request.getParameter("topic");
        
        String txt = request.getParameter("questionText");
        
        
        
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/KodeIt","Tracyd","1W0rkB3nch6!"); 
            PreparedStatement insertStatement = cnn.prepareStatement("INSERT INTO userQuestion (questiontext,userid,topic) Values (?,?,?)");
            insertStatement.setString(1, txt);
            insertStatement.setString(2, userID);
            insertStatement.setString(3 ,topic);
            
            ;
           // insertStatement.setString(1, x);
            
            insertStatement .executeUpdate();     
            
            cnn.close();
        
        
        
        return "java";
        
    }
    
    
    
    @RequestMapping(value="listStack", method= RequestMethod.GET)
    //listCustomers is just a name, if you put it in the browser you can see it
    public String listAllCustomers(Model model)
    {    try
       {
        Class.forName("com.mysql.jdbc.Driver");
        Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306","Tracyd","1W0rkB3nch6!"); 
        
        String selectCommand = "select id, email, name from stack";
        
        Statement selectStatement = cnn.createStatement();
        
        ResultSet rs =selectStatement.executeQuery(selectCommand); 
        
        String output = "<table border=1>";
        
        while(rs.next()==true)
        {
            
            output+="<tr>";
            output+="<td>"+rs.getString(1)+"</td>";
            output+="<td>"+rs.getString(2)+"</td>";
            output+="</tr>";
           
            
        }
        
        output+="</table>";
        
        model.addAttribute("ctable", output);
        
        return "stack";
       }
    
    catch (Exception e)
    {
        // to do:
        // add this view: errorPage
        return "errorPage";
        
    }
    }
    
    @RequestMapping(value="insertedStack", method= RequestMethod.GET)
    public void insertStack(Model model)
    {    
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/KodeIt","Tracyd","1W0rkB3nch6"); 
            Statement insertStatement = cnn.createStatement();
            insertStatement .executeUpdate("INSERT INTO stack (id, email, password)" +
            "Values ('15, 'Mondayat11@gmail.com', 'yea')");
            cnn.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
    
    
    @RequestMapping(value = "login1", method = RequestMethod.GET)
    public String processRegister(HttpServletRequest request){
        //pub db code to insert the new user
        String id = request.getParameter("id");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String question = request.getParameter("question");
        String answer = request.getParameter("answer");
        String comment = request.getParameter("comment");
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/KodeIt","Tracyd","1W0rkB3nch6"); 
            String insertCommand = "insert into stack('"+id+"', '"+email+"', '"+name+"', '"+password+"', '"+question+"', '"+answer+"', '"+comment+"')";
                    //+ ", '"+email+"' )";
            Statement insertStatement = cnn.createStatement();
            
            insertStatement.executeUpdate(insertCommand);
            return "stack";
        }
            
            catch (Exception e) {
                System.out.println(e);
                return "UnderConstruction";
            }
                
            
        }
    
    
    
    
  @RequestMapping(value = "login", method = RequestMethod.POST)
    public String signup(HttpServletRequest request,Model model){
        String selectCommand;
//        id, email, password
        String firstName,lastName,email,passwd,id;
        boolean isValid = true;
//        firstName = request.getParameter("firstName");
//        lastName = request.getParameter("lastName");
//        email = request.getParameter("email");
//        passwd = request.getParameter("passwd");
                firstName = "ambyr";
                email = "test";
                id = "4";
        
         try {
            //load driver for mysql
             Class.forName("com.mysql.jdbc.Driver");
            //store the info to the DB orders
            Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/StackForUs","lily","lily123"); 
            //command
//            isValid = validateFlds(model, firstName, lastName, email, passwd);
//            if (!isValid){
//                //model.addAttribute("warning","All fields are mandatory. Please try again.");
//                return "signup";
//            }
//            else
//            {
                
                selectCommand = "insert into Users (id,email,firstName) values(?,?,?)";
                //create statement
                  PreparedStatement ps = cnn.prepareStatement(selectCommand);
                  ps.setString(1, id);
                  ps.setString(2, email);
                  ps.setString(3,firstName);
//                  ps.setString(4, passwd);
                // use ps to execute the command
                   ps.executeUpdate(); 
                   
//              }
                         
             return "login";
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            model.addAttribute("Error","Error encountered restart app");
            return "errorPage";
        }
        
        
      
    }
}
    
    