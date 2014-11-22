<html>
<head>
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="pragma" content="no-cache">
	<title>Bookmark Sharing Website</title>
	<style>
		.menu-head {font-size: 10pt; font-weight: bold; color: black; }
		.menu-item {font-size: 10pt;  color: black }
    </style>
</head>

<body>
<%@ page import="databeans.User" %>

<table cellpadding="4" cellspacing="0">
    <tr>

<%
	if (request.getAttribute("title") == null) {
%>
		        <font size="7">Bookmark Sharing Website</font>
<%
    } else {
%>
		        <font size="5"><%=request.getAttribute("title")%></font>
<%
    }
%>
			</p>
		</td>
    </tr>
	
	<!-- Spacer row -->
	<tr>
		<td style="font-size:5px">&nbsp;</td>
		<td colspan="2" style="font-size:5px">&nbsp;</td>
	</tr>
	
	<tr>
		<td valign="top" height="500">
			<!-- Navigation bar is one table cell down the left side -->
            <p align="left">
<%
    User user = (User) session.getAttribute("user");
	if (user != null) {
%>
				
				<span class="menu-item"><a id="mybookmarks" href="manage.do">Manage Your Bookmarks</a></span><br/>
				<span class="menu-item"><a id="logout" href="logout.do">Logout</a></span><br/>
        <span class="menu-item"><a id="allbookmarks" href="allbookmarks.do">All Bookmarks</a></span><br/>
        <span class="menu-item"><a id="top10bookmarks" href="top10bookmarks.do">Top 10 Bookmarks</a></span><br/>
<%
		
    }
%>
			</p>
		</td>
		
		<td>
			<!-- Padding (blank space) between navbar and content -->
		</td>
		<td  valign="top">
