<%@page import="java.util.Arrays"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="java.util.List" %>
<%@page import="com.bugsprod.geektic.Geek" %>
<%@page import="com.bugsprod.geektic.Interest" %>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8"></meta>
<title>détails</title>
<link href="<c:url value='style.css'></c:url>" rel="stylesheet"></link>
</head>
<body>
<%@ include file="navbar.jsp" %>
<%!
public String writeTermLine(Geek geek, String line) {
	String termLine=geek.getFirstname()+"@"+geek.getName()+":~$ <div class=\"line\">";
	termLine+=line;
	termLine+="</div>";
	return termLine;
}
public String printInterest(Geek geek) {
	String interests="intérets=";
	List<Interest> lInterests = geek.getInterests();
	int nbInterest = geek.getInterests().size();
	for (int i=0; i<nbInterest; i++) {
		interests += geek.getInterests().get(i);
			if (i<nbInterest-1){
				interests += ":";
			}
	}
	return interests;
}
%>

<h1>détails de <c:out value="${geek.getFirstname()}"/> <c:out value="${geek.getName()}"/> :</h1>
<div class=term>
	<%
		Geek geek = (Geek) (request.getAttribute("geek"));
		String gender;
		if (geek.getGender()){
			gender = "geek";
		} else {
			gender = "geekette";
		}
	%>
	<%= writeTermLine(geek, "infos\n<br />sexe="+gender+"\n<br />") %>
	<div class="line">
		<%=printInterest(geek)%>
<%-- 		<c:forEach var="inter" items="${geek.getInterests()}"> --%>
<%-- 			 <c:out value="${inter}"/>: --%>
<%-- 		</c:forEach> --%>
	</div>
</div>
</body>
</html>