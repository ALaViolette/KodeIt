<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "javax.sql.*" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="java" method="get">
    QuestionID<br>
    <input type="text" name="questionID" ">
    <br>
    AnswerID<br>
    <input type="text" name="answerID" ">
    <br>
    Answer:<br>
    <textarea name="answer" cols="50" rows="5" ">
	</textarea>
    <!-- <input type="submit" value="Submit" onclick = "writeToPage();"> -->
    <input type="submit" value="Submit">


 
</form>

</body>
</html>