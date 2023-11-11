<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
    </form:form>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/god/test/cmm/TestCmmRegist.js"></script>
</body>
</html>