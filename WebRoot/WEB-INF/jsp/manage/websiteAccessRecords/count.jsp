<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<script type="text/javascript">
	$(function () {
	    $('#container2').highcharts({
	        chart: {
	            plotBackgroundColor: null,
	            plotBorderWidth: null,
	            plotShadow: false
	        },
	        title: {
	            text: '用户分析'
	        },
	        tooltip: {
	    	    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	        },
	        plotOptions: {
	            pie: {
	                allowPointSelect: true,
	                cursor: 'pointer',
	                dataLabels: {
	                    enabled: true,
	                    color: '#000000',
	                    connectorColor: '#000000',
	                    format: '<b>{point.name}</b>: {point.percentage:.1f} %'
	                }
	            }
	        },
	        series: [{
	            type: 'pie',
	            name: '浏览器使用',
	            data: [
	                	
                	<c:forEach var="c" items="${countList}" varStatus="status">
                		<c:if test="${!status.last}">
                			['${c.groupCondition}', ${c.countNumber}],
                		</c:if>
                		<c:if test="${status.last}">
                			['${c.groupCondition}', ${c.countNumber}]
                		</c:if>
                	</c:forEach>
	            ]
	        }]
	    });
	});
</script>
<div id="container2" style="min-width: 310px; height: 500px; margin: 0 auto"></div>