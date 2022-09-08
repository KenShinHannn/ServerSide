<%--
  Created by IntelliJ IDEA.
  User: c3bos
  Date: 8/31/2022
  Time: 2:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Favorite Subjects</title>
</head>
<body>
    <h3>Please Select Favourite Subject::</h3> <hr>
    <form method="post" action="TestReqParam">
      Student Id: <input type="number" name="student_id"> <br>
      Name: <input type="text" name="name"> <br>
      Favourite Subjects: <br>
      &nbsp; <input type="checkbox" name="fav_subjects" value="INT100">INT101 - Programming Fundamentals"<br>
      &nbsp; <input type="checkbox" name="fav_subjects" value="INT102">INT102 - Web Technology<br>
      &nbsp; <input type="checkbox" name="fav_subjects" value="INT114">INT114 - Discrete Mathematics"<br>
      &nbsp; <input type="checkbox" name="fav_subjects" value="GEN101">GEN101 - Physical Education<br>
      &nbsp; <input type="checkbox" name="fav_subjects" value="GEN111">GEN111 - Man and Ethics of Living"<br>
      &nbsp; <input type="checkbox" name="fav_subjects" value="LNG120">LNG120 - General English"<br>
      &nbsp; <input type="checkbox" name="fav_subjects" value="LNG220">LNG220 - Academic English"<br>
      &nbsp; <input type="checkbox" name="fav_subjects" value="INT103">INT103 - Advanced Programming"<br>
      &nbsp; <input type="checkbox" name="fav_subjects" value="INT104">INT104 - User Experience Design"<br>
      &nbsp; <input type="checkbox" name="fav_subjects" value="INT105">INT105 - Basic SQL<br>
      <br>
      <input type="submit">
    </form>
    <hr>
    <c:if test="${paramValues.fav_subjects != null}">
        Hello ${param.name}, id: ${param.student_id} <br>
        You selected favorite subject: <br>
        <c:forEach items="${paramValues.fav_subjects}" var="subject">
            &nbsp; &nbsp; &nbsp; ${subject} <br> <hr>
        </c:forEach>
    </c:if>
    <a href="index.jsp">[ HOME ]</a>
</body>
</html>
