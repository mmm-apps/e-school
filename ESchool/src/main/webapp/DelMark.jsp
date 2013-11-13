<%-- 
    Document   : AddMark
    Created on : Nov 13, 2013, 2:20:18 PM
    Author     : Denev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <div class="modal fade" id="delMarks" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <form action = "login.action" method ="post" class ="bs-example form-horizontal" >
                        <fieldset>
                            <legend>Изтриване на оценки по История на 6а клас</legend>
                            Изберете ученик:
                            <select id="select" class="form-control">
                                <option>-------</option>
                                <option> Иван Петров </option>
                                <option> Иван Иванов </option>
                                <option> Иван Георгиев</option>
                                <option> Петър Петров </option>
                            </select>
                            <br>
                            Изберете оценка:
                            <select id="select" class="form-control">
                                <option>-------</option>
                                <option> 6 </option>
                                <option> 5 </option>
                                <option> 4 </option>
                                <option> 3 </option>
                                <option> 2 </option>
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
