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
		<h2 class="sub-title">가게매출 등록</h2>
	</div>
	
	<div class="write-form">
		<form name = "sales" method = "post">
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
						<th>현금매출</th>
						<td><input type="text" name="cash" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"></td>
					</tr>
					<tr>
						<th>카드매출</th>
						<td><input type="text" name="card" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"></td>
					</tr>
					<tr>
						<th>카드충전(현금)</th>
						<td><input type="text" name="cash_charge" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"></td>
					</tr>
					<tr>
						<th>카드충전(카드)</th>
						<td><input type="text" name="card_charge" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"></td>
					</tr>
					
					<tr>
						<td colspan="2">
							<input type="submit" value="등록" onClick = "send()">
							<input type="button" value="취소" onClick = "history.back()">
						</td>
					</tr>
			
			</tbody>
		</table>
			</form>
	</div>
		
</div>

<script>
	function send() {
		alert("등록중...");
		sales.action = "/Admin/acount/day_acount_shop_pro.do";
		sales.submit();
	}
$(function() { $( "#Date" ).datepicker({ }); });	
</script>

<%@ include file="/include/footer.jsp"%>















