<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8"></meta>
<title>spectacles</title>
</head>
<body>
<h1>geeks</h1>
<ul>
	<c:forEach var="geek" items="${geeks}">
		<li><c:out value="${geek.firstname}"/> <c:out value="${geek.name}"/></li>
	</c:forEach>
</ul>
</body>
</html>