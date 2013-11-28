<%-- 
    Document   : editUser
    Created on : Nov 13, 2013, 12:58:46 PM
    Author     : Denev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
    <div class="modal fade" id="marksList" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <s:form action = "editConfirmUser" method ="post" cssClass="bs-example form-horizontal" >
                        <fieldset>
                            <legend>Редактиране на потребител</legend>
                            <s:fielderror/>
                            <div class = "form-group">
                                <div class="col-lg-10">
                                    <s:textfield id="userNameInput" key="username" value="%{username}" type="text" cssClass="form-control" placeholder="Потребителско име" />
                                </div>
                            </div>
                            <div class = "form-group">
                                <div class="col-lg-10">
                                    <s:password id="passwordInput" key="password" type="text" cssClass="form-control" placeholder="Парола" />
                                </div>
                            </div>

                                <div class = "form-group">
                                    <div class="col-lg-10">
                                    <s:textfield id="firstNameInput" key="firstName" type="text" cssClass="form-control" placeholder="Име" />
                                </div>
                            </div>
                            <div class = "form-group">
                                <div class="col-lg-10">
                                    <s:textfield id="lastNameInput" key="lastName" type="text" cssClass="form-control" placeholder="Фамилия" />
                                </div>
                            </div>
                            <div class = "form-group">
                                <div class="col-lg-10">
                                    <s:textfield id="telephoneInput" key="telephone" type="text" cssClass="form-control" placeholder="Телефон" />
                                </div>
                            </div>
                            <div class = "form-group">
                                <div class="col-lg-10">
                                    <s:textfield id="adressInput" key="adress" type="text" cssClass="form-control" placeholder="Адрес" />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-10">
                                    <s:textfield id="emailInput" key="email" type="text" cssClass="form-control" placeholder="E-mail" />
                                </div>
                            </div>
                        </fieldset>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Затвори</button>
                            <s:submit cssClass="btn btn-info" value="Запази"/>
                        </div>
                    </s:form>
                </div>
            </div>
        </div>
    </div>
</html>
