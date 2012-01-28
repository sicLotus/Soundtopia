<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="head.jsp" />
<div class="header">
	<div class="logo"></div>
	<div class="navi">
		<div class="navi_left"></div>
		<div class="navi_item">
			<a href="../controller/showCharts?start=1">Singlecharts</a>
		</div>
		<div class="navi_item">
			<a href="../controller/showUserCharts">Usercharts</a>
		</div>
		<c:choose>
			<c:when test="${sessionScope.loggedIn == true }">
				<div class="navi_item">
					<a href="../controller/showMyCharts"><strong>Meine
							Charts</strong></a>
				</div>
			</c:when>
			<c:when test="${sessionScope.user.admin == true }">
				<div class="navi_item">
					<a class="modalInput" href="javascript:void(0);" rel="#modalNew">Neue
						Charts einlesen</a>
				</div>
			</c:when>
		</c:choose>
		<div class="navi_right"></div>
	</div>

	<div id="navistrich" class="link3"></div>
	</body>
	</html>