<%-- 
    Document   : SubjectsList
    Created on : Nov 22, 2013, 2:27:17 PM
    Author     : Denev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
 <div id="userWelcome">
        <div class="well">
            <h3>Здравейте, Администратор</h3>
        </div>
    </div>
    <div id="spacee" style="margin-top: 80px;"></div>
    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title">
                Списък с предмети
            </h3>
        </div>
        <div class="panel-body">

            <a href="<s:url action='selectSubjectType'/>" >
                <div id="addButton">
                    <button class="btn btn-info btn-lg btn-block">Добавяне</button>
                </div>
            </a>

            <table class="table table-striped table-bordered table-hover">
                <thead>
                    <tr>
                        <th></th>
                        <th>Предмет</th>
                        <th>Тип на предмета</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr  class="success">
                        <td>1</td>
                        <td>История</td>
                        <td>Задължителен</td>
                        <td>
                            <button class="btn btn-info" type="button">
                                Информация
                            </button>
                            <button class="btn btn-warning" type="button">
                                Коригиране
                            </button>
                            <button class="btn btn-danger" type="button">
                                Изтриване
                            </button>
                        </td>
                    </tr>
                    <tr  class="success">
                        <td>2</td>
                        <td>География</td>
                        <td>Задължителен</td>
                        <td>
                            <button class="btn btn-info" type="button">
                                Информация
                            </button>
                            <button class="btn btn-warning" type="button">
                                Коригиране
                            </button>
                            <button class="btn btn-danger" type="button">
                                Изтриване
                            </button>
                        </td>
                    </tr>
                    <tr  class="success">
                        <td>3</td>
                        <td>Сип-Математика</td>
                        <td>Избираем</td>
                        <td>
                            <button class="btn btn-info" type="button">
                                Информация
                            </button>
                            <button class="btn btn-warning" type="button">
                                Коригиране
                            </button>
                            <button class="btn btn-danger" type="button">
                                Изтриване
                            </button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</html>
