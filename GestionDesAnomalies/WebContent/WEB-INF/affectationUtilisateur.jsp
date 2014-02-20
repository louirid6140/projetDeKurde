<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Création d'un nouveau projet</title>
<link type="text/css" rel="stylesheet"
	href="<c:url 
	value="/inc/style.css"/>" />
</head>
<body>
	<div>
		<form method="post" action="<c:url value="/affectation"/>">
			<fieldset>
				<legend>Choisir l'utilisateur responsable de l'anomalie</legend>
				
					<label for="SujetAnomalies">Sujet de l'anomalie <span class="requis">*</span></label>
				<BR> <SELECT NAME="SujetAnomalies">
					<c:forEach items="${liste}" var="anom">
						<option value="${anom['sujet']}">
							<c:out value="${anom['sujet']}" />
					</c:forEach>
				</SELECT>  <br />
				
				<label for="UtilisateurName">Choisir un utilisateur: <span class="requis">*</span></label>
				<BR> <SELECT NAME="UtilisateurName">
					<c:forEach items="${liste2}" var="util">
						<option value="${util['login']}">
							<c:out value="${util['login']}" />
					</c:forEach>
				</SELECT>  <br />

			</fieldset>
			<input type="submit" value="Valider" /> <input type="reset"
				value="Remettre à zéro" /> <br />
		</form>

		<p>
			<a href="<c:url value="/connectionUtilisateur"/>">Retour au menu utilisateur</a>
		</p>
	</div>
	<c:if test="${!emptysessionScope.sessionUtilisateur}">
		<%-- Si l'administrateur existe en session, alors on affiche son login. --%>
		<p class="succes">Vous êtes connecté(e) avec l'adresse :
			${sessionScope.sessionUtilisateur.login}</p>
	</c:if>
</body>
</html>