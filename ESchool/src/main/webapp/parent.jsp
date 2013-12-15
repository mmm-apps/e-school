<%-- 
    Document   : parent
    Created on : Dec 15, 2013, 10:24:14 PM
    Author     : MMihov
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>E-School</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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
          <a class="navbar-brand" href="#">
            E-School
          </a>
          <ul class="nav navbar-nav navbar-left">
            <li>
              <a href="logout">
                Начало
              </a>
            </li>
          </ul>
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
    <div id="pageContent">

      <div class="well" style="margin:20%;">
        <h3>Моля, изберете ученик</h3>

        <s:iterator value="childList" var="currentChild">
          <tr  class="success">
            <td>
              <div class="panel panel-primary">
                <div class="panel-heading">
                  <h3 class="panel-title">
                    <s:property value="firstName" /> 
                    <s:property value="lastName" />
                    <s:url id="viewChild" action="viewChild">
                      <s:param name="child" value="%{id}"></s:param>
                    </s:url>
                    <s:a href="%{viewChild}">
                      <button class="breadcrumb" type="button" style="float: right;">Виж профила</button>
                    </s:a>
                  </h3>
                </div>
              </div>
            </td>
          </tr>
        </s:iterator>
      </div>

<!--    <s:include value="StudentHome.jsp"></s:include> !-->
    </div>
    <div class = "navbar-fixed-bottom" id ="pageFooter" >
      Powered by MMM Programming
    </div>
  </body>
</html>

