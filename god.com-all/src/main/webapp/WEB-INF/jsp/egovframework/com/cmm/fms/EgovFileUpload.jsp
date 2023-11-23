
<%
/**
 * @Class Name : EgovArticleUpdt.jsp
 * @Description : EgovArticleUpdt 화면
 * @Modification Information
 * @
 * @  수정일             수정자                   수정내용
 * @ -------    --------    ---------------------------
 * @ 2009.02.01   박정규              최초 생성
 *   2016.06.13   김연호              표준프레임워크 v3.6 개선
 *  @author 공통서비스팀 
 *  @since 2009.02.01
 *  @version 1.0
 *  @see
 *  
 */
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator"%>
<%@ taglib prefix="ckeditor" uri="http://ckeditor.com"%>
<%@ taglib prefix="egovc" uri="/WEB-INF/tlds/egovc.tld"%>
<c:set var="pageTitle">
    <spring:message code="comCopBbs.articleVO.title" />
</c:set>
<!DOCTYPE html>
<html>
<head>
<title>${pageTitle }<spring:message code="title.update" /></title>
<!-- 게시글 답글 수정-->
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/com.css' />">
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/cmm/jqueryui.css' />">
<%-- <script type="text/javascript" src="<c:url value='/js/egovframework/com/cmm/fms/EgovMultiFile.js'/>" ></script> --%>
<script type="text/javascript" src="<c:url value='/js/egovframework/com/cmm/fms/EgovMultiFiles.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/egovframework/com/cmm/utl/EgovCmmUtl.js'/>"></script>
<script type="text/javascript" src="<c:url value='/html/egovframework/com/cmm/utl/ckeditor/ckeditor.js?t=B37D54V'/>"></script>
<script type="text/javascript" src="<c:url value="/validator.do"/>"></script>
<script src="<c:url value='/js/egovframework/com/cmm/jquery.js' />"></script>
<script src="<c:url value='/js/egovframework/com/cmm/jqueryui.js' />"></script>
<validator:javascript formName="articleVO" staticJavascript="false" xhtml="true" cdata="false" />
<script type="text/javascript">
    $(function() {

    });

    /* ********************************************************
     * 초기화
     ******************************************************** */
    function fn_egov_init() {

    }
    /* ********************************************************
     * 저장처리화면
     ******************************************************** */
    function fn_egov_updt_article(form) {
        form.submit();
    }
</script>
</head>
<body onLoad="fn_egov_init();">

    <!-- javascript warning tag  -->
    <noscript class="noScriptTitle">
        <spring:message code="common.noScriptTitle.msg" />
    </noscript>

    <!-- 상단타이틀 -->
    <form:form modelAttribute="searchVO" action="${pageContext.request.contextPath}/cmm/fms/uploadFile.do" method="post" onSubmit="fn_egov_updt_article(document.forms[0]); return false;" enctype="multipart/form-data">
        <div class="wTableFrm">
            <h2>${pageTitle}
                <spring:message code="title.update" />
            </h2>
            <!-- 게시글 답글 수정-->

            <!-- 수정폼 -->
            <table class="wTable" summary="<spring:message code="common.summary.update" arguments="${pageTitle}" />">
                <caption>${pageTitle}
                    <spring:message code="title.update" />
                </caption>
                <colgroup>
                    <col style="width: 20%;">
                    <col style="width:;">
                    <col style="width:;">
                    <col style="width:;">
                </colgroup>
                <tbody>

                    <!-- 첨부파일 시작 -->
                    <c:set var="title">
                        <spring:message code="comCopBbs.articleVO.updt.atchFile" />
                    </c:set>
                    <tr>
                        <th>${title}</th>
                        <td class="nopd" colspan="3"><c:import url="/cmm/fms/selectFileInfs.do" charEncoding="utf-8">
                                <%--                                 <c:param name="param_atchFileId" value="${egovc:encrypt(searchVO.atchFileId)}" /> --%>
                                <c:param name="param_atchFileId" value="${param.param_atchFileId}" />
                            </c:import></td>
                    </tr>
                    <!-- 첨부파일 끝 -->
                    <!-- 첨부파일 시작 -->
                    <c:set var="title">
                        <spring:message code="comCopBbs.articleVO.updt.atchFile" />
                    </c:set>
                    <tr>
                        <th>${title}</th>
                        <td class="nopd" colspan="3"><c:import url="/cmm/fms/selectFileInfsForUpdate.do" charEncoding="utf-8">
                                <%--                                 <c:param name="param_atchFileId" value="${egovc:encrypt(searchVO.atchFileId)}" /> --%>
                                <c:param name="param_atchFileId" value="${param.param_atchFileId}" />
                            </c:import></td>
                    </tr>
                    <!-- 첨부파일 끝 -->
                    <!-- 첨부파일 추가 시작 -->
                    <c:set var="title">
                        <spring:message code="comCopBbs.articleVO.updt.atchFileAdd" />
                    </c:set>
                    <tr>
                        <th><label for="file_1">${title}</label></th>
                        <td class="nopd" colspan="3"><input name="file_1" id="egovComFileUploader" type="file" title="<spring:message code="comCopBbs.articleVO.updt.atchFile"/>" multiple /> <!-- 첨부파일 -->
                            <div id="egovComFileList"></div></td>
                    </tr>
                    <!-- 첨부파일 추가 끝 -->

                </tbody>
            </table>

            <!-- 하단 버튼 -->
            <div class="btn">
                <input type="submit" class="s_submit" value="<spring:message code="button.update" />" title="<spring:message code="button.update" /> <spring:message code="input.button" />" />
                <!-- 수정 -->
            </div>
            <div style="clear: both;"></div>

        </div>
        <input type="text" name="param_atchFileId" value="<c:out value="${param.param_atchFileId}" />">
        <input type="text" value="<c:out value="${searchVO.atchFileId}" />">
        <input type="text" value="<c:out value="${egovc:encrypt(searchVO.atchFileId)}" />">
        <%--         <input type="text" value="<c:out value="${egovc:encrypt('FILE_000000000000071')}" />"> --%>

    </form:form>

    <!-- 첨부파일 업로드 가능화일 설정 Start..-->
    <script type="text/javascript">
                    var maxFileNum = 3;
                    var multi_selector = new MultiSelector(document.getElementById('egovComFileList'), maxFileNum);
                    multi_selector.addElement(document.getElementById('egovComFileUploader'));
                </script>
    <!-- 첨부파일 업로드 가능화일 설정 End.-->
</body>
</html>
