<%@page import="java.util.Arrays"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="java.util.List" %>
<%@page import="com.bugsprod.geektic.Geek" %>
<%@page import="com.bugsprod.geektic.Interest" %>
<%@ include file="functions.jsp" %>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8"></meta>
<title>détails</title>
<link href="<c:url value='style.css'></c:url>" rel="stylesheet"></link>
</head>
<body>
<%@ include file="navbar.jsp" %>
<h1>détails de <c:out value="${geek.getFirstname()}"/> <c:out value="${geek.getName()}"/> :</h1>
<div class=term>
	<%
		Geek geek = (Geek) (request.getAttribute("geek"));
	%>
	${geek.getFirstname()}@${geek.getName()}:~$<div class="line">infos<br />
		sexe = ${geek.getGenderString()}<br />
		date de naissance = ${geek.getFrDateOfBirth()}<br />
		e-mail = ${geek.getMail()}<br />
		ville = ${geek.getCity()}<br />	
		<%=printInterest(geek)%><br />
		nb visualisation = ${geek.getNbViews()}
	</div>
</div>
</body>
</html>