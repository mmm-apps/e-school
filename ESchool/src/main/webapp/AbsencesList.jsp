<%-- 
    Document   : AbsencesList
    Created on : Nov 13, 2013, 4:31:53 PM
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
                Списък с отсъствия
            </h3>
        </div>
        <div class="panel-body">
            <a href="<s:url action='addAbsenceProperties'/>" >
                <div id="addButton">
                    <button class="btn btn-info btn-lg btn-block">Добавяне</button>
                </div>
            </a>
            <table id="results" class="table table-striped table-bordered table-hover">
                <thead>
                    <tr>
                        <th>Тип отсъствие</th>
                        <th>Дата</th>
                        <th>Стойност</th>
                        <th>Предмет</th>
                        <th>Учител</th>
                        <th>Проверена</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <%--           <s:iterator value="StudentMarksList" status="classesStatus">
                        <tr class="success">
                            <td><s:property value="firstName" /></td>
                            <td><s:property value="lastName" /></td>
                            <td><s:property value="subject" /></td>
                            <td><s:property value="marks" /></td>
                            <td>
                                <s:url id="selectMark" action="selectMark">
                                    <s:param name="subjectName" value="%{id}"></s:param>
                                </s:url>
                                <s:a href="%{selectMark}">
                                    <button class="btn btn-info" type="button">Добави оценка</button>
                                </s:a>
                            </td>
                        </tr>
</s:iterator> --%>
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
