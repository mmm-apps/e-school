<%-- 
    Document   : TeachersList
    Created on : Nov 11, 2013, 10:43:33 PM
    Author     : Denev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <script src="JS/paging.js"></script>
    <%@include file="menu.jsp"%>   
    <div id="userWelcome">
        <div class="well">
            <h3>Здравейте, Администратор</h3>
        </div>
    </div>
    <div id="spacee" style="margin-top: 80px;"></div>
    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title">
                Списък с потребители
            </h3>
        </div>
        <div class="panel-body">

            <a href="<s:url action='addUser'/>" >
                <div id="addButton">
                    <button class="btn btn-info btn-lg btn-block">Добавяне</button>
                </div>
            </a>

            <table id="results" class="table table-striped table-bordered table-hover">
                <thead>
                    <tr>
                        <th>Име</th>
                        <th>Фамилия</th>
                        <th>Телефон</th>
                        <th>Адрес</th>
                        <th>Потребителско име</th>
                        <th></th>
                    </tr>
                </thead>

                <tbody>
                    <s:iterator value="userList" status="userStatus">
                        <tr class="success">
                            <td><s:property value="username" /></td>
                            <td><s:property value="password" /></td>
                            <td><s:property value="adress" /></td>
                            <td><s:property value="firstName" /></td>
                            <td><s:property value="" /></td>
                            <td>
                                <s:url id="infoURL" action="infoUser">
                                    <s:param name="user" value="%{id}"></s:param>
                                </s:url>
                                <s:a href="%{infoURL}">
                                    <button class="btn btn-info" type="button">Информация</button>
                                </s:a>

                                <s:url id="editURL" action="editUser">
                                    <s:param name="user" value="%{id}"></s:param>
                                </s:url>
                                <s:a href="%{editURL}">
                                    <button class="btn btn-warning" type="button">Коригиране</button>
                                </s:a>

                                <s:url id="deleteURL" action="deleteUser">
                                    <s:param name="userCon" value="%{id}"></s:param>
                                </s:url>
                                <s:a href="%{deleteURL}">
                                    <button class="btn btn-danger" type="button">Изтриване</button>
                                </s:a>
                            </td>
                        </tr>
                    </s:iterator>

                </tbody>
            </table>
            <div id="pageNavPosition" style="margin-left: 44%;"></div>
        </div>
    </div>
    <script type="text/javascript"><!--
var pager = new Pager('results', 3);
        pager.init();
        pager.showPageNav('pager', 'pageNavPosition');
        pager.showPage(1);
//--></script>
</html>