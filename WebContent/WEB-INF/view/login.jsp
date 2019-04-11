<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE>
<html>
<head>


</head>
<body>

<form:form action="/api/questionario/inserimento" modelAttribute="admin" >

email:(*) <form:input path="email"/>
<br><br>
password:(*) <form:input path="password"/>
<br>
<input type="submit" value="login">
<br>

</form:form>




</body>
</html>