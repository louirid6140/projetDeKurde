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
	<fieldset>
		<legend>Liste des utilisateurs</legend>
		<c:forEach items="${liste}" var="util">
			<div class="utilisateur">
				<b>Utilisateur : </b><br>
				<div class="nomUtilisateur">
				Nom : 
				<c:out value="${util['nom']}" />
				</div>
				<div class="prenomUtilisateur">
					Prénom :
					<c:out value="${util['prenom']}" />
				</div>
				<div class="emailUtilisateur">
					Email :
					<c:out value="${util['email']}" />
				</div>
				<div class="loginUtilisateur">
					Login :
					<a href="<c:url value="/utilisateurParAnomalie?login=${util['login']}"/>"><c:out value="${util['login']}"/></a>
				</div>
			</div>
			<br>
		</c:forEach>
	</fieldset>
		<p>
			<a href="<c:url value="/creationAdministrateur"/>">Retour au menu Administrateur</a>
		</p>
				<p>
			<a href="<c:url value="/Deconnection"/>">Se déconnecter. Retour au menu principal.</a>
		</p>
			 <c:if test="${!emptysessionScope.sessionAdministrateur}">
                    <%-- Si l'administrateur existe en session, alors on affiche son login. --%>
       <p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionAdministrateur.login}</p>
</c:if>
		
</body>
</html>