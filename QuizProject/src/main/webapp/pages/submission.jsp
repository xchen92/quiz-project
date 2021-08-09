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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>

<%@include file="nav.jsp"%>
<h1>Your Completion Results</h1>
<div class="list-group pt-5">


    <c:forEach items="${sessionScope.completions}" var = "completion">
        <a href="${pageContext.request.contextPath}/submission?submissionId=${completion.submission_id}"
           class="list-group-item list-group-action">
            quiz: ${completion.quiz_name} score: ${completion.score}
        </a>
    </c:forEach>

    <c:forEach items="${sessionScope.complete_questions}" var="question">
    <div class="d-flex flex-row align-items-center question-title">
            <h5 class="mt-1 ml-2">${question.question_text}</h5>
    </div>


        <c:forEach items="${sessionScope.quizSession2.getOptions(question.question_id)}" var="option">
            <div class="ml-md-3 ml-sm-3 pl-md-5 pt-sm-0 pt-3">

                <label class="options form-check-label" for="${option.option_id}" id="options">
                    <c:if test="${option.option_id == sessionScope.userSelectionMap.get(question)}">
                        <input type="radio" name="option" value="${option.option_id}" id="${option.option_id}" checked>
                        <div class="top-15"><span class="checkmark"></span></div>
                    </c:if>
                    <c:if test="${option.option_id != sessionScope.userSelectionMap.get(question)}">
                        <input type="radio" name="option" value="${option.option_id}" id="${option.option_id}" disabled>
                        <div class="top-15"><span class="checkmark"></span></div>
                    </c:if>
                        <c:if test="${sessionScope.userSelectionMap.get(question)==question.answer_id && option.option_id == sessionScope.userSelectionMap.get(question)}">
                        <div class = "bg-success text-white">
                        </c:if>
                            <c:if test="${sessionScope.userSelectionMap.get(question) != question.answer_id ||option.option_id != sessionScope.userSelectionMap.get(question)}">
                            <div>
                            </c:if>
                                <c:if test="${sessionScope.userSelectionMap.get(question) != question.answer_id && option.option_id == sessionScope.userSelectionMap.get(question)}">
                                <div class="bg-danger text-white">
                                    </c:if>
                    ${option.option_text}</div>
                </label>
            </div>
    </div>
        </c:forEach>
    </c:forEach>

</div>

</body>
</html>
