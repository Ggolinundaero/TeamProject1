<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/include/header.jsp"%>
 <script src="/chart/Chart.min.js"></script>
 <script src="/chart/utils.js"></script>
  <style>
    canvas {
        -moz-user-select: none;
        -webkit-user-select: none;
        -ms-user-select: none;
    }
    </style>
<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-title">년 매출 현황</h2>
		<div class="sub-search">
		</div>
	</div>
	
	<div id="container" style="width: 800px;height:480px;">
        <canvas id="canvas" ></canvas>
    </div>  
	<script>
        var color = Chart.helpers.color;
        var ChartData = {            
            labels: ['2011년', '2012년', '2013년', '2014년', '2015년', '2016년', '2017년', '2018년', '2019년', '2020년', '2021년', '2022년'], // 챠트의 항목명 설정
            datasets: [{
                label: '총매출(단위는 만단위)',  // 데이터셑의 이름
                pointRadius: 15, // 꼭지점의 원크기
                pointHoverRadius: 30, // 꼭지점에 마우스 오버시 원크기                                   
                backgroundColor: color(window.chartColors.red).alpha(0.5).rgbString(), // 챠트의 백그라운드 색상
                borderColor: window.chartColors.red, // 챠트의 테두리 색상
                borderWidth: 1, // 챠트의 테두리 굵기
                lineTension:0, // 챠트의 유연성( 클수록 곡선에 가깝게 표시됨)
                fill:false,  // 선챠트의 경우 하단 부분에 색상을 채울지 여부                  
                data: [180,210,130,440,350,260,540,170,320,230,220,350]  // 해당 데이터셋의 데이터 리스트
            }]
 
        };
 
        window.onload = function() {
            var ctx = document.getElementById('canvas').getContext('2d');
            window.myHorizontalBar = new Chart(ctx, {
                // type 을 변경하면 선차트, 가로막대차트, 세로막대차트 등을 선택할 수 있습니다 
                // ex) horizontalBar, line, bar, pie, bubble
                type: 'pie', 
                data: ChartData,
                options: {
                    responsive: true,                    
                    maintainAspectRatio: false    ,
                    title: {
                        display: true,
                        text: 'Year 매출 현황(만 단위)'
                    }
                }
            });
 
        };
    </script>

</div>
<%@ include file="/include/footer.jsp"%>















