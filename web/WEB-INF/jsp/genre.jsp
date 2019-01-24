<%--
  Created by IntelliJ IDEA.
  User: keybiz
  Date: 23/01/2019
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Servlet Library - genre name</title>
</head>
<body>
<a href="/"><h1>Servlet Library</h1></a>
<hr>
<h2>Dettagli genere</h2>
<dl>
    <dt>Nome</dt>
    <dd><c:out value="${genere.nome}"/></dd>
</dl>
<hr>
<h3>Libri di questo genere</h3></td>
<c:forEach items="${libri}" var="libro">
    <p>
        <a href="/book?id=<c:out value="${libro.id}"/>">
            <c:out value="${libro.titolo}"/>
        </a>
    </p>
</c:forEach>
</body>
</html>
