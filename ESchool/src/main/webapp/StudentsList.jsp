<%-- 
    Document   : StudentsList
    Created on : Nov 29, 2013, 3:49:19 PM
    Author     : MMihov
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
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="studnetsList" status="studentStatus">
                        <tr class="success">
                            <td><s:property value="firstName" /></td>
                            <td><s:property value="lastName" /></td>
                            <td><s:property value="email" /></td>
                            <td>
                                <s:url id="addRemark" action="selectRemark">
                                    <s:param name="userId" value="%{id}"></s:param>
                                </s:url>
                                <s:a href="%{addRemark}">
                                    <button class="btn btn-info" type="button">Добави Забележка</button>
                                </s:a>
                                <s:url id="studentMarks" action="studentMarks">
                                    <s:param name="studentId" value="%{id}"></s:param>
                                </s:url>
                                <s:a href="%{studentMarks}">
                                    <button class="btn btn-warning" type="button">Оценки</button>
                                </s:a>
                                <s:url id="deleteURL" action="deleteUser">
                                    <s:param name="userCon" value="%{id}"></s:param>
                                </s:url>
                                <s:a href="%{deleteURL}">
                                    <button class="btn btn-danger" type="button">Добави Оценка</button>
                                </s:a>
                                <s:url id="absencesList" action="absencesList">
                                    <s:param name="userId" value="%{id}"></s:param>
                                </s:url>
                                <s:a href="%{absencesList}">
                                    <button class="btn btn-warning" type="button">Отсъствия</button>
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
