<%@ page pageEncoding="UTF-8"%>
<div id="menu">
	<p>
		<a href="<c:url value="/creationAdministrateur"/>">Se connecter en tant qu'administrateur</a>
	</p>
	<p>
		<a href="<c:url value="/connectionUtilisateur"/>">Se connecter en tant qu'utilisateur</a>
	</p>

<c:if test="${!emptysessionScope.sessionAdministrateur}">
                    <%-- Si l'administrateur existe en session, alors on affiche son login. --%>
       <p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionAdministrateur.login}</p>
</c:if>
</div>