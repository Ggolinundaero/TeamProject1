<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/include/header.jsp"%>

<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-title">발주등록-버튼(롤플레이)</h2>
		<div class="sub-search">
			<form name="my" method="post" action="#" onsubmit="return check()">
				<select name="search" class="sel">
					<option value="b_name"<c:if test="${search=='b_name'}"> selected </c:if>>제품명</option>
					<option value="company"<c:if test="${search=='company'}"> selected </c:if>>회사명</option>
					<option value="b_model"<c:if test="${search=='b_model'}"> selected </c:if>>모델</option>
				</select>
				<input type="text" name="key" class="text">
				<input type="submit" value="검색" class="btn">
			</form>
		</div>
	</div>
	<form name="bal" method="post">
	<div class="content-body">
		<table class="qatable">
			<caption class="readonly">발주</caption>
			<colgroup>
				<col width="10%">
				<col width="9%">
				<col width="20%">
				<col width="20%">
				<col width="12%">
				<col width="15%">
				<col width="14%">
			</colgroup>
			<tbody>
				<tr>
					<th>체크</th>
					<th>회사</th>
					<th>제품명</th>
					<th>모델명</th>
					<th>가격</th>
					<th>색상변환가능여부</th>
					<th>옵션추가가능여부</th>
				</tr>
<c:if test="${!empty rglist}">
	<c:forEach var="rgorder" items="${rglist}">					
				<tr>
					<td><input type="checkbox" name="chk"></td>
					<td>${rgorder.company}</td>
					<td>${rgorder.b_name}</td>
					<td>${rgorder.b_model}</td>
					<td>${rgorder.price}</td>
					<td>O</td>
					<td>O</td>
				</tr>
		</c:forEach>
	</c:if>					
			</tbody>
		</table>
	</div>
	</form>
		<div class="paging">
		<input type="button" value="전송"  class="btn-reset" onclick="javascript:location.href='/Admin/order/order_pro.jsp'">	
		</div>
</div>
<script>
	function check() {
		if(my.key.value=="") {
			alert("검색단어입력하세요");
			my.key.focus;
			return false;
		}
		return true;
	}
</script>

<%@ include file="/include/footer.jsp"%>















