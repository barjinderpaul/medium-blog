<%--<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href=<%=request.getParameter("cssFile")%>>
    <title> <%= request.getParameter("title") %> </title>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div>
        <a class="navbar-brand" href="#">
            <img src="https://miro.medium.com/max/195/1*emiGsBgJu2KHWyjluhKXQw.png" alt="Logo">
        </a>
        <a class="navbar-brand" href="#">
            <img src="https://finzy.com/assets/images/badge_small.png" width="60px" alt="">
        </a>
        <span> NBFC-P2P </span>
    </div>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ml-auto ">
            <li class="nav-item active">
                <a class="nav-link" href="./">
                    <p>Home</p>
                </a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="feedback">
                    <p>Contact Us</p>
                </a>
            </li>

            <% if(session.getAttribute("Username") != null) { %>
            <li>
                <a href="admin" class="logout-btn" style="border-bottom: 0">
                    <input type="submit" class="btn" value="Feedback Entries">
                </a>
            </li>
            <li>
                <form action="logout">
                    <a href="login" class="logout-btn" style="border-bottom: 0">
                        <input type="submit" class="btn" value="Logout">
                    </a>
                </form>
            </li>
            <% } else { %>
            <li>
                <a href="login" class="login-btn">
                    <input type="submit" class="btn" value="Login">
                </a>
            </li>
            <li>
                <a href="register" class="login-btn">
                    <input type="submit" class="btn" value="Register">
                </a>
            </li>

            <% } %>

        </ul>
    </div>
</nav>