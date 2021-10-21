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
		<h2 class="sub-title">일일 매출 현황</h2>
		<div class="sub-search">
		</div>
	</div>
	
	<div id="container" style="width: 700px;height:480px;">
        <canvas id="canvas" ></canvas>
    </div>  
	<script>
        var color = Chart.helpers.color;
        var ChartData = {            
            labels: ['현금', '대여료', '카드' , '발주비용'], // 챠트의 항목명 설정
            datasets: [{
                label: '매출(흑자)',  // 데이터셑의 이름
                pointRadius: 15, // 꼭지점의 원크기
                pointHoverRadius: 30, // 꼭지점에 마우스 오버시 원크기                                   
                backgroundColor: color(window.chartColors.red).alpha(0.5).rgbString(), // 챠트의 백그라운드 색상
                borderColor: window.chartColors.red, // 챠트의 테두리 색상
                borderWidth: 1, // 챠트의 테두리 굵기
                lineTension:0, // 챠트의 유연성( 클수록 곡선에 가깝게 표시됨)
                fill:false,  // 선챠트의 경우 하단 부분에 색상을 채울지 여부                  
                data: [44,0,55,0]  // 해당 데이터셋의 데이터 리스트
            }, {
                label: '대여및발주(적자)', 
                pointRadius: 5,
                pointHoverRadius: 10,                                    
                backgroundColor: color(window.chartColors.blue).alpha(0.5).rgbString(), 
                borderColor: window.chartColors.green, 
                borderWidth: 1,
                lineTension:0, 
                fill:false,                   
                data: [0,31,0,24] // 해당 데이터셋의 데이터 리스트
            }]
 
        };
        window.onload = function() {
            var ctx = document.getElementById('canvas').getContext('2d');
            window.myHorizontalBar = new Chart(ctx, {
                // type 을 변경하면 선차트, 가로막대차트, 세로막대차트 등을 선택할 수 있습니다 
                // ex) horizontalBar, line, bar, pie, bubble
                type: 'bar', 
                data: ChartData,
                options: {
                    responsive: true,                    
                    maintainAspectRatio: false    ,
                    title: {
                        display: true,
                        text: '일일 매출 현황'
                    }
                }
            });
        };
    </script>
    <tbody>
    <tr style="right">
    	<th><h2>총 흑자 : + 100,000 원</h2></th>
    	<th><h2>총 적자 :  - 80,000원</h2></th>
    	<th><h2>총 합 : 20,000원</h2></th>
    </tr>
    </tbody>
</div>
<%@ include file="/include/footer.jsp"%>















