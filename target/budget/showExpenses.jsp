<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta content="width=device-width,initial-scale=1.0" name="viewport">
  <link href="main.css" rel="stylesheet">
  <title>Administrér udgifter</title>
</head>
<body>
<h1>Budget</h1>
<table>
  <thead>
  <tr>
    <th>Navn</th>
    <th>Pr. måned</th>
    <c:forEach items="${months}" var="monthName" varStatus="status">
      <th>${monthName}: ${status.count}</th>
    </c:forEach>
  </tr>
  </thead>

  <tbody>
  <c:forEach var="expense" items="${expenses}">
    <tr>
      <td>${expense.name}</td>
      <td>${expense.getMonthlySaving()}</td>
      <c:forEach begin="1" end="12" varStatus="loop">
        <c:set var="monthNumber" value="${loop.index}" />
        <td>${expense.getTotalSaving(monthNumber)}</td>
      </c:forEach>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
