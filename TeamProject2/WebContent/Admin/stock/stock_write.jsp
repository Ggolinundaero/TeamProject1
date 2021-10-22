<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ include file="/include/header.jsp"%>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" /> 
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script> 
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-title">재고관리 등록</h2>
	</div>
	
	<div class="write-form">
	<form name="insert" method="post" action="/Admin/stock/stock_write_pro.do?page=${page}">
		<input type="hidden" name="resive_state" value="Y">
		<table summery="재고관리 테이블 입니다">
			<caption class="readonly">재고관리 입력폼</caption>			
			<colgroup>
				<col width="20%">
				<col width="80%">
			</colgroup>
			<tbody>
					<tr>
						<th>부품종류</th>
						<td>
						<c:if test="${vo.kinds=='레버'}"><input type="checkbox" name="kinds" value="레버" checked>레버</c:if>
						<c:if test="${vo.kinds=='아케이드버튼'}"><input type="checkbox" name="kinds" value="레버" checked>아케이드버튼</c:if>
						<c:if test="${vo.kinds=='리듬게임버튼'}"><input type="checkbox" name="kinds" value="레버" checked>리듬게임버튼</c:if>
						<c:if test="${vo.kinds=='부품'}"><input type="checkbox" name="kinds" value="레버" checked>부품</c:if>
						
						</td>
						
					</tr>
					<tr>
					<th>발주번호</th>
						<td><input type="text" name="order_code" value="${vo.order_code}"></td>
					</tr>
					<tr>
						<th>회사명</th>
						<td><input type="text" name="company_name" value="${vo.company_name}"></td>
					</tr>
					<tr>
						<th>제품명</th>
						<td><input type="text" name="stock" value="${vo.stock}"></td>
					</tr>
					<tr>
						<th>모델명</th>
						<td><input type="text" name="model_name" value="${vo.model_name}"></td>
					</tr>
					<tr>
						<th>가격</th>
						<td>
							<input type="text" name="model_price" value="${vo.unit_cost}">
						</td>
					</tr>
					<tr>
						<th>수량</th>
						<td><input type="text" name="stock_amount" value="${vo.amount}"></td>
					</tr>
					<tr>
						<th>옵션</th>
						<td><input type="text" name="option_status" value="${vo.o_option}"></td>
					</tr>
					<tr>
						<th>색상</th>
						<td><input type="text" name="parts_status" value="${vo.color}"></td>
					</tr>	
					<tr>
						<td colspan="2">
							<input type="button" value="전송" class="btn-write" onClick="javascript:send()">
							<input type="button" value="목록"  class="btn-reset" onclick="javascript:location.href='/Admin/stock/Stock_list.do?pgae=${page}'">
						</td>
					</tr>
			</tbody>
		</table>
		</form>
		
	</div>
		
</div>

<script>
	function send() {
		insert.submit();
	}
$(function() { $( "#Date" ).datepicker({ }); });	
</script>

<%@ include file="/include/footer.jsp"%>















