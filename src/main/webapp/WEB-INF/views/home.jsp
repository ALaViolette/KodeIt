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

<title>Kode It</title>

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

	<!-- Full Page Image Background Carousel Header -->
	<header id="myCarousel" class="carousel slide">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>

		<!-- Wrapper for Slides -->
		<div class="carousel-inner">
			<div class="item active">
				<!-- Set the first background image using inline CSS below. -->
				<div class="fill"
					style="background-image: url('https://c51wmg-ch3301.files.1drv.com/y3mV3_BPu2cwTQMWvsjwGPF-rdZQy7lSDbRfgGnr5tkbUbV0te9WMOuAA6BisEsF7mW52iCuItvKJNNxMCGZq7sDY0BXyPwwkWBWwT04-oUzdgjPNrT7dDW5T7VXsPYBAXUaLUEMiEYR6TPGNU1sl9-DDxLlOYjcxOimvwcxC-nRCM?width=5291&amp;height=2714&amp;cropmode=none');"></div>
				<div class="carousel-caption">
					<header>  <h1>("Hello; Need Help?")</h1></header>
				</div>
			</div>
			<div class="item">
				<!-- Set the second background image using inline CSS below. -->
				<div class="fill"
					style="background-image: url('https://asunow.asu.edu/sites/default/files/styles/asu_news_article_hero/public/screaming-1436580-1600x1200.jpg?itok=Lkwz3ef7');"></div>
				<p> hello</p>
				<div class="carousel-caption">
					<h1>While(true)</h1>
					
				</div>
			</div>
			<div class="item">
				<!-- Set the third background image using inline CSS below. -->
				<div class="fill"
					style="background-image: url('https://regmedia.co.uk/2015/08/20/shutterstock_306575414_woman_programmer.jpg?x=1200&amp;y=794');"></div>
				<div class="carousel-caption">
					<h1>
						{ <br> KODE(IT); <br> }
						
					</h1>
				</div>
			</div>
		</div>

		<!-- Controls -->
		<a class="left carousel-control" href="#myCarousel" data-slide="prev">
			<span class="icon-prev"></span>
		</a> <a class="right carousel-control" href="#myCarousel"
			data-slide="next"> <span class="icon-next"></span>
		</a>

	</header>

	<!-- Page Content -->
	<div class="container">

		<div class="row">
			<div class="col-lg-12">

			</div>
		</div>

		<hr>

		<!-- Footer -->
		<footer>
			<div class="row">
				<div class="col-lg-12">
					<p>Copyright &copy; Your Website 2014</p>
				</div>
			</div>
			<!-- /.row -->
		</footer>

	</div>
	<!-- /.container -->

	<!-- jQuery -->
	<script src="resources/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="resources/js/bootstrap.min.js"></script>

	<!-- Script to Activate the Carousel -->
	<script>
		$('.carousel').carousel({
			interval : 5000
		//changes the speed
		})
	</script>

</body>

</html>
