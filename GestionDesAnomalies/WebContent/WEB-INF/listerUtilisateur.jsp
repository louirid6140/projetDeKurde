<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<title>Liste des utilisateurs existants</title>
<link type="text/css" rel="stylesheet"
	href="<c:url 
value="/inc/style.css"/>" />
</head>
<body>
	<h1>Liste des utilisateurs</h1>
	<c:forEach items="${liste}" var="util">
		<div class="utilisateur">
			<b>Utilisateur : </b><br>
			<div class="nomUtilisateur">
				Nom : <c:out value="${util['nom']}" />
			</div>
			<div class="prenomUtilisateur">
				Prénom : <c:out value="${util['prenom']}" />
			</div>
			<div class="emailUtilisateur">
				Email : <c:out value="${util['email']}" />
			</div>
			<div class="loginUtilisateur">
				Login : <c:out value="${util['login']}" />
			</div>
		</div>
		<br>
	</c:forEach>

</body>
</html>