<%-- 
    Document   : StudentHome
    Created on : Nov 11, 2013, 2:40:52 PM
    Author     : MMihov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="EditStudentProfile.jsp"/>
    <div id="userWelcome">
        <div class="well">
            <h3>Здравейте, Иван Георгиев Иванов, 7а клас </h3>
        </div>
    </div>
    <div id="StudentMenu">
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
                                        <h3 class="panel-title">Клас: 7а</h3>
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
                                <button  type="submit" class="btn btn-info" style="margin-left: 40%;" data-toggle="modal" data-target="#EditStudentProfile">Промени данните</button>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="marks">

                            <table class="table table-striped table-bordered table-hover" style="margin-top: 50px;">
                                <thead>
                                    <tr>
                                        <th></th>
                                        <th>Предмет</th>
                                        <th>Първа оценка</th>
                                        <th>Втора оценка</th>
                                        <th>Трета оценка</th>
                                        <th>Четвърта оценка</th>
                                        <th>Пета оценка</th>
                                        <th>Шеста оценка</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td><span class="label label-default" style="font-size: 1.1em;">Физика</span></td>
                                        <td><span class="label label-success" style="font-size: 1.1em;">Отличен 6</span></td>
                                        <td><span class="label label-primary" style="font-size: 1.1em;">Мн.добър 5</span></td>
                                        <td><span class="label label-info" style="font-size: 1.1em;">Добър 4</span></td>
                                        <td><span class="label label-warning" style="font-size: 1.1em;">Среден 3</span></td>
                                        <td><span class="label label-danger" style="font-size: 1.1em;">Слаб 2</span></td>
                                        <td><span class="label label-primary" style="font-size: 1.1em;">Мн.добър 5</span></td>

                                    </tr>
                                    <tr>
                                        <td>2</td>
                                        <td><span class="label label-default" style="font-size: 1.1em;">Математика</span></td>
                                        <td><span class="label label-success" style="font-size: 1.1em;">Отличен 6</span></td>
                                        <td><span class="label label-primary" style="font-size: 1.1em;">Мн.добър 5</span></td>
                                        <td><span class="label label-success" style="font-size: 1.1em;">Отличен 6</span></td>
                                        <td><span class="label label-primary" style="font-size: 1.1em;">Мн.добър 5</span></td>                                                                   <td><span class="label label-success" style="font-size: 1.1em;">Отличен 6</span></td>
                                        <td><span class="label label-primary" style="font-size: 1.1em;">Мн.добър 5</span></td>

                                    </tr>
                                    <tr>
                                        <td>3</td>
                                        <td><span class="label label-default" style="font-size: 1.1em;">Спорт</span></td>
                                        <td><span class="label label-success" style="font-size: 1.1em;">Отличен 6</span></td>
                                        <td><span class="label label-success" style="font-size: 1.1em;">Отличен 6</span></td>
                                        <td><span class="label label-success" style="font-size: 1.1em;">Отличен 6</span></td>
                                        <td><span class="label label-success" style="font-size: 1.1em;">Отличен 6</span></td>
                                        <td><span class="label label-success" style="font-size: 1.1em;">Отличен 6</span></td>
                                        <td><span class="label label-success" style="font-size: 1.1em;">Отличен 6</span></td>
                                    </tr>
                                    <tr >
                                        <td>4</td>
                                        <td><span class="label label-default" style="font-size: 1.1em;">Рисуване</span></td>
                                        <td><span class="label label-success" style="font-size: 1.1em;">Отличен 6</span></td>
                                        <td><span class="label label-success" style="font-size: 1.1em;">Отличен 6</span></td>
                                        <td><span class="label label-success" style="font-size: 1.1em;">Отличен 6</span></td>
                                        <td><span class="label label-success" style="font-size: 1.1em;">Отличен 6</span></td>
                                        <td><span class="label label-success" style="font-size: 1.1em;">Отличен 6</span></td>
                                        <td><span class="label label-success" style="font-size: 1.1em;">Отличен 6</span></td>
                                    </tr>
                                    <tr class="danger">
                                        <td>5</td>
                                        <td><span class="label label-default" style="font-size: 1.1em;">Музика</span></td>
                                        <td><span class="label label-success" style="font-size: 1.1em;">Отличен 6</span></td>
                                        <td><span class="label label-success" style="font-size: 1.1em;">Отличен 6</span></td>
                                        <td><span class="label label-success" style="font-size: 1.1em;">Отличен 6</span></td>
                                        <td><span class="label label-success" style="font-size: 1.1em;">Отличен 6</span></td>
                                        <td><span class="label label-success" style="font-size: 1.1em;">Отличен 6</span></td>
                                        <td><span class="label label-success" style="font-size: 1.1em;">Отличен 6</span></td>
                                    </tr>
                                    <tr class="warning">
                                        <td>6</td>
                                        <td><span class="label label-default" style="font-size: 1.1em;">Труд и техника</span></td>
                                        <td><span class="label label-success" style="font-size: 1.1em;">Отличен 6</span></td>
                                        <td><span class="label label-success" style="font-size: 1.1em;">Отличен 6</span></td>
                                        <td><span class="label label-success" style="font-size: 1.1em;">Отличен 6</span></td>
                                        <td><span class="label label-success" style="font-size: 1.1em;">Отличен 6</span></td>
                                        <td><span class="label label-success" style="font-size: 1.1em;">Отличен 6</span></td>
                                        <td><span class="label label-success" style="font-size: 1.1em;">Отличен 6</span></td>
                                    </tr>
                                    <tr class="active">
                                        <td>7</td>
                                        <td><span class="label label-default" style="font-size: 1.1em;">Български език</span></td>
                                        <td><span class="label label-success" style="font-size: 1.1em;">Отличен 6</span></td>
                                        <td><span class="label label-success" style="font-size: 1.1em;">Отличен 6</span></td>
                                        <td><span class="label label-primary" style="font-size: 1.1em;">Мн.добър 5</span></td>   
                                        <td><span class="label label-success" style="font-size: 1.1em;">Отличен 6</span></td>
                                        <td><span class="label label-info" style="font-size: 1.1em;">Добър 4</span></td>
                                        <td><span class="label label-success" style="font-size: 1.1em;">Отличен 6</span></td>
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
                                        <th>Домашна работа</th>
                                        <th>Крайна дата</th>
                                        <th>Изпълнено в срок</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr  class="success">
                                        <td>1</td>
                                        <td>Математика</td>
                                        <td>стр 37, зад.5 до 17</td>
                                        <td>14.11.2013г</td>
                                        <td>Да</td>
                                    </tr>
                                    <tr class="danger">
                                        <td>2</td>
                                        <td>Български език</td>
                                        <td>Есе на тема"Тумбака като част от нашето общество"</td>
                                        <td>15.11.2013г</td>
                                        <td>Не</td>
                                    </tr>
                                    <tr class="danger">
                                        <td>3</td>
                                        <td>Музика</td>
                                        <td>ДА се научи "Тих бял Дунав"</td>
                                        <td>12.11.2013г</td>
                                        <td>Не</td>
                                    </tr>
                                    <tr class="danger">
                                        <td>4</td>
                                        <td>Физика</td>
                                        <td>Урок №20</td>
                                        <td>12.11.2013г</td>
                                        <td>Не</td>
                                    </tr>
                                    <tr class="danger">
                                        <td>5</td>
                                        <td>История</td>
                                        <td>Урок №22</td>
                                        <td>12.11.2013г</td>
                                        <td>Не</td>
                                    </tr>
                                    <tr class="danger">
                                        <td>6</td>
                                        <td>Химия</td>
                                        <td>Урок №17</td>
                                        <td>12.11.2013г</td>
                                        <td>Не</td>
                                    </tr>
                                </tbody>
                            </table>


                        </div>

                        <div class="tab-pane fade well" id="remarks">
                            <div class="well">
                                <div id="StudentRemarks">

                                    <div class="well">

                                        <div class="alert alert-dismissable alert-danger">
                                            <button type="button" class="close" data-dismiss="alert">×</button>
                                            <strong>Забележка по Музика</strong> Пее в час по Музика!
                                        </div>
                                        <div class="alert alert-dismissable alert-danger">
                                            <button type="button" class="close" data-dismiss="alert">×</button>
                                            <strong>Забележка по Математика</strong> Говори в час!
                                        </div>
                                        <div class="alert alert-dismissable alert-success">
                                            <button type="button" class="close" data-dismiss="alert">×</button>
                                            <strong>Забележка по Физика</strong> Взима дейно участие!
                                        </div>

                                    </div>

                                </div>
                                <div class="panel panel-success">
                                    <div class="panel-heading">
                                        <h3 class="panel-title">Извинени отсъствия</h3>
                                    </div>
                                    <div class="panel-body">
                                        57
                                    </div>
                                </div>

                                <div class="panel panel-danger">
                                    <div class="panel-heading">
                                        <h3 class="panel-title">Неизвинени отсъствия</h3>
                                    </div>
                                    <div class="panel-body">
                                        3
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</html>
