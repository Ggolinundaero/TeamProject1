<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*, Model.Admin.Recive.*" %>
<%
ReceiveDAO dao = ReceiveDAO.getInstance();
ReceiveVO vo = new ReceiveVO();
List<ReceiveVO> list = new ArrayList<ReceiveVO>();
list = dao.LeverList();
%>



<%@ include file="/include/header.jsp"%>

<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" /> 
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script> 
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-title">제품입고 등록</h2>
	</div>
	
	<div class="write-form">
		<table summery="입고등록 테이블 입니다">
			<caption class="readonly">입고등록 입력폼</caption>			
			<colgroup>
				<col width="20%">
				<col width="80%">
			</colgroup>
			<tbody>
			<form name="my" method="post" action="qainsert.do" enctype="multipart/form-data" onsubmit="return formcheck();">
					<tr>
						<th>부품종류</th>
						<td>
						<select name = "chk">
						<option value = "lever">레버</option>
						<option value = "button">버튼</option>
						</select>
						</td>
					
					</tr>
					<tr>
						<th>게임종류</th>
						<td>
						<select name="kind" name="game">
							<option value="action"> 액션 </option>
							<option value="shooting"> 슈팅 </option>
							<option value="vr"> VR게임 </option>
							<option value="arcade"> 아케이드 </option>
							<option value="racing"> 레이싱 </option>
							<option value="crain"> 크래인 </option>
						</select>
						</td>
					</tr>
				
					<tr>
						<th>제품명</th>
						
						<td>
						
						<select name = "lever">
						<%for(int x=0; x<list.size();x++){ %>
						<option value = "<%=list.get(x).getL_name() %>"><%=list.get(x).getL_name() %></option>
						<%} %>
						</select>
						
						
						<select id="llever"></select>
						
						</td>
					</tr>
					
					

					<tr>
						<th>수량</th>
						<td><input type="text" name="pay" value=""></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><input type="text" name="member" value=""></td>
					</tr>
					<tr>
						<th>입고일</th>
						<td><input type="text" name="date" id="Date"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="전송" class="btn-write">
							<input type="button" value="목록"  class="btn-reset" onclick="javascript:location.href='qa.do'">
						</td>
					</tr>
				</form>
			</tbody>
		</table>
	</div>
		
</div>

<script>
	function formcheck() {
		if(my.title.value=="") {
			alert("제목입력하세요");
			my.title.focus();
			return false;
		}
		if(my.content.value=="") {
			alert("내용입력하세요");
			my.contnet.focus();
			return false;
		}
		return true;
	}
$(function() { $( "#Date" ).datepicker({ }); });





var selectItem = $("#chk").val();

var changeItem;
  
if(selectItem == "lever"){
  changeItem = llever;
}
else if(selectItem == "button"){
  changeItem = button;
}

</script>

<%@ include file="/include/footer.jsp"%>















