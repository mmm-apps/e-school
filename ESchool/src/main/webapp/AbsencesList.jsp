<%-- 
    Document   : AbsencesList
    Created on : Nov 13, 2013, 4:31:53 PM
    Author     : Denev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
  <script src="JS/paging.js"></script>
  <%@include file="adminMenu.jsp"%>   
  <div id="userWelcome">
    <div class="well">
      <h3>Здравейте, Администратор</h3>
    </div>
  </div>
  <div id="spacee" style="margin-top: 80px;"></div>
  <div class="panel panel-info">
    <div class="panel-heading">
      <h3 class="panel-title">
        Списък с отсъствия
      </h3>
    </div>
    <div class="panel-body">
      <a href="<s:url action='addAbsenceProperties'/>" >
        <div id="addButton">
          <button class="btn btn-info btn-lg btn-block">Добавяне</button>
        </div>
      </a>
      <table id="results" class="table table-striped table-bordered table-hover">
        <thead>
          <tr>
            <th>Тип отсъствие</th>
            <th>Дата</th>
            <th>Стойност</th>
            <th>Предмет</th>
            <th>Учител</th>
            <th>Проверена</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          <s:iterator value="StudentAbsenceList" status="classesStatus">
            <tr class="success">
              <s:if test="absenceType == true">
                <td>Извинено</td>
              </s:if>
              <s:if test="absenceType == false">
                <td>Неизвинено</td>
              </s:if>
              <td><s:property value="absenceDate"/></td>
              <td><s:property value="value" /></td>
              <td><s:property value="subjectId.subjectName" /></td>
              <td><s:property value="teacherId.lastName" /></td>              
              <td><s:property value="isSeen" /></td>
              <s:if test="absenceType == false">
                <td>
                  <s:url id="selsectAbsence" action="selsectAbsence">
                    <s:param name="AbsenceNo" value="%{id}"></s:param>
                  </s:url>
                  <s:a href="%{selsectAbsence}">
                    <button class="btn btn-info" type="button">Извини</button>
                  </s:a>
                </td>
              </s:if>
              <s:if test="absenceType == true"><td> </td></s:if> 
            </tr>
          </s:iterator>
        </tbody>
      </table>
      <div id="pageNavPosition" style="margin-left: 44%;"></div>
    </div>
  </div>
  <script type="text/javascript"><!--
var pager = new Pager('results', 3);
    pager.init();
    pager.showPageNav('pager', 'pageNavPosition');
    pager.showPage(1);
//--></script>
</html>
