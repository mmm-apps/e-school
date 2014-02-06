<%-- 
    Document   : TeacherSubjectsList
    Created on : Nov 28, 2013, 5:32:31 PM
    Author     : Denev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
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
        Списък с водените предмети от учителите
      </h3>
    </div>
    <div class="panel-body">

      <div id="addButton">
        <button class="btn btn-info btn-lg btn-block" data-toggle="modal" data-target="#addTeacherToSubject">Добавяне</button>
      </div>

      <div class="modal fade" id="addTeacherToSubject" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-body">
              <s:form action = "addSubjectToTeacher" cssClass="bs-example form-horizontal" onsubmit="return validateAddSubjectToTeacher(this)">
                <fieldset>
                  <legend>Добавяне на предмети за преподавател</legend>
                  <s:fielderror/>
                  <div id="loginError"></div>
                  <div class = "form-group">
                    <div class="col-lg-10">
                      <s:select headerKey="-1" headerValue="Моля Изберете преподавател" 
                                list="teacherNamesList" name="teacherName" cssClass="form-control" />
                    </div>
                  </div>
                  <div class = "form-group">
                    <div class="col-lg-10">
                      <s:select headerKey="-1" headerValue="Моля Изберете клас" 
                                list="classNamesList" name="className" cssClass="form-control" />
                    </div>
                  </div>
                  <div class = "form-group">
                    <div class="col-lg-10">
                      <s:select headerKey="-1" headerValue="Моля Изберете предмет" 
                                list="subjectNamesList" name="subjectName" cssClass="form-control" />
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

      <table id="results" class="table table-striped table-bordered table-hover">
        <thead>
          <tr>
            <th>Преподавател</th>
            <th>Предмет</th>
            <th>Клас</th>
            <th></th>
          </tr>
        </thead>

        <tbody>
          <s:iterator value="teachersSubjectsList" var="current">
            <tr class="success">
              <td><s:property value="teacher.userInfo.lastName" /></td>
              <td><s:property value="subject.subjectName" /></td>
              <td><s:property value="classes.className" /></td>
              <td>
                <s:url id="deleteTeacherSubject" action="deleteTeacherSubject">
                  <s:param name="tsIdParam" value="%{id}"></s:param>
                </s:url>
                <s:a href="%{deleteTeacherSubject}">
                  <button class="btn btn-danger" type="button">Изтриване</button>
                </s:a>
              </td>
            </tr>
          </s:iterator>
        </tbody>
      </table>
      <div id="pageNavPosition" style="margin-left: 44%;"></div>
    </div>
  </div>
</html>
