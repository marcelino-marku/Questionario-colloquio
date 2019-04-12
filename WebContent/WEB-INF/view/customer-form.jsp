<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>

<head>

<link href="<c:url value="/resources/css/error.css" />" rel="stylesheet" type="text/css">


</head>
<body>

	<form:form action="processForm" modelAttribute="customer">
		Nome: <form:input path="nome" />
		<br>
		Cognome (*): <form:input path="cognome" />

		<form:errors path="cognome" class="error" />
		<br>
		<input type="submit" value="invia">
	</form:form>

</body>
</html>