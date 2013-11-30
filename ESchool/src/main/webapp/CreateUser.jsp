<%-- 
    Document   : CreateUser
    Created on : Nov 17, 2013, 7:29:42 PM
    Author     : MMihov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
 <jsp:include page="admin.jsp"></jsp:include>         
        <div class="well well-sm" style="margin-left: 30%;margin-right: 30%; margin-top: 5%;padding: 3%">
            <s:form action = "createuser" cssClass="bs-example form-horizontal">
                <fieldset>
                    <legend>Добавяне на потребител</legend>
                    <s:fielderror/>
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
                            <s:radio list="#{'STUDENT':'STUDENT','TEACHER':'TEACHER','PARENT':'PARENT'}" value="Role" name="list1" cssClass="btn btn-primary"></s:radio>
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
                    <button type="button" class="btn btn-info" style="float: left;">Назад</button>
                    <s:submit cssClass="btn btn-info" value="Добави"/>
                </div>
            </s:form>
        </div>
    </body>
</html>
