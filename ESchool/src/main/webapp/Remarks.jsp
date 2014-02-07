<%-- 
    Document   : Remarks
    Created on : Nov 29, 2013, 7:10:10 PM
    Author     : MMihov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
  <%@include file="MainAdmin.jsp"%>    
  <script src="JS/validation.js"></script>
  <div class="well well-sm" style="margin-left: 30%;margin-right: 30%; margin-top: 5%;padding: 3%">
    <s:form action = "addRemark" cssClass="bs-example form-horizontal" onsubmit="return validateAddRemark(this)">
      <fieldset>
        <legend>Добавяне на Забележка</legend>
        <s:fielderror/>
        <div id="loginError"></div>
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
        <div class = "form-group">
          <div  class="col-lg-10">
            <s:textfield  key="date" type="date" id="datepicker" cssClass="form-control"/>
          </div>
        </div>
      </fieldset>
      <div class="modal-footer">
        <a href="<s:url action='classesList'/>">
          <button type="button" class="btn btn-info" style="float: left;">Назад</button>
        </a>
        <s:submit cssClass="btn btn-info" value="Добави"/>
      </div>
    </s:form>
  </div>

  <div class="panel panel-info" style="margin-left: 20%;margin-right: 20%;">
    <div class="panel-heading">
      <h3 class="panel-title">Забележки на ученика до момента</h3>
    </div>
    <div class="panel-body">


      <table id="results" class="table table-striped table-bordered table-hover">
        <thead>
          <tr>
            <th>Предмет</th>
            <th>Забележка</th>
            <th></th>
          </tr>
        </thead>

        <tbody>
          <s:iterator value="studentRemarks" status="remarkStatus">
            <tr class="success">
              <td><s:property value="subjectId.subjectName" /></td>
              <td><s:property value="remark" /></td>
              <td>
                <s:url id="deleteRemark" action="deleteRemark">
                  <s:param name="remarkIdParam" value="%{id}"></s:param>
                </s:url>
                <s:a href="%{deleteRemark}">
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
