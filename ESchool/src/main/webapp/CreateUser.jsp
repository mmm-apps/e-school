<%-- 
    Document   : CreateUser
    Created on : Nov 17, 2013, 7:29:42 PM
    Author     : MMihov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
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
                    <a class="navbar-brand" href="#">
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
        <div class="well well-sm" style="margin-left: 30%;margin-right: 30%; margin-top: 5%;padding: 3%">
            <s:form action = "createuser" cssClass="bs-example form-horizontal">
                <fieldset>
                    <legend>Добавяне на потребител</legend>
                    <s:fielderror/>
                    <div class = "form-group">
                        <div class="col-lg-10">
                            <s:textfield id="userNameInput" key="username" type="text" cssClass="form-control" placeholder="Потребителско име" />
                        </div>
                    </div>
                    <div class = "form-group">
                        <div class="col-lg-10">
                            <s:password id="passwordInput" key="password" type="text" cssClass="form-control" placeholder="Парола" />
                        </div>
                    </div>
                    <div class = "form-group">
                        <div class="col-lg-10">
                            <s:radio list="#{'STUDENT':'STUDENT','TEACHER':'TEACHER','PARENT':'PARENT'}" value="Role" name="list1" cssClass="btn btn-primary"></s:radio>
                            </div>
                        </div>
                        <div class = "form-group">
                            <div class="col-lg-10">
                            <s:textfield id="firstNameInput" key="firstName" type="text" cssClass="form-control" placeholder="Име" />
                        </div>
                    </div>
                    <div class = "form-group">
                        <div class="col-lg-10">
                            <s:textfield id="lastNameInput" key="lastName" type="text" cssClass="form-control" placeholder="Фамилия" />
                        </div>
                    </div>
                    <div class = "form-group">
                        <div class="col-lg-10">
                            <s:textfield id="telephoneInput" key="telephone" type="text" cssClass="form-control" placeholder="Телефон" />
                        </div>
                    </div>
                    <div class = "form-group">
                        <div class="col-lg-10">
                            <s:textfield id="adressInput" key="adress" type="text" cssClass="form-control" placeholder="Адрес" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-10">
                            <s:textfield id="emailInput" key="email" type="text" cssClass="form-control" placeholder="E-mail" />
                        </div>
                    </div>
                </fieldset>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Затвори</button>
                    <s:submit cssClass="btn btn-info" value="Добави"/>
                </div>
            </s:form>
        </div>
    </body>
</html>
