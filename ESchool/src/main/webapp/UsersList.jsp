<%-- 
    Document   : UsersList
    Created on : Nov 11, 2013, 10:43:33 PM
    Author     : Denev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
  <link type="text/css" rel="stylesheet" href="CSS/bootstrap.css" media="screen">
  <script src="JS/paging.js"></script>
  <jsp:include page="admin.jsp"></jsp:include>
  <script>
    function modalOpen(id) 
    {
      $('#'+id).addClass('modal fade in').attr("aria-hidden", "false").show();
    }
  </script>
    <div id="userWelcome">
      <div class="well">
        <h3>Здравейте, Администратор</h3>
      </div>
    </div>

    <div id="spacee" style="margin-top: 80px;"></div>
    <div class="panel panel-info">
      <div class="panel-heading">
        <h3 class="panel-title">
          Списък с потребители
        </h3>
      </div>
      <div class="panel-body">
        <a href="<s:url action='addUser'/>" >
        <div id="addButton">
          <button class="btn btn-info btn-lg btn-block">Добавяне</button>
        </div>
      </a>

      <table id="results" class="table table-striped table-bordered table-hover">
        <thead>
          <tr>
            <th>Потребителско име</th>
            <th>Роля</th>
            <th></th>
          </tr>
        </thead>

        <tbody>
          <s:iterator value="userList" var="currentUser">
            <tr class="success">
              <td><s:property value="username" /></td>
              <td><s:property value="rolesSet[0].roleName" /></td>
              <td>
                <button class="btn btn-info" data-toggle="modal" data-target="#info<s:property value="username" />">Информация</button>
                <button class="btn btn-warning" data-toggle="modal" data-target="#edit<s:property value="username" />">Редактиране</button>                    
                <s:url id="deleteUser" action="deleteUser">
                  <s:param name="userId" value="%{id}"></s:param>
                </s:url>
                <s:a href="%{deleteUser}">
                  <button class="btn btn-danger" type="button">Изтриване</button>
                </s:a>

                <div class="modal fade" id="info<s:property value="username" />" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                  <div class="modal-dialog">
                    <div class="modal-content">
                      <div class="modal-body">
                        <form action = "login.action" method="post" class ="bs-example form-horizontal" >
                          <fieldset>
                            <legend>Преглед на потребител</legend>
                            <table class="table table-striped table-bordered table-hover">
                              <tbody>
                                <tr>
                                  <td>Потребителско име</td>
                                  <td><s:property value="username" /></td>
                                </tr>
                                <tr>
                                  <td>Роля</td>
                                  <td><s:property value="rolesSet[0].roleName" /></td>
                                </tr>
                                <tr>
                                  <td>Име</td>
                                  <s:if test="student != null">
                                    <td><s:property value="student.firstName" /></td>
                                  </s:if>
                                  <s:elseif test="teacher != null">
                                    <td><s:property value="teacher.firstName" /></td>
                                  </s:elseif>
                                  <s:elseif test="parent != null">
                                    <td><s:property value="parent.firstName" /></td>
                                  </s:elseif>
                                  <s:else><td></td></s:else>
                                  </tr>
                                  <tr>
                                    <td>Фамилия</td>
                                  <s:if test="student != null">
                                    <td><s:property value="student.lastName" /></td>
                                  </s:if>
                                  <s:elseif test="teacher != null">
                                    <td><s:property value="teacher.lastName" /></td>
                                  </s:elseif>
                                  <s:elseif test="parent != null">
                                    <td><s:property value="parent.lastName" /></td>
                                  </s:elseif>
                                  <s:else><td></td></s:else>
                                  </tr>
                                  <tr>
                                    <td>Телефон</td>
                                  <s:if test="student != null">
                                    <td><s:property value="student.phone" /></td>
                                  </s:if>
                                  <s:elseif test="teacher != null">
                                    <td><s:property value="teacher.phone" /></td>
                                  </s:elseif>
                                  <s:elseif test="parent != null">
                                    <td><s:property value="parent.phone" /></td>
                                  </s:elseif>
                                  <s:else><td></td></s:else>
                                  </tr>
                                  <tr>
                                    <td>Имейл</td>
                                  <s:if test="student != null">
                                    <td><s:property value="student.email" /></td>
                                  </s:if>
                                  <s:elseif test="teacher != null">
                                    <td><s:property value="teacher.email" /></td>
                                  </s:elseif>
                                  <s:elseif test="parent != null">
                                    <td><s:property value="parent.email" /></td>
                                  </s:elseif>
                                  <s:else><td></td></s:else>
                                  </tr>
                                  <tr>
                                    <td>Адрес</td>
                                  <s:if test="student != null">
                                    <td><s:property value="student.adress" /></td>
                                  </s:if>
                                  <s:elseif test="teacher != null">
                                    <td><s:property value="teacher.adress" /></td>
                                  </s:elseif>
                                  <s:elseif test="parent != null">
                                    <td><s:property value="parent.adress" /></td>
                                  </s:elseif>
                                  <s:else><td></td></s:else>
                                  </tr>
                                </tbody>
                            </table>
                          </fieldset>
                          <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Затвори</button>
                          </div>
                        </form>
                      </div>
                    </div>
                  </div>
                </div>

                <div class="well well-sm modal fade" id="edit<s:property value="username" />" style="margin-left: 30%;margin-right: 30%; margin-top: 5%;padding: 3%;">
                  <s:form action="editConfirmUser" method="post" cssClass="bs-example form-horizontal">
                    <fieldset>
                      <legend>Редактиране на потребител</legend>
                      <s:fielderror/>
                      <div class="col-lg-10">
                       <s:hidden id="userId" key="id" type="text" cssClass="form-control"/>
                      </div>
                      <div class = "form-group">
                        <div class="col-lg-10">
                          <s:textfield id="userNameInput" key="username" type="text" cssClass="form-control" placeholder="Потребителско име" />
                        </div>
                      </div>
                      <div class = "form-group">
                        <div class="col-lg-10">
                          <s:password id="passwordInput" key="password" type="text" cssClass="form-control" placeholder="Парола" />
                        </div>
                      </div>
                      <div class = "form-group">
                        <div class="col-lg-10">
                          <s:password id="newPassword" key="newPassword" value="" type="text" cssClass="form-control" placeholder="Нова Парола" />
                        </div>
                      </div>
                      <div class = "form-group">
                        <div class="col-lg-10">
                          <s:password id="reNewPassword" key="reNewPassword" value="" type="text" cssClass="form-control" placeholder="Нова Парола Отново" />
                        </div>
                      </div>
                      <div class = "form-group">
                        <div class="col-lg-10">
                            <s:select headerKey="-1" headerValue="Моля изберете роля" 
                                      list="roleCollection" name="roleList" cssClass="form-control"/>
                        </div>
                      </div>
                      <div class = "form-group">
                        <div class="col-lg-10">
                          <s:if test="student != null">
                            <s:textfield id="nameInput" key="student.firstName" type="text" cssClass="form-control" placeholder="Име"/>
                          </s:if>
                          <s:elseif test="teacher != null">
                            <s:textfield id="nameInput" key="teacher.firstName" type="text" cssClass="form-control" placeholder="Име"/>
                          </s:elseif>
                          <s:elseif test="parent != null">
                            <s:textfield id="nameInput" key="parent.firstName" type="text" cssClass="form-control" placeholder="Име"/>
                          </s:elseif>
                        </div>
                      </div>
                      <div class = "form-group">
                        <div class="col-lg-10">
                          <s:if test="student != null">
                            <s:textfield id="lastNameInput" key="student.lastName" type="text" cssClass="form-control" placeholder="Фамилия" />
                          </s:if>
                          <s:elseif test="teacher != null">
                            <s:textfield id="lastNameInput" key="teacher.lastName" type="text" cssClass="form-control" placeholder="Фамилия" />
                          </s:elseif>
                          <s:elseif test="parent != null">
                            <s:textfield id="lastNameInput" key="parent.lastName" type="text" cssClass="form-control" placeholder="Фамилия" />
                          </s:elseif>
                        </div>
                      </div>
                      <div class = "form-group">
                        <div class="col-lg-10">
                          <s:if test="student != null">
                            <s:textfield id="phoneInput" key="student.phone" type="text" cssClass="form-control" placeholder="Телефон" />
                          </s:if>
                          <s:elseif test="teacher != null">
                            <s:textfield id="phoneInput" key="teacher.phone" type="text" cssClass="form-control" placeholder="Телефон" />
                          </s:elseif>
                          <s:elseif test="parent != null">
                            <s:textfield id="phoneInput" key="parent.phone" type="text" cssClass="form-control" placeholder="Телефон" />
                          </s:elseif>
                        </div>
                      </div>
                      <div class = "form-group">
                        <div class="col-lg-10">
                          <s:if test="student != null">
                            <s:textfield id="emailInput" key="student.email" type="text" cssClass="form-control" placeholder="Имейл" />
                          </s:if>
                          <s:elseif test="teacher != null">
                            <s:textfield id="emailInput" key="teacher.email" type="text" cssClass="form-control" placeholder="Имейл" />
                          </s:elseif>
                          <s:elseif test="parent != null">
                            <s:textfield id="emailInput" key="parent.email" type="text" cssClass="form-control" placeholder="Имейл" />
                          </s:elseif>
                        </div>
                      </div>
                      <div class = "form-group">
                        <div class="col-lg-10">
                          <s:if test="student != null">
                            <s:textfield id="addressInput" key="student.adress" type="text" cssClass="form-control" placeholder="Адрес" />
                          </s:if>
                          <s:elseif test="teacher != null">
                            <s:textfield id="addressInput" key="teacher.adress" type="text" cssClass="form-control" placeholder="Адрес" />
                          </s:elseif>
                          <s:elseif test="parent != null">
                            <s:textfield id="addressInput" key="parent.adress" type="text" cssClass="form-control" placeholder="Адрес" />
                          </s:elseif>
                        </div>
                      </div>
                    </fieldset>
                    <div class="modal-footer">
                      <a href="<s:url action='listUser'/>">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Затвори</button>
                      </a>
                      <s:submit cssClass="btn btn-info" value="Запази"/> <!--onclick="$(this).parents('.modal').attr('id')" -->
                    </div>
                </s:form>
                </div>

              </td>
            </tr>
          </s:iterator>
        </tbody>
      </table>
      <div id="pageNavPosition" style="margin-left: 44%;"></div>
    </div>
  </div>
  <script type="text/javascript">
    <!--
    var pager = new Pager('results', 5);
    pager.init();
    pager.showPageNav('pager', 'pageNavPosition');
    pager.showPage(1);//-->
  </script>
</html>