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
	<div id="menu">
		<c:choose>
			<c:when test="${erreur==true}">Le pseudo et/ou le mot de passe sont incorrects.
    	<p>
					<a href="<c:url value="/connection"/>">Retour au Menu Principal</a>
				</p>
				<p>
					<a href="<c:url value="/connectionUtilisateur"/>">Connection
						utilisateur</a>
				</p>
			</c:when>
			<c:otherwise>Vous êtes connecté en tant qu'utilisateur.
					<p>
						<a href="<c:url value="/projets"/>">Ajouter projet</a>
					</p>
					
					<p>
						<a href="<c:url value="/listeProjets"/>">Obtenir la liste des projets</a>
					</p>
					
					<p>
						<a href="<c:url value="/anomalies"/>">Ajouter une anomalie</a>
					</p>
						
					<p>
						<a href="<c:url value="/affectation"/>">Affecter une anomalie à un utilisateur</a>
					</p>
						<p>
						<a href="<c:url value="/listeAnomalies"/>">Obtenir la liste des anomalies affectées</a>
					</p>
					
					<a href="<c:url value="/Deconnection"/>">Se déconnecter. Retour au menu principal.</a>

			</c:otherwise>
		</c:choose>

		<c:if test="${!emptysessionScope.sessionUtilisateur}">
			<%-- Si l'administrateur existe en session, alors on affiche son login. --%>
			<p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionUtilisateur.login}</p>
		</c:if>

	</div>
</body>
</html>
