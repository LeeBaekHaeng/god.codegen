<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자</title>
<link rel="icon" type="image/png" href="<c:url value="/resources/admin/favicon.png" />">
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