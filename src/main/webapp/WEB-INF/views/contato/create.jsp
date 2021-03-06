<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="0">
<c:forEach items="${contatos}" var="contato">
<tr>
<td>${contato.id}</td>
<td>${contato.name}</td>
</tr>
</c:forEach>
</table>

<div>
<c:url var="url" value="/contato"/>
<form:form action="${url}" method="POST" modelAttribute="contato">
<div>
	<label for="name">Nome:</label>
	<form:input path="name" size="30"/>
</div>
<div>
	<label for="telefone">Telefone:</label>
	<form:input path="telefone" size="30"/>
</div>
<div>
<input value="Criar contato" type="submit">
</form:form>
</div>
<div>


</body>
</html>