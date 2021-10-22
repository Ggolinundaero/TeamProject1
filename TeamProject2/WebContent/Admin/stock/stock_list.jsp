e<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/include/header.jsp"%>
<%
	request.setCharacterEncoding("utf-8");
%>

<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-title">재고관리</h2>
		<div class="sub-search">
			<form name="my" method="post" action="/Admin/stock/Stock_list.do" onsubmit="return check()">
				<select name="search" class="sel">
					<option value="title">장르명</option>
					<option value="company_name">회사명</option>
					<option value="stock">제품명</option>
					<option value="model_name">모델</option>
				</select>
				<input type="text" name="key" value="${key}" class="text">
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
				<col width="15%">
				<col width="20%">
				<col width="15%">
				<col width="10%">
				<col width="10%">
				<col width="15%">
			</colgroup>
			<tbody>
				<tr>
					<th>번호</th>
					<th>제품명</th>
					<th>회사</th>
					<th>모델명</th>
					<th>옵션</th>
					<th>색상</th>
					<th>수량</th>
					<th>입고일</th>
				</tr>
				<c:if test="${empty list}">
					<tr class="text_center">
					<th colspan="100%">등록된 게시물이 없습니다.</th>
					</tr>
				</c:if>
				<c:if test="${!empty list}">
				<c:forEach var="stock" items="${list}">
				<tr>
					<td >${listcount}</td>
					<td><a href="/Admin/stock/stock_view.do?order_code=${stock.order_code}&page=${page}">${stock.stock}</a></td>
					<td><a href="">${stock.company_name}</a></td>
					<td><span  class="red">${stock.model_name}</td>
					<td>${stock.option_status}</td>
					<td>${stock.parts_status}</td>
					<td>${stock.stock_amount}개</td>
					<td>${stock.latest_day.substring(0,10)}</td>
				</tr>
				<c:set var="listcount" value ="${listcount-1}"/>
				</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
		
		
		<div class="paging">
			<ul>
				<c:if test="${page!=1}">
				<li><a href="/Admin/stock/Stock_list.do?page=${page-1}">이전</a></li>
				</c:if>
				<c:if test="${page==1}">
				<li><a href="javascript:alert1()">이전</a></li>
				</c:if>
				<li>${pageSkip}</li>
				<li><a href="/Admin/stock/Stock_list.do?page=${page+1}">다음</a></li>
			</ul>
				
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
	function alert1(){
		alert("이전으로 돌아갈수 없습니다.");
		locion.href="/Admin/stock/Stock_list.do?page=1"
	}
		
</script>

<%@ include file="/include/footer.jsp"%>















