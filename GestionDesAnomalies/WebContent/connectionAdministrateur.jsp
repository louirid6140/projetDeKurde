<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Connection de l'administrateur</title>
<link type="text/css" rel="stylesheet" href="<c:url 
value="/inc/style.css"/>" />
</head>
<body>
	<div>
		<form method="post" action="<c:url value="/creationAdministrateur"/>">
			<fieldset>
				<legend>Informations Administrateur</legend>
				<c:import url="/inc/inc_connection_form.jsp" />
			</fieldset>
			<input type="submit" value="Valider" /> <input type="reset"
				value="Remettre à zéro" /> <br />
		</form>
	</div>
</body>
</html>