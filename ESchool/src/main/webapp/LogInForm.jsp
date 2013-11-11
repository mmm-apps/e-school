<%-- 
    Document   : LogInForm
    Created on : Nov 10, 2013, 9:56:17 PM
    Author     : Denev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
      <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-body">
                        <s:form action = "login" method ="post" cssClass ="bs-example form-horizontal" >
                            <fieldset>
                                <legend>Вход в системата</legend>
                                <div class = "form-group">
                                    <div class="col-lg-10">
                                        <s:textfield id="userNameInput" key="username" cssClass="form-control" placeholder="Потребителксо име" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-lg-10">
                                        <s:password id="passwordInput" key="password" cssClass="form-control" placeholder="Парола" />
                                    </div>
                                </div>
                            </fieldset>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Затвори</button>
                                <s:submit cssClass="btn btn-info" value="Вход"/>
                            </div>
                        </s:form>
                    </div>
                </div>
            </div>
        </div>
</html>
