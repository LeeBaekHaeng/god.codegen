<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="egovc" uri="/WEB-INF/tlds/egovc.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form:form modelAttribute="testCmmVO" action="${pageContext.request.contextPath}/do/test/cmm/insertTestCmm.do" onsubmit="return fn_saveTestCmmRegist()">
        <ol>
            <li>행정구역구분: <form:input path="administZoneSe" /></li>
            <li>행정구역코드: <form:input path="administZoneCode" /></li>

            <li>searchCondition: <form:input path="searchCondition" /></li>
            <li>searchKeyword: <form:input path="searchKeyword" /></li>
            <li>searchUseYn: <form:input path="searchUseYn" /></li>

            <li>result: <c:out value="${result}" /></li>

            <li><a href="<c:url value="/do/test/cmm/selectTestCmmList.do" />" onclick="return fn_listTestCmmRegist(this)">목록</a></li>
            <li><button type="submit">저장</button></li>
        </ol>


        <h2>등록 화면</h2>
        <input type="text" id="atchFileId">
        <c:url value="/cmm/fms/uploadFile.do" var="url">
            <c:param name="param_atchFileId"></c:param>
            <c:param name="keyStr"></c:param>
            <c:param name="storePath"></c:param>
            <c:param name="fn">fn_regist_setAtchFileId</c:param>
        </c:url>
        <a href="${url}" target="/cmm/fms/uploadFile.do" onclick="window.open('${url}', '/cmm/fms/uploadFile.do', 'left=100,top=100,width=800,height=600'); return false;">파일 업로드</a>

        <h2>수정 화면</h2>
        <input type="text" id="atchFileId2">
        <c:url value="/cmm/fms/uploadFile.do" var="url">
            <c:param name="param_atchFileId">${egovc:encrypt('FILE_000000000000071')}</c:param>
            <c:param name="keyStr">CMM_</c:param>
            <%--             <c:param name="storePath">Globals.fileStorePath</c:param> --%>
            <c:param name="storePath">Globals.fileStorePath.test</c:param>
            <c:param name="fn">fn_regist_setAtchFileId2</c:param>
        </c:url>
        <a href="${url}" target="/cmm/fms/uploadFile.do" onclick="window.open('${url}', '/cmm/fms/uploadFile.do', 'left=100,top=100,width=800,height=600'); return false;">파일 업로드</a>

    </form:form>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/god/test/cmm/TestCmmRegist.js"></script>
</body>
</html>