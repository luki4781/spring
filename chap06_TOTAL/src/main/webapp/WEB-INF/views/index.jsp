<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--  <script type="text/javascript" src="/js/custom.js"></script>-->
<head>
<title>Juventus Football Club</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.carousel-inner>.item>img, .carousel-inner>.item>a>img {
	width: 70%;
	margin: auto;
}
</style>
</head>
<body>
	<div align="center">
		<h1>Le zebre!</h1>
	</div>
	<div class="container">
		<br>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
				<li data-target="#myCarousel" data-slide-to="4"></li>
				<li data-target="#myCarousel" data-slide-to="5"></li>
			</ol>
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img src="/juventus/juventus.jpg" alt="JuventusFC"
						style="width: 500px; height: 345px;">
					<div class="carousel-caption">
						<h3>Juventus FC</h3>
						<p>Juventus Football Club S.p.A.</p>
					</div>
				</div>
				<div class="item">
					<img src="/juventus/buffon.jpg" alt="Gianluigi Buffon"
						style="width: 500px; height: 345px;">
					<div class="carousel-caption">
						<h3>Gianluigi Buffon</h3>
						<p>GK</p>
					</div>
				</div>
				<div class="item">
					<img src="/juventus/Trezeguet.jpg" alt="David Trezeguet"
						style="width: 500px; height: 345px;">
					<div class="carousel-caption">
						<h3>David Trezeguet</h3>
						<p>ST</p>
					</div>
				</div>
				<div class="item">
					<img src="/juventus/delpiero.jpg" alt="Alessandro Del Piero"
						style="width: 500px; height: 345px;">
					<div class="carousel-caption">
						<h3>Alessandro Del Piero</h3>
						<p>CF</p>
					</div>
				</div>
				<div class="item">
					<img src="/juventus/nedved.jpg" alt="Pavel Nedved"
						style="width: 500px; height: 345px;">
					<div class="carousel-caption">
						<h3>Pavel Nedved</h3>
						<p>MF</p>
					</div>
				</div>
				<div class="item">
					<img src="/juventus/pirlo.jpg" alt="Andrea pirlo"
						style="width: 500px; height: 345px;">
					<div class="carousel-caption">
						<h3>Andrea pirlo</h3>
						<p>MF</p>
					</div>
				</div>
			</div>
			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" role="button"
				data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel" role="button"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>

		</div>
	</div>
</body>
