<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ page import="java.util.*, Model.Admin.Acount.*" %>
    <%@ page import="java.text.SimpleDateFormat" %>
<%
	AccountDAO dao = AccountDAO.getInstance();
AccountVO vo = new AccountVO();
List<AccountVO> list = new ArrayList<AccountVO>();
list = dao.MCList();
	Date nowTime = new Date();
	SimpleDateFormat sf = new SimpleDateFormat("yyyy년 MM월 dd일");
	
%>


<%@ include file="/include/header.jsp"%>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" /> 
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script> 
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-title">게임매출 등록</h2>
	</div>
	
	<div class="write-form">
		<form name="gamepay" method="post">
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
						<th>기기번호(이름)</th>
						<td>
						<select name = "machine_code">
						<%
						for(int x=0; x<list.size();x++){
						%>
						<option value = "<%=list.get(x).getMachine_code() %>"><%=list.get(x).getMachine_code() %>
						<%
						}
						%>
						</select>
						
						</td>
					</tr>
					
					<tr>
						<th>매출</th>
						<td>현금
						<input type="text" name="cash" size = "6" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">카드<input type="text" name="card" size = "6" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"></td>
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
	function send() {
		alert("등록중...");
		gamepay.action = "/Admin/acount/day_acount_game_pro.do";
		gamepay.submit();
	}
$(function() { $( "#Date" ).datepicker({ }); });	
</script>

<%@ include file="/include/footer.jsp"%>















