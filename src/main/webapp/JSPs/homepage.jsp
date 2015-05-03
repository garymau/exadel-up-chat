<%--
  Created by IntelliJ IDEA.
  User: Diman
  Date: 21.04.2015
  Time: 8:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="navbar.jsp"%>

<%
  String nickName = (String)session.getAttribute("nickname");
  if (nickName==null || nickName.equals("")){
    response.sendRedirect("index.jsp");
  }
%>
<html>
<head>
  <meta charset="utf-8">
  <link rel="stylesheet" href='../CSS/bootstrap-3.3.2-dist/bootstrap-3.3.2-dist/css/bootstrap.min.css' type="text/css" />
  <link rel="stylesheet" href='../CSS/style.css' type="text/css" />
  <script src="../js/jquery-2.1.3.js"></script>
  <title>Chat</title>
</head>
<body>



<div class="page-header">
  <h1>Welcome to Chat, <%=nickName%></h1>
</div>
<div class="container-fluid">
  <div class="row">
    <div class="col-lg-4">
      <ul class="nav nav-pills nav-stacked">
        <li class="list-group-item active">Options</li>
        <li class="list-group-item"><a href="#" >Settings</a></li>
        <li class="list-group-item"><a href="#" >Profile</a></li>
      </ul>
      </br>
      <ul class="nav nav-pills nav-stacked">
        <li class="list-group-item active">Friends</li>
        <li class="list-group-item"> <a href="#">Johnny Christ</a></li>
        <li class="list-group-item"> <a href="#">Matthew Sanders</a></li>
        <li class="list-group-item"> <a href="#">Zakhary Vengeance</a></li>
      </ul>
      </br>
      <ul class="list-group">
        <div class="input-group stylish-input-group">
          <input type="text" class="form-control"  placeholder="Search" >
                  <span class="input-group-addon">
                    <button type="submit" class="glyphicon glyphicon-search">
                    </button>
                  </span>
        </div>
      </ul>
    </div>
    <div class="col-lg-4 form-group">
      <label for="messages">Your Messages:</label>
      <div class="form-group">
            <textarea class="form-control fixed-width fixed-height" rows="5" id="messages" disabled="True"></textarea>
        <label for="message">Enter Your Message Here:</label>
        <input type="text" class="form-control fixed-width" id="message" >
        <button type="button" class="btn-primary active" id="send">Send</button>
      </div>
    </div>
    <div class="col-lg-4">
    </div>
  </div>


</div>

<script type="text/javascript" src="../js/usefulFuncs.js"></script>
<script type="text/javascript" src="../js/chatHandle.js"></script>
<script type="text/javascript" src="../js/KeyListener.js"></script>
</body>
</html>
