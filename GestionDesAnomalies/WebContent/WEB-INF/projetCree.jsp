<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Synthèse du projet crée</title>
<link type="text/css" rel="stylesheet"
	href="<c:url
value="/inc/style.css"/>" />
</head>
<body>
	<div id="corps">
		<p class="info">${ message }</p>
		<c:choose>
			<c:when test="${ !erreur }">
				<p>
					Nom :
					<c:out value="${projet.nomProjet}" />
				</p>
				<p>
					Caractéristiques du projet :
					<c:out value="${projet.caracProjet}" />
				</p>
			</c:when>
			<c:otherwise> Choix :
   			 </c:otherwise>
		</c:choose>
		<p>
			<a href="<c:url value="/connectionUtilisateur"/>">Retour au menu utilisateur</a>
		</p>
		<p>
			<a href="<c:url value="/projets"/>">Créer un autre projet</a>
		</p>
		<p>
			<a href="<c:url value="/Deconnection"/>">Se déconnecter. Retour au menu principal.</a>
		</p>
	</div>

	<c:if test="${!emptysessionScope.sessionUtilisateur}">
		<%-- Si l'administrateur existe en session, alors on affiche son login. --%>
		<p class="succes">Vous êtes connecté(e) avec l'adresse :
			${sessionScope.sessionUtilisateur.login}</p>
	</c:if>
</body>
</html>