<%--
  Created by IntelliJ IDEA.
  User: Diman
  Date: 21.04.2015
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@ include file="navbar.jsp" %>
<%
  String nickName = (String)session.getAttribute("nickname");
  if (nickName!=null && !nickName.equals("")) {
    response.sendRedirect("homepage.jsp");
  }
%>
<html>
<head>
  <link rel="stylesheet" href='../CSS/bootstrap-3.3.2-dist/bootstrap-3.3.2-dist/css/bootstrap.min.css' type="text/css" />
  <title>Welcome!!!</title>
</head>
<body>
  <h1>Welcome!!!</h1>
  <div class="container-fluid">
    <div class="row">
      <div class="col-md-4">
        <form role="form" action="/login" method="post" name="Login">
            <label class="control-label" for="nickname" >Nickname</label>
            <input type="text" name="nickname" id="nickname" class="form-control" placeholder="Enter nickname..">
            <input class="btn btn-default" name="submit" type="submit" value="Login">
        </form>
      </div>
      <div class="col-md-8"></div>
    </div>
  </div>

</body>
</html>
