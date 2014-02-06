<%-- 
    Document   : ClassSubjects.jsp
    Created on : Nov 29, 2013, 9:31:14 PM
    Author     : Denev
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
                Списък с предмети за клас
            </h3>
        </div>
        <div class="panel-body">

            <table id="results" class="table table-striped table-bordered table-hover">
                <thead>
                    <tr>
                        <th>Предмет</th>
                        <th>Тип</th>
                        <th></th>
                    </tr>
                </thead>

                <tbody>
                    <s:iterator value="subjectsList" var="currentSubject">
                        <tr class="success">
                            <td><s:property value="subjectName" /></td>
                            <td><s:property value="subjectKind" /></td>
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
