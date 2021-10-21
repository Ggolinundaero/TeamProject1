<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/include/header.jsp"%>

<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-title">기기 관리</h2>
		<div class="sub-search">
			<form name="my" method="post" action="/Admin/machine/machine_list.do" onsubmit="return check()">
				<select name="search" class="sel">
					<option value="machine_code"<c:if test="${search=='machine_code'}"> selected </c:if>>기기코드</option>
					<option value="company_name"<c:if test="${search=='company_name'}"> selected </c:if>>회사명</option>
					<option value="game_name"<c:if test="${search=='game_name'}"> selected </c:if>>게임명</option>
					<option value="machine_model"<c:if test="${search=='machine_model'}"> selected </c:if>>기기모델명</option>
				</select>
				<input type="text" name="key" class="text" value="${key}">
				<input type="submit" value="검색" class="btn">
			</form>
		</div>
	</div>
	<form name="machine_list" method="post">
	<div class="content-body">
		<table class="qatable">
			<caption class="readonly">기기 관리</caption>
			<colgroup>
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
			</colgroup>
			<tbody>
				<tr>
					<th>기기코드</th>
					<th>회사명</th>
					<th>게임명</th>
					<th>기기모델명</th>
					<th>렌터여부</th>
					<th>튜닝여부</th>
					<th>고장여부</th>
					<th>사용료</th>
				</tr>
				
			<c:if test="${!empty list}">
				<c:forEach var="machine" items="${list}">					
				<tr>
					<td>${machine.machine_code}</td>
					<td>${machine.company_name}</td>
					<td>${machine.game_name}</td>
					<td>${machine.machine_model}</td> 
					<td>${machine.renter_chk}</td>
					<td>${machine.tuning_chk}</td>
					<td>${machine.broken_chk}</td>
					<td>${machine.play_fee}</td>
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















