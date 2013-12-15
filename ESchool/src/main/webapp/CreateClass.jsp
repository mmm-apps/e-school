
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <%@include file="adminMenu.jsp"%>         
    <div class="well well-sm" style="margin-left: 30%;margin-right: 30%; margin-top: 5%;padding: 3%">
        <s:form action = "addClass" cssClass="bs-example form-horizontal">
            <fieldset>
                <legend>Добавяне на паралелка</legend>
                <s:fielderror/>
                <div class = "form-group">
                    <div class="col-lg-10">
                        <s:textfield id="subjectNameInput" key="className" type="text" cssClass="form-control" placeholder="Име на класа" />
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
