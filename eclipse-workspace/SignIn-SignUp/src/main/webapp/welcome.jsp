
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Welcome to Authenticator</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<link rel="stylesheet" href="welcomestlye.css">
</head>
<body>
	<h2>Welcome to Authenticator!</h2>

	<div class="container" id="container">
		<div class="welcome-panel">
			<h1>Welcome User!</h1>
			<p>You are now logged in to your account.</p>
			<p>Explore our exciting content and enjoy your time on Authenticator.</p>
			<a href="#">Start Exploring</a>

			<form action="logout" method="post">
				<button type="submit" class="ghost">Logout</button>
			</form>
		</div>
	</div>
	<footer>
		<p>
			Created with <i class="fa fa-heart"></i> by <a target="_blank"
				href="https://florin-pop.com">Florin Pop</a> - Read how I created
			this and how you can join the challenge <a target="_blank"
				href="https://www.florin-pop.com/blog/2019/03/double-slider-sign-in-up-form/">here</a>.
		</p>
	</footer>
</body>
</html>
