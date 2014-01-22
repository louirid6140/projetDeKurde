<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="menu">
	<p>
		<a href="<c:url value="/WEB-INF/ajouterProjet.jsp"/>">Ajouter projet</a>
	</p>
	<p>
		<a href="<c:url value="/WEB-INF/modificationCaractProjet.jsp"/>">Modifier caractéristiques projet</a>
	</p>
	<p>
		<a href="<c:url value="/etc.jsp"/>">etc</a>
	</p>
</div>