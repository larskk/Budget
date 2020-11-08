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
<p>Nedenfor vises akkumuleret aconto pr. måned for dine variable udgifter. I betalingsmånederne vil det være 0 kr.</p>
<table>
  <thead>
  <tr>
    <th>Navn</th>
    <th class="right">Pr. måned</th>
    <c:forEach items="${months}" var="monthName" varStatus="status">
      <th class="right">${monthName}</th>
    </c:forEach>
  </tr>
  </thead>

  <tbody>

  <c:forEach var="expense" items="${expenses}">
    <tr>
      <td>${expense.name}</td>
      <td class="right">${expense.getMonthlySaving()}</td>
      <c:forEach begin="1" end="12" varStatus="loop">
        <c:set var="monthNumber" value="${loop.index}"/>
        <td class="right">${expense.getTotalSaving(monthNumber)}</td>
      </c:forEach>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
