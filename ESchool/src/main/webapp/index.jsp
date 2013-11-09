<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TEST Page</title>
    </head>
    <body>
      === ADD FORM ===
      <s:form action="addUser">
        <s:textfield key="username" label="Username" />
        <s:password key="password" label="Password" />
        <s:textfield key="userRole" label="Role" />
        <s:submit name="Добави"/>
      </s:form>
      
      === UPDATE FORM ===
      <s:form action="editUser">
        <s:push value="user">
          <s:textfield key="username" value="username" label="Username" />
          <s:password key="password" label="Password" />
          <s:textfield key="userRole" value="userRole" label="Role" />
          <s:submit name="Редактирай"/>
        </s:push>
      </s:form>

<s:if test="userList.size() > 0">
  <div class="content">
    <table class="userTable" cellpadding="5px">
      <tr class="even">
        <th>Username</th>
        <th>Password</th>
        <th>User Role</th>
        <th>Delete</th>
      </tr>
      <s:iterator value="userList" status="userStatus">
        <tr
          class="<s:if test="#userStatus.odd == true ">odd</s:if> <s:else>even</s:else>">
          <td><s:property value="username" /></td>
          <td><s:property value="password" /></td>
          <td><s:property value="userRole" /></td>
          <td>
            <s:url id="deleteURL" action="deleteUser">
              <s:param name="username" value="%{username}"></s:param>
            </s:url>
            <s:a href="%{deleteURL}">Изтрий</s:a>
          </td>
        </tr>
      </s:iterator>
    </table>
  </div>
</s:if>
    </body>
</html>
