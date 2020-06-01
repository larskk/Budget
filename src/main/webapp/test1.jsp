
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test JSTL</title>
</head>
<body>
<c:if test="${4>2}">TEST OK</c:if>
<c:forEach items="januar,februar,marts, april, maj, juni" var="name" varStatus="status">
  <p>${name}: ${status.count}</p>
</c:forEach>
</body>
</html>
