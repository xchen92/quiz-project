<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/styles.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>JSP - Hello World</title>
</head>
<body>
<%@include file="nav.jsp"%>
<h1><%= "Welcome to the quiz :)" %>
</h1>
</br>

<div class = "quiz-block">
    <div class="row">
        <c:forEach items = "${sessionScope.quizzes}" var = "quiz">
        <div class="col-md-6">
            <div class="card" style="width: 18rem;">
                <img class="card-img-top" src="${pageContext.request.contextPath}/images/${quiz.quiz_img}" alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title">${quiz.quiz_name}</h5>
                    <p class="card-text">Let's do this</p>
                    <a href="quiz?quiz=${quiz.quiz_id}&user=${sessionScope.username}" class="btn btn-primary">Start</a>
                </div>
            </div>
        </div>
        </c:forEach>
    </div>
</div>

</body>
</html>