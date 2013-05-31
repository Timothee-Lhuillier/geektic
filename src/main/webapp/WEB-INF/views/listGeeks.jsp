<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8"></meta>
<title>geeks</title>
<link href="<c:url value='style.css'></c:url>" rel="stylesheet"></link>
</head>
<body>
<nav>
	<a href="<c:url value='/'></c:url>">recherche</a> |  <a href="<c:url value='geeks'></c:url>">résultat</a>
</nav>
<h1>geeks</h1>
<ul>
	<c:forEach var="geek" items="${geeks}">
		<li><c:out value="${geek.getFirstname()}"/> <c:out value="${geek.getName()}"/></li>
	</c:forEach>
</ul>
</body>
</html>