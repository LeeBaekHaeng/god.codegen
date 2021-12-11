<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : ComtcadministcoderecptnlogList.jsp
  * @Description : Comtcadministcoderecptnlog List 화면
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
<title>목록</title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/>
<script type="text/javaScript" language="javascript" defer="defer">
<!--
/* 글 수정 화면 function */


function fn_egov_select(occrrncDe, administZoneSe, administZoneCode, opertSn) {
	document.getElementById("listForm").occrrncDe.value = occrrncDe;
	document.getElementById("listForm").administZoneSe.value = administZoneSe;
	document.getElementById("listForm").administZoneCode.value = administZoneCode;
	document.getElementById("listForm").opertSn.value = opertSn;
   	document.getElementById("listForm").action = "<c:url value='/comtcadministcoderecptnlog/updateComtcadministcoderecptnlogView.do'/>";
   	document.getElementById("listForm").submit();
}

/* 글 등록 화면 function */
function fn_egov_addView() {
   	document.getElementById("listForm").action = "<c:url value='/comtcadministcoderecptnlog/addComtcadministcoderecptnlogView.do'/>";
   	document.getElementById("listForm").submit();		
}

/* pagination 페이지 링크 function */
function fn_egov_link_page(pageNo){
	document.getElementById("listForm").pageIndex.value = pageNo;
	document.getElementById("listForm").action = "<c:url value='/comtcadministcoderecptnlog/ComtcadministcoderecptnlogList.do'/>";
   	document.getElementById("listForm").submit();
}

 // -->
</script>
</head>
<body>
<form:form commandName="searchVO" name="listForm" id="listForm" method="post">
	<input type="hidden" name="occrrncDe" />
	<input type="hidden" name="administZoneSe" />
	<input type="hidden" name="administZoneCode" />
	<input type="hidden" name="opertSn" />
<div id="content_pop">
	<!-- 타이틀 -->
	<div id="title">
		<ul>
			<li><img src="<c:url value='/images/egovframework/example/title_dot.gif'/>" alt="title" /> List </li>
		</ul>
	</div>
	<!-- // 타이틀 -->
	<!-- List -->
	<div id="table">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<colgroup>
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
							</colgroup>		  
			<tr>
								<th align="center">OccrrncDe</th>
								<th align="center">AdministZoneSe</th>
								<th align="center">AdministZoneCode</th>
								<th align="center">OpertSn</th>
								<th align="center">ChangeSeCode</th>
								<th align="center">ProcessSe</th>
								<th align="center">AdministZoneNm</th>
								<th align="center">LowestAdministZoneNm</th>
								<th align="center">CtprvnCode</th>
								<th align="center">SignguCode</th>
								<th align="center">EmdCode</th>
								<th align="center">LiCode</th>
								<th align="center">CreatDe</th>
								<th align="center">AblDe</th>
								<th align="center">AblEnnc</th>
								<th align="center">FrstRegisterId</th>
								<th align="center">FrstRegistPnttm</th>
								<th align="center">LastUpdusrId</th>
								<th align="center">LastUpdtPnttm</th>
							</tr>
			<c:forEach var="result" items="${resultList}" varStatus="status">
			<tr>
																															<td align="center" class="listtd"><c:out value="${result.occrrncDe}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.administZoneSe}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.administZoneCode}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.opertSn}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.changeSeCode}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.processSe}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.administZoneNm}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.lowestAdministZoneNm}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.ctprvnCode}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.signguCode}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.emdCode}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.liCode}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.creatDe}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.ablDe}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.ablEnnc}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.frstRegisterId}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.frstRegistPnttm}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.lastUpdusrId}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.lastUpdtPnttm}"/>&nbsp;</td>
				    			</tr>
			</c:forEach>
		</table>
	</div>
	<!-- /List -->
	<div id="paging">
		<ui:pagination paginationInfo = "${paginationInfo}"
				   type="image"
				   jsFunction="fn_egov_link_page"
				   />
		<form:hidden path="pageIndex" />
	</div>
	<div id="sysbtn1">
		<ul>
			<li>
				<div id="sysbtn">
					<span class="btn_blue_l"><a href="javascript:fn_egov_addView();">등록</a><img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>" alt="" />
					</span>
				</div>
			</li>
		</ul>
	</div>
</div>
</form:form>
</body>
</html>
