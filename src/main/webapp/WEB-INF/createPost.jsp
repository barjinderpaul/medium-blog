<%--
  Created by IntelliJ IDEA.
  User: barjinder
  Date: 22/12/19
  Time: 10:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Post form</title>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div>
        <a class="navbar-brand" href="#">
            <img src="https://img.icons8.com/ios-filled/50/000000/medium-logo.png" alt="medium-logo">
        </a>
        <span>Medium</span>
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
                <a class="nav-link" href="">
                    <p>Create Post</p>
                </a>
            </li>
        </ul>
    </div>
</nav>


<h1>Add post</h1>

<%--<form action="add">--%>
<%--    <label for="title">--%>
<%--        <input id="title" type="text" name="title" required>--%>
<%--    </label><br>--%>
<%--    <label for="content"><br>--%>
<%--        <input id="content" type="text" name="content" required>--%>
<%--    </label>--%>
<%--    <input type="submit" value="Publish">--%>
<%--</form>--%>

<form action= "<c:choose>
    <c:when test="${customAction == 'addPost'}">
        addPost
    </c:when>
    <c:otherwise>
        ./updates/${id}
    </c:otherwise>
</c:choose>"
method="post">
<div class="form-group">
    <label for="title">Title</label>
    <input id="title" type="text" class="form-control" id="exampleInputEmail1" placeholder="Enter title" name="title"
           required value="<c:if test="${customAction != 'addPost'}">${title}</c:if>">
    <small id="emailHelp" class="form-text text-muted">First 50 characters from content will be displayed as
        excerpt.</small>
</div>

<div class="md-form">
    <label for="content">Enter content</label>
    <textarea id="content" class="md-textarea form-control" rows="3" name="content" required></textarea>
</div>
<button type="submit" class="btn btn-primary">Publish Content</button>
</form>


</body>
</html>
