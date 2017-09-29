<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div align="center">
	<h3>데이터 시각화 (google chart)</h3>
	<div id="chartV" style="width: 500px; height: 500px;"></div>
	<small>Google PIE CHART</small>
</div>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script>
	google.charts.load("current", {
		"packages" : [ "corechart" ]
	});
	google.charts.setOnLoadCallback(drawChart);
	function drawChart() {
		var data = new google.visualization.DataTable();
	      data.addColumn('string', 'gender');
	      data.addColumn('number', 'count');
	      $.ajax({
	    	"url" :  "/chart/piedata" ,
	    	"async" : false
	      }).done(function(obj){
		      data.addRows(obj);
	      });
 
		var options = {
			"title" : "남/녀 성비",
			"is3D" : true
		};
		var chart = new google.visualization.PieChart(document
				.getElementById("chartV"));
		chart.draw(data, options);
	}
</script>