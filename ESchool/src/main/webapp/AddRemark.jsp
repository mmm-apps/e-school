<%-- 
    Document   : AddRemark
    Created on : Nov 29, 2013, 7:10:10 PM
    Author     : MMihov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
  <%@include file="menu.jsp"%>         
  <div class="well well-sm" style="margin-left: 30%;margin-right: 30%; margin-top: 5%;padding: 3%">
    <s:form action = "createRemark" cssClass="bs-example form-horizontal">
      <fieldset>
        <legend>Добавяне на Забележка</legend>
        <s:fielderror/>
        <div class = "form-group">
          <div class="col-lg-10">
            <s:textfield id="remarkNameInput" key="remark" type="text" cssClass="form-control" placeholder="Напишете забележката" />
          </div>
        </div>
        <div class = "form-group">
          <div class="col-lg-10">
            <s:select headerKey="-1" headerValue="Моля Изберете предмет" 
                      list="subjectsList" name="subjectName" cssClass="form-control" />
          </div>
        </div>    
      </fieldset>
      <div class="modal-footer">
        <button type="button" class="btn btn-info" style="float: left;">Назад</button>
        <s:submit cssClass="btn btn-info" value="Добави"/>
      </div>
    </s:form>
  </div>

  <div class="panel panel-info" style="margin-left: 20%;margin-right: 20%;">
    <div class="panel-heading">
      <h3 class="panel-title">Забележки на ученика</h3>
    </div>
    <div class="panel-body">
      Panel content
    </div>
  </div>
</body>
</html>
