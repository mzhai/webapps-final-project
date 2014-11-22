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
A:link, A:visited, A:active, A:hover {
	font-family: "Verdana";
	font-size: 12px;
	color: #062270;
	text-decoration: underline;
}



</style>
</head>

<body>
<form method="post" action="questionhome.do">
<p align = "right">
<input type="submit" value="Home" class="button" id = "home" name="button" />
</form>
<form method="post" action="logout.do">
<p align = "right">
<input type="submit" value="Logout" class="button" id = "logout" name="button" /></p>
</form>
<center>

<table class = "outerborder">
<tr><td><img src = "banner.jpg" /></td></tr>
<tr align = "left"><td class = "outerborder" width = "700 px"><br>Have a question you want answered? Submit your own question 
and have it answered by other users! Choose the correct categories so your question can be easily found!<br></td></tr>
<tr align = "left"><td>
<h3>Select Question Type</h3>
<form method="post" action="addQuestion.do">
<table width = "700 px"><tr>
<td>Company
<select name="company">
<option value="google">Google</option>
<option value="microsoft">Microsoft</option>
<option value="amazon">Amazon</option>
<option value="cisco">Cisco</option>
<option value="qualcomm">Qualcomm</option>
<option value="palantir">Palantir</option>
<option value="citigroup">Citi Group</option>
<option value="ibm">IBM</option>
<option value="schlumberger">Schlumberger</option>
<option value="jpmorgan">JPMorgan</option>
<option value="deloitte">Deloitte</option>
<option value="intel">Intel</option>
<option value="accenture">Accenture</option>
<option value="goldmansachs">Goldman Sachs</option>
<option value="northropgrumman">Northrop Grumman</option>
<option value="boeing">Boeing</option>
<option value="lockheedmartin">Lockheed Martin</option>
<option value="boozallenhamilton">Booz Allen Hamilton</option>
<option value="citadel">Citadel</option>
<option value="other">other</option>
</select></td>
<td>Category
<select name="category">
<option value="linkedlists">Linked Lists</option>
<option value="heaps">Heaps</option>
<option value="math">Math</option>
<option value="bitmanipulation">Bit Manipulation</option>
<option value="operatingsystems">Operating Systems</option>
<option value="hardware">Hardware</option>
<option value="arrays">Arrays</option>
<option value="trees">Trees</option>
<option value="stacksandqueques">Stacks and Queques</option>
<option value="heaps">Heaps</option>
<option value="dynamicprogramming">Dynamic Programming</option>
<option value="concurrency">Concurrency</option>
<option value="graphs">Graphs</option>
<option value="sorting">Sorting</option>
<option value="webtechnologies">Web Technologies</option>
<option value="databases">Databases</option>
<option value="behavioral">Behavioral</option>
<option value="other">Other</option>
</select></td>
<td>Language
<select name="language">
<option value="java">Java</option>
<option value="c++">C++</option>
<option value="Perl">Perl</option>
<option value="c">C</option>
<option value=".net">.NET</option>
<option value="c#">C#</option>
<option value="ruby">Ruby</option>
<option value="python">Python</option>
<option value="ml">ML</option>
<option value="assembly">Assembly</option>
<option value="sql">SQL</option>
<option value="other">Other</option>
</select></td>
</tr></table>

</td></tr>

<tr align = "left"><td><h3>Submit a Question</h3>
<textarea cols = "85" rows = "10">Enter in your question here.</textarea>
</td></tr>

<tr align = "right"><td><input type="submit" value="Submit" class="button" id = "submit" name="button" /></td></tr>

</table>
</form>
</center>
</html>





