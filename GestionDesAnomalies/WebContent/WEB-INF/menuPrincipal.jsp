<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="menu">
	<p>
		<a href="<c:url value="/connectionAdministrateur.jsp"/>">Se connecter en tant qu'administrateur</a>
	</p>
	<p>
		<a href="<c:url value="/connectionUtilisateur.jsp"/>">Se connecter en tant qu'utilisateur</a>
	</p>
</div>