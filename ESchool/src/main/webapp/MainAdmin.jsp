<%-- 
    Document   : Master
    Created on : Nov 9, 2013, 9:20:08 PM
    Author     : Denev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <%@include file="MainHeadContent.jsp"%>
  <body onload="loadError()">
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
                  <a href="<s:url action='listSubject'/>">
                    Учебни предмети
                  </a>
                </li>
              </ul>
            </li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">Потребители<b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li>
                  <a href="<s:url action='listUser'/>">
                    Списък с потребители
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
    <div id="pageContent">
      <%
        final String contentParam = request.getParameter("content");
        if (contentParam != null && contentParam.equals("student")) {
      %>
      <%@include file="StudentHome.jsp"%>
      <%
        } 
      %>
    </div>
    
    <div class = "navbar-fixed-bottom" id ="pageFooter" >
      Powered by MMM Programming
    </div>
  </body>
</html>
