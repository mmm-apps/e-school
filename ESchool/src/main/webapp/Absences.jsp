<%-- 
    Document   : Absences
    Created on : Nov 13, 2013, 4:31:53 PM
    Author     : Denev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
  <script src="JS/paging.js"></script>
  <%@include file="MainAdmin.jsp"%>
  <script src="JS/validation.js"></script>
  <div id="userWelcome">
    <div class="well">
      <h3>Здравейте, <s:property value="%{#session.user.username}"/></h3>
    </div>
  </div>
  <div id="spacee" style="margin-top: 80px;"></div>
  <div class="panel panel-info">
    <div class="panel-heading">
      <h3 class="panel-title">
        Списък с отсъствия
      </h3>
    </div>
    <s:set var="studentVar" value="student" />
    <div class="panel-body">
        <div id="addButton">
            <button class="btn btn-info" data-toggle="modal" data-target="#addAbsence">Добавяне</button>
        </div>
      <table id="results" class="table table-striped table-bordered table-hover">
        <thead>
          <tr>
            <th>Тип отсъствие</th>
            <th>Дата</th>
            <th>Стойност</th>
            <th>Предмет</th>
            <th>Учител</th>
            <th>Видяно от родител</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          <s:iterator value="studentAbsencesList" status="classesStatus">
            <tr class="success">
              <s:if test="absenceType">
                <td>Извинено</td>
              </s:if>
              <s:else>
                <td>Неизвинено</td>
              </s:else>
              <td><s:property value="absenceDate"/></td>
              <td><s:property value="value" /></td>
              <td><s:property value="subjectId.subjectName" /></td>
              <td><s:property value="teacherId.lastName" /></td>              
              <td><s:property value="isSeen" /></td>
              <s:if test="!absenceType">
                <td>
                  <s:url id="selsectAbsence" action="selsectAbsence">
                    <s:param name="absenceIdParam" value="%{id}"></s:param>
                  </s:url>
                  <s:a href="%{selsectAbsence}">
                    <button class="btn btn-info" type="button">Извини</button>
                  </s:a>
                </td>
              </s:if>
              <s:if test="absenceType"><td> </td></s:if> 
                <td>
                <s:url id="deleteAbsence" action="deleteAbsence">
                  <s:param name="absenceIdParam" value="%{id}"></s:param>
                </s:url>
                <s:a href="%{deleteAbsence}">
                  <button class="btn btn-danger" type="button">Изтриване</button>
                </s:a>
              </td>
            </tr>
          </s:iterator>
        </tbody>
      </table>
      <div id="pageNavPosition" style="margin-left: 44%;"></div>
    </div>
    
    <div class="modal fade" id="addAbsence" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-body">
              <s:form action = "addAbsence" cssClass="bs-example form-horizontal" onsubmit="return validateAddAbsence(this)">
                <fieldset>
                    <legend>Добавяне на отсъствие</legend>
                    <s:fielderror/>
                    <div id="loginError"></div>
                    <s:hidden key="student" value="%{#studentVar}"/>
                    <div class = "form-group">
                        <div class="col-lg-10">
                            <s:select headerKey="-1" headerValue="Моля изберете тип отсъствие" 
                                      list="absenceTypeList" name="absenceType" cssClass="form-control" />
                        </div>
                    </div>   
                    <div class = "form-group">
                        <div  class="col-lg-10">
                            <s:textfield  key="date" type="date" id="datepicker" cssClass="form-control"/>
                        </div>
                    </div>
                    <div class = "form-group">
                        <div class="col-lg-10">
                            <s:select headerKey="-1" headerValue="Моля изберете стойност на отсъствие" 
                                      list="absenceValueList" name="absenceValue" cssClass="form-control" />
                        </div>
                    </div>
                    <div class = "form-group">
                        <div class="col-lg-10">
                            <s:select headerKey="-1" headerValue="Моля изберете предмет" 
                                      list="subjectList" name="subject" cssClass="form-control" />
                        </div>
                    </div>  
                </fieldset>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Назад</button>
                    <s:submit cssClass="btn btn-info" value="Добави"/>
                </div>
            </s:form>
            </div>
          </div>
        </div>
      </div>
  </div>
  <script type="text/javascript"><!--
var pager = new Pager('results', 3);
    pager.init();
    pager.showPageNav('pager', 'pageNavPosition');
    pager.showPage(1);
//--></script>
</html>
