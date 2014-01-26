<%-- 
    Document   : Master
    Created on : Nov 9, 2013, 9:20:08 PM
    Author     : Denev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>E-School</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <script src="JS/jquery-1.9.1.js"></script>
    <script src="JS/jquery-ui.js"></script>
    <script src="JS/jquery.min.js"></script>
    <script src="JS/bootstrap.min.js"></script>
    <script src="JS/bootswatch.js"></script>
    <script src="JS/validation.js"></script>

    <link type="text/css" rel="stylesheet" href="CSS/bootstrap.css" media="screen">
    <link type="text/css" rel="stylesheet" href="CSS/AditionalCss.css" media="screen">

  </head>
  <body onload="loadError()">
    <div id = "Menu">
      <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="navbar-header">
          <button class="navbar-toggle" data-target=".navbar-inverse-collapse" data-toggle="collapse" type="button">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">
            E-School
          </a>
        </div>
        <div class="navbar-collapse collapse navbar-inverse-collapse">
          <ul class="nav navbar-nav">
          </ul>
          <ul class="nav navbar-nav navbar-right" >
            <li>
              <a href="#" data-toggle="modal" data-target="#myModal">
                Вход
              </a>
            </li>
            <li>
              <a href="#" data-toggle="modal" data-target="#myModalReg">
                Регистрация 
              </a>
            </li>
          </ul>
        </div>
      </div>
    </div>
    <div id="pageContent">
      <s:include value="LogInForm.jsp"></s:include>
      <s:include value="RegisterForm.jsp"></s:include>
    </div>
    <div class = "navbar-fixed-bottom" id ="pageFooter" >
      Powered by MMM Programming
    </div>
  </body>
</html>
