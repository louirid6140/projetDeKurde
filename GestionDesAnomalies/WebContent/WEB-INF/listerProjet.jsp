<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Liste des Projets existants</title>
<link type="text/css" rel="stylesheet"
	href="<c:url 
value="/inc/style.css"/>" />
</head>
<body>
	<fieldset>
		<legend>Liste des projets</legend>
		<c:forEach items="${liste}" var="proj">
			<div class="anomalie">
				<b>Projet : </b><br>
				<div class="nomProjet">
					Nom du projet :
					<a href="<c:url value="/modifierProjet?nomPro=${proj['nomProjet']}"/>"><c:out value="${proj['nomProjet']}"/></a>
				</div>
				<div class="caracProjet">
					Caractéristiques du projet :
					<c:out value="${proj['caracProjet']}" />
				</div>
			</div>
			<br>
		</c:forEach>
	</fieldset>
		
		<p>
			<a href="<c:url value="/connectionUtilisateur"/>">Retour au menu utilisateur</a>
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