<%--
  Created by IntelliJ IDEA.
  User: keybiz
  Date: 23/01/2019
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Servlet Library - <c:out value="${autore.cognome}"/> <c:out value="${autore.nome}"/></title>
</head>
<body>
<a href="/"><h1>Servlet Library</h1></a>
<hr>
<h2>Author details</h2>
<dl>
    <dt>Firstname</dt>
    <dd><c:out value="${autore.nome}"/></dd>
    <dt>Lastname</dt>
    <dd><c:out value="${autore.cognome}"/></dd>
</dl>
<hr>
<h3>Author books</h3>
<c:forEach items="${libri}" var="libro">
    <p><a href="/book?id=<c:out value="${libro.id}"/>"><c:out value="${libro.titolo}"/></a></p>
</c:forEach>
</body>
</html>
