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
		<form method="post" action="<c:url value="/projets"/>">
			<fieldset>
				<legend>Informations sur le projet à créer</legend>
				<label for="nomProjet">Nom du projet <span class="requis">*</span></label>
				<input type="text" id="nomPrtojet" name="nomProjet" value=""
					size="30" maxlength="30" /> <br /> <label for="caracProjet">Caractèristiques
					du projet <span class="requis">*</span>
				</label> <input type="text" id="caracProjet" name="caracProjet" value=""
					size="150" maxlength="255" /> <br />

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