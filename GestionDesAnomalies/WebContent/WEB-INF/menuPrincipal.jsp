<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Menu Administrateur</title>
<link type="text/css" rel="stylesheet"
	href="<c:url 
	value="/inc/style.css"/>" />
</head>
<body>
	<div id="menu">
		<p>
			<a href="<c:url value="/creationAdministrateur"/>">Se connecter
				en tant qu'administrateur</a>
		</p>
		<p>
			<a href="<c:url value="/connectionUtilisateur"/>">Se connecter en tant qu'utilisateur</a>
		</p>

		<c:choose>
			<c:when test="${!emptysessionScope.sessionAdministrateur}">
				<%-- Si l'administrateur existe en session, alors on affiche son login. --%>
				<p class="succes">Vous êtes connecté(e) avec l'adresse :
					${sessionScope.sessionAdministrateur.login}</p>
			</c:when>
			<c:otherwise> Coucou
		</c:otherwise>
		</c:choose>
	</div>
</body>
</html>