<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Création d'un utilisateur</title>
<link type="text/css" rel="stylesheet"
	href="<c:url 
	value="/inc/style.css"/>" />
</head>
<body>
	<div>
		<form method="post" action="<c:url value="/creationUtilisateur"/>">
			<fieldset>
				<legend>Informations de l'utilisateur à créer</legend>
				<label for="nomUtilisateur">Nom <span class="requis">*</span></label> <input
					type="text" id="nomUtilisateur" name="nomUtilisateur" value="" size="30"
					maxlength="30" />
					
					 <br /> 
				<label for="prenomUtilisateur">Prénom <span class="requis">*</span>
				</label> <input type="text" id="prenomUtilisateur" name="prenomUtilisateur" value=""
					size="30" maxlength="30" /> 
					
					<br /> 
				
				<label for="emailUtilisateur">Email <span class="requis">*</span>
				</label> <input type="email" id="emailUtilisateur" name="emailUtilisateur" value=""
					size="30" maxlength="60" /> 
					
					<br /> 
					
					<label for="loginUtilisateur">Pseudo <span class="requis">*</span>
				</label> <input type="text" id="loginUtilisateur" name="loginUtilisateur"
					value="" size="30" maxlength="30" />
					
					 <br /> 
					 
				<label
					for="passwordUtilisateur">Mot de passe <span class="requis">*</span></label> 
					<input type="text"
					id="passwordUtilisateur" name="passwordUtilisateur" value="" size="30"
					maxlength="60" /> <br />
			</fieldset>
			<input type="submit" value="Valider" /> <input type="reset"
				value="Remettre à zéro" /> <br />
		</form>
	</div>
	 <c:if test="${!emptysessionScope.sessionAdministrateur}">
                    <%-- Si l'administrateur existe en session, alors on affiche son login. --%>
       <p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionAdministrateur.login}</p>
</c:if>
</body>
</html>