<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="validator"
	uri="http://www.springmodules.org/tags/commons-validator"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form:form modelAttribute="voRegist"
		action="${pageContext.request.contextPath}/do/sample/insertSampleAa01.do"
		method="post">

		<table border="1">
			<tr>
				<th><spring:message code="god.sample.a.a.regist.administZoneSe" /></th>
				<td><form:input path="administZoneSe" /> <form:errors
						path="administZoneSe" /></td>
			</tr>
			<tr>
				<th><spring:message
						code="god.sample.a.a.regist.administZoneCode" /></th>
				<td><form:input path="administZoneCode" /> <form:errors
						path="administZoneCode" /></td>
			</tr>
		</table>

		<div>
			<button type="submit">
				<spring:message code="button.save" />
			</button>
			<button type="reset">
				<spring:message code="button.reset" />
			</button>
			<button type="button">
				<spring:message code="button.list" />
			</button>
		</div>

	</form:form>

</body>
</html>