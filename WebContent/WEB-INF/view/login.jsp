<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>



<link href="<c:url value="/resources/css/error.css" />" rel="stylesheet" type="text/css">


</head>
<body>

	<form:form action="processLogin" modelAttribute="admin">

email:(*) <form:input path="email" />
		<form:errors path="email" class="error" />
		<br>
		<br>
password:(*) <form:password path="password" />
		<form:errors path="password" class="error" />
		<br>
		<input type="submit" value="login">
		<br>

	</form:form>




</body>
</html>