(function () {
  "use strict";

  // Wait for the DOM to be ready
  document.addEventListener("DOMContentLoaded", function () {
    // Smooth scroll for navigation links
    const navLinks = document.querySelectorAll("#navbar ul li a");

    if (window.innerWidth > 790) {
      navLinks.forEach((link) => {
        link.addEventListener("click", smoothScroll);
      });
    }

    function smoothScroll(event) {
      event.preventDefault();
      const targetId = this.getAttribute("href").substring(1);
      const targetElement = document.getElementById(targetId);

      window.scrollTo({
        top: targetElement.offsetTop - document.getElementById("navbar").offsetHeight,
        behavior: "smooth",
      });
    }
  });

    // Form submission handling
    const form = document.querySelector("#contact-box form");

    form.addEventListener("submit", function (event) {
      event.preventDefault();

      // Fetch form data
      const name = document.getElementById("name").value;
      const email = document.getElementById("email").value;
      const phone = document.getElementById("phone").value;
      const message = document.getElementById("message").value;

      // Placeholder for sending data to a server (backend)
      form.reset();

      // Optional
      alert("Form submitted successfully!");
    });

    // Services-Box handling
    const wears = document.getElementById("Wears");
    const supplements = document.getElementById("Supplements");
    const trainer = document.getElementById("Trainer");

    wears.addEventListener("click", function () {
      window.location.href = "https://www.gymarmour.co/";
    });

    supplements.addEventListener("click", function () {
      window.location.href = "https://www.bravonutrition.pk/";
    });

    trainer.addEventListener("click", function () {
      window.location.href = "https://www.movenfit.pk/";
    });

    // Personal-Logo handling
    const Instagram = document.getElementById("Instagram");
    const Linkdin = document.getElementById("Linkdin");

    Instagram.addEventListener("click", function () {
      window.location.href = "https://www.instagram.com/pandistic._.zain/";
    });

    Linkdin.addEventListener("click", function () {
      window.location.href = "https://www.linkedin.com/in/zain-ul-abideen-b9215a283/";
    });

    // Register-Online handling
    const registerBtn = document.getElementById("Register-btn");

    registerBtn.addEventListener("click", function () {
      window.location.href = "https://forms.gle/w1XZWim3oTgB88qt5";
    });
  })();