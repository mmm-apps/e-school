<%-- 
    Document   : LoginPanel
    Created on : Oct 31, 2013, 10:01:57 PM
    Author     : Mariyan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<head>
	<!-- General meta information -->
	<title>E-School Login Form</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta name="robots" content="index, follow" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- // General meta information -->

	<!-- Load Javascript -->
        <script type="text/javascript" src="/JS/jquery.js"></script>
	<script type="text/javascript" src="/JS/jquery.query-2.1.7.js"></script>
	<script type="text/javascript" src="/JS/rainbows.js"></script>
	<!-- // Load Javascipt -->

	<!-- Load stylesheets -->
	<link type="text/css" rel="stylesheet" href="CSS/style.css" media="screen" />
	<link type="text/css" rel="stylesheet" href="CSS/reset.css" media="screen" />
	<!-- // Load stylesheets -->
	
<script>
	$(document).ready(function(){
	$("#submit1").hover(
	function() {
	$(this).animate({"opacity": "0"}, "slow");
	},
	function() {
	$(this).animate({"opacity": "1"}, "slow");
	});
 	});
</script>
</head>

<body>
  <div id="wrapper">
          <div id="wrappertop"></div>
          <div id="wrappermiddle">
                  <h2>Login</h2>
                  <s:form action = "login">
                  <div id="username_input">
                    <div id="username_inputleft"></div>
                    <div id="username_inputmiddle">
                      <s:textfield label="Username" key="username" name="link" id="url" placeholder="Username" onclick="this.value = ''" />
                        <img id="url_user" src="images/user_icon.png" alt="">
                      </div>
                    <div id="username_inputright"></div>
                  </div>

                  <div id="password_input">
                    <div id="password_inputleft"></div>
                    <div id="password_inputmiddle">
                      <s:password label="Password" key="password" type="password" name="link" id="url" placeholder="Password" onclick="this.value = ''" />
                        <img id="url_password" src="images/passicon.png" alt="">
                    </div>
                    <div id="password_inputright"></div>
                  </div>

                  <div id="submit">
                    <s:submit src="images/submit_hover.png" id="submit1" value="Sign In" />
                    </div>
                  </s:form>
                  <div id="links_left">
                  <a href="#">Forgot your Password?</a>
                  </div>
                  <div id="links_right"><a href="#">Not a Member Yet?</a></div>
          </div>
          <div id="wrapperbottom"></div>
  </div>
</body>
</html>
