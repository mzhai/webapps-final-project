<jsp:include page="template-top.jsp" />

<%@ page import="databeans.Bookmark" %>
<p>
	<table>
<%
    for (Bookmark bookmark : (Bookmark[])request.getAttribute("bookmarkList")) {
%>
    <div id= <%=bookmark.getId()%>>
    <tr>
			<td><a href="redirect.do?id=<%=bookmark.getId()%>"><%=bookmark.getUrl()%></a></td>
		</tr>
	 <tr>
		<td class = "comment" >Comment: <%=bookmark.getComment()%></td>
	 </tr>
	 <tr>
		<td class = "owner" >Owner: <%=bookmark.getOwner()%></td>
		<td class = "clicks">Clicks: <%=bookmark.getClicks()%></td>
	 </tr>
	 </div>
<%
		}
%>
	</table>
</p>

<jsp:include page="template-bottom.jsp" />
