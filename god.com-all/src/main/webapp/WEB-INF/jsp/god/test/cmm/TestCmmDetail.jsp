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
    <ol>
        <li>searchCondition: <c:out value="${comDefaultVO.searchCondition}" /></li>
        <li>searchKeyword: <c:out value="${comDefaultVO.searchKeyword}" /></li>
        <li>searchUseYn: <c:out value="${comDefaultVO.searchUseYn}" /></li>

        <li>result: <c:out value="${result}" /></li>

        <li><a href="<c:url value="/do/test/cmm/selectTestCmmList.do" />" onclick="return fn_detailTestCmmDetail(this)">목록</a></li>
        <li><a href="<c:url value="/do/test/cmm/insertTestCmmView.do" />" onclick="return fn_createTestCmmDetail(this)">등록</a></li>
    </ol>
    <script type="text/javascript">
                    var searchKeyword = '<c:out value="${comDefaultVO.searchKeyword}" />';
                </script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/god/test/cmm/TestCmmDetail.js"></script>
</body>
</html>