<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<title>Liste des anomalies de l'utilisateur</title>
<link type="text/css" rel="stylesheet"
	href="<c:url 
value="/inc/style.css"/>" />
</head>
<body>
	<h1>Liste des anomalies de l'utilisateur</h1>
	<b>Anomalie(s) de <c:out value="${login}" />: </b><br>
			<c:forEach items="${liste}" var="anom">
			<div class="anomalie">
				
				<div class="sujetAnomalie">
					Sujet :
					<c:out value="${anom['sujet']}" />
				</div>
				<div class="descriptionAnomalie">
					Description :
					<c:out value="${anom['description']}" />
				</div>
				<div class="etatAnomalie">
					Etat :
					<c:out value="${anom['etat']}" />
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
		<p>
			<a href="<c:url value="/listeUtilisateurs"/>">Retour à la liste des utilisateurs</a>
		</p>

		<p>
			<a href="<c:url value="/creationAdministrateur"/>">Retour au menu Administrateur</a>
		</p>
				<p>
			<a href="<c:url value="/Deconnection"/>">Se déconnecter. Retour au menu principal.</a>
		</p>
	</div>
	
	 <c:if test="${!emptysessionScope.sessionAdministrateur}">
                    <%-- Si l'administrateur existe en session, alors on affiche son login. --%>
       <p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionAdministrateur.login}</p>
</c:if>

</body>
</html>