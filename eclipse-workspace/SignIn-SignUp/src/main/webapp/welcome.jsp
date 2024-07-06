<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Welcome</title>
<link rel="stylesheet" href="style.css">
<script defer src="script.js"></script>
</head>
<body>
	<div class="container">
		<div class="overlay-container">
			<div class="overlay">
				<div class="overlay-panel overlay-left">
					<h1>Welcome to our site!</h1>
					<p>
						Hello <strong>${sessionScope.name}</strong>, welcome back!
					</p>
					<p>Explore our services and stay connected.</p>
					<form action="logout" method="post">
						<button type="submit" class="ghost">Logout</button>
					</form>
				</div>
			</div>
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
