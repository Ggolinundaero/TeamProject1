<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Date" %>
    <%@ page import="java.text.SimpleDateFormat" %>
<%
	Date nowTime = new Date();
	SimpleDateFormat sf = new SimpleDateFormat("yyyy년 MM월 dd일");
%>

<%@ include file="/include/header.jsp"%>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" /> 
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script> 
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-title">준비금 등록</h2>
	</div>
	
	<div class="write-form">
		<form name="startcoin" method="post">
		<table summery="일일마감 테이블 입니다">
			<caption class="readonly">일일마감 입력폼</caption>			
			<colgroup>
				<col width="20%">
				<col width="80%">
			</colgroup>
			<tbody>
			
					<tr>
						<th>작성날짜</th>
						<td><%=sf.format(nowTime) %></td>
					</tr>
					<tr>
						<th>100원(개)</th>
						<td><input type="text" value = '0' oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" name='OH' id='OH' onkeyup='tot()' ></td>
					</tr>
					<tr>
						<th>500원(개)</th>
						<td><input type="text" value = '0' oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" name='FH' id='FH' onkeyup='tot()' ></td>
					</tr>
					<tr>
						<th>1,000원(장)</th>
						<td><input type="text" value = '0' oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" name='OT' id='OT' onkeyup='tot()'></td>
					</tr>
					<tr>
						<th>5,000원(장)</th>
						<td><input type="text" value = '0' oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" name='FT' id='FT' onkeyup='tot()'></td>
					</tr>
					<tr>
						<th>10,000원(장)</th>
						<td>
							<input type="text" value = '0' oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" name='TT' id='TT' onkeyup='tot()' value="">
						</td>
					</tr>
					<tr>
						<th>50,000원(장)</th>
						<td><input type="text" value = '0' oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" name='FTT' id='FTT' onkeyup='tot()' value=""></td>
					</tr>
					
					<tr>
						<th>총합(원)</th>
						<td><input type="text" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" name='total' id='total' value="" readonly></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="등록" onClick = "send()" class="btn-write">
							<input type="button" value="취소"  class="btn-reset">
						</td>
					</tr>
			
			</tbody>
		</table>
			</form>
	</div>
		
</div>

<script>

function tot()
{
 if(document.getElementById("OH").value && document.getElementById("FH").value && document.getElementById("OT").value && document.getElementById("FT").value && document.getElementById("TT").value && document.getElementById("FTT").value){
  document.getElementById('total').value =(100*parseInt(document.getElementById('OH').value)) + (500*parseInt(document.getElementById('FH').value)) + (1000*parseInt(document.getElementById('OT').value)) + (5000*parseInt(document.getElementById('FT').value)) + (10000*parseInt(document.getElementById('TT').value)) + (50000*parseInt(document.getElementById('FTT').value));
 }
}
function send() {
	alert("등록중...");
	startcoin.action = "/Admin/acount/day_acount_ready_pro.do";
	startcoin.submit();
}
	
$(function() { $( "#Date" ).datepicker({ }); });
</script>

<%@ include file="/include/footer.jsp"%>















