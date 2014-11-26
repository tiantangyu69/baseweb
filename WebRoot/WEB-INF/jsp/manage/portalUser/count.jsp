<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/manage/taglib.jsp"%>
<script type="text/javascript">
	$(function () {
        $('#container').highcharts({
            chart: {
                type: 'column'
            },
            title: {
                text: '会员注册统计'
            },
            xAxis: {
                categories: [
                	<c:forEach var="c" items="${countList}" varStatus="status">
                		<c:if test="${!status.last}">
                			${c.groupCondition},
                		</c:if>
                		<c:if test="${status.last}">
                			${c.groupCondition}
                		</c:if>
                	</c:forEach>
                ]
            },
            yAxis: {
                min: 0,
                title: {
                    text: '注册会员 (人)'
                }
            },
            tooltip: {
                headerFormat: '<span style="font-size:10px">{point.key}年</span><table>',
                pointFormat: '<tr><td style="color:{series.color};padding:0">注册会员数: </td>' +
                    '<td style="padding:0"><b>{point.y} 人</b></td></tr>',
                footerFormat: '</table>',
                shared: true,
                useHTML: true
            },
            plotOptions: {
                column: {
                    pointPadding: 0.2,
                    borderWidth: 0
                }
            },
            series: [{
                name: '注册会员(按年份统计)',
                data: [
                	<c:forEach var="c1" items="${countList}" varStatus="status2">
                		<c:if test="${!status2.last}">
                			${c1.countNumber},
                		</c:if>
                		<c:if test="${status2.last}">
                			${c1.countNumber}
                		</c:if>
                	</c:forEach>
                ]
            }]
        });
    });
</script>
<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>