<%-- 
    Document   : AddHomeworkToClass
    Created on : Dec 5, 2013, 5:39:28 PM
    Author     : MMihov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
  <%@include file="adminMenu.jsp"%>         
  <div class="well well-sm" style="margin-left: 30%;margin-right: 30%; margin-top: 5%;padding: 3%">
    <s:form action = "addHomeworkToClass" cssClass="bs-example form-horizontal">
      <fieldset>
        <legend>Добавяне на домашна работа на клас</legend>
        <s:fielderror/>
        <div class = "form-group">
          <div class="col-lg-10">
            <s:select headerKey="-1" headerValue="Моля Изберете предмет" 
                      list="subjectList" name="subjectName" cssClass="form-control" />
          </div>
        </div>
        <div class = "form-group">
          <div class="col-lg-10">
            <s:textfield id="homeworkInput" key="homeworkNote" type="text" cssClass="form-control" placeholder="Домашна работа" />
          </div>
        </div>
        <div class = "form-group">
          <div  class="col-lg-10">
            <s:textfield  key="date" type="date" id="datepicker" cssClass="form-control"/>
          </div>
        </div>
      </fieldset>
      <div class="modal-footer">
        <button type="button" class="btn btn-info" style="float: left;">Назад</button>
        <s:submit cssClass="btn btn-info" value="Добави"/>
      </div>
    </s:form>
  </div>

  <div class="panel panel-info" style="margin-left: 10%;margin-right: 10%;">
    <div class="panel-heading">
      <h3 class="panel-title">Домашни работи на класа</h3>
    </div>
    <div class="panel-body">
      <table id="results" class="table table-striped table-bordered table-hover">
        <thead>
          <tr>
            <th>Дата</th>
            <th>Домашна работа</th>
            <th></th>
          </tr>
        </thead>

        <tbody>
          <s:iterator value="studentHomeworks" status="homeworkStatus">
            <tr class="success">
              <td><s:date name="dateCreated" format="dd/MM/yyyy"/>г.</td>
              <td><s:property value="homeWorkTitle"/></td>
              <td>
                <s:url id="deleteHomework" action="deleteHomework">
                  <s:param name="homeworkNo" value="%{id}"></s:param>
                </s:url>
                <s:a href="%{deleteHomework}">
                  <button class="btn btn-danger" type="button">Изтриване</button>
                </s:a>
              </td>
            </tr>
          </s:iterator>
        </tbody>
      </table>

    </div>
  </div>
</body>
</html>

