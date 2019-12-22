<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.medium.Model.Posts" %>
<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: barjinder
  Date: 21/12/19
  Time: 2:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Blog Posts</title>
</head>
<body>

    <h1>Add post</h1>

    <form action="addPost">
        <label for="title">
            <input id="title" type="text" name="title" required>
        </label>
        <label for="content">
            <input id="content" type="text" name="content" required>
        </label>
        <input type="submit" value="Publish">
    </form>

</body>
</html>

