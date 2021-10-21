<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
백원 : <%=request.getParameter("OH") %><br>
오백원 : <%=request.getParameter("FH") %><br>
천원 : <%=request.getParameter("OT") %><br>
오천원 : <%=request.getParameter("FT") %><br>
만원 : <%=request.getParameter("TT") %><br>
오만원 : <%=request.getParameter("FTT") %><br>
총합 : <%=request.getParameter("total") %>

</body>
</html>