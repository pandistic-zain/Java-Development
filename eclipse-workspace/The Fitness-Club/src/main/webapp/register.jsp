<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Register - G-7 Fitness-Club</title>
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
          <h1>Register</h1>
          <form action="RegisterServlet" method="post">
            <div class="form-group">
              <label for="register-name">Name:</label>
              <input type="text" name="username" id="register-name" required />
            </div>
            <div class="form-group">
              <label for="register-email">Email:</label>
              <input type="email" name="email" id="register-email" required />
            </div>
            <div class="form-group">
              <label for="register-password">Password:</label>
              <input
                type="password"
                name="password"
                id="register-password"
                required
              />
            </div>
            <div class="form-group">
              <input type="submit" value="Register" class="btn" />
            </div>
          </form>
           <p><a href="index.html">Back to Home</a></p>
    
        <%-- Display error message if registration fails --%>
        <% String error = request.getParameter("error");
           if (error != null && error.equals("1")) { %>
            <p style="background-color: #f8d7da;
  color: #721c24;
  border: 4px solid #f5c6cb;
    border-radius: 10px;
  margin:15px;
  padding:12px;
            ">Registration failed. Please try again.</p>
        <% } %>
          <%-- Display error message if Register Successful --%>
        <% String rs = request.getParameter("registration");
            if (rs != null && rs.equals("success")) { %>
                <p style="  background-color: #d4edda;
  color: #155724;
  border: 4px solid #c3e6cb;
    border-radius: 10px;
  margin:15px;
  padding:12px;
  white-space:nowrap;">Registration is Successful. Please Login.</p>
        <% } %>
        </div>
      </section>
    </main>
  </body>
</html>