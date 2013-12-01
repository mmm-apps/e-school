<%-- 
    Document   : ClassesList
    Created on : Nov 29, 2013, 3:17:24 PM
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
                Списък с класове
            </h3>
        </div>
        <div class="panel-body">
            <table id="results" class="table table-striped table-bordered table-hover">
                <thead>
                    <tr>
                        <th>Име на класа</th>
                        <th></th>
                    </tr>
                </thead>

                <tbody>
                    <s:iterator value="classesList" status="classesStatus">
                        <tr class="success">
                            <td><s:property value="className" /></td>
                            <td>
                                <s:url id="infoURL" action="infoClass">
                                    <s:param name="classNameInfo" value="%{id}"></s:param>
                                </s:url>
                                <s:a href="%{infoURL}">
                                    <button class="btn btn-info" type="button">Виж учениците в класа</button>
                                </s:a>
                                    
                                <s:url id="showSubjectToClass" action="showSubjectToClass">
                                    <s:param name="classNameInfo" value="%{id}"></s:param>
                                </s:url>
                                <s:a href="%{showSubjectToClass}">
                                    <button class="btn btn-success" type="button">Виж предметите за класа</button>
                                </s:a>
                                    
                                <s:url id="selectSubjectToClass" action="selectSubjectToClass">
                                    <s:param name="classNameInfo" value="%{id}"></s:param>
                                </s:url>
                                <s:a href="%{selectSubjectToClass}">
                                    <button class="btn btn-success" type="button">Добави предмети за класа</button>
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
