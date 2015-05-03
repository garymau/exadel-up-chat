<%--
  Created by IntelliJ IDEA.
  User: Diman
  Date: 01.05.2015
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title></title>
  <link rel="stylesheet" href='../CSS/bootstrap-3.3.2-dist/bootstrap-3.3.2-dist/css/bootstrap.min.css' type="text/css" />
</head>
<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#" >Chat</a>

    </div>
    <div>
      <ul class="nav navbar-nav">
        <li class="divider-vertical"></li>
        <li class="active"><a href="#">Home</a></li>
        <c:set var="nick" value="nickname" />
        <c:set var="emptyString" value="" />
        <c:if test="${sessionScope[nick]!=null && sessionScope[nick]!=emptyString}">
          <li><a href="/logout">LogOut</a></li>
        </c:if>
        <li><a href="#">Register</a></li>
      </ul>
    </div>
  </div>
</nav>

</body>
</html>
