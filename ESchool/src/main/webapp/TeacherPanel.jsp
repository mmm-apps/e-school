<%-- 
    Document   : TeacherPanel
    Created on : Nov 11, 2013, 9:40:42 PM
    Author     : Denev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
  <%@include file="menu.jsp"%> 
  <jsp:include page="EditStudentProfile.jsp"/>
  <jsp:include page="MarksList.jsp"/>
  <jsp:include page="AddHomework.jsp"/>
  <jsp:include page="DeleteHomework.jsp"/>
  <div id="userWelcome">
    <div class="well">
      <h3>Здравейте, <s:label key="teacherName" /> </h3>
    </div>
  </div>
  <div id="TeacherMenu">
    <div id="spacee" style="margin-top: 80px;"></div>
    <div class="well">
      <div class="col-lg-12">
        <div class="bs-example">
          <ul class="nav nav-tabs nav-justified" style="margin-bottom: 15px;">
            <li class="active"><a href="#profile" data-toggle="tab">Профил</a></li>
            <li class=""><a href="#marks" data-toggle="tab">Оценки</a></li>
            <li class=""><a href="#homeworks" data-toggle="tab">Домашни</a></li>
            <li class=""><a href="#remarks" data-toggle="tab">Забележки и отсъствия</a></li>
          </ul>
          <div id="myTabContent" class="tab-content">
            <div class="tab-pane fade active in" id="profile">
              <div class="well">
                <div class="panel panel-success">
                  <div class="panel-heading">
                    <h3 class="panel-title"><s:label key="fullName" /></h3>
                  </div>
                </div>
                <div class="panel panel-success">
                  <div class="panel-heading">
                    <h3 class="panel-title"><s:label key="telephone" /></h3>
                  </div>
                </div>
                <div class="panel panel-success">
                  <div class="panel-heading">
                    <h3 class="panel-title"><s:label key="email" /></h3>
                  </div>
                </div>
                <div class="panel panel-success">
                  <div class="panel-heading">
                    <h3 class="panel-title"><s:label key="adress" /></h3>
                  </div>
                </div>
                <button type="submit" class="btn btn-info" style="margin-left: 40%;" data-toggle="modal" data-target="#EditStudentProfile">Промени данните</button>
              </div>
            </div>
            <div class="tab-pane fade" id="marks">

              <table class="table table-striped table-bordered table-hover">
                <thead>
                  <tr>
                    <th>Предмет</th>
                    <th>Клас</th>
                    <th></th>
                  </tr>
                </thead>
                <tbody>
                  <tr class="success">
                    <s:iterator value="classes" var="currentClass">
                    <tr>
                      <td><span class="label label-default" style="font-size: 1.1em;"><s:property value="subject"/></span></td>
                      <td><span class="label label-default" style="font-size: 1.1em;"><s:property value="clas"/></span></td>
                      <td>
                        <s:url id="ViewMark" action="selectRemark">
                          <s:param name="userId" value="%{id}"></s:param>
                        </s:url>
                        <s:a href="%{addMark}">
                          <button class="btn btn-success" type="button">Добавяне</button>
                        </s:a>
                        <s:url id="AddMark" action="selectRemark">
                          <s:param name="userId" value="%{id}"></s:param>
                        </s:url>
                        <s:a href="%{addMark}">
                          <button class="btn btn-info" type="button">Преглед</button>
                        </s:a>
                        <s:url id="AddMark" action="selectRemark">
                          <s:param name="userId" value="%{id}"></s:param>
                        </s:url>
                        <s:a href="%{addMark}">
                          <button class="btn btn-danger" type="button">Изтриване</button>
                        </s:a>
                      </td>
                    </tr>
                  </s:iterator>
                </tbody>
              </table>


            </div>
            <div class="tab-pane fade" id="homeworks">

              <table class="table table-striped table-bordered table-hover">
                <thead>
                  <tr>
                    <th>Предмет</th>
                    <th>Клас</th>
                    <th>Домашна работа</th>
                  </tr>
                </thead>
                <tbody>
                  <s:iterator value="classes" var="currentClass">
                    <tr>
                      <td><span class="label label-default" style="font-size: 1.1em;"><s:property value="subject"/></span></td>
                      <td><span class="label label-default" style="font-size: 1.1em;"><s:property value="clas"/></span></td>
                      <td>
                        <s:url id="ViewMark" action="selectRemark">
                          <s:param name="userId" value="%{id}"></s:param>
                        </s:url>
                        <s:a href="%{addMark}">
                          <button class="btn btn-success" type="button">Добавяне</button>
                        </s:a>
                        <s:url id="AddMark" action="selectRemark">
                          <s:param name="userId" value="%{id}"></s:param>
                        </s:url>
                        <s:a href="%{addMark}">
                          <button class="btn btn-info" type="button">Преглед</button>
                        </s:a>
                        <s:url id="AddMark" action="selectRemark">
                          <s:param name="userId" value="%{id}"></s:param>
                        </s:url>
                        <s:a href="%{addMark}">
                          <button class="btn btn-danger" type="button">Изтриване</button>
                        </s:a>
                      </td>
                    </tr>
                  </s:iterator>
                </tbody>
              </table>


            </div>

            <div class="tab-pane fade well" id="remarks">

              <div class="panel panel-info">
                <div class="panel-heading">
                  <h3 class="panel-title">
                    Отсъствия
                  </h3>
                </div>
                <div class="panel-body">
                  <table class="table table-striped table-bordered table-hover">
                    <thead>
                      <tr>
                        <th>Предмет</th>
                        <th>Клас</th>
                        <th></th>
                      </tr>
                    </thead>
                    <tbody>
                      <s:iterator value="classes" var="currentClass">
                        <tr>
                          <td><span class="label label-default" style="font-size: 1.1em;"><s:property value="subject"/></span></td>
                          <td><span class="label label-default" style="font-size: 1.1em;"><s:property value="clas"/></span></td>
                          <td>
                            <s:url id="ViewMark" action="selectRemark">
                              <s:param name="userId" value="%{id}"></s:param>
                            </s:url>
                            <s:a href="%{addMark}">
                              <button class="btn btn-success" type="button">Добавяне</button>
                            </s:a>
                            <s:url id="AddMark" action="selectRemark">
                              <s:param name="userId" value="%{id}"></s:param>
                            </s:url>
                            <s:a href="%{addMark}">
                              <button class="btn btn-info" type="button">Преглед</button>
                            </s:a>
                            <s:url id="AddMark" action="selectRemark">
                              <s:param name="userId" value="%{id}"></s:param>
                            </s:url>
                            <s:a href="%{addMark}">
                              <button class="btn btn-danger" type="button">Изтриване</button>
                            </s:a>
                          </td>
                        </tr>
                      </s:iterator>
                    </tbody>
                  </table>
                </div>
              </div>
              <div class="panel panel-info">
                <div class="panel-heading">
                  <h3 class="panel-title">
                    Забележки
                  </h3>
                </div>
                <div class="panel-body">
                  <table class="table table-striped table-bordered table-hover">
                    <thead>
                      <tr>
                        <th></th>
                        <th>Предмет</th>
                        <th>Клас</th>
                        <th></th>
                      </tr>
                    </thead>
                    <tbody>
                      <s:iterator value="classes" var="currentClass">
                        <tr>
                          <td><span class="label label-default" style="font-size: 1.1em;"><s:property value="subject"/></span></td>
                          <td><span class="label label-default" style="font-size: 1.1em;"><s:property value="clas"/></span></td>
                          <td>
                            <s:url id="ViewMark" action="selectRemark">
                              <s:param name="userId" value="%{id}"></s:param>
                            </s:url>
                            <s:a href="%{addMark}">
                              <button class="btn btn-success" type="button">Добавяне</button>
                            </s:a>
                            <s:url id="AddMark" action="selectRemark">
                              <s:param name="userId" value="%{id}"></s:param>
                            </s:url>
                            <s:a href="%{addMark}">
                              <button class="btn btn-info" type="button">Преглед</button>
                            </s:a>
                            <s:url id="AddMark" action="selectRemark">
                              <s:param name="userId" value="%{id}"></s:param>
                            </s:url>
                            <s:a href="%{addMark}">
                              <button class="btn btn-danger" type="button">Изтриване</button>
                            </s:a>
                          </td>
                        </tr>
                      </s:iterator>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</html>
