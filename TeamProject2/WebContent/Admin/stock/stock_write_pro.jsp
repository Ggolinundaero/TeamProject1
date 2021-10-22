<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
 <c:if test ="${row==1}">
 	<script>
 	alert("등록완료");
 	</script>
 </c:if>
 <c:if test ="${row!=1}">
 	<script>
 	alert("등록실패 \n잠시후 다시 시도해 주세요.");
	location.href="/Admin/stock/stock_write.do?page=${page}";
 	</script>
 </c:if>
<c:if test="${row1==1}">
	<script>
	location.href="/Admin/stock/resive.do?page=${page}"
	</script>
</c:if>