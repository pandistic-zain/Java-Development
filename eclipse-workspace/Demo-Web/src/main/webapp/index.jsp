<!-- index.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
    <style>
        /* Basic styling for demonstration */
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        .navbar {
            background-color: #f2f2f2;
            overflow: hidden;
        }
        .navbar a {
            float: left;
            display: block;
            color: black;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }
        .navbar a:hover {
            background-color: #ddd;
            color: black;
        }
        .content {
            padding: 20px;
        }
    </style>
</head>
<body>

<div class="navbar">
    <!-- Login button in navbar -->
    <form action="login.jsp" style="display: inline;">
        <button type="submit">Login</button>
    </form>
    
    <!-- Signup button in navbar -->
    <form action="register.jsp" style="display: inline;">
        <button type="submit">Sign Up</button>
    </form>
</div>

<div class="content">
    <h1>Welcome to My Website</h1>
    <p>Some random strings or content here...</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla condimentum tortor eu nunc fermentum blandit.</p>
    <p>Phasellus dapibus odio nec metus fringilla hendrerit.</p>
</div>

</body>
</html>
