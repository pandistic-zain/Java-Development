<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<title>G-7 Fitness-Club</title>
<link rel="stylesheet" href="WelcomeStyle.css" />
<link rel="stylesheet" media="screen and (max-width: 790px)"
	href="WelcomePhone.css" />
<link
	href="https://fonts.googleapis.com/css?family=Baloo+Bhai|Bree+Serif&amp;display=swap"
	rel="stylesheet" />
<link rel="icon" href="Pictures/LogoVector.png" type="image/png" />
<script src="script.js" defer type="text/javascript"></script>
</head>

<body>
	<header>
		<!-- Navigation Bar -->
		<nav id="navbar">
			<div id="logo">
				<img src="Pictures/logo.png" alt="Fitness-Club.com" />
				<h3>The Fitness-Club</h3>
			</div>
			<ul>
				<li class="item"><a href="#Home-Section">Home</a></li>
				<li class="item"><a href="#Services-Section">Services</a></li>
				<li class="item"><a href="#Contact-Section">Suggestion</a></li>
				<li class="item"><a href="#Partners-Section">Our Partners</a></li>
			</ul>
		<div class="admin-area">
    <form action="logout" method="post">
        <button type="submit" id="logoutBtn">Log Out</button>
    </form>
</div>

		</nav>
	</header>

	<main>
		<!-- Home Section -->
		<section id="Home-Section">
			<div class="hacker-text">
				<h1>
					Welcome to Fitness-Club --
					<%=session.getAttribute("name")%>
				</h1>
			</div>
			<p>At Fitness-Club, we believe in empowering our members through
				fitness and wellness. Our state-of-the-art facilities and expert
				trainers ensure that your fitness journey is both enjoyable and
				effective.</p>
			<button class="btn" id="Register-btn">Register Online</button>
		</section>

		<!-- Services Section -->
		<section id="Services-Section">
			<h1 class="h-primary center">Our Services</h1>
			<div id="services">
				<!-- Service Box 1 -->
				<div class="box" id="Wears">
					<img src="Pictures/1.png" alt="" />
					<h2 class="h-secondary center">Gym Wears</h2>
					<p class="center">Our gym wears are designed for comfort and
						performance. Whether you're lifting weights or doing cardio, our
						collection includes breathable fabrics and ergonomic designs to
						support your workout routine.</p>
				</div>
				<!-- Service Box 2 -->
				<div class="box" id="Supplements">
					<img src="Pictures/2.png" alt="" />
					<h2 class="h-secondary center">Food Supplements</h2>
					<p class="center">Enhance your fitness journey with our range
						of food supplements. Carefully selected for quality and
						effectiveness, our supplements provide essential nutrients to
						support muscle growth, recovery, and overall health.</p>
				</div>
				<!-- Service Box 3 -->
				<div class="box" id="Trainer">
					<img src="Pictures/3.png" alt="" />
					<h2 class="h-secondary center">Private Trainer</h2>
					<p class="center">Personalize your training experience with our
						dedicated private trainers. Certified professionals will guide you
						through tailored workouts, focusing on your goals and ensuring
						proper form and technique for maximum results.</p>
				</div>
			</div>
		</section>

		<!-- Contact Section -->
		<section id="Contact-Section">
			<h1 class="h-primary center">Suggestion For Us</h1>
			<div id="contact-box">
				<form action="">
					<!-- Name Input -->
					<div class="form-group">
						<label for="name">Name: </label> <input type="text" name="name"
							id="name" placeholder="Enter your name" />
					</div>
					<!-- Email Input -->
					<div class="form-group">
						<label for="email">Email: </label> <input type="email" name="name"
							id="email" placeholder="Enter your email" />
					</div>
					<!-- Phone Input -->
					<div class="form-group">
						<label for="phone">Phone Number: </label> <input name="name"
							id="phone" placeholder="Enter your phone" />
					</div>
					<!-- Message Input -->
					<div class="form-group">
						<label for="message">Message: </label>
						<textarea name="message" id="message" cols="30" rows="10"></textarea>
					</div>
					<!-- Submit Button -->
					<div id="submit_form">
						<label for="submit"></label> <input type="submit"
							value="Submit Now" class="btn" />
					</div>
				</form>
			</div>
		</section>
		<!-- Partners Section -->
		<section id="Partners-Section">
			<h1 class="h-primary center">Our Partners</h1>
			<div id="Partners">
				<!-- Partner 1 -->
				<div class="Partners-item">
					<img src="Pictures/logo1.png" alt="Our Partners" />
				</div>
				<!-- Partner 2 -->
				<div class="Partners-item">
					<img src="Pictures/logo2.png" alt="Our Partners" />
				</div>
				<!-- Partner 3 -->
				<div class="Partners-item">
					<img src="Pictures/logo4.png" alt="Our Partners" />
				</div>
				<!-- Partner 4 -->
				<div class="Partners-item">
					<img src="Pictures/logo3.png" alt="Our Partners" />
				</div>
			</div>
		</section>
	</main>
	<!-- Footer -->
	<footer>
		<div class="center">Copyright &copy; www.Fitness-Club.com. All
			rights reserved!</div>
		<div class="personal-logos">
			<img src="Pictures/icons8-instagram.gif" alt="Instagram"
				id="Instagram" /> <img src="Pictures/icons8-linkedin-logo.gif"
				alt="Linkd-In" id="Linkdin" />
		</div>
	</footer>
</body>

</html>