<%-- 
    Document   : AddHomework
    Created on : Nov 13, 2013, 2:38:10 PM
    Author     : Denev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <div class="modal fade" id="addHomework" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <form action = "login.action" method ="post" class ="bs-example form-horizontal" >
                        <fieldset>
                            <legend>Добавяне на домашна работа по История на 6а клас</legend>
                            <div class = "form-group">
                                <div class="col-lg-10">
                                    <s:textfield id="titleInput" key="homeworkTitle" type="text" cssClass="form-control" placeholder="Име на домашната работа" />
                                </div>
                            </div>
                            <div class = "form-group">
                                <div id="datepicker" class="col-lg-10">
                                    Начална дата
                                    <input type="date" id="datepicker" class="form-control"/>
                                </div>
                            </div>
                            <div class = "form-group">
                                <div id="datepicker" class="col-lg-10">
                                    Крайна дата
                                    <input type="date" id="datepickerEnd" class="form-control"/>
                                </div>
                            </div>
                            <div class = "form-group">
                                <div class="col-lg-10">
                                    Изпълнена:
                                    <select id="select" class="form-control">
                                        <option>-------</option>
                                        <option> Не </option>
                                        <option> Да </option>
                                    </select>
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
