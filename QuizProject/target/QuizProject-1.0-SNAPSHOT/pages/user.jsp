<%--
  Created by IntelliJ IDEA.
  User: xchen
  Date: 8/1/2021
  Time: 4:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Profile Page</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/styles.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>

<%@include file="nav.jsp"%>
<div class="mt-5 d-flex justify-content-center ">
    <div class="p-3">
            <div class="text-center py-4"> <img src="${pageContext.request.contextPath}/images/profile.jpg" class="rounded-circle" width="200">
                <h3 class="mt-2 mb-0">${sessionScope.username}</h3> <small>@${sessionScope.username}</small>
                <div class="stats d-flex justify-content-between px-3 mt-3">
                    <div class="stats-1 d-flex flex-column"> <span>16</span> <span>Completion</span> </div>
                    <div class="stats-1 d-flex flex-column"> <span>80%</span> <span>Average Score</span> </div>
                </div>
            </div>
            <div class="text-center py-3 px-3">
                <h4>About</h4>
                <p class="text-justify big-text">I believe that if life gives you lemons, you should make lemonade... And try to find somebody whose life has given them vodka, and have a party..</p>
            </div>
    </div>
</div>

</body>
</html>
