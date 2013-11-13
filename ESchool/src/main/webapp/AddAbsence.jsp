<%-- 
    Document   : AddAbsence
    Created on : Nov 13, 2013, 4:47:38 PM
    Author     : Denev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <div class="modal fade" id="addAbsence" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <form action = "login.action" method ="post" class ="bs-example form-horizontal" >
                        <fieldset>
                            <legend>Добавяне на отсъствия по История на 6а клас</legend>
                            Изберете ученик:
                            <select id="select" class="form-control">
                                <option>-------</option>
                                <option> Иван Петров </option>
                                <option> Иван Иванов </option>
                                <option> Иван Георгиев</option>
                                <option> Петър Петров </option>
                            </select>
                            <br>
                            
                            Изберете тип отсъствие:
                            <select id="select" class="form-control">
                                <option>-------</option>
                                <option> Извинено </option>
                                <option> Неизвинено </option>
                            </select>
                            <br/>
                            
                            Дата:
                            <input type="date" id="datepicker" class="form-control"/>
                            <br/> 

                            Стойност на отсъствие:
                            <select id="select" class="form-control">
                                <option>-------</option>
                                <option> 1 </option>
                                <option> 1/3 </option>
                            </select>
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
