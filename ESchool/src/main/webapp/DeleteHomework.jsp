<%-- 
    Document   : DeleteHomework
    Created on : Nov 13, 2013, 4:23:34 PM
    Author     : Denev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <div class="modal fade" id="delHomework" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <form action = "login.action" method ="post" class ="bs-example form-horizontal" >
                        <fieldset>
                            <legend>Изтриване на домашни работи по История на 6а клас</legend>
                            Изберете домашно:
                            <select id="select" class="form-control">
                                <option>-------</option>
                                <option> Урок номер 1 </option>
                                <option> Урок номер 2 </option>
                                <option> Подготовка за тест</option>
                            </select>
                        </fieldset>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Затвори</button>
                            <s:submit cssClass="btn btn-danger" value="Изтрии"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</html>
