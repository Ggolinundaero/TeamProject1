<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="Model.Admin.Order.*,java.util.*" %>

<%
	request.setCharacterEncoding("utf-8");
	OrderDAO dao = OrderDAO.getInstance();
	List<OrderVO> list = dao.order_List();
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function have(){
		alert("재고처리가 왼료된 작업입니다.");
		location.href="resive.do?page="+${page};
	}
	function send(){
		alert("재고등록 페이지로 이동합니다.");
		insert.submit();
	}
</script>
</head>
<body>

</body>
<%@ include file="/include/header.jsp"%>

<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-title">입고현황</h2>
		<div class="sub-search">
			
			<form name="my" method="post" action="/Admin/stock/Stock_list.do" onsubmit="return check()">
			
				<select name="search" class="sel">
					<option value="title">오더코드</option>
				</select>
				<input type="text" name="key" value="${key}" class="text">
				<input type="submit" value="검색" class="btn">
			</form>
		</div>
	</div>
	
	<div class="content-body">
	<form name="insert" method="post" action="/Admin/stock/stock_write.do">
		<table class="qatable">
			<caption class="readonly">재고관리 표</caption>
			<colgroup>
				<col width="33%">
				<col width="33%">
				<col width="33%">
			</colgroup>
				<tr>
					<th>번호</th>
					<th>발주코드</th>
					<th>재고처리현황</th>
				</tr>
				<c:if test="${empty list}">
						<tr class="text_center">
							<th colspan="100%">입고현황이 없습니다.</th>
						</tr>
				</c:if>
				<c:if test="${!empty list}">
				<c:forEach var="order" items="${list}">
				<tr>
					<td >${listcount}</td>
					<td>${order.order_code}</td>
					<c:if test ="${order.resive_state=='N'}">
					<td><a href="/Admin/stock/stock_write.do?order_code=${order.order_code}&page=${page}">
					<input type="button" value="미완"></a>
					</td>
					</c:if>
					<c:if test="${order.resive_state=='Y'}">
					<td><input type="button" value="완료" onclick="have()"></td>
					</c:if>
				</tr>
				
				<c:set var="listcount" value ="${listcount-1}"/>
				</c:forEach>
				</c:if>
			</table>
		</form>
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















