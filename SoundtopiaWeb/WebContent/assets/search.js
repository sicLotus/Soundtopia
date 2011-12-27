document.onmousemove = onMouseMove;
document.onkeydown = onKeyPressedDown;

var paddingLeftAndRight = 3;
var paddingTopAndDown = 0;
var searchStyleOne = "'background-color: #FFFFFF; padding: "
		+ paddingTopAndDown + "px " + paddingLeftAndRight
		+ "px; margin: 0px; cursor: default;'";
var searchStyleTwo = "'background-color: rgb(230,230,230); padding: "
		+ paddingTopAndDown + "px " + paddingLeftAndRight
		+ "px; margin: 0px; cursor: default;'";
var searchStyleHover = "'background-color: #1F3022; color: #17c905; padding: "
		+ paddingTopAndDown
		+ "px "
		+ paddingLeftAndRight
		+ "px; margin: 0px; cursor: default;'";

var textArray = new Array();
var textArrayB = new Array(); // same array as above, but with <b></b> tags

var searchPos = -1;
var focussed = 0;
var mouseMoved = 0;
var noSearch = 0;

$("#search_results").fadeOut(0);

// removes double entries
Array.prototype.unique = function() {
	var o = {};
	var tmp = [];
	for ( var i = 0; i < this.length; i++)
		o[this[i]] = true;
	for ( var i in o)
		tmp[tmp.length] = i;
	return tmp;
};

function getFocus() {
	focussed = 1;
	searchPos = -1;
	showSearchSuggestions();
}

function loseFocus() {
	focussed = 0;
	if (document.searchform.searchinput.value == 0)
		document.searchform.searchinput.value = "Suchbegriff eingeben";
	$("#search_results").fadeOut(25);
}

function boxHover(i) {
	if (!mouseMoved)
		return;
	searchPos = i;
	noSearch = 1;
	showSearchSuggestions();
}

function boxClick(i) {
	searchPos = i;
	noSearch = 1;
	document.searchform.searchinput.value = textArray[searchPos];
	showSearchSuggestions();
}

function onMouseMove(e) {
	mouseMoved = 1;
}

function onKeyPressedDown(e) {
	if (!focussed)
		return;

	noSearch = 0;
	if (!e)
		e = window.event;

	if (e.which)
		code = e.which;
	else if (e.keyCode)
		code = e.keyCode;

	// arrow down
	if (code == 40) {
		searchPos++;
		noSearch = 1;
		e.preventDefault();

		if (searchPos >= textArray.length - 1)
			searchPos = textArray.length - 2;

		if (searchPos >= 0)
			document.searchform.searchinput.value = textArray[searchPos];
	}

	// arrow up
	else if (code == 38) {
		searchPos--;
		noSearch = 1;
		e.preventDefault();

		if (searchPos < 0)
			searchPos = -1;

		if (searchPos >= 0)
			document.searchform.searchinput.value = textArray[searchPos];
	}

	// Enter
	else if (code == 13) {
		if (searchPos >= 0) {
			document.searchform.searchinput.value = textArray[searchPos];
			searchPos = -1;
			textArray.length = 0;
			$("#search_results").empty();
			$("#search_results").fadeOut(25);
		}
	}

	// ESC
	else if (code == 27) {
		searchPos = -1;
		noSearch = 1;
		textArray.length = 0;
		$("#search_results").empty();
		$("#search_results").fadeOut(25);
	} else
		searchPos = -1;

	showSearchSuggestions();
}

function search(f) {
	if (noSearch == 1)
		return;

	var search = f.value.replace(/[\+\?\!\.\'\;\/\&\%\#\\*\$\§\"\-\<\>\,"]/g, "");

	if (search.length < 2) {
		$("#search_results").fadeOut(25);
		return;
	}

	var searchArray = search.split(" ");

	var _data = "searchinput=" + searchArray;
	var foo, bar, reg;
	jQuery.ajax({
		url : "../controller/suggestSearch",
		type : "POST",
		data : _data,
		success : function(reqCode) {
			textArray.length = 0;
			textArray = reqCode.searchResults.split("#");
			textArrayB = reqCode.searchResults.split("#");

			jQuery.each(textArrayB, function(i, value) {
				jQuery.each(searchArray, function(j, value) {
					if (value.length > 0) {
						foo = new RegExp("(?!\<)" +searchArray[j] + "(?!\>)",
								'ig');
						bar = textArrayB[i].match(foo);
						if (bar != null) {
							bar = bar.unique();
							for (k = 0; k < bar.length; k++) {
								reg = new RegExp("(?!\<)" +bar[k]+ "(?!\>)", 'g');
								textArrayB[i] = textArrayB[i].replace(reg,
										"<b>" + bar[k] + "</b>");
							}
						}
					}
				});
			});
			showSearchSuggestions();
		}
	});
}

function showSearchSuggestions() {
	var text = "";
	var foo = 0;
	for (i = 0; i < textArray.length - 1; i++, foo = (foo + 1) % 2) {
		if (searchPos != i)
			if (foo == 1)
				text = text + "<div onmousedown='boxClick(" + i
						+ ")' onmouseover='boxHover(" + i + ")' style="
						+ searchStyleOne + ">" + textArrayB[i] + "</div>";
			else
				text = text + "<div onmousedown='boxClick(" + i
						+ ")' onmouseover='boxHover(" + i + ")' style="
						+ searchStyleTwo + ">" + textArrayB[i] + "</div>";
		else
			text = text + "<div onmousedown='boxClick(" + i
					+ ")' onmouseover='boxHover(" + i + ")' style="
					+ searchStyleHover + ">" + textArrayB[i] + "</div>";
	}

	$("#search_results").empty();
	if (text.length > 3) {
		$("#search_results").fadeIn(0);
		$("#search_results").append(text);
	} else {
		$("#search_results").fadeOut(25);
	}
	mouseMoved = 0;
}