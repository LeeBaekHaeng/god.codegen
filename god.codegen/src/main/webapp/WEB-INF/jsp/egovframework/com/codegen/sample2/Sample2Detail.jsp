<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : Sample2Register.jsp
  * @Description : Sample2 Register 화면
  * @Modification Information
  * 
  * @author 코드생성팀 이백행
  * @since 2022-04-24
  * @version 1.0
  * @see
  *  
  * Copyright (C) All right reserved.
  */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<c:set var="registerFlag" value="${empty sample2VO.id ? '등록' : '상세'}"/>

<title> <c:out value="${registerFlag}"/> </title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/>

<!--For Commons Validator Client Side-->
<!-- script type="text/javascript" src="<c:url value='/cmmn/validator.do'/>"></script -->
<!-- validator:javascript formName="sample2VO" staticJavascript="false" xhtml="true" cdata="false"/ -->

<script type="text/javaScript" language="javascript" defer="defer">
<!--
/* 글 목록 화면 function */
function fn_egov_selectList() {
	document.getElementById("detailForm").method = "get";
   	document.getElementById("detailForm").action = "<c:url value='/sample2/selectSample2List.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* 글 삭제 function */
function fn_egov_delete() {
   	document.getElementById("detailForm").action = "<c:url value='/sample2/deleteSample2.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* 글 등록 function */
function fn_egov_save() {	
	frm = document.getElementById("detailForm");

	/* TODO Validation기능 보완 */
	
  	frm.action = "<c:url value="${registerFlag == '등록' ? '/sample2/addSample2.do' : '/sample2/updateSample2.do'}"/>";
    frm.submit();

}

// -->
</script>
</head>
<body>

<form:form modelAttribute="sample2VO" name="detailForm" id="detailForm">
<div id="content_pop">
	<!-- 타이틀 -->
	<div id="title">
		<ul>
			<li><img src="<c:url value='/images//title_dot.gif'/>" alt="" /><c:out value="${registerFlag}"/></li>
		</ul>
	</div>
	<!-- // 타이틀 -->
	<div id="table">
	<table width="100%" border="1" cellpadding="0" cellspacing="0" >
		<colgroup>
			<col width="150"/>
			<col width=""/>
		</colgroup>
			
		<c:if test="${registerFlag == '상세'}">
	   <tr>
			<th>ID *</th>
			<td>
				<form:hidden path="id" />
				<c:out value="${sample2VO.id}" />
			</td>			
		</tr>	
		</c:if>
		<c:if test="${registerFlag == '등록'}">
	   <tr>
			<th>ID *</th>
			<td>
				<form:input path="id" cssClass="txt" readonly="false" />
			</td>			
		</tr>	
		</c:if>		
		<tr>
			<th>NAME</th>
			<td>
				<c:out value="${sample2VO.name}" />
			</td>
		</tr>	
		<tr>
			<th>DESCRIPTION</th>
			<td>
				<c:out value="${sample2VO.description}" />
			</td>
		</tr>	
		<tr>
			<th>USE_YN</th>
			<td>
				<c:out value="${sample2VO.useYn}" />
			</td>
		</tr>	
		<tr>
			<th>REG_USER</th>
			<td>
				<c:out value="${sample2VO.regUser}" />
			</td>
		</tr>	
	</table>
  </div>
	<div id="sysbtn">
		<ul>
			<li><span class="btn_blue_l"><a href="javascript:fn_egov_selectList();">List</a><img src="<c:url value='/images//btn_bg_r.gif'/>" alt="" /></span></li>
			<c:if test="${registerFlag == '상세'}">
			<li><span class="btn_blue_l"><a href="javascript:fn_egov_delete();">삭제</a><img src="<c:url value='/images//btn_bg_r.gif'/>" alt="" /></span></li>
			</c:if>
	</div>
</div>
<!-- 검색조건 유지 -->
<form:hidden path="searchCondition" />
<form:hidden path="searchKeyword" />
<form:hidden path="pageIndex" />
</form:form>
</body>
</html>

