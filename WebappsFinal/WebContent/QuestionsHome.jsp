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

<p align = "right">
<form method="post" action="logout.do">
<input type="submit" value="Logout" class="button" id = "logout" name="button" /></p>
</form>
<center>


<table class = "outerborder">

<tr><td><img src = "banner.jpg" /></td></tr>

<tr align = "left">
<td class = "outerborder" width = "700 px"><br>Welcome to Success Forum! Here, you can exchange questions and answers for interview questions. 
Have a question? Submit it, and 
wait for others to respond with the solution! The solution with the highest votes will be listed 
first -- users decide on the best solution. Think you have a great solution to a problem? Click on the title of a question 
to submit your solution and see if other users like it!<br></td></tr>
<tr align = "left"><td>
<h3>Select Question Type</h3>
<form method="post" action="questionhome.do">
<table width = "700 px"><tr>
<td><input type="radio" name="sort" value="mostrecent" checked> Most Recent</td>
<td><input type="radio" name="sort" value="mostanswers"> Most Answers</td>
<td><input type="radio" name="sort" value="highestranked"> Highest Ranked</td>
</tr></table>
</form>
<form method="post" action="questionhome.do">
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
</form>

</td></tr>

<tr align = "right"><td>
<form method="post" action="addquestion.do">
<input type="submit" value="Submit a New Question" class="button" id = "submitanewquestion" name="button" />
</form>
<form method="post" action="questionhome.do">
<input type="submit" value="Go" class="button" id = "go" name="button" />
</form>
</td></tr>


<tr align = "left"><td><h3>Questions</h3>
<%@ page import="databeans.Question" %>
<%
        Question[] questions = (Question[])request.getAttribute("questionList");
        for (int i=0; i<questions.length; i++) {
%>
 
<table class = "questions">
<tr><td  class = "questions" width = "535 px"><a href="question.do?id=<%questions[i].getId();%>"><u><% questions[i].getTitle(); %></u></a>
<br>Company: <% questions[i].getCompany(); %><br>Category: <% questions[i].getCatagory(); %> <br>Language: <% questions[i].getLanguage(); %><br><br>
<% questions[i].getContent(); %></td>
<td class = "questions" width = "150 px"> <% questions[i].getOwner(); %> <br><% questions[i].getDate(); %><br><% questions[i].getClicks(); %> votes </td></tr>
</table><br>

<%
		}
%>

</td></tr>
</table>

</center>

</html>





