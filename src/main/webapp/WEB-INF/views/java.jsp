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

<title>Java</title>

<!-- Bootstrap Core CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="resources/css/full-slider.css" rel="stylesheet">



<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>


<body>
<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="home">KODEIT</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="about">About</a></li>
					<li><a href="lang">Questions</a></li>
					<li><a href="education">Education</a></li>
					<li><a href="login">Login</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
	<br>
	<br><!-- /.container -->

	<!-- jQuery -->
	<script src="resources/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="resources/js/bootstrap.min.js"></script>
 <h2>Java:</h2>
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