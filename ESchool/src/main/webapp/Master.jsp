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

        <script type="text/javascript" src="JS/jquery.js"></script>
        <script type="text/javascript" src="JS/jquery.query-2.1.7.js"></script>
        <script type="text/javascript" src="JS/rainbows.js"></script>
        <script type="text/javascript" src="JS/bootstrap.js"></script>
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

        <script src="http://bootswatch.com/bower_components/jquery/jquery.min.js"></script>
        <script src="http://bootswatch.com/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
        <script src="http://bootswatch.com/assets/js/bootswatch.js"></script>

        <link type="text/css" rel="stylesheet" href="CSS/Site.css" media="screen">
        <link type="text/css" rel="stylesheet" href="CSS/jQueryCss.css" media="screen">
        <link type="text/css" rel="stylesheet" href="CSS/StudentCss.css" media="screen">
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
                </div>
                <div class="navbar-collapse collapse navbar-inverse-collapse">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="#">
                                За продукта
                            </a>
                        </li>
                        <li>
                            <a href="Master.jsp?content=student">
                                Ученик
                            </a>
                        </li>
                        <li>
                            <a href="Master.jsp?content=teacher">
                                Учител
                            </a>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
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
            <jsp:include page="LogInForm.jsp"/>
            <jsp:include page="RegisterForm.jsp"/>
            <%
                final String contentParam = request.getParameter("content");
                if (contentParam != null && contentParam.equals("student")) {
            %>
            <%@include file="StudentHome.jsp"%>
            <%
            } else if (contentParam != null && contentParam.equals("teacher")) {
            %>
            <%@include file="TeacherPanel.jsp"%>
            <%
                }
            %>
        </div>
        <div class = "navbar-fixed-bottom" id ="pageFooter" >
            Powered by MMM Programming
        </div>
    </body>
</html>
