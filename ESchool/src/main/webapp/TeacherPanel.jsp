<%-- 
    Document   : TeacherPanel
    Created on : Nov 11, 2013, 9:40:42 PM
    Author     : Denev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="EditStudentProfile.jsp"/>
    <jsp:include page="MarksList.jsp"/>
    <jsp:include page="DelMark.jsp"/>
    <jsp:include page="AddHomework.jsp"/>
    <jsp:include page="DeleteHomework.jsp"/>
    <jsp:include page="AbsencesList.jsp"/>
    <jsp:include page="AddAbsence.jsp"/>
    <div id="userWelcome">
        <div class="well">
            <h3>Здравейте, Иван Георгиев Иванов </h3>
        </div>
    </div>
    <div id="TeacherMenu">
        <div id="spacee" style="margin-top: 80px;"></div>
        <div class="well">
            <div class="col-lg-12">
                <div class="bs-example">
                    <ul class="nav nav-tabs nav-justified" style="margin-bottom: 15px;">
                        <li class="active"><a href="#profile" data-toggle="tab">Профил</a></li>
                        <li class=""><a href="#marks" data-toggle="tab">Оценки</a></li>
                        <li class=""><a href="#homeworks" data-toggle="tab">Домашни</a></li>
                        <li class=""><a href="#remarks" data-toggle="tab">Забележки и отсъствия</a></li>
                    </ul>
                    <div id="myTabContent" class="tab-content">
                        <div class="tab-pane fade active in" id="profile">
                            <div class="well">
                                <div class="panel panel-success">
                                    <div class="panel-heading">
                                        <h3 class="panel-title">Име: Иван Георгиев Иванов</h3>
                                    </div>
                                </div>
                                <div class="panel panel-success">
                                    <div class="panel-heading">
                                        <h3 class="panel-title">Преподавател по: История</h3>
                                    </div>
                                </div>
                                <div class="panel panel-success">
                                    <div class="panel-heading">
                                        <h3 class="panel-title">Телефон: 0896793267</h3>
                                    </div>
                                </div>
                                <div class="panel panel-success">
                                    <div class="panel-heading">
                                        <h3 class="panel-title">Е-mail: baiIvan@gmail.com</h3>
                                    </div>
                                </div>
                                <div class="panel panel-success">
                                    <div class="panel-heading">
                                        <h3 class="panel-title">Адрес: Бул.Панчо Владигеров №390 </h3>
                                    </div>
                                </div>
                                <button type="submit" class="btn btn-info" style="margin-left: 40%;" data-toggle="modal" data-target="#EditStudentProfile">Промени данните</button>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="marks">

                            <table class="table table-striped table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th></th>
                                        <th>Предмет</th>
                                        <th>Клас</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr class="success">
                                        <td>1</td>
                                        <td><span class="label label-default" style="font-size: 1.1em;">История</span></td>
                                        <td><span class="label label-default" style="font-size: 1.1em;">6а</span></td>
                                        <td>
                                            <button class="btn btn-success" type="button" data-toggle="modal" data-target="#marksList">
                                                Преглед
                                            </button>
                                            <a href="<s:url action='AddMark?content=teachersList'/>" >
                                                <button class="btn btn-info">Добавяне</button>
                                            </a>
                                            <button class="btn btn-danger" type="button" data-toggle="modal" data-target="#delMarks">
                                                Изтриване
                                            </button>
                                        </td>
                                    </tr>
                                    <tr class="success">
                                        <td>2</td>
                                        <td><span class="label label-default" style="font-size: 1.1em;">История</span></td>
                                        <td><span class="label label-default" style="font-size: 1.1em;">6б</span></td>
                                        <td>
                                            <button class="btn btn-success" type="button">
                                                Преглед
                                            </button>
                                            <button class="btn btn-info" type="button">
                                                Дообавяне
                                            </button>
                                            <button class="btn btn-danger" type="button">
                                                Изтриване
                                            </button>
                                        </td>
                                    </tr>
                                    <tr class="success">
                                        <td>3</td>
                                        <td><span class="label label-default" style="font-size: 1.1em;">История</span></td>
                                        <td><span class="label label-default" style="font-size: 1.1em;">6в</span></td>
                                        <td>
                                            <button class="btn btn-success" type="button">
                                                Преглед
                                            </button>
                                            <button class="btn btn-info" type="button">
                                                Дообавяне
                                            </button>
                                            <button class="btn btn-danger" type="button">
                                                Изтриване
                                            </button>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>


                        </div>
                        <div class="tab-pane fade" id="homeworks">

                            <table class="table table-striped table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th></th>
                                        <th>Предмет</th>
                                        <th>Клас</th>
                                        <th>Домашна работа</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr class="success">
                                        <td>1</td>
                                        <td><span class="label label-default" style="font-size: 1.1em;">История</span></td>
                                        <td><span class="label label-default" style="font-size: 1.1em;">6а</span></td>
                                        <td><span class="label label-default" style="font-size: 1.1em;">Урок номер 1</span></td>
                                        <td>
                                            <button class="btn btn-success" type="button">
                                                Преглед
                                            </button>
                                            <button class="btn btn-info" type="button" data-toggle="modal" data-target="#addHomework">
                                                Дообавяне
                                            </button>
                                            <button class="btn btn-danger" type="button" data-toggle="modal" data-target="#delHomework" >
                                                Изтриване
                                            </button>
                                        </td>
                                    </tr>
                                    <tr class="success">
                                        <td>2</td>
                                        <td><span class="label label-default" style="font-size: 1.1em;">История</span></td>
                                        <td><span class="label label-default" style="font-size: 1.1em;">6а</span></td>
                                        <td><span class="label label-default" style="font-size: 1.1em;">Отговор на въпроси от урок номер 2</span></td>
                                        <td>
                                            <button class="btn btn-success" type="button">
                                                Преглед
                                            </button>
                                            <button class="btn btn-info" type="button">
                                                Дообавяне
                                            </button>
                                            <button class="btn btn-danger" type="button">
                                                Изтриване
                                            </button>
                                        </td>
                                    </tr>
                                    <tr class="success">
                                        <td>3</td>
                                        <td><span class="label label-default" style="font-size: 1.1em;">История</span></td>
                                        <td><span class="label label-default" style="font-size: 1.1em;">6а</span></td>
                                        <td><span class="label label-default" style="font-size: 1.1em;">Подготовка за тест</span></td>
                                        <td>
                                            <button class="btn btn-success" type="button">
                                                Преглед
                                            </button>
                                            <button class="btn btn-info" type="button">
                                                Дообавяне
                                            </button>
                                            <button class="btn btn-danger" type="button">
                                                Изтриване
                                            </button>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>


                        </div>

                        <div class="tab-pane fade well" id="remarks">

                            <div class="panel panel-info">
                                <div class="panel-heading">
                                    <h3 class="panel-title">
                                        Отсъствия
                                    </h3>
                                </div>
                                <div class="panel-body">
                                    <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                            <tr>
                                                <th></th>
                                                <th>Предмет</th>
                                                <th>Клас</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr  class="success">
                                                <td>1</td>
                                                <td>История</td>
                                                <td>6а</td>
                                                <td>
                                                    <button class="btn btn-success" type="button" data-toggle="modal" data-target="#absencesList">
                                                        Преглед
                                                    </button>
                                                    <button class="btn btn-info" type="button" data-toggle="modal" data-target="#addAbsence">
                                                        Дообавяне
                                                    </button>
                                                    <button class="btn btn-warning" type="button">
                                                        Коригиране
                                                    </button>
                                                    <button class="btn btn-danger" type="button">
                                                        Изтриване
                                                    </button>
                                                </td>
                                            </tr>
                                            <tr class="success">
                                                <td>2</td>
                                                <td>История</td>
                                                <td>6б</td>
                                                <td>
                                                    <button class="btn btn-success" type="button">
                                                        Преглед
                                                    </button>
                                                    <button class="btn btn-info" type="button">
                                                        Дообавяне
                                                    </button>
                                                    <button class="btn btn-warning" type="button">
                                                        Коригиране
                                                    </button>
                                                    <button class="btn btn-danger" type="button">
                                                        Изтриване
                                                    </button>
                                                </td>
                                            </tr>
                                            <tr class="success">
                                                <td>3</td>
                                                <td>История</td>
                                                <td>6в</td>
                                                <td>
                                                    <button class="btn btn-success" type="button">
                                                        Преглед
                                                    </button>
                                                    <button class="btn btn-info" type="button">
                                                        Дообавяне
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
                            <div class="panel panel-info">
                                <div class="panel-heading">
                                    <h3 class="panel-title">
                                        Забележки
                                    </h3>
                                </div>
                                <div class="panel-body">
                                    <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                            <tr>
                                                <th></th>
                                                <th>Предмет</th>
                                                <th>Клас</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr  class="success">
                                                <td>1</td>
                                                <td>История</td>
                                                <td>6а</td>
                                                <td>
                                                    <button class="btn btn-success" type="button">
                                                        Преглед
                                                    </button>
                                                    <button class="btn btn-info" type="button">
                                                        Дообавяне
                                                    </button>
                                                    <button class="btn btn-danger" type="button">
                                                        Изтриване
                                                    </button>
                                                </td>
                                            </tr>
                                            <tr class="success">
                                                <td>2</td>
                                                <td>История</td>
                                                <td>6б</td>
                                                <td>
                                                    <button class="btn btn-success" type="button">
                                                        Преглед
                                                    </button>
                                                    <button class="btn btn-info" type="button">
                                                        Дообавяне
                                                    </button>
                                                    <button class="btn btn-danger" type="button">
                                                        Изтриване
                                                    </button>
                                                </td>
                                            </tr>
                                            <tr class="success">
                                                <td>3</td>
                                                <td>История</td>
                                                <td>6в</td>
                                                <td>
                                                    <button class="btn btn-success" type="button">
                                                        Преглед
                                                    </button>
                                                    <button class="btn btn-info" type="button">
                                                        Дообавяне
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
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</html>
