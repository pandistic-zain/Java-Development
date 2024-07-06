<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Login - G-7 Fitness-Club</title>
<link rel="icon" href="Pictures/LogoVector.png" type="image/png" />
<link rel="stylesheet" href="login_register.css" />
</head>
<body>
	<header>
		<nav id="navbar">
			<div id="logo">
				<img src="Pictures/logo.png" alt="Fitness-Club.com" />
				<h3>G-7 Fitness-Club</h3>
			</div>
		</nav>
	</header>
	<main>
		<section id="login-register-section">
			<div class="form-container">
				<h1>Login</h1>
				<form action="LoginServlet" method="post">
					<div class="form-group">
						<label for="login-email">Email:</label> <input type="email"
							name="email" id="login-email" required />
					</div>
					<div class="form-group">
						<label for="login-password">Password:</label> <input
							type="password" name="password" id="login-password" required />
					</div>
					<div class="form-group">
						<input type="submit" value="Login" class="btn" />
					</div>
				</form>
				<p>
					<a href="index.html">Back to Home</a>
				</p>

				<%-- Display error message if login fails --%>
				<%
				String error = request.getParameter("error");
				if (error != null && error.equals("1")) {
				%>
				<p
					style="background-color: #f8d7da; color: #721c24; border: 4px solid #f5c6cb; border-radius: 10px; margin: 15px; padding: 12px;">Invalid
					username or password.</p>
				<%
				}
				%>


			</div>
		</section>
	</main>
</body>
</html>