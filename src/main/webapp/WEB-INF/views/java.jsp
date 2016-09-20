<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<body>
 <h1>Welcome to our Java page</h1>
<h3> Search Database</h3>

<form method="get" action="search">
		<input type="text" name="topic">&nbsp &nbsp &nbsp
		<input type="submit" value = "search">
	</form>
<br>
<br>



<form action="java" method="get">
  <fieldset>
    <legend><h3>Pose a Question</h3></legend>
    Topic<br>
    <input type="insertQuestion" name="topic" placeholder = "ex: String, Array ..">
    <br>
    
    <div id ="div">
    Question:
    <textarea name="questionText" cols="50" rows="5" placeholder = "Question..">
	</textarea>
    <!-- <input type="submit" value="Submit" onclick = "writeToPage();"> -->
    <input type="submit" value="Submit">
 	</div>
 	<p><small> include code if you can</small></p>
    <br>
    <br>
   </fieldset>
</form>



${ctable}
${test} <br> 
${test2} 

<!-- <p>database place holder</p>  -->


</body>
</html>