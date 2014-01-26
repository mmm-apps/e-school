<%-- 
    Document   : AddStudentToClass
    Created on : Nov 26, 2013, 2:44:31 PM
    Author     : MMihov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
  <%@include file="adminMenu.jsp"%>
  <script src="JS/validation.js"></script>
  <div class="well well-sm" style="margin-left: 30%;margin-right: 30%; margin-top: 5%;padding: 3%">
    <s:form action = "addStudentInClassForm" cssClass="bs-example form-horizontal" onsubmit="return validateAddStudentInClassForm(this)">
      <fieldset>
        <legend>Преместване на ученик в клас</legend>
        <s:fielderror/>
        <div id="loginError"></div>
        <div class = "form-group">
          <div class="col-lg-10">
            <s:select headerKey="-1" headerValue="Моля Изберете ученик" 
                      list="studentsList" name="student" cssClass="form-control" />
          </div>
        </div>
        <div class = "form-group">
          <div class="col-lg-10">
            <s:select headerKey="-1" headerValue="Моля изберете клас,в който ще бъде настанен ученика" 
                      list="classesList" name="classNo" cssClass="form-control" />
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
