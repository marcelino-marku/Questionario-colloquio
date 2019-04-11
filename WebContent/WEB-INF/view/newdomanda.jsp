<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html>
<html>

</head>
<body>

	<form action="/questions" method="post">

		<label>Inserisci domanda</label>
		<div>
			<textarea name="domanda" placeholder="Inserisci domanda"> </textarea>

		</div>
		<label>Inserisci risposta</label>
		<button type="button" onclick="return add()">add</button>
		<button type="button" onclick="return remove()">remove</button>
		<div id="contenitore"></div>

		<input type="hidden" value="0" id="domanda-hidden"> <select
			name="diff">
			<option value="1">bassa
			<option value="2">medio basso
			<option value="3">medio
			<option value="4">medio alto
			<option value="5">alto
		</select> <br> <label> inserisci tag </label> <br> <select name="tag">
			<c:forEach items="${tags}" var="t">
				<option  value="${t.getTesto()}">${t.getTesto()}
			</c:forEach>
		</select> <input type="submit">


	</form>





	<script src="<c:url value="/resources/jquery.min.js" />"></script>
	<script src="<c:url value="/resources/Add.js" />"></script>
</body>
</html>