<%-- 
    Document   : SubjectsList
    Created on : Nov 22, 2013, 2:27:17 PM
    Author     : Denev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <%@include file="adminMenu.jsp"%> 
    <div id="userWelcome">
        <div class="well">
            <h3>Здравейте, Администратор</h3>
        </div>
    </div>
    <div id="spacee" style="margin-top: 80px;"></div>
    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title">
                Списък с предмети
            </h3>
        </div>
        <div class="panel-body">

            <a href="<s:url action='selectSubjectType'/>" >
                <div id="addButton">
                    <button class="btn btn-info btn-lg btn-block">Добавяне</button>
                </div>
            </a>

            <table class="table table-striped table-bordered table-hover">
                <thead>
                    <tr>
                        <th></th>
                        <th>Предмет</th>
                        <th>Тип на предмета</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="subjectsList" status="subjectStatus">
                        <tr  class="success">
                            <td><s:property value="subjectName"/></td>
                            <td><s:property value="subjectKind"/></td>
                            <td>
                                <s:url id="deleteURL" action="deleteSubject">
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
        </div>
    </div>
</html>
