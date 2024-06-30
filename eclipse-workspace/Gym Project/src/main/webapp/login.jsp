<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Login/Register - G-7 Fitness-Club</title>
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
          <form action="LServlet" method="post">
            <div class="form-group">
              <label for="login-email">Email:</label>
              <input type="email" name="email" id="login-email" required />
            </div>
            <div class="form-group">
              <label for="login-password">Password:</label>
              <input
                type="password"
                name="password"
                id="login-password"
                required
              />
            </div>
            <div class="form-group">
              <input type="submit" value="Login" class="btn" />
            </div>
          </form>
        </div>
      </section>
    </main>
  </body>
</html>
