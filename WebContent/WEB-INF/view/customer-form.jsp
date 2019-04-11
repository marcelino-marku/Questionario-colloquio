<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE>
<html>

<head>
 
 <style >
  .error{
  color: red;
  }
 </style>

</head>
<body>

	<form:form action="processForm" modelAttribute="customer">
		Nome: <form:input path="nome"/>
		<br>
		Cognome (*): <form:input path="cognome"/>
		<form:errors path="cognome" class="error"/>
		<br>
		<input type="submit" value="invia">
	 </form:form>
 	
</body>
</html>