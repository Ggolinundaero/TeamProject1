<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/include/header.jsp"%>

<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-title">재고관리</h2>
		<div class="sub-search">
			<form name="my" method="post" action="qasearch.do" onsubmit="return check()">
				<select name="sel" class="sel">
					<option value="title">장르명</option>
					<option value="content">회사명</option>
					<option value="content">제품명</option>
					<option value="content">모델</option>
				</select>
				<input type="text" name="cont" class="text">
				<input type="submit" value="검색" class="btn">
			</form>
		</div>
	</div>
	
	<div class="content-body">
		<table class="qatable">
			<caption class="readonly">재고관리 표</caption>
			<colgroup>
				<col width="10%">
				<col width="9%">
				<col width="20%">
				<col width="20%">
				<col width="17%">
				<col width="18%">
				<col width="6%">
			</colgroup>
			<tbody>
				<tr>
					<th>번호</th>
					<th>회사</th>
					<th>제품명</th>
					<th>모델명</th>
					
					<th>부속품</th>
					<th>옵션</th>
					<th>수량</th>
				</tr>
				<tr>
					<td>10</td>
					<td class="tleft"><a href="#">IST(명신)</a></td>
					<td><a href="stock_view.jsp">무릎레버</a></td>
					<td><span  class="red">ISL-69S-C KNEE</td>
					<td>더스트커버</td>
					<td>빨강 30g</td>
					<td>23개</td>
				</tr>
			</tbody>
		</table>
	</div>
		
		
		<div class="paging">
			<ul>
				<li><a href="#">이전</a></li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li><a href="#">다음</a></li>
			</ul>
				<input type="button" value="등록"  class="btn-reset" onclick="javascript:location.href='/Admin/stock/stock_write.jsp'">
		</div>
</div>
<script>
	function check() {
		if(my.cont.value=="") {
			alert("검색단어입력하세요");
			my.cont.focus;
			return false;
		}
		return true;
	}
</script>

<%@ include file="/include/footer.jsp"%>















