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
		<h2 class="sub-title">수리 등록</h2>
	</div>
	
	<div class="write-form">
		<form name="accountrepair" method="post">
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
						<th>수리기계</th>
						<td><input type="text" name="repair_machine"></td>
					</tr>
					<tr>
						<th>수리내용</th>
						<td><textarea name="repair_comment" cols="30" rows="5"></textarea></td>
					</tr>
					<tr>
						<th>수리비용(원)</th>
						<td><input type="text" name="repair_pay" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" value = ""></td>
					</tr>
					
					
					<tr>
						<td colspan="2">
							<input type="submit" value="등록" class="btn-write" onClick = "send()">
							<input type="button" value="취소"  class="btn-reset" onClick = "history.back()">
						</td>
					</tr>
			
			</tbody>
		</table>
			</form>
	</div>
		
</div>

<script>
	function send() {
		if(accountrepair.repair_machine.value=="") {
			alert("제목입력하세요");
			accountrepair.repair_machine.focus();
			return;
		}
		if(accountrepair.repair_comment.value=="") {
			alert("내용입력하세요");
			accountrepair.repair_comment.focus();
			return;
		}
		alert("등록중...");
		accountrepair.action = "/Admin/acount/day_acount_repair_pro.do";
		accountrepair.submit();
	}
</script>

<%@ include file="/include/footer.jsp"%>















