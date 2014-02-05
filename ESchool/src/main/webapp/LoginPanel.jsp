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
                    <a class="navbar-brand" href="/ESchool">
                        E-School
                    </a>
                </div>
                <div class="navbar-collapse collapse navbar-inverse-collapse">
                    <ul class="nav navbar-nav">
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="#" data-toggle="modal" data-target="#loginForm">
                                Вход
                            </a>
                        </li>
                        <li>
                            <a href="#" data-toggle="modal" data-target="#registerForm">
                                Регистрация 
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div id="pageContent">
          
          <div  class="modal fade" id="loginForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-body">
                        <s:form action = "login" method ="post" cssClass ="bs-example form-horizontal" onsubmit="return validateLogin(this)">
                            <fieldset>
                                <legend>Вход в системата</legend>
                                <s:fielderror/>
                                <div id="loginError"></div>
                                <div class = "form-group">
                                    <div class="col-lg-10">
                                        <s:textfield id="userNameInput" key="username" cssClass="form-control" placeholder="Потребителско име" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-lg-10">
                                        <s:password id="passwordInput" key="password" cssClass="form-control" placeholder="Парола" />
                                    </div>
                                </div>
                            </fieldset>
                            <div class="modal-footer">
                                <a href="<s:url action=''/>">
                                  <button type="button" class="btn btn-default" data-dismiss="modal">Затвори</button>
                                </a>
                                <s:submit cssClass="btn btn-info" value="Вход"/>
                            </div>
                        </s:form>
                    </div>
                </div>
            </div>
        </div>
          
          <div class="modal fade" id="registerForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-body">
                        <form action = "" method ="post" class ="bs-example form-horizontal" >
                            <fieldset>
                                <legend>Регистриране</legend>
                                <div class = "form-group">
                                    <div class="col-lg-10">
                                        <s:textfield id="userNameInput" key="username" type="text" cssClass="form-control" placeholder="Потребителксо име" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-lg-10">
                                        <s:password id="passwordInput" key="password" type="password" cssClass="form-control" placeholder="Парола" />
                                    </div>
                                </div>
                            </fieldset>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Затвори</button>
                                <s:submit cssClass="btn btn-info" value="Регистриране"/>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
          
      </div>
                            
        <div class = "navbar-fixed-bottom" id ="pageFooter" >
            Powered by MMM Programming
        </div>
    </body>
</html>
