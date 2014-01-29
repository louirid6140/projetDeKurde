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
		<c:choose>
			<c:when test="${erreur==true}">Le pseudo et/ou le mot de passe sont incorrects.
    	<p>
					<a href="<c:url value="/connection"/>">Retour au Menu Principal</a>
				</p>
				<p>
					<a href="<c:url value="/creationAdministrateur"/>">Connection
						administrateur</a>
				</p>
			</c:when>
			<c:otherwise>Vous êtes connecté en tant qu'administrateur.
    	<p>
					<a href="<c:url value="/creationUtilisateur"/>">Créer un nouvel
						utilisateur</a>
				</p>
				<p>
					<a href="<c:url value="listeUtilisateurs.jsp"/>">Récupérer la
						liste des utilisateurs</a>
				</p>

				<p>
					<a href="<c:url value="/Deconnection"/>">Se déconnecter. Retour
						au menu principal.</a>
				</p>

			</c:otherwise>
		</c:choose>

		<c:if test="${!emptysessionScope.sessionAdministrateur}">
			<%-- Si l'administrateur existe en session, alors on affiche son login. --%>
			<p class="succes">Vous êtes connecté(e) avec l'adresse :
				${sessionScope.sessionAdministrateur.login}</p>
		</c:if>

	</div>
</body>
</html>