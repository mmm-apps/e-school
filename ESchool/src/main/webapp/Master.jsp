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

        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta name="robots" content="index, follow" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <script type="text/javascript" src="JS/jquery.js"></script>
        <script type="text/javascript" src="JS/jquery.query-2.1.7.js"></script>
        <script type="text/javascript" src="JS/rainbows.js"></script>

        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

        <link type="text/css" rel="stylesheet" href="CSS/Site.css" media="screen">
        <link type="text/css" rel="stylesheet" href="CSS/jQueryCss.css" media="screen">

        <script>
            $(function() {
                $("#dialog").dialog();
            });
        </script>

    </head>
    <body>
        <div id = "Menu">
            <div class="navbar navbar-inverse">
                <div class="navbar-header">
                    <button class="navbar-toggle" data-target=".navbar-inverse-collapse" data-toggle="collapse" type="button">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">
                        Начало
                    </a>
                </div>
                <div class="navbar-collapse collapse navbar-inverse-collapse">
                    <ul class="nav navbar-nav">
                        <li class="active">
                            <a href="#">
                                За продукта
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                За производителите                
                            </a>
                        </li>
                    </ul>
                    <form class="navbar-form navbar-left">
                        <input class="form-control col-lg-8" type="text" placeholder="Search"></input>
                    </form>
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="Master.jsp">
                                Вход
                            </a>
                        </li>
                        <li>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                Регистрация 
                                <b class="caret"></b>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div id = "dialog" class = "well">
            <form action = "login.action" method ="post" class ="bs-example form-horizontal" >
                <fieldset>
                    <legend>Вход в системата</legend>
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
                    <div class="form-group">
                        <div class="col-lg-10">
                            <s:submit cssClass="btn btn-info" value="Вход"/>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </body>
</html>
