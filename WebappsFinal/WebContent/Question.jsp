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

h3 {
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
	word-break: break-word;
}

th.outerborder, td.outerborder {
	border-width: 0 px solid;
	word-break: break-word;
}

table.questions {
	table-layout: fixed;
	width: 700 px;
	border: .5px  solid;
	border-width: 1px;
	border-color: black;
	border-spacing: 0px;
	word-break: break-word;

}
tr.questions, td.questions {
	table-layout: fixed;
	width: 700 px;
	border: .5px  solid;
	border-width: 1px;
	border-color: black;
	border-spacing: 0px;
	word-break: break-word;
	padding: 5px;
	vertical-align: top;
}

</style>
</head>

<body>
<p align = "right">
<input type="submit" value="Home" class="button" id = "home" name="button" />
<input type="submit" value="Logout" class="button" id = "logout" name="button" /></p>
<center>

<table class = "outerborder">
<tr><td><img src = "banner.jpg" /></td></tr>
<tr align = "left"><td class = "outerborder" width = "700 px"><br>Here, you can vote on the question if you like. You can also vote 
on the answers you like. If you think you have a better answer, click on the button to submit an answer!<br></td></tr>


<tr align = "left"><td><h3>Question</h3>
<table class = "questions">
<tr><td  class = "questions" width = "535 px"><font color= "#062270">Bubble Sort (Title)</font>
<br>Company: Google<br>Category: Sorting Algorithms <br>Language: Java<br><br>
Write a method to implement Bubble Sort on an array in Java.</td>
<td class = "questions" width = "150 px"> NewUser123 <br>10/17/2011<br>234 votes <br>24 answers<br><br>
<input type="submit" value="Submit an Answer" class="button" id = "submitananswer" name="button" /><br><br>
<input type="submit" value="Vote" class="button" id = "vote" name="button" /></td></tr>
</table><br>
</td></tr>


<tr align = "left"><td><h3>Answers</h3>
<table class = "questions">
<tr><td  class = "questions" width = "535 px"><font color= "#062270">Bubble Sort Implementation</font>
<br>public void bubbleSort(int[] array{<br>...<br>...<br>}</td>
<td class = "questions" width = "150 px"> NewUser123 <br>10/17/2011<br>234 votes <br>24 answers<br><br>
<input type="submit" value="Vote" class="button" id = "vote" name="button" />
</td></tr>
</table>
</td></tr>



</table>

</center>
</html>





