<%@ page pageEncoding="UTF-8"%>
<div id="menu">
<c:choose>
    <c:when test="${erreur==true}">Le pseudo et/ou le mot de passe sont incorrects.
    	<p>
			<a href="<c:url value="menuPrincipal.jsp"/>">Retour au Menu Principal</a>
		</p>
		<p>
			<a href="<c:url value="/WEB-INF/connectionAdministrateur.jsp"/>">Connection administrateur</a>
		</p>
    </c:when>
    <c:otherwise>Vous êtes connecté en tant qu'administrateur.
    	<p>
			<a href="<c:url value="/WEB-INF/creerUtilisateur.jsp"/>">Créer un nouvel utilisateur</a>
		</p>
		<p>
			<a href="<c:url value="/WEB-INF/listeUtilisateurs.jsp"/>">Récupérer la liste des utilisateurs</a>

    </c:otherwise>
</c:choose>
</div>