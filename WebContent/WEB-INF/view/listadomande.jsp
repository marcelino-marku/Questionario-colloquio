<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE >
<html>

<body>
<a href="inserimento">Vai ad inserimento domanda</a>
<table>

  <c:forEach  items="${domande}" var="d">
  	<tr>
  	<td>testo domanda: <br></td>
  	
  	<td>${d.getTestoDomanda()} <br></td>
  	
  	</tr>
  	
  	<tr>
  	<td>difficoltà: <br></td>
  	
  	<td>${d.getDifficolta()} <br></td>
  	
  	</tr>
  </c:forEach>
  
</table>
      
</body>
</html>