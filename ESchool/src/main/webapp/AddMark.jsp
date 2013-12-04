<%-- 
    Document   : AddMark
    Created on : Dec 4, 2013, 11:25:47 PM
    Author     : Denev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
  <%@include file="menu.jsp"%>         
  <div class="well well-sm" style="margin-left: 30%;margin-right: 30%; margin-top: 5%;padding: 3%">
    <s:form action = "addMark" cssClass="bs-example form-horizontal">
      <fieldset>
        <legend>Добавяне на Оценка</legend>
        <s:fielderror/>
        <div class = "form-group">
          <div class="col-lg-10">
            <s:select headerKey="-1" headerValue="Моля Изберете оценка" 
                      list="marksList" name="markVal" cssClass="form-control" />
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
