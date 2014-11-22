<div id="errors">
<%
    java.util.List<String> errors = (java.util.List) request.getAttribute("errors");
	if (errors != null && errors.size() > 0) { %>
		<font face ="Verdana" size="2" color = "#000000">
		<%
		for (String error : errors) {
			out.println(error+"<br/>");
		}
		out.println("</p>");
	}
%>
</font>
</div>
