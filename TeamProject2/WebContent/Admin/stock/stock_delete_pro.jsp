<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
 <c:if test ="${row==1}">
 	<script>
 	alert("삭제완료");
 	location.href="/Admin/stock/Stock_list.do?page=${page}"
 	</script>
 </c:if>
 <c:if test ="${row!=1}">
 	<script>
 	alert("삭제실패 \n잠시후 다시 시도해 주세요.");
	location.href="/Admin/stock/stock_view.do?page=${page}&order_code=${order_code}";
 	</script>
 </c:if>
