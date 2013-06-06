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
	
	<label for="centerOfInterest">Centre d'intéret(s) : </label>
	<input list="interest" type="text" placeholder="tag1, tag2, tag3" id="centerOfInterest" name="centerOfInterest" autocomplete="off" ></input>
	<datalist id="interest"></datalist><br /><br />
	
	<label for="city">ville(s) : </label>
	<input list="cities" type="text" placeholder="Lyon" id="city" name="city" autocomplete="off" ></input>
	<datalist id="cities"></datalist><br /><br />
	
	<button type="submit">chercher</button>
</form>

<script
   type='text/javascript'
   src='autoComplete.js'>
</script>
<script type="text/javascript">

// globals
/*var rawTags = ["python", "java", "C++", "C", "C#", "TDD", "JUnit", "PHP", "html", "html5", "css", "css3"];
var inputField = document.getElementById('centerOfInterest');
var initInputFieldValue = inputField.value;
var dataList = document.getElementById('interest');
var initNbVirgules = (initInputFieldValue.match(/,/g)||[]).length;

fillDatalist("");
mainLoop();*/
var interests = ["python", "java", "C++", "C", "C#", "TDD", "JUnit", "PHP", "html", "html5", "css", "css3"];
var inputCenterOfInterest = new FillDatalist(interests, 'centerOfInterest', 'interest');

var cities = ["Lyon", "Grenoble", "Strasbourg", "Toulouse", "Paris"];
var inputCities = new FillDatalist(cities, 'city', 'cities');

</script>
</body>
</html>
