<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <table>
        <c:forEach items="${resultList}" var="result" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${result.administZoneSe}</td>
                <td>${result.administZoneCode}</td>
                <td>${result.useAt}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>