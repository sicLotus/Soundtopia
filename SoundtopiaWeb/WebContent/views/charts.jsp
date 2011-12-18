<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
</head>
<body>
<jsp:include page="navi.jsp" />
 <div id="contentLoading" class="contentLoading" style="display:none;">
	<span>
		<img src="../images/ajaxLoad.gif" align="middle">
		Loading Please Wait...
	</span>
</div>
 <div id="content">
 <c:forEach var="chart" items="${chartList}">
    	<div class="content_item">
        	<div class="chartplatzierung"><span class="platznummer">${chart.ranking}.</span><span class="platz">Platz</span></div>
            <div class="chartbild"><img id="cover" alt="Cover" src="${chart.picture}" /></div>
            <div class="kasten">
                <div class="chartautor">${chart.interpreter}</div><span class="platzhalter_autor_name"> | </span><div class="chartname">${chart.title}</div>
                <div class="chartpreise">
                <c:forEach var="price" items="${chart.prices}">
                	<div class="chartpreis"><a target="_blank" href="${price.url}"><img class="resize" src="../images/${price.provider}_resize.png" /></a><div class="chartpreis_preis"><a target="_blank" href="${price.url}">${price.value} ${price.currency}</a></div></div>
                </c:forEach>
                </div>
                <div class="chartbewertung">Bewertung:</div>
                <div class="chartstars">${chart.rating}</div>
                
                <div class="chartlaenge">Trackl&auml;nge: ${chart.tracklength}min</div>
                <!-- <div class="chartplayer">Play | Stop | Volume</div> -->
                <div class="chart_extend"></div>
            </div>
            <div class="kasten_extended">
                <div class="chartvideo">
					<object style='width:301px;height:200px;' width='301' height='200'>
						<embed src='${chart.video }' width='301' height='200' type='application/x-shockwave-flash' allowscriptaccess='always' allowfullscreen='true'>
						</embed>
						<param name='movie' value='${chart.video}'/>
						<param name='AllowFullscreen' value='true'/>
						<param name='AllowScriptAccess' value='always'/>
					</object>
				</div>
                <div class="chartlyrik">Lyrik
                	<div class="lyriktext">
                    	${chart.lyric.text}<br><br>
                    	<a target="_blank" href="${chart.lyric.url}">${chart.interpreter} - ${chart.title}</a>
					</div>
                </div> <!-- Lyrik Ende -->
            </div> <!-- Kasten Extended Ende -->
        </div> <!--  Content_Item Ende -->
 </c:forEach>       
 </div> <!-- Content Ende -->

 <div id="footer">
  	<div class="platzierungen">
    	<div class="platz76UP">75+</div>   		
        <div class="platz51_75">51-75</div>
        <div class="platz26_50"><a href="javascript:loadContent(26,50);">26-50</a></div>
        <div class="platz1_25">1-25</div>
	    Platzierungen 
   	</div>
</div>
</div>
</body>
</html>