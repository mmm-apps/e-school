<%-- 
    Document   : MarksList
    Created on : Nov 13, 2013, 12:58:46 PM
    Author     : Denev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="modal fade" id="marksList" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <form action = "login.action" method ="post" class ="bs-example form-horizontal" >
                        <fieldset>
                            <legend>Преглед на оценки по История на 6а клас</legend>
                            <table class="table table-striped table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th></th>
                                        <th>Име</th>
                                        <th>Фамилия</th>
                                        <th>Списък с оценки</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr  class="success">
                                        <td>1</td>
                                        <td>Иван</td>
                                        <td>Петров</td>
                                        <td>
                                            <span class="label label-success" style="font-size: 1.1em;">6</span>
                                            <span class="label label-primary" style="font-size: 1.1em;">5</span>
                                            <span class="label label-info" style="font-size: 1.1em;">4</span>
                                            <span class="label label-warning" style="font-size: 1.1em;">3</span>
                                            <span class="label label-danger" style="font-size: 1.1em;">2</span>
                                        </td>
                                    </tr>
                                    <tr  class="success">
                                        <td>1</td>
                                        <td>Георги</td>
                                        <td>Димитров</td>
                                        <td>
                                            <span class="label label-success" style="font-size: 1.1em;">6</span>
                                            <span class="label label-success" style="font-size: 1.1em;">6</span>
                                            <span class="label label-info" style="font-size: 1.1em;">4</span>
                                            <span class="label label-success" style="font-size: 1.1em;">6</span>
                                            <span class="label label-success" style="font-size: 1.1em;">6</span>
                                        </td>
                                    </tr>
                                    <tr  class="success">
                                        <td>1</td>
                                        <td>Петър</td>
                                        <td>Петров</td>
                                        <td>
                                            <span class="label label-success" style="font-size: 1.1em;">6</span>
                                            <span class="label label-primary" style="font-size: 1.1em;">5</span>
                                            <span class="label label-info" style="font-size: 1.1em;">4</span>
                                            <span class="label label-warning" style="font-size: 1.1em;">3</span>
                                            <span class="label label-danger" style="font-size: 1.1em;">2</span>
                                        </td>
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
</html>
