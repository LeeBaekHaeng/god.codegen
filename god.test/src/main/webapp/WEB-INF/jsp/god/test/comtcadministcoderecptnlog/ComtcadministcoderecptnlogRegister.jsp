<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : ComtcadministcoderecptnlogRegister.jsp
  * @Description : Comtcadministcoderecptnlog Register 화면
  * @Modification Information
  * 
  * @author 이백행
  * @since 2021-12-11 18:58:51
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

<c:set var="registerFlag" value="${empty comtcadministcoderecptnlogVO.occrrncDe ? '등록' : '수정'}"/>

<title> <c:out value="${registerFlag}"/> </title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/>

<!--For Commons Validator Client Side-->
<!-- script type="text/javascript" src="<c:url value='/cmmn/validator.do'/>"></script -->
<!-- validator:javascript formName="comtcadministcoderecptnlogVO" staticJavascript="false" xhtml="true" cdata="false"/ -->

<script type="text/javaScript" language="javascript" defer="defer">
<!--
/* 글 목록 화면 function */
function fn_egov_selectList() {
   	document.getElementById("detailForm").action = "<c:url value='/comtcadministcoderecptnlog/ComtcadministcoderecptnlogList.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* 글 삭제 function */
function fn_egov_delete() {
   	document.getElementById("detailForm").action = "<c:url value='/comtcadministcoderecptnlog/deleteComtcadministcoderecptnlog.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* 글 등록 function */
function fn_egov_save() {	
	frm = document.getElementById("detailForm");

	/* TODO Validation기능 보완 */
	
  	frm.action = "<c:url value="${registerFlag == '등록' ? '/comtcadministcoderecptnlog/addComtcadministcoderecptnlog.do' : '/comtcadministcoderecptnlog/updateComtcadministcoderecptnlog.do'}"/>";
    frm.submit();

}

// -->
</script>
</head>
<body>

<form:form commandName="comtcadministcoderecptnlogVO" name="detailForm" id="detailForm" >
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
			
		<c:if test="${registerFlag == '수정'}">
	   <tr>
			<th>OCCRRNC_DE *</th>
			<td>
				<form:input path="occrrncDe" cssClass="essentiality" readonly="true" />
			</td>			
		</tr>	
		</c:if>
		<c:if test="${registerFlag == '등록'}">
	   <tr>
			<th>OCCRRNC_DE *</th>
			<td>
				<form:input path="occrrncDe" cssClass="txt" readonly="false" />
			</td>			
		</tr>	
		</c:if>		
		<tr>
			<th>OCCRRNC_DE</th>
			<td>
				<form:input path="occrrncDe" cssClass="txt"/>
				&nbsp;<form:errors path="occrrncDe" />
			</td>
		</tr>	
		<tr>
			<th>ADMINIST_ZONE_SE</th>
			<td>
				<form:input path="administZoneSe" cssClass="txt"/>
				&nbsp;<form:errors path="administZoneSe" />
			</td>
		</tr>	
		<tr>
			<th>ADMINIST_ZONE_CODE</th>
			<td>
				<form:input path="administZoneCode" cssClass="txt"/>
				&nbsp;<form:errors path="administZoneCode" />
			</td>
		</tr>	
		<tr>
			<th>OPERT_SN</th>
			<td>
				<form:input path="opertSn" cssClass="txt"/>
				&nbsp;<form:errors path="opertSn" />
			</td>
		</tr>	
		<tr>
			<th>CHANGE_SE_CODE</th>
			<td>
				<form:input path="changeSeCode" cssClass="txt"/>
				&nbsp;<form:errors path="changeSeCode" />
			</td>
		</tr>	
		<tr>
			<th>PROCESS_SE</th>
			<td>
				<form:input path="processSe" cssClass="txt"/>
				&nbsp;<form:errors path="processSe" />
			</td>
		</tr>	
		<tr>
			<th>ADMINIST_ZONE_NM</th>
			<td>
				<form:input path="administZoneNm" cssClass="txt"/>
				&nbsp;<form:errors path="administZoneNm" />
			</td>
		</tr>	
		<tr>
			<th>LOWEST_ADMINIST_ZONE_NM</th>
			<td>
				<form:input path="lowestAdministZoneNm" cssClass="txt"/>
				&nbsp;<form:errors path="lowestAdministZoneNm" />
			</td>
		</tr>	
		<tr>
			<th>CTPRVN_CODE</th>
			<td>
				<form:input path="ctprvnCode" cssClass="txt"/>
				&nbsp;<form:errors path="ctprvnCode" />
			</td>
		</tr>	
		<tr>
			<th>SIGNGU_CODE</th>
			<td>
				<form:input path="signguCode" cssClass="txt"/>
				&nbsp;<form:errors path="signguCode" />
			</td>
		</tr>	
		<tr>
			<th>EMD_CODE</th>
			<td>
				<form:input path="emdCode" cssClass="txt"/>
				&nbsp;<form:errors path="emdCode" />
			</td>
		</tr>	
		<tr>
			<th>LI_CODE</th>
			<td>
				<form:input path="liCode" cssClass="txt"/>
				&nbsp;<form:errors path="liCode" />
			</td>
		</tr>	
		<tr>
			<th>CREAT_DE</th>
			<td>
				<form:input path="creatDe" cssClass="txt"/>
				&nbsp;<form:errors path="creatDe" />
			</td>
		</tr>	
		<tr>
			<th>ABL_DE</th>
			<td>
				<form:input path="ablDe" cssClass="txt"/>
				&nbsp;<form:errors path="ablDe" />
			</td>
		</tr>	
		<tr>
			<th>ABL_ENNC</th>
			<td>
				<form:input path="ablEnnc" cssClass="txt"/>
				&nbsp;<form:errors path="ablEnnc" />
			</td>
		</tr>	
		<tr>
			<th>FRST_REGISTER_ID</th>
			<td>
				<form:input path="frstRegisterId" cssClass="txt"/>
				&nbsp;<form:errors path="frstRegisterId" />
			</td>
		</tr>	
		<tr>
			<th>FRST_REGIST_PNTTM</th>
			<td>
				<form:input path="frstRegistPnttm" cssClass="txt"/>
				&nbsp;<form:errors path="frstRegistPnttm" />
			</td>
		</tr>	
		<tr>
			<th>LAST_UPDUSR_ID</th>
			<td>
				<form:input path="lastUpdusrId" cssClass="txt"/>
				&nbsp;<form:errors path="lastUpdusrId" />
			</td>
		</tr>	
		<tr>
			<th>LAST_UPDT_PNTTM</th>
			<td>
				<form:input path="lastUpdtPnttm" cssClass="txt"/>
				&nbsp;<form:errors path="lastUpdtPnttm" />
			</td>
		</tr>	
	</table>
  </div>
	<div id="sysbtn">
		<ul>
			<li><span class="btn_blue_l"><a href="javascript:fn_egov_selectList();">List</a><img src="<c:url value='/images//btn_bg_r.gif'/>" alt="" /></span></li>
			<li><span class="btn_blue_l"><a href="javascript:fn_egov_save();"><c:out value='${registerFlag}'/></a><img src="<c:url value='/images//btn_bg_r.gif'/>" alt="" /></span></li>
			<c:if test="${registerFlag == '수정'}">
			<li><span class="btn_blue_l"><a href="javascript:fn_egov_delete();">삭제</a><img src="<c:url value='/images//btn_bg_r.gif'/>" alt="" /></span></li>
			</c:if>
			<li><span class="btn_blue_l"><a href="javascript:document.detailForm.reset();">Reset</a><img src="<c:url value='/images//btn_bg_r.gif'/>" alt="" /></span></li></ul>
	</div>
</div>
<!-- 검색조건 유지 -->
<input type="hidden" name="searchCondition" value="<c:out value='${searchVO.searchCondition}'/>"/>
<input type="hidden" name="searchKeyword" value="<c:out value='${searchVO.searchKeyword}'/>"/>
<input type="hidden" name="pageIndex" value="<c:out value='${searchVO.pageIndex}'/>"/>
</form:form>
</body>
</html>

