<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
原因：${exception}
<c:forEach var="trace" items="${pageContext.exception.stackTrace}">
	<p>${trace}</p>
</c:forEach> 