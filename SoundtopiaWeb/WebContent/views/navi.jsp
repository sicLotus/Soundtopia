<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

	<jsp:include page="header.jsp" />

	<div class="navi_bar">
		<div class="navi_bar_content_left">
			<%if (session.getAttribute("loggedIn") != null){
					boolean loggedIn = false; 
					loggedIn = (Boolean) session.getAttribute("loggedIn");
					if (loggedIn==true){ 
						String email = (String) session.getAttribute("email");
						
					%>
					
					<div id="login_success">Angemeldet unter <u><%=email %></u> (<a href="../controller/logout">Logout</a>)</div>
					</div>
					<% }} else { %>

			<form id="login_form" action="../controller/login" Method="post">
				<input id="iuser" name="iuser" class="input" value="Username"
					type="text">&nbsp; <input id="ipass" name="ipass"
					class="input" value="Passwort" type="password">&nbsp; <input
					id="ilogin" type="image" src="../images/login.png">&nbsp; <span
					id="ireg"><a class="modalInput" rel="#modalRegister"
					href="javascript:void(0);">Registrierung</a></span>
			</form>
		</div>

		<div class="modal" id="modalRegister">

			<form id="validRegistrationForm" action="../controller/register"
				Method="post">
				<fieldset>
					<legend>Registration</legend>
					<table>
						<tr>
							<td><label>E-Mail Adresse</label></td>
							<td><input type="text" name="emailR" /></td>
							<td></td>
						</tr>
						<tr>
							<td><label>Kennwort</label></td>
							<td><input type="password" name="passwordR" id="passwordR" /></td>
							<td></td>
						</tr>
						<tr>
							<td><label>Kennwort&uuml;berpr&uuml;fung</label></td>
							<td><input type="password" name="checkR" /></td>
							<td></td>
						</tr>
						<tr>
							<td id="terms"><label>AGB gelesen und aktzeptiert</label></td>
							<td><input type="checkbox" name="agbR"
								data-message="Please accept our terms" /></td>
							<td></td>
						</tr>
						<tr>
							<td>
								<button type="submit">Submit form</button>
								<button type="reset">Reset</button>
							</td>
						</tr>
					</table>
				</fieldset>
			</form>
			<a class="close"></a>
		</div>
<% } %>
		<div class="navi_bar_content_right">
			<form id="search_form">
				<input id="isenter" class="input" value="Suchbegriff eingeben"
					type="text">&nbsp; <input id="isearch" type="image"
					src="../images/suche.png">&nbsp;
			</form>
		</div>
	</div>
	</div>
	<!-- --------- -- -- Header Ende -->

</body>
</html>