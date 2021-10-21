<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/include/header.jsp"%>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" /> 
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script> 
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-title">재고관리 등록</h2>
	</div>
	
	<div class="write-form">
		<table summery="재고관리 테이블 입니다">
			<caption class="readonly">재고관리 입력폼</caption>			
			<colgroup>
				<col width="20%">
				<col width="80%">
			</colgroup>
			<tbody>
			<form name="my" method="post" action="qainsert.do" enctype="multipart/form-data" onsubmit="return formcheck();">
					<tr>
						<th>부품종류</th>
						<td><input type="checkbox" name="chk" value="0"> 레버
						<input type="checkbox" name="chk" value="1"> 버튼
						<input type="checkbox" name="chk" value="2"> 키보드
						<input type="checkbox" name="chk" value="3"> 발판
						<input type="checkbox" name="chk" value="4"> 앰프</td>
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
						<th>회사명</th>
						<td><input type="text" name="company" placeholder="회사명을 입력하세요"></td>
					</tr>
					<tr>
						<th>제품명</th>
						
						<td><input type="text" name="jepum"></td>
					</tr>
					<tr>
						<th>모델명</th>
						<td><input type="text" name="model"></td>
					</tr>
					<tr>
						<th>가격</th>
						<td>
							<input type="text" name="writer" value="">
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
						<th>작성날짜</th>
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
</script>

<%@ include file="/include/footer.jsp"%>















