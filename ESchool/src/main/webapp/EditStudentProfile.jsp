<%-- 
    Document   : LogInForm
    Created on : Nov 10, 2013, 9:56:17 PM
    Author     : Denev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <div class="modal fade" id="EditStudentProfile" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <form action = "login.action" method ="post" class ="bs-example form-horizontal" >
                        <fieldset>
                            <legend>Редактиране на профил</legend>
                            <div class = "form-group">
                                <div class="col-lg-10">
                                    <s:textfield id="telephoneInput" key="telephone" type="text" cssClass="form-control" placeholder="Телефон" />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-10">
                                    <s:password id="emailInput" key="email" type="text" cssClass="form-control" placeholder="E-mail" />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-10">
                                    <s:password id="adressInput" key="adress" type="text" cssClass="form-control" placeholder="Adress" />
                                </div>
                            </div>
                        </fieldset>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Затвори</button>
                            <s:submit cssClass="btn btn-info" value="Редактирай"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</html>
