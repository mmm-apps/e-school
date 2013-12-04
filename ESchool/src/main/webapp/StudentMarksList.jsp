<%-- 
    Document   : StudentMarksList
    Created on : Nov 29, 2013, 6:54:13 PM
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
                Списък с оценки
            </h3>
        </div>
        <div class="panel-body">
            <table id="results" class="table table-striped table-bordered table-hover">
                <thead>
                    <tr>
                        <th>Име</th>
                        <th>Фамилия</th>
                        <th>Предмет</th>
                        <th>Оценки</th>
                        <th></th>
                    </tr>
                </thead>

                <tbody>
                    <s:iterator value="StudentMarksList" status="classesStatus">
                        <tr class="success">
                            <td><s:property value="firstName" /></td>
                            <td><s:property value="lastName" /></td>
                            <td><s:property value="subject" /></td>
                            <td><s:property value="marks" /></td>
                            <td>
                                <s:url id="selectMark" action="selectMark">
                                    <s:param name="subjectName" value="%{subject}"></s:param>
                                </s:url>
                                <s:a href="%{selectMark}">
                                    <button class="btn btn-info" type="button">Добави оценка</button>
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
