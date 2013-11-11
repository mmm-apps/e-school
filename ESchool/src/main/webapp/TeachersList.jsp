<%-- 
    Document   : TeachersList
    Created on : Nov 11, 2013, 10:43:33 PM
    Author     : Denev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="AddTeacher.jsp"/>
    <div id="StudentWelcome">
        <div class="well">
            <h3>Здравейте, Иван Иванов</h3>
        </div>
    </div>

    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title">
                Списък с учители
            </h3>
        </div>
        <div class="panel-body">

            <button class="btn btn-info btn-lg btn-block" type="submit" data-toggle="modal" data-target="#AddTeacher">
                Добавяне
            </button>

            <table class="table table-striped table-bordered table-hover">
                <thead>
                    <tr>
                        <th></th>
                        <th>Име</th>
                        <th>Фамилия</th>
                        <th>Телефон</th>
                        <th>Адрес</th>
                        <th>Потребителско име</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr  class="success">
                        <td>1</td>
                        <td>Иван</td>
                        <td>Петров</td>
                        <td>0899434343</td>
                        <td>София, Студентски град, бл59</td>
                        <td>iPetrov</td>
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
                        <td>1</td>
                        <td>Георги</td>
                        <td>Димитров</td>
                        <td>0899434343</td>
                        <td>София, Студентски град, бл60</td>
                        <td>gDimitrov</td>
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
                        <td>1</td>
                        <td>Петър</td>
                        <td>Петров</td>
                        <td>0899434343</td>
                        <td>София, Студентски град, бл15</td>
                        <td>пPetrov</td>
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
