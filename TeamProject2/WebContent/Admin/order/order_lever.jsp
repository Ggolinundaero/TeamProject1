<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/include/header.jsp"%>

<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-title">발주등록 - 레버</h2>
		<div class="sub-search">
			<form name="my" method="post" action="/Admin/order/order_lever.do" onsubmit="return check()">
				<select name="search" class="sel">
					<option value="t_name"<c:if test="${search=='t_name'}"> selected </c:if>>제품명</option>
					<option value="company"<c:if test="${search=='company'}"> selected </c:if>>회사명</option>
					<option value="t_model"<c:if test="${search=='t_model'}"> selected </c:if>>모델</option>
				</select>
				<input type="text" name="key" class="text" value="${key}">
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
<c:if test="${!empty list}">
	<c:forEach var="order" items="${list}">					
				<tr>
					<td><input type="button" name="cart" value = "전송"></td>
					<td>${order.company}</td>
					<td>${order.t_name}</td>
					<td>${order.t_model}</td>
					<td>${order.price}</td>
					<td><select name = "color">
					<option value = "1">1</option>
					<option value = "2">2</option>
					<option value = "3">3</option>
					<option value = "4">4</option>
					<option value = "5">5</option>
					
				</select></td>
					<td><select name = "color">
					<option value = "A">빨강</option>
					<option value = "B">파랑</option>
					<option value = "C">초록</option>
				</select></td>
				<td><select name = "parts">
					<option value = "A">더스트커버</option>
					<option value = "B">윤활</option>
				</select></td>
					
				</tr>
		</c:forEach>
	</c:if>					
			</tbody>
		</table>
	</div>
	</form>
		
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















