<%-- 
    Document   : AddMark
    Created on : Nov 13, 2013, 2:20:18 PM
    Author     : Denev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
  <%@include file="adminMenu.jsp"%>    
  <script src="JS/validation.js"></script>
  <div class="well well-sm" style="margin-left: 30%;margin-right: 30%; margin-top: 5%;padding: 3%">
    <s:form action = "delMark" cssClass="bs-example form-horizontal" onsubmit="return validateDelMark(this)">
      <fieldset>
        <legend>Изтриване на Оценка</legend>
        <s:fielderror/>
        <div id="loginError"></div>
        <div class = "form-group">
          <div class="col-lg-10">
            <s:select headerKey="-1" headerValue="Моля Изберете оценка" 
                      list="marksListForStudent" name="selectedMarkToDel" cssClass="form-control" />
          </div>
        </div>
      </fieldset>
      <div class="modal-footer">
        <button type="button" class="btn btn-info" style="float: left;">Назад</button>
        <s:submit cssClass="btn btn-danger" value="Изтрии"/>
      </div>
    </s:form>
  </div>
</html>
