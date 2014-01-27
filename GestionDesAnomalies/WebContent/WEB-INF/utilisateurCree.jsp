<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Création utilisateur</title>
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
				<c:out value="${utilisateur.nom }" />
			</p>
			<p>
				Prénom :
				<c:out value="${utilisateur.prenom }" />
			</p>
			<p>
				Email :
				<c:out value="${utilisateur.email}" />
			</p>
			<p>
				Pseudo :
				<c:out value="${utilisateur.login }" />
			</p>
			<p>
				Mot de passe :
				<c:out value="${utilisateur.password }" />
			</p>
			</c:when>
			<c:otherwise> Choix :
   			 </c:otherwise>
		</c:choose>
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