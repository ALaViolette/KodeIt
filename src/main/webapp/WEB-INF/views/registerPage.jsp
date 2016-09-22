<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">



		<form action="RegisterPage.jsp" method="post"> <br/>
			<h1>Login Form</h1>
			<div>
				Email:<input type="text" name="userID"> <br/>
			</div>
			<div>
				Name:<input type="text" name="firstName"> <br/>
			</div>
			
			<div>
				Last Name:<input type="text" name="lastName"> <br/>
			</div>
			
			<div>
				Password:<input type="password" name="password"> <br/>
			</div>
			<div>
				<input type="submit" value="submit" /> <a href="#">Lost your
					password?</a> 
					<!-- <a href="login">Register</a> -->
			</div>
		</form>
		

</body>
</html>

