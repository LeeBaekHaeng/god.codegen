<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>행정코드 등록</title>
</head>
<body>

	<form:form modelAttribute="registVO">

		<h1>행정코드 등록</h1>

		<div>
			<form:select path="administZoneSe">
				<form:options items="${cmmCodeDetail.COM001}" itemValue="code"
					itemLabel="codeNm" />
			</form:select>
		</div>

		<div>
			<form:select path="administZoneSe">
				<form:options items="${cmmCodeDetail.COM002}" itemValue="code"
					itemLabel="codeNm" />
			</form:select>
		</div>

		<div>
			<form:select path="administZoneSe">
				<form:options items="${cmmCodeDetails.COM003}" itemValue="code"
					itemLabel="codeNm" />
			</form:select>
		</div>

		<div>
			<form:select path="administZoneSe">
				<form:options items="${cmmCodeDetails.COM005}" itemValue="code"
					itemLabel="codeNm" />
			</form:select>
		</div>

		<div>
			<form:select path="administZoneSe">
				<form:options items="${cmmCodeDetails.COM006}" itemValue="code"
					itemLabel="codeNm" />
			</form:select>
		</div>

	</form:form>

</body>
</html>