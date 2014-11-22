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
<input type="submit" value="Logout" class="button" id = "logout" name="button" /></p>
<center>

<table class = "outerborder">
<tr><td><img src = "banner.jpg" /></td></tr>
<tr align = "left"><td class = "outerborder" width = "700 px"><br>Welcome to Success Forum! Here, you can exchange questions and answers for interview questions. 
Have a question? Submit it, and wait for others to respond with the solution! The solution with the highest votes will be listed 
first -- users decide on the best solution. Think you have a great solution to a problem? Click on the title of a question 
to submit your solution and see if other users like it!<br></td></tr>
<tr align = "left"><td>
<h3>Select Question Type</h3>
<table width = "700 px"><tr>
<td><input type="radio" name="sort" value="mostrecent" checked> Most Recent</td>
<td><input type="radio" name="sort" value="mostanswers"> Most Answers</td>
<td><input type="radio" name="sort" value="highestranked"> Highest Ranked</td>
</tr></table>

<table width = "700 px"><tr>
<td>Company
<select name="company">
<option value="google">Google</option>
<option value="microsoft">Microsoft</option>
<option value="amazon">Amazon</option>
</select></td>
<td>Category
<select name="category">
<option value="linkedlists">Linked Lists</option>
<option value="heaps">Heaps</option>
<option value="arrays">Arrays</option>
</select></td>
<td>Language
<select name="language">
<option value="java">Java</option>
<option value="c++">C++</option>
<option value="Perl">Perl</option>
</select></td>
</tr></table>

</td></tr>
<tr align = "right"><td>
<input type="submit" value="Submit a New Question" class="button" id = "submitanewquestion" name="button" />
<input type="submit" value="Go" class="button" id = "go" name="button" />
</td></tr>

<tr align = "left"><td><h3>Questions</h3>

<table class = "questions">
<tr><td  class = "questions" width = "535 px"><a href = ""><u>Bubble Sort (Title)</u></a>
<br>Company: Google<br>Category: Sorting Algorithms <br>Language: Java<br><br>
Write a method to implement Bubble Sort on an array in Java.</td>
<td class = "questions" width = "150 px"> BobSmith <br>10/17/2011<br>34 votes </td></tr>
</table><br>


<table class = "questions">
<tr><td  class = "questions" width = "535 px"><a href = ""><u>Bubble Sort (Title)</u></a>
<br>Company: Google<br>Category: Sorting Algorithms <br>Language: Java<br><br>
Write a method to implement Bubble Sort on an array in Java.</td>
<td class = "questions" width = "150 px"> BobSmith <br>10/17/2011<br>34 votes </td></tr>
</table><br>



</td></tr>
</table>

</center>
</html>





