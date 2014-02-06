<%-- 
    Document   : Marks
    Created on : Nov 29, 2013, 6:54:13 PM
    Author     : Denev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
  <script src="JS/paging.js"></script>
  <%@include file="MainAdmin.jsp"%>
  <script src="JS/validation.js"></script>
  <div id="userWelcome">
    <div class="well">
      <h3>Здравейте, <s:property value="%{#session.user.username}"/></h3>
    </div>
  </div>
  <div id="spacee" style="margin-top: 80px;"></div>
  <div class="panel panel-info">

    <div class="panel-heading">
      <h3 class="panel-title">
        Списък с оценки на <s:property value="student.userInfo.firstName" /> <s:property value="student.userInfo.lastName" />
      </h3>
    </div>

    <s:set var="studentVar" value="student" />
    <div class="panel-body">    
      <s:iterator var="subjectVar" value="student.subjectsSet" status="studentStatus">
        <div class="panel panel-info markInfo">
          <div id ="subject">
            <img class="get-info" style="cursor:pointer;" src="Images/arrow_down.png"/>
            <span><s:hidden name="sid" value="#subjectVar.id" /></span>
            <span class="get-info" style="cursor:pointer; width: 30%;"><s:property value="#subjectVar.subjectName" /></span> 
            <button class="btn btn-info newMark" type="button" data-toggle="modal" data-id="<s:property value="#subjectVar.id"/>" style="float:right;">Добави оценка</button>          
          </div>

          <div class="subjectMarks" style="display:none;">
            <table id="results" class="table table-striped table-bordered table-hover">
              <thead>
                <tr>
                  <th>Оценкa</th>
                  <th>От дата</th>
                  <th></th>
                </tr>
              </thead>
              <tbody>
                <s:iterator value="#studentVar.marksSet" status="markStatus">
                  <s:if test="#studentVar.id == studentId.id && #subjectVar.id == subjectId.id">
                    <tr class="success">
                      <td><s:property value="mark" /></td>
                      <td><s:property value="dateCreated" /></td>
                      <td>
                        <s:url id="delMark" action="delMark">
                          <s:param name="markIdParam" value="id"></s:param>
                          <s:param name="studentIdParam" value="#studentVar.id"></s:param>
                        </s:url>
                        <s:a href="%{delMark}">
                          <button class="btn btn-danger" type="button">Изтрий</button>
                        </s:a>
                      </td>
                    </tr>
                  </s:if>
                </s:iterator>
              </tbody>
            </table>
          </div>
        </div>

      </s:iterator>
      <div id="pageNavPosition" style="margin-left: 44%;"></div>
    </div>

    <div class="modal fade" id="addMark" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-body">
            <s:form action = "addMark" cssClass="bs-example form-horizontal" onsubmit="return validateAddMark(this)">
              <fieldset>
                <legend>Добавяне на Оценка</legend>
                <s:fielderror/>
                <div id="loginError"></div>
                <s:hidden name="subjectIdParam" cssClass="hiddenVal"/>
                <s:hidden name="studentIdParam" value="%{#studentVar.id}"/>
                <div class = "form-group">
                  <div class="col-lg-10">
                    <s:select headerKey="-1" headerValue="Моля Изберете оценка" 
                              list="marksList" name="markVal" cssClass="form-control" />
                  </div>
                </div>
                <div class = "form-group">
                  <div  class="col-lg-10">
                    <s:textfield  key="date" type="date" id="datepicker" cssClass="form-control"/>
                  </div>
                </div>
              </fieldset>
              <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Назад</button>
                <s:submit cssClass="btn btn-info" value="Добави"/>
              </div>
            </s:form>
          </div>
        </div>
      </div>
    </div>

  </div>
  <script type="text/javascript">
    $(document).ready(function() {
      isClicked = false;
      $(".newMark").click(function() { // Click to only happen on announce links
        $("#sid").val($(this).data('id'));
        $('#addMark').find('.hiddenVal').val($(this).data('id'));
        $('#addMark').modal('show');
      });
      $('.get-info').click(function() {
        $(this).parents('.markInfo').find('.subjectMarks').toggle('slow');

        if (isClicked) {
          $(this).parents('.markInfo').find('img').attr('src', 'Images/arrow_down.png');
          isClicked = false;
        }
        else {
          $(this).parents('.markInfo').find('img').attr('src', 'Images/arrow_top.png');
          isClicked = true;
        }
      });
    });

    var pager = new Pager('results', 3);
    pager.init();
    pager.showPageNav('pager', 'pageNavPosition');
    pager.showPage(1);
  </script>
</html>
