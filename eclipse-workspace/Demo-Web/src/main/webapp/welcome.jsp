<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .welcome-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
            text-align: center;
        }
        .welcome-container h1 {
            margin-bottom: 20px;
        }
        .welcome-container p {
            margin-bottom: 10px;
        }
        .logout-button {
            background-color: #f44336;
            color: white;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            border-radius: 4px;
            cursor: pointer;
        }
        .logout-button:hover {
            background-color: #d32f2f;
        }
    </style>
</head>
<body>

<div class="welcome-container">
    <h1>Welcome, <%= session.getAttribute("username") %>!</h1>

    <p>You are now logged in.</p>
    
    <form action="logoutServlet" method="post">
        <button type="submit" class="logout-button">Logout</button>
    </form>
</div>

</body>
</html>
