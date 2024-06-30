<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>G-7 Fitness-Club</title>
    <link rel="stylesheet" href="style.css" />
    <link
      rel="stylesheet"
      media="screen and (max-width: 790px)"
      href="phone.css"
    />
    <link
      href="https://fonts.googleapis.com/css?family=Baloo+Bhai|Bree+Serif&display=swap"
      rel="stylesheet"
    />
    <link rel="icon" href="Pictures/LogoVector.png" type="image/png" />
    <script src="script.js" defer></script>
  </head>

  <body>
    <header>
      <!-- Navigation Bar -->
      <nav id="navbar">
        <div id="logo">
          <img src="Pictures/logo.png" alt="Fitness-Club.com" />
          <h3>G-7 Fitness-Club</h3>
        </div>
        <ul>
          <li class="item"><a href="#Home-Section">Home</a></li>
          <li class="item"><a href="#Services-Section">Services</a></li>
          <li class="item"><a href="#Contact-Section">Suggestion</a></li>
          <li class="item"><a href="#Partners-Section">Our Partners</a></li>
        </ul>
        <div class="admin-area">
          <a href="login.jsp"><button id="loginBtn">Login</button></a>
          <a href="register.jsp"><button id="registerBtn">Register</button></a>
        </div>
      </nav>
    </header>
    <main>
      <!-- Home Section -->
      <section id="Home-Section">
        <h1 class="h-primary">Welcome to Fitness-Club</h1>
        <p>
          Lorem ipsum dolor sit amet consectetur, adipisicing elit. Perferendis
          dolorum numquam minus.
        </p>
        <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit.</p>
      </section>

      <!-- Services Section -->
      <section id="Services-Section">
        <h1 class="h-primary center">Our Services</h1>
        <div id="services">
          <!-- Service Box 1 -->
          <div class="box" id="Wears">
            <img src="Pictures/1.png" alt="" />
            <h2 class="h-secondary center">Gym Wears</h2>
            <p class="center">
              Lorem ipsum dolor sit, amet consectetur adipisicing elit. Quidem,
              culpa suscipit error Lorem ipsum dolor sit, amet consectetur
              adipisicing elit. Et qui, repudiandae similique nam, recusandae
              quidem ab asperiores ex, aut fugit labore veritatis facere? sint
              delectus ab dolorum nam. Debitis facere, incidunt voluptates eos,
              mollitia voluptatem iste sunt voluptas beatae facilis labore,
              omnis sint quae eum.
            </p>
          </div>
          <!-- Service Box 2 -->
          <div class="box" id="Supplements">
            <img src="Pictures/2.png" alt="" />
            <h2 class="h-secondary center">Food Supplements</h2>
            <p class="center">
              Lorem ipsum dolor sit, amet consectetur adipisicing elit. Quidem,
              culpa suscipit error Lorem ipsum dolor sit amet consectetur
              adipisicing elit. Unde laudantium a incidunt animi ad, ab
              dignissimos vero? Unde numquam odit repudiandae perferendis nisi.
              sint delectus ab dolorum nam. Debitis facere, incidunt voluptates
              eos, mollitia voluptatem iste sunt voluptas beatae facilis labore,
              omnis sint quae eum.
            </p>
          </div>
          <!-- Service Box 3 -->
          <div class="box" id="Trainer">
            <img src="Pictures/3.png" alt="" />
            <h2 class="h-secondary center">Private Trainer</h2>
            <p class="center">
              Lorem ipsum dolor sit, amet consectetur adipisicing elit. Quidem,
              culpa suscipit error Lorem ipsum dolor sit amet consectetur
              adipisicing elit. Necessitatibus provident fugiat aliquam minima
              at explicabo. Earum eveniet quaerat, sunt molestias nesciunt quas!
              Quis. sint delectus ab dolorum nam. Debitis facere, incidunt
              voluptates eos, mollitia voluptatem iste sunt voluptas beatae
              facilis labore, omnis sint quae eum.
            </p>
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
              <label for="name">Name: </label>
              <input
                type="text"
                name="name"
                id="name"
                placeholder="Enter your name"
              />
            </div>
            <!-- Email Input -->
            <div class="form-group">
              <label for="email">Email: </label>
              <input
                type="email"
                name="name"
                id="email"
                placeholder="Enter your email"
              />
            </div>
            <!-- Phone Input -->
            <div class="form-group">
              <label for="phone">Phone Number: </label>
              <input
                type="phone"
                name="name"
                id="phone"
                placeholder="Enter your phone"
              />
            </div>
            <!-- Message Input -->
            <div class="form-group">
              <label for="message">Message: </label>
              <textarea
                name="message"
                id="message"
                cols="30"
                rows="10"
              ></textarea>
            </div>
            <!-- Submit Button -->
            <div id="submit_form">
              <label for="submit"></label>
              <input type="submit" value="Submit Now" class="btn" />
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
      <div class="center">
        Copyright &copy; www.Fitness-Club.com. All rights reserved!
      </div>
      <div class="personal-logos">
        <img
          src="Pictures/icons8-instagram.gif"
          alt="Instagram"
          id="Instagram"
        />
        <img
          src="Pictures/icons8-linkedin-logo.gif"
          alt="Linkd-In"
          id="Linkdin"
        />
      </div>
    </footer>
  </body>
</html>
