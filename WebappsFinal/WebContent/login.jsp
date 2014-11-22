<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success Forum</title>
</head>


<style type="text/css">
body {
	background-color: #33CCCC;
	font-family: "Verdana";
	font-size: 12px;
	color: #FFFFFF;
}

h1 {
	color: #062270;
	font-family: "Verdana";
}

p {
	font-family: "Verdana";
	font-size: 12px;
}

.button {
	border: 1px solid;
	background: #062270;
	color: #FFFFFF;
	font-family: "Verdana";
	font-size: 15px;
}

label {
	font-family: "Verdana";
	font-size: 12px;
	color: #062270;
}

input {
	font-family: "Verdana";
	font-size: 12px;
	
}

table.outerborder {
	width: 700 px;
	border: 1px  solid;
	border-width: 2px;
	border-color: black;
	border-spacing: 10px;
}

table.outerborder th, td {
	border-width: 0 px solid;
}


</style>
</head>

<body>
<form method="post" action="login.do">

<p align = "right"><input type="submit" value="New User" class="button" id ="register" name="button" /></p>
<center>
<table class = "outerborder">
<tr><td><img src = "banner.jpg" /></td></tr>
<tr align = "left"><td><br>Welcome to Success Forum!! Login to begin or click on "New User" to register a new user.<br><br></td></tr>

<tr align = "center"><td>
<jsp:include page="error-list.jsp" />
<table>
  <tr align = "left">
    <td><label>Email: </label></td>
    <td><input type="text" id="email" name="email" value="${form.email}"/></td>  
  </tr>
  <tr align = "left">
    <td><label>Password: </label></td>
    <td><input type="password" class="textbox" id = "password" name="password" value="" /></td>
  </tr>
  <tr>
    <td></td>
    <td align = "right"><input type="submit" value="Login" class="button" id = "login" name="button" /></td>
  </tr>
</table>
</td></tr>

</table>

</center>
</form>
<jsp:include page="template-bottom.jsp" />
</html>











