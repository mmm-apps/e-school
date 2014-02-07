<%-- 
    Document   : ChangeParent
    Created on : Feb 7, 2014, 2:46:13 AM
    Author     : Denev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <%@include file="MainAdmin.jsp"%>
    <div class="well well-sm" style="margin-left: 30%;margin-right: 30%; margin-top: 5%;padding: 3%">
        <s:form action = "setNewStudentParent" cssClass="bs-example form-horizontal">
            <fieldset>
                <legend>Промяна на родител за даден ученик</legend>
                <s:fielderror/>
                <div class = "form-group">
                    <div class="col-lg-10">
                        <s:select headerKey="-1" headerValue="Моля Изберете ученик" 
                                  list="studentNamesList" name="studentName" cssClass="form-control" />
                    </div>
                </div>
                <div class = "form-group">
                    <div class="col-lg-10">
                        <s:select headerKey="-1" headerValue="Моля Изберете родител" 
                                  list="parentNamesList" name="parentName" cssClass="form-control" />
                    </div>
                </div>
            </fieldset>
            <div class="modal-footer">
                <button type="button" class="btn btn-info" style="float: left;">Назад</button>
                <s:submit cssClass="btn btn-info" value="Добави"/>
            </div>
        </s:form>
    </div>
</html>
