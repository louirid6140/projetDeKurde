<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Création d'une nouvelle anomalie</title>
<link type="text/css" rel="stylesheet"
	href="<c:url 
	value="/inc/style.css"/>" />
</head>
<body>
	<div>
		<form method="post" action="<c:url value="/anomalies"/>">
			<fieldset>
				<legend>Informations sur l'anomalie à créer</legend>
				<label for="sujetAnomalie">Sujet<span class="requis">*</span></label>
				<input type="text" id="sujetAnomalie" name="sujetAnomalie" value=""
					size="30" maxlength="30" /> <br /> <label for="desAnomalie">Description
					<span class="requis">*</span>
				</label> <input type="text" id="desAnomalie" name="desAnomalie" value=""
					size="150" maxlength="255" /> <br /> <label for="etatAnomalie">Etat
					<span class="requis">*</span>
				</label> <BR> <SELECT NAME="etatAnomalie">
					<OPTION VALUE="NOUVEAU" SELECTED>NOUVEAU
				</SELECT> <br /> <label for="utilAnomalie">Projet affecté : <span
					class="requis">*</span>
				</label> <SELECT NAME="utilAnomalie">
					<c:forEach items="${liste}" var="pro">
						<option value="${pro['nom']}">
							<c:out value="${pro['nom']}" />
					</c:forEach>
				</SELECT><br> <label for="noteAnomalie">Note anomalie <span
					class="requis">*</span>
				</label> <input type="text" id="noteAnomalie" name="noteAnomalie" value=""
					size="150" maxlength="255" /> <br />

			</fieldset>
			<input type="submit" value="Valider" /> <input type="reset"
				value="Remettre à zéro" /> <br />
		</form>

		<p>
			<a href="<c:url value="/connectionUtilisateur"/>">Retour au menu
				utilisateur</a>
		</p>
	</div>
	<c:if test="${!emptysessionScope.sessionUtilisateur}">
		<%-- Si l'administrateur existe en session, alors on affiche son login. --%>
		<p class="succes">Vous êtes connecté(e) avec l'adresse :
			${sessionScope.sessionUtilisateur.login}</p>
	</c:if>
</body>
</html>