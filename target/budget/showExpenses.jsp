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
    <th>Frekvens</th>
    <th>Beløb</th>
    <th>Test</th>
  </tr>
  </thead>

  <tbody>
  <c:forEach var="expense" items="${expenses}">
    <tr>
      <td>${expense.name}</td>
      <td>${expense.frequency}</td>
      <td>${expense.amount}</td>
      <td>${expense.getFrequency()}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
