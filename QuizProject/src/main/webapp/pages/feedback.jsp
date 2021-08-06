<%--
  Created by IntelliJ IDEA.
  User: xchen
  Date: 8/1/2021
  Time: 4:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <title>Feedback</title>
</head>
<body>

<%@include file="nav.jsp"%>

<div class="container mt-2">
  <form action="/QuizProject_war_exploded/profile" method="POST">
    <div class="form-group">
      <label>Rate the quiz</label>
      <div class="star-rating">
        <input type="radio" name="rating" id="rating-5">
        <label for="rating-5"></label>
        <input type="radio" name="rating" id="rating-4">
        <label for="rating-4"></label>
        <input type="radio" name="rating" id="rating-3">
        <label for="rating-3"></label>
        <input type="radio" name="rating" id="rating-2">
        <label for="rating-2"></label>
        <input type="radio" name="rating" id="rating-1">
        <label for="rating-1"></label>
      </div>

      </span>

    </div>
    <div class="form-group">
      <label for="comment">Your comments</label>
      <input type="text" class="form-control" id="comment" name="comment" placeholder="Comment">
    </div>
    <button type="submit" class="btn btn-primary" id="submit">submit</button>
  </form>
</div>

</body>
</html>
