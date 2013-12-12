<%-- 
    Document   : StudentHome
    Created on : Nov 11, 2013, 2:40:52 PM
    Author     : MMihov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
  <s:include value="EditStudentProfile.jsp"></s:include>
    <div id="userWelcome">
      <div class="well">
        <h3>Здравейте, <s:label key="studentName" />, <s:label key="clas" /> клас </h3>
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
                    <h3 class="panel-title"><s:label key="fullName" /></h3>
                  </div>
                </div>
                <div class="panel panel-success">
                  <div class="panel-heading">
                    <h3 class="panel-title">Клас: <s:label key="clas" /></h3>
                  </div>
                </div>
                <div class="panel panel-success">
                  <div class="panel-heading">
                    <h3 class="panel-title"><s:label key="telephone" /></h3>
                  </div>
                </div>
                <div class="panel panel-success">
                  <div class="panel-heading">
                    <h3 class="panel-title"><s:label key="email" /></h3>
                  </div>
                </div>
                <div class="panel panel-success">
                  <div class="panel-heading">
                    <h3 class="panel-title"><s:label key="adress" /></h3>
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
                  </tr>
                </thead>
                <tbody>
                  <s:iterator value="homeworks" var="currentHomework">
                    <tr  class="success">
                      <td><s:property value="id" /></td>
                      <td><s:property value="subject" /></td>
                      <td><s:property value="homeworkTitle" /></td>
                      <td><s:property value="date" /></td>
                    </tr>
                  </s:iterator>
                </tbody>
              </table>


            </div>

            <div class="tab-pane fade" id="remarks">
              <div class="well">
                <div id="StudentRemarks">
                  <div class="panel panel-info" >
                    <div class="panel-heading">
                      <h3 class="panel-title">Отсъствия</h3>
                    </div>
                    <div class="panel panel-success" style="width: 50%;float:left;">
                      <div class="panel-heading">
                        <h3 class="panel-title">Извинени отсъствия : 57</h3>
                      </div>
                    </div>
                    <div class="panel panel-danger" style="width: 50%;float:left;">
                      <div class="panel-heading">
                        <h3 class="panel-title">Неизвинени отсъствия: 3</h3>
                      </div>
                    </div>
                  </div>
                  <div class="well" style="margin-top: 85px;">
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
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</html>
