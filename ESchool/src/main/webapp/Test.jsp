<%-- 
    Document   : Test
    Created on : Nov 9, 2013, 4:32:46 PM
    Author     : MMihov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="CSS/bootstrap.css" media="screen">
        <link type="text/css" rel="stylesheet" href="CSS/reset_1.css" media="screen">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="Menu">
            <div class="navbar navbar-inverse navbar-fixed-top">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-inverse-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Начало</a>
                </div>
                <div class="navbar-collapse collapse navbar-inverse-collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">Active</a></li>
                        <li><a href="#">Link</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                                <li class="divider"></li>
                                <li class="dropdown-header">Dropdown header</li>
                                <li><a href="#">Separated link</a></li>
                                <li><a href="#">One more separated link</a></li>
                            </ul>
                        </li>
                    </ul>
                    <form class="navbar-form navbar-left">
                        <input type="text" class="form-control col-lg-8" placeholder="Search">
                    </form>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#">Вход</a></li>
                        <li><a href="#">Регистрация</a></li>
                    </ul>
                </div><!-- /.nav-collapse -->
            </div>
        </div>
        <div id="board">
            <div id="space" style="height: 35px;border-style:solid;border-width:5px;border-top: none;border-left: none;border-right: none;border-color: #044687"><span style="color: white">Някакъв текст</span></div>
            <div id="content" style="height: 100%;">
                <div id="innerContent">
                    <div class="col-lg-6" style="width: 70%;">
                        <div class="well">
                            <form class="bs-example form-horizontal">
                                <fieldset>
                                    <legend>Регистрация</legend>
                                    <div class="form-group">
                                        <label for="inputEmail" class="col-lg-2 control-label">Email</label>
                                        <div class="col-lg-10">
                                            <input type="text" class="form-control" id="inputEmail" placeholder="Email">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputPassword" class="col-lg-2 control-label">Password</label>
                                        <div class="col-lg-10">
                                            <input type="password" class="form-control" id="inputPassword" placeholder="Password">
                                            <div class="checkbox">
                                                <label>
                                                    <input type="checkbox"> Checkbox
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="textArea" class="col-lg-2 control-label">Textarea</label>
                                        <div class="col-lg-10">
                                            <textarea class="form-control" rows="3" id="textArea"></textarea>
                                            <span class="help-block">A longer block of help text that breaks onto a new line and may extend beyond one line.</span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-2 control-label">Radios</label>
                                        <div class="col-lg-10">
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked="">
                                                    Option one is this
                                                </label>
                                            </div>
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
                                                    Option two can be something else
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="select" class="col-lg-2 control-label">Selects</label>
                                        <div class="col-lg-10">
                                            <select class="form-control" id="select">
                                                <option>1</option>
                                                <option>2</option>
                                                <option>3</option>
                                                <option>4</option>
                                                <option>5</option>
                                            </select>
                                            <br>
                                            <select multiple="" class="form-control">
                                                <option>1</option>
                                                <option>2</option>
                                                <option>3</option>
                                                <option>4</option>
                                                <option>5</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-lg-10 col-lg-offset-2">
                                            <button class="btn btn-default">Cancel</button> 
                                            <button type="submit" class="btn btn-primary">Submit</button> 
                                        </div>
                                    </div>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>

            </div>
            <div id="Content" style="float:left; clear: left;margin-top:300px;">
                <div class="well">
                    <h1>Някакъв текст</h1>
                    <p>Още мнооооооо оооооооооооооооооо ооооооооооооооо ооооооо ооооооооо оооооооооооооооооо оооооооооооооооооо ооооо оооооооооооооо ooooooooooooooo ooooooooooo oooooooo ooooooo oooooo  ооо оооооооо ооооо оооооооо ооооооооо ооооооо ооооооооооооооооо ооооооо ооооооооо ооооооооооооооооо ооооооооооо оооооооо ооооооооооооооооооо ooooooooooooooo ooooooooooo oooooooo ooooooo oooooo  ооо оооооооо ооооооооооооо оооооооооооооо ооооооооооо оооооооо ооооооо оооооо ооооооооооооооо ооооооооооооо ооооооооооо ооооооо оооооооооооо ooooooo oooooooo ooooo oooooo oooooooo ooooooo oooooo  ооо оооооооо оооооого текст</p>
                    <p><a class="btn btn-primary btn-lg">Learn more</a></p>
                </div>  
            </div>
            <div id="Content" style="clear: left;padding-top:300px;">

                <div class="well">
                    <h1>Успех по предметите изучавани от Тумбак Тумбаков</h1>
                    <p>Ученик от: класа на Тумбаците.</p>
                    <p>Класен ръководител: г-н Тумбака</p>
                    <p></p>
                    <p><a class="btn btn-primary btn-lg">Виж пълен профил</a></p>
                </div>  



                <table class="table table-striped table-bordered table-hover">
                    <thead>
                        <tr class="success">
                            <th>#</th>
                            <th>Предмет</th>
                            <th>Column heading</th>
                            <th>Column heading</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr class="warning">
                            <td>1</td>
                            <td>История</td>
                            <td>(отличен) 6</td>
                            <td>(среден) 3</td>
                        </tr>
                        <tr class="warning">
                            <td>2</td>
                            <td>Физика</td>
                            <td>(отличен) 6</td>
                            <td>(отличен) 6</td>
                        </tr>
                        <tr class="warning">
                            <td>3</td>
                            <td>Химия</td>
                            <td>(слаб) 2</td>
                            <td>(среден) 3</td>
                        </tr>
                        <tr class="warning">
                            <td>4</td>
                            <td>Спорт</td>
                            <td>(отличен) 6</td>
                            <td>(отличен) 6</td>
                        </tr>
                        <tr class="warning">
                            <td>5</td>
                            <td>Рисуване</td>
                            <td>(отличен) 6</td>
                            <td>(отличен) 6</td>
                        </tr>
                        <tr class="warning">
                            <td>6</td>
                            <td>Column content</td>
                            <td>Column content</td>
                            <td>Column content</td>
                        </tr>
                        <tr class="active">
                            <td>7</td>
                            <td>Column content</td>
                            <td>Column content</td>
                            <td>Column content</td>
                        </tr>
                    </tbody>
                </table>

            </div>
            <div id="Content" style="clear: left;padding-top:300px;"></div>
        </div>


    </body>
</html>
