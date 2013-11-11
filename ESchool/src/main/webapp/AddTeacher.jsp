<%-- 
    Document   : AddTeacher
    Created on : Nov 11, 2013, 11:08:51 PM
    Author     : Denev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <div class="modal fade" id="AddTeacher" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <form action = "login.action" method ="post" class ="bs-example form-horizontal" >
                        <fieldset>
                            <legend>Добавяне на потребител</legend>
                            <div class = "form-group">
                                <div class="col-lg-10">
                                    <s:textfield id="telephoneInput" key="userName" type="text" cssClass="form-control" placeholder="Потребителско име" />
                                </div>
                            </div>
                            <div class = "form-group">
                                <div class="col-lg-10">
                                    <s:password id="telephoneInput" key="password" type="text" cssClass="form-control" placeholder="Парола" />
                                </div>
                            </div>
                            <div class = "form-group">
                                <div class="col-lg-10">
                                    <s:textfield id="telephoneInput" key="firstName" type="text" cssClass="form-control" placeholder="Име" />
                                </div>
                            </div>
                            <div class = "form-group">
                                <div class="col-lg-10">
                                    <s:textfield id="telephoneInput" key="lastName" type="text" cssClass="form-control" placeholder="Фамилия" />
                                </div>
                            </div>
                            <div class = "form-group">
                                <div class="col-lg-10">
                                    <s:textfield id="telephoneInput" key="telephone" type="text" cssClass="form-control" placeholder="Телефон" />
                                </div>
                            </div>
                            <div class = "form-group">
                                <div class="col-lg-10">
                                    <s:textfield id="telephoneInput" key="adress" type="text" cssClass="form-control" placeholder="Адрес" />
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
                            <s:submit cssClass="btn btn-info" value="Добави"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</html>
