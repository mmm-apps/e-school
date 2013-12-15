<%-- 
    Document   : editUser
    Created on : Nov 13, 2013, 12:58:46 PM
    Author     : Denev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
  <%@include file="adminMenu.jsp"%>         
  <link type="text/css" rel="stylesheet" href="CSS/bootstrap.css" media="screen">
    <div class="well well-sm" style="margin-left: 30%;margin-right: 30%; margin-top: 5%;padding: 3%;">
        <s:form action="editConfirmUser" method="post" cssClass="bs-example form-horizontal">
            <fieldset>
              <legend>Редактиране на потребител</legend>
                <div class = "form-group">
                  <div class="col-lg-10">
                    <s:textfield id="userNameInput" key="username" value="%{user.username}" type="text" cssClass="form-control" placeholder="Потребителско име" />
                  </div>
                </div>
                <div class = "form-group">
                  <div class="col-lg-10">
                      <s:password id="passwordInput" key="password" value="%{user.password}" type="text" cssClass="form-control" placeholder="Парола" />
                  </div>
                </div>
            </fieldset>
            <div class="modal-footer">
                <a href="<s:url action='listUser'/>">
                  <button type="button" class="btn btn-default" data-dismiss="modal">Затвори</button>
                </a>
                <s:submit cssClass="btn btn-info" value="Запази"/>
            </div>
        </s:form>
    </div>
</html>
