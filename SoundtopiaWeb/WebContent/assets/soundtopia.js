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
	 
	 $('#txtCover').focus(function() {
	  		$(this).select();
		 });
	 
	 $('#txtInterpreter').focus(function() {
	  		$(this).select();
		 });
	 
	 $('#txtTitle').focus(function() {
	  		$(this).select();
		 });
	 
	jQuery(".modalInput").overlay({
		mask: {
			color: '#113d2b',
			loadSpeed: 200,
			opacity:0.7
		},
		closeOnEsc: false,
		closeOnClick: true
	});
});

function hideKasten() {
	$(".kasten_extended").hide();
	 $('.chart_extend').click(function(){
		$(this).toggleClass("chart_extend_active").parent().next('.kasten_extended').slideToggle('normal');
	 });
}

function rate(divID, value) {
	$("#stars-wrapper"+divID).stars('select', parseInt(value));
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
        	});
        	
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

//frueher startLoadingEdit mit saveEdit und loadingEdit
function startLoadingModal(divFadeOut, divFadeIn) {
	$(document.getElementById(divFadeOut)).fadeOut('slow');
	$(document.getElementById(divFadeIn)).fadeIn('slow');
}

//frueher finishLoadingEdit mit saveEdit und loadingEdit
function finishLoadingModal(divFadeIn, divFadeOut) {
	$(document.getElementById(divFadeIn)).fadeIn();
	$(document.getElementById(divFadeOut)).fadeOut();
}

//function startLoadingUndo() {
//	$(document.getElementById('undoButtons')).fadeOut('slow');
//	$(document.getElementById('loadingUndo')).fadeIn('slow');
//}
//
//function finishLoadingUndo() {
//	$(document.getElementById('undoButtons')).fadeIn();
//	$(document.getElementById('loadingUndo')).fadeOut();
//}



function loadContent(start, end) {
	 document.getElementById("platzierungen").display = 'none';
	  startLoading();
//	  new Ajax.Updater('content', '../controller/showCharts', {method: 'post', postBody:'startChart='+ start +'&endChart='+ end +''});
	  showCharts(start, end);
	 finishLoading();
	 document.getElementById("platzierungen").display = 'block';
}

function showCharts(start, end) {
	var _data = "op=update&start="+start+"&end="+end;
	jQuery.ajax({
				url: "../controller/showCharts",
				type: "POST",
				data: _data,
				success: function (reqCode) {
					var chartList = "";
					jQuery.each(reqCode.chart, function(i, value) {
						
						chartList += "<div class=\"content_item\"><div class=\"chartplatzierung\"><div class=\"chartState\">";
						if(reqCode.chart[i].change > 0) {
							chartList += "<span class=\"chartStateText\">"+reqCode.chart[i].change+"</span><img class=\"up\" src=\"../images/up.png\">";
						}
						else if (reqCode.chart[i].change < 0) {
							chartList += "<span class=\"chartStateText\">"+reqCode.chart[i].change+"</span><img class=\"down\" src=\"../images/down.png\">";
						}
						else if (reqCode.chart[i].change == 0) {
							chartList += "<span class=\"chartStateText\"></span><img class=\"equal\" src=\"../images/equal.png\">";
						}
						else {
							chartList += "<span class=\"chartStateText\">Neu</span><img class=\"new\" src=\"../images/new.png\">";
						}						
						chartList += "</div><span class=\"platznummer\">"+reqCode.chart[i].ranking+".</span><span class=\"platz\">Platz</span></div>";
						
						if(reqCode.user != null) {
							if (reqCode.user.admin == 1) {
								chartList += "<a class=\"modalInput\" onclick=\"javascript:fillText("+reqCode.chart[i].id+"); \"rel=\"#modalEdit\" href=\"javascript:void(0);\"> <img class=\"edit\" src=\"../images/edit.png\" /></a><a onclick=\"javascript:setUndoID("+reqCode.chart[i].id+")\" class=\"modalInput\" rel=\"#modalUndo\" href=\"javascript:void(0);\"><img class=\"undo\" src=\"../images/undo.png\" /></a>";	
							}
						}
						
						chartList += "<div class=\"chartbild\"> <img id=\"cover"+reqCode.chart[i].id+"\" class=\"cover\" alt=\"Coverlink:"+reqCode.chart[i].picture+"\" src=\""+reqCode.chart[i].picture+"\" /> </div>"; 
						chartList += "<div class=\"kasten\"> <div id=\"chartautor"+reqCode.chart[i].id+"\" class=\"chartautor\">"+reqCode.chart[i].interpreter+"</div> <span class=\"platzhalter_autor_name\"> | </span> <div id=\"chartname"+reqCode.chart[i].id+"\" class=\"chartname\">"+reqCode.chart[i].title+"</div> <div id=\"chartpreise"+reqCode.chart[i].id+"\" class=\"chartpreise\">";

						if (reqCode.chart[i].prices != null) {
							jQuery.each(reqCode.chart[i].prices, function(j,value) {
								chartList += " <div class=\"chartpreis\"> <a target=\"_blank\" href=\""+reqCode.chart[i].prices[j].url+"\"><img class=\"resize\" src=\"../images/"+reqCode.chart[i].prices[j].provider+"_resize.png\" /></a> <div class=\"chartpreis_preis\"> <a target=\"_blank\" href=\""+reqCode.chart[i].prices[j].url+"\">"+reqCode.chart[i].prices[j].value+" "+reqCode.chart[i].prices[j].currency+"</a></div></div>";
							});
						}
						chartList += "</div><div class=\"chartbewertung\"><form>Bewertung: &oslash;";
						
						if(reqCode.loggedIn == false) {
							chartList += " <br> <div id=\"fake-stars-off"+reqCode.chart[i].ranking+"\" class=\"stars-off\" style=\"width: 81px;\"> <div id=\"fake-stars-on"+reqCode.chart[i].ranking+"\" class=\"stars-on\"></div></div><script> rateFake('"+reqCode.chart[i].ranking+"', '"+reqCode.chart[i].rating+"');</script>";
						}
						else {
							chartList += " <div class=\"stars-wrapper\" id=\"stars-wrapper"+reqCode.chart[i].ranking+"\"> <select name=\"selrate\"> <option value=\"1\">Very poor</option> <option value=\"2\">Not that bad</option> <option value=\"3\">Average</option> <option value=\"4\">Good</option> <option value=\"5\">Perfect</option> </select> </div> <script> showStars('"+reqCode.chart[i].ranking+"', '"+reqCode.chart[i].id+"'); rate('"+reqCode.chart[i].ranking+"', '"+reqCode.chart[i].userRating+"'); </script>";
						}
						
						chartList += "</form> </div> <div id=\"chartstars"+reqCode.chart[i].ranking+"\" class=\"chartstars\">"+reqCode.chart[i].rating+"</div><div class=\"chartlaenge\">Trackl&auml;nge: "+reqCode.chart[i].tracklength+"min</div> <!-- <div class=\"chartplayer\">Play | Stop | Volume</div> --> <div class=\"chart_extend\"></div> </div> <div class=\"kasten_extended\"> <div class=\"chartvideo\"> <object style='width: 301px; height: 200px;' width='301' height='200'> <embed src='"+reqCode.chart[i].video+"' width='301' height='200' type='application/x-shockwave-flash' allowscriptaccess='always' allowfullscreen='true'> </embed> <param name='movie' value='"+reqCode.chart[i].video+"' /> <param name='AllowFullscreen' value='true' /> <param name='AllowScriptAccess' value='always' /> </object> </div> <div class=\"chartlyrik\"> Lyrik <div id=\"lyriktext"+reqCode.chart[i].id+"\" class=\"lyriktext\"> "+reqCode.chart[i].lyric.text+"<br> <br> <a target=\"_blank\" href=\""+reqCode.chart[i].lyric.url+"\">"+reqCode.chart[i].interpreter+" - "+reqCode.chart[i].title+"</a> </div> </div> <!-- Lyrik Ende --> </div> <!-- Kasten Extended Ende --> </div> <!-- Content_Item Ende -->";
						
						});
	
					updateChartList(chartList);
					
					var prevS = "";
					var prevE = "";
					var nextS = "";
					var nextE = "";
					if(reqCode.prev != null) {
						prevS = reqCode.prev.start;
						prevE = reqCode.prev.end;
					}
					if(reqCode.next != null) {
						nextS = reqCode.next.start;
						nextE = reqCode.next.end;
					}
					
					setFooter(prevS,prevE,nextS,nextE);
				
				}
			});
	}

function setFooter(prevS, prevE, nextS, nextE) {
	var html = "";
	if (prevS != "")
		html += "<a href=\"javascript:loadContent("+prevS+","+prevE+");\"><img "+
		"alt=\"Vorherige\" src=\"../images/prev.jpg\" /></a>&nbsp;"; 
	if (nextS != "") 
		html += "<a href=\"javascript:loadContent("+nextS+","+nextE+");\"><img "+
		"alt=\"Nächste\" src=\"../images/next.jpg\" /></a>"; 
	
	document.getElementById("platzierungen").innerHTML = html;
}

function updateChartList(chartList){
	document.getElementById('content').innerHTML = chartList;
	hideKasten();
}

//setzt die Durchschnittsbewertung eines Songs
function updateChartstars(id, html) {
	ele = 'chartstars'+id;
	document.getElementById(ele).innerHTML = html;
}

function setUndoID(songID) {
	document.getElementById("undoID").value = songID;
}

function fillText(songID) {
	var _data = "songID="+songID;
	jQuery.ajax({
		url: "../controller/showInfo",
		type: "POST",
		data: _data,
		success: function (reqCode) {
			document.getElementById("txtID").value = songID;
			document.getElementById("txtCover").value = reqCode.songAddition.cover;
			document.getElementById("txtInterpreter").value = reqCode.songAddition.interpreter;
			document.getElementById("txtTitle").value = reqCode.songAddition.title;
			changePreview(reqCode.songAddition.cover);
		}
	});
	
}

function hidePreview() {
	document.getElementById("editPreview").style.display = "none";
}

function showPreview() {
	document.getElementById("editPreview").style.display = "block";
}

function changePreview(preview) {
	document.getElementById("editPreviewSmall").setAttribute("src", preview);
	document.getElementById("editPreview").setAttribute("src", preview);
}

function getURLfromAPI() {
	startLoadingModal('saveEdit', 'loadingEdit');
	var api = document.getElementById('txtAPI').options[document.getElementById('txtAPI').selectedIndex].value;
	var interpreter = document.getElementById("txtInterpreter").value;
	var title = document.getElementById("txtTitle").value;
	var _data = "api="+api+"&interpreter="+interpreter+"&title="+title;
	jQuery.ajax({
		url: "../controller/getPictureURL",
		type: "POST",
		data: _data,
		success: function (reqCode) {
			document.getElementById("txtCover").value = reqCode.url;
			changePreview(reqCode.url);
			finishLoadingModal('saveEdit', 'loadingEdit');
		}
	});
}

function undoChanges() {
	//$('#modalUndo').getOverlay().closeOnEsc = false;
	
	//$(".modalInput").overlay({closeOnEsc: 'false'});
	//$.tools.overlay.conf.closeOnEsc = false;
	//$("#modalUndo").overlay({closeOnEsc: false});
	//alert("ok");
	startLoadingModal('undoButtons', 'loadingUndo');
	var songID = document.getElementById("undoID").value;
	var _data = "songID="+songID;
	jQuery.ajax({
		url: "../controller/undoChanges",
		type: "POST",
		data: _data,
		success: function (reqCode) {
			document.getElementById("cover"+songID).setAttribute("src", reqCode.cover);
			document.getElementById("chartautor"+songID).innerHTML = reqCode.interpreter;
			document.getElementById("chartname"+songID).innerHTML = reqCode.title;
			var priceHtml = "";
			if (reqCode.prices != null) {
			jQuery.each(reqCode.prices, function(i, value) {
				priceHtml +="<div class=\"chartpreis\"><a target=\"_blank\" href=\""+reqCode.prices[i].url+
				"\"><img class=\"resize\" src=\"../images/"+reqCode.prices[i].provider+"_resize.png\" /></a><div class=\"chartpreis_preis\"><a target=\"_blank\" "+
				"href=\""+reqCode.prices[i].url+"\">"+reqCode.prices[i].value+" "+reqCode.prices[i].currency+"</a></div></div>";
			});
			
		}
			document.getElementById("chartpreise"+songID).innerHTML = priceHtml;
			var lyricHtml = reqCode.lyric.text+"<br><br><a target=\"_blank\" href=\""+reqCode.lyric.url+"\">"+reqCode.interpreter+" - "+reqCode.title+"</a>";
			
			document.getElementById("lyriktext"+songID).innerHTML = lyricHtml;
			document.getElementById("closeUndoChanges").click();
			finishLoadingModal('undoButtons', 'loadingUndo');
		}
	});
}

function changeSongInformation() {
	startLoadingModal('saveEdit', 'loadingEdit');
	var songID = document.getElementById("txtID").value;
	var cover = document.getElementById("txtCover").value;
	var interpreter = document.getElementById("txtInterpreter").value;
	var title = document.getElementById("txtTitle").value;
	
	var _data = "songID="+songID+"&cover="+cover+"&interpreter="+interpreter+"&title="+title;
	jQuery.ajax({
		url: "../controller/changeSongInformation",
		type: "POST",
		data: _data,
		success: function (reqCode) {
			document.getElementById("cover"+songID).setAttribute("src", reqCode.cover);
			document.getElementById("chartautor"+songID).innerHTML = reqCode.interpreter;
			document.getElementById("chartname"+songID).innerHTML = reqCode.title;
			var priceHtml = "";
			if (reqCode.prices != null) {
			jQuery.each(reqCode.prices, function(i, value) {
				priceHtml +="<div class=\"chartpreis\"><a target=\"_blank\" href=\""+reqCode.prices[i].url+
				"\"><img class=\"resize\" src=\"../images/"+reqCode.prices[i].provider+"_resize.png\" /></a><div class=\"chartpreis_preis\"><a target=\"_blank\" "+
				"href=\""+reqCode.prices[i].url+"\">"+reqCode.prices[i].value+" "+reqCode.prices[i].currency+"</a></div></div>";
			});
			
		}
			document.getElementById("chartpreise"+songID).innerHTML = priceHtml;
			var lyricHtml = reqCode.lyric.text+"<br><br><a target=\"_blank\" href=\""+reqCode.lyric.url+"\">"+reqCode.interpreter+" - "+reqCode.title+"</a>";
			
			document.getElementById("lyriktext"+songID).innerHTML = lyricHtml;
			

			finishLoadingModal('saveEdit', 'loadingEdit');
			document.getElementById("closeModalEdit").click();
		}
	});
}

function readCharts() {
	startLoadingModal('newButtons', 'loadingNew');
	document.getElementById('modalNewTxt').innerHTML = "Die neusten Charts werden eingelesen. Dies kann einen Moment dauern.";
	jQuery.ajax({
		url: "../controller/readNewCharts",
		type: "POST",
		success: function (reqCode) {
			
			finishLoadingModal('newButtons', 'loadingNew');
			self.location.href='../controller/showCharts';
		}
	});
}
