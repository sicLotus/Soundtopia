jQuery(document).ready(function(){
	hideKasten();
	
	 $('#iuser').focus(function() {
  		$(this).select();
	 });
	 
	 $('#ipass').focus(function() {
  		$(this).select();
	 });
	 
	 $('#isenter').focus(function() {
  		$(this).select();
	 });
	 
	  var triggers = jQuery(".modalInput").overlay({
		mask: {
			color: '#113d2b',
			loadSpeed: 200,
			opacity:0.7
		},
		closeOnClick: true
	});
	  
	/*    $("#stars-wrapper1").stars({
	        cancelShow: false,
	        captionEl: $("#stars-cap"),
	        callback: function(ui, type, value)
	        {
	            $.getJSON("ratings.php", {rate: value}, function(json)
	            {
	                $("#fake-stars-on").width(Math.round( $("#fake-stars-off").width() / ui.options.items * parseFloat(json.avg) ));
	                $("#fake-stars-cap").text(json.avg + " (" + json.votes + ")");
	            });
	        }
	    });*/

});

function hideKasten() {
	$(".kasten_extended").hide();
	 $('.chart_extend').click(function(){
		$(this).toggleClass("chart_extend_active").parent().next('.kasten_extended').slideToggle('normal');
	 });
}

function rate(divID, value) {
	$("#stars-wrapper"+divID).stars('select', parseInt(value));
	document.getElementById('#fake-stars-off'+divID).style.display = "none";
}

function rateFake(divID, value) { 
	$("#fake-stars-on"+divID).width(Math.round( $("#fake-stars-off"+divID).width() / 5 * parseFloat(value) ));
}

function showStars (divID, songID) {
	$("#stars-wrapper"+divID).stars({
        inputType: "select",
        callback: function(ui, type, value){
        	var ui = $("#stars-wrapper"+divID).data("stars");
        	var _data = "songID="+songID+"&rating="+ui.options.value;
        	jQuery.ajax({
        				url: "../controller/rateSong",
        				type: "POST",
        				data: _data,
        				success: function (reqCode) {
        					//aktualisieren des durchschnittwertes
        					var html = reqCode.meanRating;
        					updateChartstars(divID, html);
        				}
        	})
        	
        }
    });
}

function disableStars() {
    $(".stars-wrapper").stars({
        disabled: true
    });
}

function startLoading() {
	$(document.getElementById('contentLoading')).fadeIn('slow');
	$(document.getElementById('content')).fadeOut();
}

function finishLoading() {

	
	setTimeout(function(){ $(document.getElementById('contentLoading')).fadeOut('slow');
	$(document.getElementById('content')).fadeIn('slow');
	}, 2000);
}

function loadContent(start, end) {
	  startLoading();
//	  new Ajax.Updater('content', '../controller/showCharts', {method: 'post', postBody:'startChart='+ start +'&endChart='+ end +''});
	  showCharts(start, end);
	 finishLoading();
}

function showCharts(start, end) {
	var _data = "op=update&startChart="+start+"&endChart="+end;
	jQuery.ajax({
				url: "../controller/showCharts",
				type: "POST",
				data: _data,
				success: function (reqCode) {
					var chartList = "";
					jQuery.each(reqCode.chart, function(i, value) {
						chartList +="<div class=\"content_item\"><div class=\"chartplatzierung\"><span class=\"platznummer\">"+reqCode.chart[i].ranking+".</span>"
								+"<span class=\"platz\">Platz</span></div><div class=\"chartbild\"><img id=\"cover\" alt=\"Cover\" "
								+"src=\""+reqCode.chart[i].picture+"\" /></div><div class=\"kasten\"><div class=\"chartautor\">"+reqCode.chart[i].interpreter+""
								+"</div><span class=\"platzhalter_autor_name\"> | </span><div class=\"chartname\">"+reqCode.chart[i].title+"</div>"
								+"<div class=\"chartpreise\">";
						
						jQuery.each(reqCode.chart[i].prices, function(j,value) {
							chartList += "<div class=\"chartpreis\"><a target=\"_blank\" href=\""+reqCode.chart[i].prices[j].url+"\"><img class=\"resize\" "
									+"src=\"../images/"+reqCode.chart[i].prices[j].provider+"_resize.png\" /></a><div class=\"chartpreis_preis\">"
									+"<a target=\"_blank\" href=\""+reqCode.chart[i].prices[j].url+"\">"+reqCode.chart[i].prices[j].value+" "+reqCode.chart[i].prices[j].currency+"</a>"
									+"</div></div>";
						});

			                chartList+="</div>"
			                		+"<div class=\"chartbewertung\">Bewertung:</div><div class=\"chartstars\">"+reqCode.chart[i].rating+"</div>"
			                		+"<div class=\"chartlaenge\">Trackl&auml;nge: "+reqCode.chart[i].tracklength+"min</div><div class=\"chart_extend\"></div>"
			                		+"</div><div class=\"kasten_extended\"><div class=\"chartvideo\"><object style='width:301px;height:200px;' width='301' height='200'>"
									+"<embed src='"+reqCode.chart[i].video+"' width='301' height='200' type='application/x-shockwave-flash' allowscriptaccess='always' "
									+"allowfullscreen='true'></embed><param name='movie' value='"+reqCode.chart[i].video+"'/><param name='AllowFullscreen' "
									+"value='true'/><param name='AllowScriptAccess' value='always'/></object></div><div class=\"chartlyrik\">Lyrik"
									+"<div class=\"lyriktext\">"+reqCode.chart[i].lyric.text+"<br><br><a target=\"_blank\" href=\""+reqCode.chart[i].lyric.url+"\">"
									+reqCode.chart[i].interpreter+" - "+reqCode.chart[i].title+"</a></div></div> <!-- Lyrik Ende --></div> <!-- Kasten Extended Ende -->"
									+"</div> <!--  Content_Item Ende -->";
						});
	
					updateChartList(chartList);
				
				}
			});
	}

function updateChartList(chartList){
	document.getElementById('content').innerHTML = chartList;
	hideKasten();
}

function updateChartstars(id, html) {
	ele = 'chartstars'+id;
	document.getElementById(ele).innerHTML = html;
}