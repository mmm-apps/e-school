<%-- 
    Document   : AddMark
    Created on : Nov 13, 2013, 1:18:18 PM
    Author     : Denev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <%@include file="menu.jsp"%> 
    <div class="well well-sm" style="margin-left: 30%;margin-right: 30%; margin-top: 5%;padding: 3%">
        <s:form action = "createmark" cssClass="bs-example form-horizontal">
            <fieldset>
                <legend>Добавяне на оценки по История на 6а клас</legend>
                Изберете ученик:
                <s:fielderror/>
                <s:select label="Select a student" 
                          headerKey="-1" headerValue="Изберете ученик"
                          list="studentsList" 
                          name="studentName" 
                          cssClass="form-control"/>
                <br>
                Изберете оценка:
                <s:select label="Select a mark" 
                          headerKey="-1" headerValue="Изберете оценка"
                          list="#{'1':'Слаб 2', '2':'Среден 3', '3':'Добър 4', '4':'Мн.Добър 5', '5':'Отличен 6'}" 
                          name="yourMonth" 
                          cssClass="form-control"/>
            </fieldset>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Затвори</button>
                <s:submit cssClass="btn btn-info" value="Добави"/>
            </div>
        </s:form>
    </div>
</html>
