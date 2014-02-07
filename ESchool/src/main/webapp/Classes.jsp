<%-- 
    Document   : Classes
    Created on : Nov 29, 2013, 3:17:24 PM
    Author     : MMihov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <script src="JS/paging.js"></script>
    <script src="JS/validation.js"></script>
    <%@include file="MainAdmin.jsp"%>
    <div id="userWelcome">
        <div class="well">
            <h3>Здравейте, <s:property value="%{#session.user.username}"/></h3>
        </div>
    </div>
    <div id="spacee" style="margin-top: 80px;"></div>
    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title">
                Списък с класове
            </h3>
        </div>
        <div class="panel-body">
            <s:if test="%{#session.user.rolesSet[0].roleName == 'Администратор'}">
                <div id="addButton">
                    <button class="btn btn-info btn-lg btn-block" data-toggle="modal" data-target="#addClass">Добавяне</button>
                </div>
                <div id="addButton">
                    <button class="btn btn-info btn-lg btn-block" data-toggle="modal" data-target="#addStudentToClass">Добавяне на ученик към клас</button>
                </div>
                <s:url id="changeStudentParent" action="changeStudentParent">
                </s:url>
                <s:a href="%{changeStudentParent}">
                    <button class="btn btn-warning btn-lg btn-block" type="button">Промяна на родител за ученик</button>
                </s:a>
            </s:if>

            <div class="modal fade" id="addClass" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-body">
                            <s:form action = "addClass" cssClass="bs-example form-horizontal" onsubmit="return validateAddClass(this)">
                                <fieldset>
                                    <legend>Добавяне на паралелка</legend>
                                    <s:fielderror/>
                                    <div id="loginError"></div>
                                    <div class = "form-group">
                                        <div class="col-lg-10">
                                            <s:textfield id="subjectNameInput" key="newClassName" type="text" cssClass="form-control" placeholder="Име на класа" />
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

            <div class="modal fade" id="addStudentToClass" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-body">
                            <s:form action = "changeStudentClass" cssClass="bs-example form-horizontal" onsubmit="return validateAddStudentInClassForm(this)">
                                <fieldset>
                                    <legend>Преместване на ученик в клас</legend>
                                    <s:fielderror/>
                                    <div id="addError"></div>
                                    <div class = "form-group">
                                        <div class="col-lg-10">
                                            <s:select headerKey="-1" headerValue="Моля Изберете ученик" 
                                                      list="studentNamesList" name="student" cssClass="form-control" />
                                        </div>
                                    </div>
                                    <div class = "form-group">
                                        <div class="col-lg-10">
                                            <s:select headerKey="-1" headerValue="Моля изберете клас,в който ще бъде настанен ученика" 
                                                      list="classNamesList" name="classNo" cssClass="form-control" />
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
                        <th>Име на класа</th>
                        <th></th>
                    </tr>
                </thead>

                <tbody>
                    <s:iterator value="classesList" status="classesStatus">
                        <s:fielderror/>
                        <tr class="success">
                            <td><s:property value="className" /></td>
                            <td>
                                <s:url id="infoURL" action="showClassStudents">
                                    <s:param name="classIdParam" value="%{id}"></s:param>
                                </s:url>
                                <s:a href="%{infoURL}">
                                    <button class="btn btn-info" type="button">Виж учениците в класа</button>
                                </s:a>
                                <s:if test="%{#session.user.rolesSet[0].roleName == 'Администратор'}">
                                    <s:url id="showClassSubjects" action="showClassSubjects">
                                        <s:param name="classIdParam" value="%{id}"></s:param>
                                    </s:url>
                                    <s:a href="%{showClassSubjects}">
                                        <button class="btn btn-success" type="button">Виж предметите за класа</button>
                                    </s:a>
                                </s:if>
                                <s:url id="addHomework" action="addHomework">
                                    <s:param name="classIdParam" value="%{id}"></s:param>
                                </s:url>
                                <s:a href="%{addHomework}">
                                    <button class="btn btn-success" type="button">Домашни работи за класа</button>
                                </s:a>
                                <s:if test="%{#session.user.rolesSet[0].roleName == 'Администратор'}">
                                    <s:url id="deleteClass" action="deleteClass">
                                        <s:param name="classIdParam" value="%{id}"></s:param>
                                    </s:url>
                                    <s:a href="%{deleteClass}">
                                        <button class="btn btn-warning" type="button">Изтриване на клас</button>
                                    </s:a>
                                </s:if>
                            </td>
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
