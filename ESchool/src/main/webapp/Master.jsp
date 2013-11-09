<%-- 
    Document   : Master
    Created on : Nov 9, 2013, 9:20:08 PM
    Author     : Denev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="CSS/bootstrap.css" media="screen">
        <title>JSP Page</title>
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
                            <a href="#">
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
    </body>
</html>
