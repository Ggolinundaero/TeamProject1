<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/include/header.jsp"%>

<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-view-title">입고현황 상세 출력</h2>
		<p class="sub-view-wd">제품명 | 입고일 | 수량 </p>
	</div>
	<div class="sub-view-contnet">
		<p>발주코드 : as20210928 </p>
		<p>입고등록 : admin <br>
		회사명 : <br>
		제품명 : <br>
		모델명 : </p>
		사진 :  <br>
		수량 :	<br>
		상품금액 :	<br>
		부가세 :	<br>
		총액 : 	<br>
		<p>
		<p>상세 사항(부속품,옵션등) : </p>
	</div>
	
	<div class="sub-view-bottom">
		<a href="qareply.do" class="btn-modify">수정</a>&nbsp;&nbsp;
		<a href="javascript:void(0)" class="btn-delete" onclick="avent();">삭제</a>&nbsp;&nbsp;
		<a href="qa.do" class="btn-list">목록</a>&nbsp;&nbsp;
	</div>
		
</div>
<script>
function avent(){
	if(confirm("후회안해? 삭제?") == true) {
		location.href="qadelete.do";
	}else {
		return;
	}
}
</script>


<%@ include file="/include/footer.jsp"%>















