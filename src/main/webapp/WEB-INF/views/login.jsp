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



<!-- Bootstrap Core CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="resources/css/full-slider.css" rel="stylesheet">

<link href="resources/css/login.css" rel="stylesheet">


<!-- <meta name="google-signin-scope" content="profile email"> -->
   <!--  <meta name="google-signin-client_id" content="385584717683-2hr5neg70lj0kr39oijqrl34vjmldcbm.apps.googleusercontent.com">
    <script src="https://apis.google.com/js/platform.js" async defer></script> -->
<title>Login</title>

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
<br>
<br>
<br>
<br>
	
	<div class="container">
		<section id="content">
		<form method = "post" action="submit">
			<h1>Start Coding!</h1>
			<div>
				<input type="text" name = "userID" placeholder="email" required="" id="email" />
			</div>
			<div>
				<input type="password" name = "password" placeholder="Password" required=""
					id="password" />
			</div>
			<div>
				<input type="submit" value="Log in" /> <a href="#">Lost your
					password?</a> <a href="#">Register</a>
			</div>
		</form>
		<!-- form -->
		
		<!-- button --> </section>
		<!-- content -->
	</div>
	<!-- container -->
	
	<%-- <!-- Google api -->
	
	
	
	<center><div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark"></div></center>
	
    <script>
      function onSignIn(googleUser) {
        // Useful data for your client-side scripts:
        var profile = googleUser.getBasicProfile();
        console.log("ID: " + profile.getId()); // Don't send this directly to your server!
        console.log('Full Name: ' + profile.getName());
      /*   console.log('Given Name: ' + profile.getGivenName());
        console.log('Family Name: ' + profile.getFamilyName());
        console.log("Image URL: " + profile.getImageUrl()); */
        console.log("Email: " + profile.getEmail());

        // The ID token you need to pass to your backend:
        var id_token = googleUser.getAuthResponse().id_token;
        console.log("ID Token: " + id_token);
        
     // auth2 is initialized with gapi.auth2.init() and a user is signed in.

     /*    if (auth2.isSignedIn.get()) {
          var profile = auth2.currentUser.get().getBasicProfile();
          console.log('ID: ' + profile.getId());
          console.log('Full Name: ' + profile.getName());
       /*    console.log('Given Name: ' + profile.getGivenName());
          console.log('Family Name: ' + profile.getFamilyName());
          console.log('Image URL: ' + profile.getImageUrl()); 
          console.log('Email: ' + profile.getEmail());
        } */
        
        
        
        var id_token = googleUser.getAuthResponse().id_token;
       /* requestObject = {'id_token': id_token }; */
        
        var xhr = new XMLHttpRequest();
        xhr.open('POST', '/finalproject/signIn');
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xhr.onload = function() {
          console.log('Signed in as: ' + xhr.responseText);
        };
        xhr.send("id_token="+id_token);
      };
  	 --%>
    
		
  <!--   </script> -->
  	<!-- jQuery -->
	<script src="resources/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="resources/js/bootstrap.min.js"></script>


</body>
</html>