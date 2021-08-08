<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xchen
  Date: 8/8/2021
  Time: 2:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your Submission History</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/styles.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>

<%@include file="nav.jsp"%>
<h1>Your Completion Results</h1>
<div class="list-group mt-5">

    <c:forEach items="${sessionScope.completions}" var = "completion">
        <a href="${pageContext.request.contextPath}/submission?submissionId=${completion.submission_id}"
           class="list-group-item list-group-action">
            quiz: ${completion.quiz_name} score: ${completion.score}
        </a>
    </c:forEach>
</div>

</body>
</html>
