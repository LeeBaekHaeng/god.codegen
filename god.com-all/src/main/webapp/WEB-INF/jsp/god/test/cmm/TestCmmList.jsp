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
    <form:form modelAttribute="comDefaultVO" method="get" onsubmit="return fn_searchTestCmmList()">
        <ol>
            <li>searchCondition: <form:input path="searchCondition" /></li>
            <li>searchKeyword: <form:input path="searchKeyword" /></li>
            <li>searchUseYn: <form:input path="searchUseYn" /></li>

            <li>result: <c:out value="${result}" /></li>

            <li><a href="<c:url value="/do/test/cmm/selectTestCmmList.do" />" onclick="return fn_listTestCmmList(this)">목록</a></li>
            <li><a href="<c:url value="/do/test/cmm/insertTestCmmView.do" />">등록</a></li>
            <li><a href="<c:url value="/do/test/cmm/selectTestCmm.do" />" onclick="return fn_detailTestCmmList(this)">상세</a></li>
            <li><button type="submit">검색</button></li>
        </ol>
    </form:form>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/god/test/cmm/TestCmmList.js"></script>
</body>
</html>