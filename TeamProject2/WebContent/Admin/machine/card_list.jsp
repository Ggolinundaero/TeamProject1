<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/include/header.jsp"%>

<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-title">카드 관리</h2>
		<div class="sub-search">
			<form name="my" method="post" action="/Admin/machine/card_list.do" onsubmit="return check()">
				<select name="search" class="sel">
					<option value="card_code"<c:if test="${search=='card_code'}"> selected </c:if>>카드넘버</option>
					<option value="user_code"<c:if test="${search=='user_code'}"> selected </c:if>>사용자</option>
				</select>
				<input type="text" name="key" class="text" value="${key}">
				<input type="submit" value="검색" class="btn">
			</form>
		</div>
	</div>
	<form name="card_list" method="post">
	<div class="content-body">
		<table class="qatable">
			<caption class="readonly">카드 관리</caption>
			<colgroup>
				<col width="10%">
				<col width="10%">
				<col width="10%">
			</colgroup>
			<tbody>
				<tr>
					<th>카드넘버</th>
					<th>잔액</th>
					<th>사용자</th>
				</tr>
				
			<c:if test="${!empty list}">
				<c:forEach var="card" items="${list}">					
				<tr>
					<td>${card.card_code}</td>
					<td>${card.now_fee}</td>
					<td>${card.user_code}</td>
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















