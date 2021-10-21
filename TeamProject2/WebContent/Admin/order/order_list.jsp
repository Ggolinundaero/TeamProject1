<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/include/header.jsp"%>

<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-title">발주현황</h2>
		<div class="sub-search">
			<form name="my" method="post" action="qasearch.do" onsubmit="return check()">
				<select name="sel" class="sel">
					<option value="title">제품명</option>
					<option value="content">회사명</option>
					<option value="content">발주번호</option>
					<option value="content">완/미완</option>
				</select>
				<input type="text" name="cont" class="text">
				<input type="submit" value="검색" class="btn">
			</form>
		</div>
	</div>
	
	<div class="content-body">
		<table class="qatable">
			<caption class="readonly">발주</caption>
			<colgroup>
				<col width="10%">
				<col width="9%">
				<col width="18%">
				<col width="20%">
				<col width="12%">
				<col width="13%">
				<col width="11%">
				<col width="7%">
			</colgroup>
			<tbody>
				<tr>
					<th>발주번호</th>
					<th>회사</th>
					<th>제품명</th>
					<th>모델명</th>
					<th>가격</th>
					<th>발주자</th>
					<th>상세사항</th>
					<th>수량</th>
				</tr>
				<tr>
					<td>AS20210924</td>
					<td class="tleft"><a href="#">IST(명신)</a></td>
					<td><a href="#">무릎레버</a></td>
					<td><span  class="red">ISL-69S-C KNEE</td>
					<td>68,800</td>
					<td>타쿠왕 킹지현</td>
					<td><a href="#">5종류의색상</a></td>
					<td>23개</td>
				</tr>
			</tbody>
		</table>
	</div>
		<div class="paging">
			<ul>
				<li><a href="#">이전</a></li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li><a href="#">다음</a></li>
			</ul>
		</div>
</div>
<script>
	function check() {
		if(my.cont.value=="") {
			alert("검색단어입력하세요");
			my.cont.focus;
			return false;
		}
		return true;
	}
</script>

<%@ include file="/include/footer.jsp"%>















