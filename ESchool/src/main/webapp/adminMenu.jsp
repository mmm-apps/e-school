<%-- 
    Document   : adminMenu
    Created on : Dec 15, 2013, 3:28:31 PM
    Author     : MMihov
--%>

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
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
    <script src="http://bootswatch.com/bower_components/jquery/jquery.min.js"></script>
    <script src="http://bootswatch.com/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="http://bootswatch.com/assets/js/bootswatch.js"></script>
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
        <a class="navbar-brand" href="/ESchool">E-School</a>
      </div>
      <div class="navbar-collapse collapse navbar-inverse-collapse">
        <ul class="nav navbar-nav navbar-left">

          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">За учителите<b class="caret"></b></a>
            <ul class="dropdown-menu">
              <li>
                <a href="<s:url action='teacherSubjectsList'/>">
                  Списък с водени предмети от преподаватели
                </a>
              </li>
            </ul>
          </li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">За класовете<b class="caret"></b></a>
            <ul class="dropdown-menu">
              <li>
                <a href="<s:url action='classesList'/>">
                  Списък с класове
                </a>
              </li>
              <li>
                <a href="admin?content=addClass">
                  Добавяне на клас
                </a>
              </li>
              <li>
                <a href="<s:url action='addStudentToClass'/>">
                  Добавяне на ученик към клас
                </a>
              </li>
              <li>
                <a href="<s:url action='listSubject'/>">
                  Добавяне на учебни предмети
                </a>
              </li>
            </ul>
          </li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">За директора<b class="caret"></b></a>
            <ul class="dropdown-menu">
              <li>
                <a href="<s:url action='listUser'/>">
                  Списък с потребители
                </a>
              </li>
            </ul>
          </li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Другите роли<b class="caret"></b></a>
            <ul class="dropdown-menu">
              <li>
                <a href="admin?content=student">
                  Ученик
                </a>
              </li>
              <li>
                <a href="admin?content=teacher">
                  Учител
                </a>
              </li>
            </ul>
          </li>
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