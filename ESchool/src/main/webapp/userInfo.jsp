<%-- 
    Document   : userInfo
    Created on : Nov 30, 2013, 9:07:43 PM
    Author     : Mariyan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
  <link type="text/css" rel="stylesheet" href="CSS/bootstrap.css" media="screen">
    <div class="modal fade" id="userInfo1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <form action = "login.action" method="post" class ="bs-example form-horizontal" >
                        <fieldset>
                            <legend>Преглед на потребител</legend>
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
                                  <td></td>
                                  <td><s:property value="username" /></td>
                                  <td><s:property value="password" /></td>
                                  <td><s:property value="rolesSet.roleName" /></td>
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
