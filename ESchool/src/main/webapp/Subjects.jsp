<%-- 
    Document   : SubjectsList
    Created on : Nov 22, 2013, 2:27:17 PM
    Author     : Denev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <jsp:include page="MainAdmin.jsp"></jsp:include>
    <div id="userWelcome">
        <div class="well">
            <h3>Здравейте, Администратор</h3>
        </div>
    </div>
    <div id="spacee" style="margin-top: 80px;"></div>
    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title">
                Списък с предмети
            </h3>
        </div>
        <div class="panel-body">

            <a href="<s:url action='selectSubjectType'/>" >
                <div id="addButton">
                    <button class="btn btn-info btn-lg btn-block">Добавяне</button>
                </div>
            </a>

            <table class="table table-striped table-bordered table-hover">
                <thead>
                    <tr>
                        <th></th>
                        <th>Предмет</th>
                        <th>Тип на предмета</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="subjectsList" status="subjectStatus">
                        <tr  class="success">
                            <td><s:property value="subjectName"/></td>
                            <td><s:property value="subjectKind"/></td>
                            <td>
                                <s:url id="deleteSubject" action="deleteSubject">
                                    <s:param name="subjectIdParam" value="%{id}"></s:param>
                                </s:url>
                                <s:a href="%{deleteSubject}">
                                    <button class="btn btn-danger" type="button">Изтриване</button>
                                </s:a>
                            </td>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>
        </div>
                
            <div class="modal fade" id="addAbsence" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
              <div class="modal-dialog">
                <div class="modal-content">
                  <div class="modal-body">
                    <s:form action = "addSubject" cssClass="bs-example form-horizontal">
                  <fieldset>
                      <legend>Добавяне на предмети</legend>
                      <s:fielderror/>
                      <div class = "form-group">
                          <div class="col-lg-10">
                              <s:textfield id="subjectNameInput" key="subjectName" type="text" cssClass="form-control" placeholder="Име на предмет" />
                          </div>
                      </div>
                      <div class = "form-group">
                          <div class="col-lg-10">
                              <s:select headerKey="-1" headerValue="Тип на предмета" 
                                        list="subjectTypes" key="subjectKind" cssClass="form-control"/>
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
</html>
