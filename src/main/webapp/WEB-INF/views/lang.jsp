<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">



<!-- Bootstrap Core CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="resources/css/full-slider.css" rel="stylesheet">


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Languages</title>

<style>
.dropbtn {
	background-color: Black;
	color: white;
	padding: 20px;
	font-size: 20px;
	border: none;
	cursor: pointer;
}

.dropbtn:hover, .dropbtn:focus {
	background-color: grey;
}

#myInput {
	border-box: box-sizing;
background-image: url('searchicon.png'); 
	background-position: 14px 12px;
	background-repeat: no-repeat;
	font-size: 16px;
	padding: 14px 20px 12px 45px;
	border: none;
}

.dropdown {
position: relative; 
 display: inline-block;  
}

.dropdown-content {
display: none;
/* 	display: inline-block; */
	postion: center;
	/* position: absolute; */
	background-color: #f6f6f6;
	min-width: 230px; 
	overflow: auto;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown a:hover {
	background-color: #ddd
}

.show {
	display: block;
}
</style>


</head>
<body>
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
</nav>
<br>
<br>
<center>
		<h1>Select A Language </h1>
	
		<div class="dropdown">
		
			<button onclick="myFunction()" class="dropbtn">Select a Language</button>
			<div id="myDropdown" class="dropdown-content">
				<input type="text" placeholder="Search.." id="myInput"
					onkeyup="filterFunction()"> 
					<a href="java">Java</a> 
					<a href="CS">C#</a> 
					<a href="C++">C++</a> 
					<a href="Python">Python</a>
					<a href="JavaScript">JavaScript</a> 
					<a href="HTML/CSS">HTML/CSS</a> 
					<a href="Other">Other</a>
			</div>
		
		</div>

	</center>
	<script>
		/* When the user clicks on the button,
		 toggle between hiding and showing the dropdown content */
		function myFunction() {
			document.getElementById("myDropdown").classList.toggle("show");
		}

		 function filterFunction() {
			var input, filter, ul, li, a, i;
			input = document.getElementById("myInput");
			filter = input.value.toUpperCase();
			div = document.getElementById("myDropdown");
			a = div.getElementsByTagName("a");
			for (i = 0; i < a.length; i++) {
				if (a[i].innerHTML.toUpperCase().indexOf(filter) > -1) {
					a[i].style.display = "";
				} else {
					a[i].style.display = "none";
				} 
		 	}
		} 
	</script>
	<!-- jQuery -->
	<script src="resources/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="resources/js/bootstrap.min.js"></script>

	

</body>
</html>