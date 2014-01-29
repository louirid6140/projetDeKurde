<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Menu Utilisateur</title>
<link type="text/css" rel="stylesheet"
	href="<c:url 
	value="/inc/style.css"/>" />
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="menu">
	<p>
		<a href="<c:url value="ajouterProjet.jsp"/>">Ajouter projet</a>
	</p>
	<p>
		<a href="<c:url value="modificationCaractProjet.jsp"/>">Modifier caractéristiques projet</a>
	</p>
	<p>
		<a href="<c:url value="/etc.jsp"/>">etc</a>
	</p>
</div>
</body>
</html>