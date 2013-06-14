<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8"></meta>
<title>recherche</title>
<link href="<c:url value='style.css'></c:url>" rel="stylesheet"></link>
</head>
<body>
<%@ include file="navbar.jsp" %>

<h1>recherche : </h1>
<form action="searchGeeks" method="get">
	<label for="gender">je cherche : </label>
	<select name="gender" id="gender">
		<option value="false" label="une geekette">une geekette</option>
		<option value="true" label="un geek">un geek</option>
	</select><br /><br />
	
	<label for="centerOfInterest">centre d'intéret(s) : </label>
	<input list="listInterests" type="text" placeholder="tag1, tag2, tag3" id="centerOfInterest" name="centerOfInterest" autocomplete="off" ></input>
	<datalist id="listInterests"></datalist>
	<button type="button" onclick="javascript:document.getElementById('centerOfInterest').value=''" class="del">X</button><br /><br />
	
	<label for="cities">ville(s) ou chercher : </label>
	<input list="listCities" type="text" placeholder="tag1, tag2, tag3" id="cities" name="cities" autocomplete="off" ></input>
	<datalist id="listCities"></datalist>
	<button type="button" onclick="javascript:document.getElementById('cities').value=''" class="del">X</button><br /><br />
	
	<button type="submit">chercher</button>
</form>

<script
   type='text/javascript'
   src='<c:url value="autoComplete.js"></c:url>'>
</script>
<script type="text/javascript">

// globals
var interests = ${interests};
var inputCenterOfInterest = new FillDatalist(interests, 'centerOfInterest', 'listInterests');

var cities = ${cities};
var inputCities = new FillDatalist(cities, 'cities', 'listCities');

</script>
</body>
</html>
