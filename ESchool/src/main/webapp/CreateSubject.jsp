<%-- 
    Document   : CreateSubject
    Created on : Nov 22, 2013, 2:44:31 PM
    Author     : Denev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <%@include file="adminMenu.jsp"%>         
    <div class="well well-sm" style="margin-left: 30%;margin-right: 30%; margin-top: 5%;padding: 3%">
        <s:form action = "addSubject" cssClass="bs-example form-horizontal">
            <fieldset>
                <legend>Добавяне на предмети</legend>
                <s:fielderror/>
                <div class = "form-group">
                    <div class="col-lg-10">
                        <s:textfield id="subjectNameInput" key="subjectName" type="text" cssClass="form-control" placeholder="Име на предмет" />
                    </div>
                </div>
                <div class = "form-group">
                    <div class="col-lg-10">
                        <s:select headerKey="-1" headerValue="Тип на предмета" 
                                  list="subjectTypes" name="subjectType" cssClass="form-control"/>
                    </div>
                </div>
            </fieldset>
            <div class="modal-footer">
                <button type="button" class="btn btn-info" style="float: left;">Назад</button>
                <s:submit cssClass="btn btn-info" value="Добави"/>
            </div>
        </s:form>
    </div>
</body>
</html>
