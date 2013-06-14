<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="functions.jsp" %>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8"></meta>
<title>geeks</title>
<link href="<c:url value='style.css'></c:url>" rel="stylesheet"></link>
</head>
<body>
<%@ include file="navbar.jsp" %>

<h1>
	<%=request.getAttribute("gender")!=null?request.getAttribute("gender").toString().equals("true")?"geeks":"geekettes":"geek(ette)s" %>
</h1>
<ul>
	<c:forEach var="geek" items="${geeks}">
		<li>
		<%
			Geek geek = (Geek) (pageContext.getAttribute("geek"));
			String cities = (String) request.getAttribute("cities");
		%>
		<%=request.getAttribute("gender")==null?geek.getGenderString()+" : ":"" %>
		<a href="detailsGeek?id=${geek.getId()}"><c:out value="${geek.getFirstname()}"/> <c:out value="${geek.getName()}"/>,
		ville = ${geek.getCity()},
		<%=printInterest(geek)%>
		</a></li>
	</c:forEach>
</ul>
</body>
</html>