<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>행정코드 목록</title>
</head>
<body>

	<h1>행정코드 목록</h1>

	<table border="1">
		<c:forEach items="${resultList}" var="result" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${result.administZoneSe}</td>
				<td>${result.administZoneCode}</td>
				<td>${result.useAt}</td>

				<td>${result.frstRegistPnttm}</td>
				<td>${result.frstRegisterId}</td>
				<td>${result.lastUpdtPnttm}</td>
				<td>${result.lastUpdusrId}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>