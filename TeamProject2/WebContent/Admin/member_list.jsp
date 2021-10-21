<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${row==1}">
	<script>
		alert("삭제되었습니다..");
		location.href="/Admin/admin_list.do";
	</script>
</c:if>
<c:if test="${row==0}">
	<script>
		alert("삭제실패하였습니다.");
		history.back();
	</script>
</c:if>
<html>
<head>
<title>협력업체 관리 - 관리자페이지</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css"> 
<!-- 
body,td,tr,table{font-size:9pt; font-family:tahoma;color:#666666;line-height:160%;} 

A:link {font-family:tahoma;font-size:9pt;color:#666666;text-decoration:none;} 
A:visited {font-family:tahoma;font-size:9pt;color:#666666;text-decoration:none;} 
A:active {font-family:tahoma;font-size:9pt;color:#666666;text-decoration:none;} 
A:hover {font-family:tahoma;font-size:9pt;color:#009900;text-decoration:underline;} 
--> 
</style> 

</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td><jsp:include page="top_menu.jsp" flush="true" /></td></tr>
	<tr>
		<td align="center" height="100%" valign=middle><br>
			<table width="30%" border="1" cellspacing="0" cellpadding="3" bgcolor="#FFCC66" bordercolor="#FFFFFF" bordercolorlight="#000000">
				<tr> 
					<td height=40 align="center" style="font-size: 15px;"><b>회원정보리스트</b></a>
					</b></td>
				</tr>
			</table><br>
			<table width="80%" border="0" cellspacing="0" cellpadding="0">
				<tr>
                    <td height="20">* 총 회원수 : <font color=red>${totcount}</font> 명</td>
                  </tr>
                  <tr>
                    <td><table width="90%" border="0" cellpadding="6" cellspacing="1" bgcolor="DDDDDD">
                      <tr bgcolor="EcECEC">
						<td align="center" bgcolor="EcECEC"><strong>이름</strong></td>
						<td width="20%" align="center"><strong>아이디</strong></td>
                        <td width="20%" align="center"><strong>이메일</strong></td>
                        <td width="20%" align="center"><strong>가입일자</strong></td>
                        <td width="20%" align="center"><strong>최근로그인</strong></td>
                      </tr>
                      
               <c:if test="${!empty list}">
				<c:forEach var="member" items="${list}">
						<tr>       
                        <td bgcolor="#FFFFFF">${member.name.substring(0,1).concat('xx')}</td>
                        <td align="center" bgcolor="#FFFFFF"><a href="/Admin/admin_view.do?userid=${member.userid}&page=${page}">${member.userid}</a></td>
						<td align="center" bgcolor="#FFFFFF">${member.email}</td>
						<td align="center" bgcolor="#FFFFFF">${member.first_time}</td>
						<td align="center" bgcolor="#FFFFFF">${member.last_time}</td>
						<c:if test="${member.userid !='sub3815'}"><td><a href="/Admin/admin_delete.do?userid=${member.userid}"><input type="button" value="탈퇴"></a></td></c:if>
                     	</tr>
                     </c:forEach>
                   </c:if>
                   	</form>   
	                  <tr>
                        <td height="35" colspan="10" align="center" bgcolor="#FFFFFF"></td>
                      </tr>
						<form action="/Admin/admin_list.do" method="post" name="search" onsubmit="return check()">
                      <tr>
                        <td colspan="7" align="center" bgcolor="#FFFFFF">${pageSkip}<table width="610" border="0" cellspacing="0" cellpadding="0">
                            <tr>
							
                              <td width=80% height="30" colspan="2" align="right">
								<select name="search" class="textfield">
									<option value="userid"<c:if test="${search=='userid'}"> selected </c:if>>아이디</option>
									<option value="name"<c:if test="${search=='name'}"> selected </c:if>>이름</option>
								</select>
								<input name="key" type="text" class="textfield" size="30" value="${key}"></td>
                              <td width=20% align="right"><input type="submit" value="검색" class="btn"> &nbsp;
                              
                            </tr>
                        </table></td>
                      </tr>
					</form>
                    </table>
                </td>
            </tr>
       </table>
  </td>
  </tr>
  </table>                  
</body>
</html>
<script>
	function check() {
		if(search.key.value=="") {
			alert("검색단어입력하세요");
			search.key.focus;
			return false;
		}
		return true;
	}
	function del(){
		if(confirm("탈퇴시키시겠습니까?") == true) {
			admins.action="/Admin/admin_delete.do";
			admins.submit();
		}else{
			return;
		}
	}
</script>