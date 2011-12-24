<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<jsp:include page="header.jsp" />
	<div class="navi_bar">
		<div class="navi_bar_content_left">
			<c:choose>
				<c:when test="${sessionScope.loggedIn == true }">
					<div id="login_success">
						Angemeldet unter <u>${sessionScope.user.email}</u> (<a
							href="../controller/logout">Logout</a>)
					</div>
				</c:when>
				<c:otherwise>
					<form id="login_form" action="../controller/login" Method="post">
						<input id="iuser" name="iuser" class="input" value="lotus" type="text">&nbsp; 
						<input id="ipass" name="ipass" class="input" value="lotus" type="password">&nbsp; 
						<input id="ilogin" type="image" src="../images/login.png">&nbsp;
						<span id="ireg">
						<a class="modalInput" rel="#modalRegister" href="javascript:void(0);">Registrierung</a></span>
					</form>
				</c:otherwise>
			</c:choose>
		</div>
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
