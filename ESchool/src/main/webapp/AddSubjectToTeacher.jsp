<%-- 
    Document   : AddSubjectToTeacher
    Created on : Nov 28, 2013, 5:53:34 PM
    Author     : Denev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <%@include file="adminMenu.jsp"%>         
    <div class="well well-sm" style="margin-left: 30%;margin-right: 30%; margin-top: 5%;padding: 3%">
        <s:form action = "addSubjectToTeacher" cssClass="bs-example form-horizontal">
            <fieldset>
                <legend>Добавяне на предмети за преподавател</legend>
                <s:fielderror/>
                <div class = "form-group">
                    <div class="col-lg-10">
                        <s:select headerKey="-1" headerValue="Моля Изберете преподавател" 
                                  list="teachersList" name="teacherName" cssClass="form-control" />
                    </div>
                </div>
                <div class = "form-group">
                    <div class="col-lg-10">
                        <s:select headerKey="-1" headerValue="Моля Изберете клас" 
                                  list="classList" name="className" cssClass="form-control" />
                    </div>
                </div>
                <div class = "form-group">
                    <div class="col-lg-10">
                        <s:select headerKey="-1" headerValue="Моля Изберете предмет" 
                                  list="subjectsList" name="subjectName" cssClass="form-control" />
                    </div>
                </div>
            </fieldset>
            <div class="modal-footer">
                <button onclick="location.href='teacherSubjectsList';" type="button" class="btn btn-info" style="float: left;">Назад</button>
                <s:submit cssClass="btn btn-info" value="Добави"/>
            </div>
        </s:form>
    </div>
</html>
