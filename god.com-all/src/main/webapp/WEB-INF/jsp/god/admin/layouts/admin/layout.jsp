<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자</title>
<link rel="icon" type="image/png" href="<c:url value="/resources/admin/favicon.png" />">

<script src="${pageContext.request.contextPath}/js/egovframework/com/cmm/jquery-1.12.4.min.js"></script>

<script type="text/javascript">
    var vr_comCmm_contextPath = '${pageContext.request.contextPath}';
</script>

<script src="${pageContext.request.contextPath}/resources/com/cmm/ComCmm.js"></script>

</head>
<body>

    <table border="1">
        <tr>
            <td colspan="2"><tiles:insertAttribute name="header" /></td>
        </tr>
        <tr>
            <td><tiles:insertAttribute name="menu" /></td>
            <td><tiles:insertAttribute name="body" /></td>
        </tr>
        <tr>
            <td colspan="2"><tiles:insertAttribute name="footer" /></td>
        </tr>
    </table>

</body>
</html>