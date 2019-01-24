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
    <title>Servlet Library - <c:out value="${libro.titolo}"/></title>
</head>
<body>
<a href="/"><h1>Servlet Library</h1></a>
<hr>
<h2>Book details</h2>
<dl>
    <dt>title</dt>
    <dd><c:out value="${libro.titolo}"/></dd>
    <dt>Author</dt>
    <dd>
        <a href="/author?id=<c:out value="${autore.id}"/>">
            <c:out value="${autore.nome}"/>
            <c:out value="${autore.cognome}"/>
        </a>
    </dd>
    <dt>description</dt>
    <dd><c:out value="${libro.descrizione}"/></dd>
</dl>
<hr>
<h3>Book genres</h3></td>
<c:forEach items="${generi}" var="genere">
    <p>
        <a href="/genre?id=<c:out value="${genere.id}"/>">
            <c:out value="${genere.nome}"/>
        </a>
    </p>
</c:forEach>
</body>
</html>
