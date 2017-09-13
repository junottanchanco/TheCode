<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Secret Code</title>
</head>
<body>
	<% if(session.getAttribute("error") != null) { %>
		<h2><%= session.getAttribute("error") %></h2>
	<% } %>
	<form action="" method="POST">
		<input type="text" name="guess" placeholder="What is the Code?">
		<input type="submit" value="Try Code">
	</form>
</body>
</html>