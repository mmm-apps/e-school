<%-- 
    Document   : menu
    Created on : Nov 21, 2013, 4:42:07 PM
    Author     : MMihov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>JSP Page</title>
  <script type="text/javascript" src="JS/jquery.js"></script>
  <script type="text/javascript" src="JS/jquery.query-2.1.7.js"></script>
  <script type="text/javascript" src="JS/rainbows.js"></script>
  <script src="JS/jquery-1.9.1.js"></script>
  <script src="JS/jquery-ui.js"></script>
  <script src="JS/jquery.min.js"></script>
  <script src="JS/bootstrap.min.js"></script>
  <script src="JS/bootswatch.js"></script>
  <link type="text/css" rel="stylesheet" href="CSS/bootstrap.css" media="screen">
  <link type="text/css" rel="stylesheet" href="CSS/AditionalCss.css" media="screen">
</head>
<body> 
    <div id = "Menu">
        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-header">
                <button class="navbar-toggle" data-target=".navbar-inverse-collapse" data-toggle="collapse" type="button">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/ESchool">
                    E-School
                </a>
            </div>
            <div class="navbar-collapse collapse navbar-inverse-collapse">
                <ul class="nav navbar-nav">
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="logout">
                            Изход
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
