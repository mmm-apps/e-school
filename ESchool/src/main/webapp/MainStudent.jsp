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
        <div id="pageContent">
           <s:include value="StudentHome.jsp"></s:include>
        </div>
        <div class = "navbar-fixed-bottom" id ="pageFooter" >
            Powered by MMM Programming
        </div>
    </body>
</html>
