<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="sortNavi">
<form name="sortTopUserChartsForm">
<select name="sortTopUserCharts" onchange="showUserCharts(document.sortTopUserChartsForm.sortTopUserCharts.options[document.sortTopUserChartsForm.sortTopUserCharts.selectedIndex].value);" id="sortTopUserCharts">
<option value="rating">Bewertung</option>
<option value="votes">meistbewertete </option>
</select>
</form>
</div>