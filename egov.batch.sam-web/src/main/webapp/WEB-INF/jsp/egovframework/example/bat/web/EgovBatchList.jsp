<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
  /**
  * @Class Name : batchList.jsp
  * @Description : Job 실행 템플릿 List 화면
  * @Modification Information
  * 
  *   수정일         수정자                   수정내용
  *  -------    --------    ---------------------------
  *  2012.08.02            최초 생성
  *
  * author 실행환경 개발팀
  * since 2012.08.02
  *  
  */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Job 실행 템플릿 예제 List(SAM)</title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/batch.css'/>"/>
<script type="text/javaScript" language="javascript" defer="defer">
<!--
/* Job 실행 function */
function fn_egov_batchRun() {
   	document.listForm.action = "<c:url value='./batchRun.do'/>";
   	document.listForm.submit();		
}
-->
</script>
</head>

<body style="text-align:center; margin:0 auto; display:inline; padding-top:100px;">
<div id="content_pop">
	<!-- 타이틀 -->
	<div id="title">
		<ul>
			<li><img src="<c:url value='/images/egovframework/batch/title_dot.gif'/>" alt="" /> Job 실행 템플릿 List </li>
		</ul>
	</div>
	<!-- Job List -->
	<form:form commandName="searchVO" id="listForm"  name="listForm" method="post">
    	<div id="table">
    		<table width="100%" border="0" cellpadding="0" cellspacing="0">
    			<colgroup>
    				<col width="40"/>				
    				<col width="50"/>
    				<col width="%"/>
    			</colgroup>		  
    			<tr>
    				<th align="center">No</th>
    				<th align="center">작업선택</th>
    				<th align="center">Job 이름</th>
    			</tr>
    			<c:forEach items="${jobList}" var="item" varStatus="status">      
    			<tr>
    				<td align="center" class="listtd"><c:out value="${status.count}"/></td>
    				<td align="center" class="listtd"><input type="radio" name="jobName" value="${item}" <c:if test="${status.first == true}">checked="checked"</c:if> /></td>
    				<td align="center" class="listtd"><c:out value="${item}"/>&nbsp;</td>
    			</tr>
    			</c:forEach>
    		</table>
    	</div>
	</form:form>
	<!-- /Job List -->
	<!--  Button -->
	<div id="sysbtn1">
		<ul>
            <li>
        		<div id="sysbtn">
                    <ul>
                        <li>
                            <span class="btn_blue_l">
                                <a href="javascript:fn_egov_batchRun();">배치실행</a>
                                <img src="<c:url value='/images/egovframework/batch/btn_bg_r.gif'/>" style="margin-left:6px;" alt=""/>
                            </span>
                        </li>
                    </ul>
        		</div>
            </li>
		</ul>
	</div>
</div>
</body>
</html>