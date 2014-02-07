<%-- 
    Document   : Students
    Created on : Nov 29, 2013, 3:49:19 PM
    Author     : MMihov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <script src="JS/paging.js"></script>
    <%@include file="MainAdmin.jsp"%>
    <div id="userWelcome">
        <div class="well">
            <h3>Здравейте, <s:property value="%{#session.user.username}"/></h3>
        </div>
    </div>
    <div id="spacee" style="margin-top: 80px;"></div>
    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title">
                Списък с ученици
            </h3>
        </div>
        <div class="panel-body">
            <table id="results" class="table table-striped table-bordered table-hover">
                <thead>
                    <tr>
                        <th>Име</th>
                        <th>Фамилия</th>
                        <th>E-mail</th>
                        <th>Име на родител</th>
                        <th>Фамилия на родител</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="studentsList" status="studentStatus">
                        <tr class="success">
                            <td><s:property value="userInfo.firstName" /></td>
                            <td><s:property value="userInfo.lastName" /></td>
                            <td><s:property value="userInfo.email" /></td>
                            <td><s:property value="parentId.userInfo.firstName" /></td>
                            <td><s:property value="parentId.userInfo.lastName" /></td>
                            <td>
                                <s:url id="remarks" action="remarks">
                                    <s:param name="studentIdParam" value="%{id}"></s:param>
                                </s:url>
                                <s:a href="%{remarks}">
                                    <button class="btn btn-info" type="button">Забележки</button>
                                </s:a>
                                <s:url id="studentMarks" action="studentMarks">
                                    <s:param name="studentIdParam" value="%{id}"></s:param>
                                </s:url>
                                <s:a href="%{studentMarks}">
                                    <button class="btn btn-warning" type="button">Оценки</button>
                                </s:a>
                                <s:url id="absencesList" action="absencesList">
                                    <s:param name="studentIdParam" value="%{id}"></s:param>
                                </s:url>
                                <s:a href="%{absencesList}">
                                    <button class="btn btn-danger" type="button">Отсъствия</button>
                                </s:a>
                                <s:if test="%{#session.user.rolesSet[0].roleName == 'Администратор'}">
                                    <s:url id="deleteStudentParent" action="deleteStudentParent">
                                        <s:param name="studentIdParam" value="%{id}"></s:param>
                                    </s:url>
                                    <s:a href="%{deleteStudentParent}">
                                        <button class="btn btn-danger" type="button">Премахване на родител</button>
                                    </s:a>
                                </s:if>
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
