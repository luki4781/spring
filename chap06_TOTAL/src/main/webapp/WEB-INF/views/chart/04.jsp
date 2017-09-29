<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div align="center">
	<h3>데이터 시각화 (google chart / bar )</h3>
	<div id="chartV" style="width: 600px; height: 500px;"></div>
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
		data.addColumn('number', '점수');
		data.addColumn('number', '인원수');
		data.addColumn({
			'type' : 'string',
			'role' : 'style'
		});
		data.addRows([ [ 1, 4, 'silver' ], [ 2, 10, 'gold' ],
				[ 3, 5, 'silver' ], [ 4, 20, 'gold' ], [ 5, 0, 'red' ] ]);
		var options = {
			"title" : "점수별 인원수",
		};
		/*ColumnChart , BarChart, PieChart*/
		var chart = new google.visualization.BarChart(document
				.getElementById("chartV"));
		chart.draw(data, options);
	}
</script>