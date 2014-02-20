<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Menu Principal</title>
<link type="text/css" rel="stylesheet"
	href="<c:url 
	value="/inc/style.css"/>" />
</head>
<body>	
<fieldset>	
<legend>Menu principal</legend>
	<div>
		<p>
			<a href="<c:url value="/creationAdministrateur"/>">Se connecter
				en tant qu'administrateur</a>
		</p>
		<p>
			<a href="<c:url value="/connectionUtilisateur"/>">Se connecter en tant qu'utilisateur</a>
		</p>
	</div>
</fieldset>	
</body>
</html>