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
		<legend>Liste des anomalies</legend>
		<c:forEach items="${liste}" var="anom">
			<div class="anomalie">
				<b>Anomalie : </b><br>
				<div class="sujetAnomalie">
					Sujet :
					<a href="<c:url value="/modifierAnomalie?sujet=${anom['sujet']}"/>"><c:out value="${anom['sujet']}" /></a>
					
				</div>
				<div class="descriptionAnomalie">
					Description :
					<c:out value="${anom['description']}" />
				</div>
				<div class="etatAnomalie">
					Etat :
					<a href="<c:url value="/majAnomalie?sujet=${anom['sujet']}"/>"><c:out value="${anom['etat']}" /></a>
				</div>
<%-- 				<div class="nomUtilisateurAffAnomalie">
					Nom de l'utilisateur :
					<c:out value="${anom['nomUtilisateurAff']}" />
				</div> --%>
				<div class="notesAnomalie">
					Notes :
					<c:out value="${anom['notes']}" />
				</div>
				<div class="utilisateurAnomalie">
					Utilisateur affecté :
					<c:out value="${anom['utilisateur']}" />
				</div>
				<div class="projetAnomalie">
					Projet affecté :
					<c:out value="${anom['projet']}" />
				</div>
			</div>
			<br>
		</c:forEach>
	</fieldset>
			<p>
			<a href="<c:url value="/connectionUtilisateur"/>">Retour au menu utilisateur</a>
		</p>
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