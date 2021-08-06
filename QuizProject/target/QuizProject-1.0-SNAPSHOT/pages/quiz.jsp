<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xchen
  Date: 8/1/2021
  Time: 5:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <html>
    <head>
        <title>Quiz</title>
        <link rel="stylesheet"
              href="${pageContext.request.contextPath}/css/styles.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    </head>
    <body>

    <%@include file="nav.jsp"%>
    <div class="container mt-5">
    <div class="d-flex justify-content-center row">
        <div class="col-md-10 col-lg-10">
            <div class="border">
                <div class="question bg-white p-3 border-bottom">
                    <div class="d-flex flex-row justify-content-between align-items-center mcq">
                        <h4>Get it going! </h4><span>Q${sessionScope.quizSession.curr + 1} of 5</span>
                    </div>
                </div>
                <form action="quiz" method="post" id ="my-form">
                <div class="question bg-white p-3 border-bottom">
                    <div class="d-flex flex-row align-items-center question-title">
                        <h3 class="text-danger">${sessionScope.quizSession.curr + 1}.</h3>
                        <h5 class="mt-1 ml-2">${sessionScope.quizSession.currentQuestion.question_text}</h5>
                    </div>
                    <c:forEach items="${sessionScope.quizSession.currentQuestion.options}" var="option">
                        <div class="ml-md-3 ml-sm-3 pl-md-5 pt-sm-0 pt-3" id="options">
                        <label class="options" for="${option.option_id}">
                            <input type="radio" name="radio" value="${option.option_id}" id="${option.option_id}">
                            ${option.option_text}
                            <span class="checkmark"></span>
                        </label>
                    </div>
                    </c:forEach>
                </div>

                <div class="d-flex flex-row justify-content-between align-items-center p-3 bg-white">
                    <button form = "my-form" class="btn btn-primary d-flex align-items-center btn-primary" type ="submit" name="button" value="previous">
                    <i class="fa fa-angle-left mt-1 mr-1"></i>
                    previous
                </button>
                    <button form = "my-form" class="btn btn-primary border-success align-items-center btn-danger" type ="submit" name="button" value="submit">
                        Submit
                        <i class="fa fa-angle-right ml-2"></i>
                    </button>
                    <button form = "my-form" class="btn btn-primary border-success align-items-center btn-success" type ="submit" name="button" value="next">
                        Next
                        <i class="fa fa-angle-right ml-2"></i>
                    </button>
                </div>
                </form>
            </div>


        </div>
    </div>
    </div>

</body>
</html>
