<%--
  Created by IntelliJ IDEA.
  User: xchen
  Date: 8/1/2021
  Time: 4:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

  <title>Log in</title>
</head>
<body>
<%@include file="nav.jsp"%>

<div class="container mt-2">
  <form action="/QuizProject_war_exploded/login" method="GET">
    <div class="form-group">
      <label for="username">User Name</label>
      <input type="text" class="form-control" id="username" name="username" placeholder="User Name">
    </div>
    <div class="form-group">
      <label for="password">Password</label>
      <input type="password" class="form-control" id="password" name="password" placeholder="Password">
    </div>
    <button type="submit" class="btn btn-primary" id="submit">Login</button>
  </form>
</div>

</body>
</html>
