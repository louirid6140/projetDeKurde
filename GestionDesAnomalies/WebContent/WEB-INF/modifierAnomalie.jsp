<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<title>Modification d'une anomalie</title>
<link type="text/css" rel="stylesheet"
	href="<c:url 
value="/inc/style.css"/>" />
</head>
<body>
	<h1>Modifier l'anomalie <c:out value="${sujet}" /></h1>
	
	<form method="post" action="<c:url value="/modifierAnomalie"/>">
			<fieldset>
				<legend>Informations sur l'anomalie à modifier</legend>
				<label for="sujetAnomalie">Sujet<span class="requis">*</span></label>
				<input type="text" id="sujetAnomalie" name="sujetAnomalie" value=""
					size="30" maxlength="30" /> <br /> <label for="desAnomalie">Description
					<span class="requis">*</span>
				</label> <input type="text" id="desAnomalie" name="desAnomalie" value=""
					size="150" maxlength="255" /> <br /> 
					<span class="requis">*</span>			
				<br> <label for="noteAnomalie">Note anomalie<span
					class="requis">*</span>
				</label> <input type="text" id="noteAnomalie" name="noteAnomalie" value=""
					size="150" maxlength="255" /> <br />

			</fieldset>
			<input type="submit" value="Valider" /> <input type="reset"
				value="Remettre à zéro" /> <br />
		</form>
	
		<p>
			<a href="<c:url value="/listeAnomalies"/>">Retour à la liste des anomalies</a>
		</p>

		<p>
			<a href="<c:url value="/connectionUtilisateur"/>">Retour au menu utilisateur</a>
		</p>
				<p>
			<a href="<c:url value="/Deconnection"/>">Se déconnecter. Retour au menu principal.</a>
		</p>
	</div>
	
	 <c:if test="${!emptysessionScope.sessionUtilisateur}">
                    <%-- Si l'utilisateur existe en session, alors on affiche son login. --%>
       <p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionUtilisateur.login}</p>
</c:if>

</body>
</html>