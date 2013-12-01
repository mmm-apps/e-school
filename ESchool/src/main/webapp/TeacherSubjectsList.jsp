<%-- 
    Document   : AddSubjectToTeacher
    Created on : Nov 28, 2013, 5:32:31 PM
    Author     : Denev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
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
                Списък с водените предмети от учителите
            </h3>
        </div>
        <div class="panel-body">

            <a href="<s:url action='loadTeacherSubject'/>" >
                <div id="addButton">
                    <button class="btn btn-info btn-lg btn-block">Добавяне</button>
                </div>
            </a>

            <table id="results" class="table table-striped table-bordered table-hover">
                <thead>
                    <tr>
                        <th>Преподавател</th>
                        <th>Предмет</th>
                        <th>Клас</th>
                    </tr>
                </thead>

                <tbody>
                    <tr class="success">
                        <td>Иван Георгиев</td>
                        <td>История</td>
                        <td>6а</td>
                </tr>
                </tbody>
            </table>
            <div id="pageNavPosition" style="margin-left: 44%;"></div>
        </div>
    </div>
</html>
