<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../style.css" rel="stylesheet" type="text/css">
<link href="../jquery.ui.stars.css" rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<script src="http://cdn.jquerytools.org/1.2.6/all/jquery.tools.min.js"></script>
<script src="../assets/soundtopia.js"></script>
<script src="../assets/jquery-ui-1.8.16.custom.js"></script>
<script src="../assets/jquery.ui.stars.js"></script>


<title>Soundtopia</title>
</head>
<body>
	<div id="main">
		<div class="header">
			<div class="logo"></div>
			<div class="navi">
				<div class="navi_left"></div>
				<div class="navi_item">
					<a href="../controller/showCharts">Singlecharts</a>
				</div>
				<div class="navi_item">Albumcharts</div>
				<div class="navi_item">Neuheiten</div>
				<c:choose>
					<c:when test="${sessionScope.user.admin == 1 }">
						<div class="navi_item">
							<a class="modalInput" href="javascript:void(0);" rel="#modalNew">Neue
								Charts einlesen</a>
						</div>
					</c:when>
				</c:choose>
				<div class="navi_right"></div>
			</div>

			<div class="navistrich"></div>
</body>
</html>