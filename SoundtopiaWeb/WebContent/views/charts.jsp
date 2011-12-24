<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
</head>
<body>
<jsp:include page="navi.jsp" />
<div id="modalEdit" class="songAddition modal">
	<form action="javascript:void(0);" onSubmit="javascript:changeSongInformation();" method="post">
		<input id="txtID" name="txtID" type="text" style="display: none" />
		<div class="songAdditionCover">
			Cover<br>
			<input id="txtCover" name="txtCover" type="text" />
		</div>
		<div class="songAdditionInterpreter">
			Interpreter<br>
			<input id="txtInterpreter" name="txtInterpreter" type="text" />
		</div>
		<div class="songAdditionTitle">
			Title<br>
			<input id="txtTitle" name="txtTitle" type="text" />
		</div>
		<input src="../images/save.jpg" type="image" />
		<button style="display: none" type="reset" id="closeModalEdit"  class="close"> Abbrechen </button>
	</form>
</div>

 <div id="contentLoading" class="contentLoading" style="display:none;">
	<span>
		<img src="../images/ajaxLoad.gif" align="middle">
		Loading Please Wait...
	</span>
</div>
 <div id="content">
 <c:forEach var="chart" items="${chartList}">
    	<div id="so" class="content_item">
        	<div class="chartplatzierung">
        		<div class="chartState">
        		<c:choose>
      				<c:when test="${chart.change > '0'}">
      					<span class="chartStateText">${chart.change}</span>
      					<img class="up" src="../images/up.png">
      				</c:when>
      				<c:when test="${chart.change < '0' }">
      					<span class="chartStateText">${chart.change}</span>
      					<img class="down" src="../images/down.png">
					</c:when>
					<c:when test="${chart.change == '0' }">
      					<span class="chartStateText"></span>
      					<img class="equal" src="../images/equal.png">
					</c:when>
      				<c:otherwise>
						<span class="chartStateText">Neu</span>
      					<img class="new" src="../images/new.png">
      				</c:otherwise>
    			</c:choose>
        		</div>
        		<span class="platznummer">${chart.ranking}.</span>
        		<span class="platz">Platz</span>
        	</div>
	        		<a class="modalInput" onclick="fillText('${chart.id}');" rel="#modalEdit" href="javascript:void();">
	        			<img class="edit" src="../images/edit.png" />
	        		</a>

            <div class="chartbild">
            	<img id="cover${chart.id}" class="cover" alt="Coverlink:${chart.picture}" src="${chart.picture}" />	
            </div>
            <div class="kasten">
                <div id="chartautor${chart.id}" class="chartautor">${chart.interpreter}</div><span class="platzhalter_autor_name"> | </span><div id="chartname${chart.id}" class="chartname">${chart.title}</div>
                <div id="chartpreise${chart.id}" class="chartpreise">
                <c:forEach var="price" items="${chart.prices}">
                	<div class="chartpreis"><a target="_blank" href="${price.url}"><img class="resize" src="../images/${price.provider}_resize.png" /></a><div class="chartpreis_preis"><a target="_blank" href="${price.url}">${price.value} ${price.currency}</a></div></div>
                </c:forEach>
                </div>
                <div class="chartbewertung">
                    <form>
	       				 Bewertung: &oslash;
	       				  <c:choose>
   					 	<c:when test="${sessionScope.loggedIn  == false}">
   					 	<br>
	        			<div id="fake-stars-off${chart.ranking}" class="stars-off" style="width:81px;"><div id="fake-stars-on${chart.ranking}" class="stars-on"></div></div>
	        			<script>

   					 			rateFake('${chart.ranking}','${chart.rating}');
   					 		</script>
   					 	</c:when>
   					 	<c:otherwise>
   					 	<div class="stars-wrapper" id="stars-wrapper${chart.ranking}">
	            			<select name="selrate">
				                <option value="1">Very poor</option>
				                <option value="2">Not that bad</option>
				                <option value="3">Average</option>
				                <option value="4">Good</option>
				                <option value="5">Perfect</option>
	            			</select>
	        			</div>
	        			   					 		<script>
	        			   					 	showStars('${chart.ranking}', '${chart.id}');
   					 			rate('${chart.ranking}','${chart.userRating}');
   					 		</script>
   					 	</c:otherwise>
   					 	
   					 </c:choose>
	       				 
   					 </form>
   					 
   					</div>
                <div id="chartstars${chart.ranking}" class="chartstars">${chart.rating}</div>
                
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
                	<div id="lyriktext${chart.id}" class="lyriktext">
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