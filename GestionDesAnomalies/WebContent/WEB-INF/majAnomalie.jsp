<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<title>Mise à jour d'une anomalie</title>
<link type="text/css" rel="stylesheet"
	href="<c:url 
value="/inc/style.css"/>" />
</head>
<body>
	<h1>Mise à jour de l'anomalie <c:out value="${sujet}" /></h1>
			<form method="post" action="<c:url value="/majAnomalie"/>">
			<fieldset>
				<legend>Nouvel état de l'anomalie </legend>
				<label for="etatAnomalie">Etat
					<span class="requis">*</span>
				</label> <BR> <SELECT NAME="etatAnomalie">
					<OPTION VALUE="AFFECTEE">AFFECTEE
					<OPTION VALUE="RESOLUE">RESOLUE
					<OPTION VALUE="FERMEE">FERMEE
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