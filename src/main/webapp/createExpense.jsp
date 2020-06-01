<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <meta charset="UTF-8">
  <meta content="width=device-width,initial-scale=1.0" name="viewport">
  <link href="main.css" rel="stylesheet">
  <title>Opret udgift</title>
</head>
<body>
<div class="flex-container">
  <div>
    <h1>Opret udgift</h1>

    <form action="MinServlet" method="post">
      <input type="hidden" name="action" value="create">
      <label for="name">Navn</label>
      <input autofocus id="name" name="name" required>
      <label for="amount">Beløb</label>
      <input id="amount" name="amount" required type="number">
      <p>
        <label>Make a choice:</label>
        <input type="radio" id=yes name="choice" value="yes">
        <label class="radio" for="yes">Yes</label>
        <input type="radio" id=no name="choice" value="no">
        <label class="radio" for="no">No</label>
      </p>
      <label>Betalingsfrekvens:</label>
      <fieldset>

        <c:forEach items="januar,februar,marts, april, maj, juni, juli, august, september, oktober, november, december"
                   var="month" varStatus="status">
          <p>
            <input id="${status.count}" name="month" type="checkbox" value="${status.count}">
            <label class="checkbox" for="${status.count}"> ${month}</label>
          </p>
        </c:forEach>

      </fieldset>
      <input type="submit" value="Gem">
    </form>
  </div>
</div>

</body>
</html>
