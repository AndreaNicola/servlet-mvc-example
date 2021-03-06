<%--
  Created by IntelliJ IDEA.
  User: keybiz
  Date: 23/01/2019
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Libreria Servlet</title>
</head>
<body>

<a href="/"><h1>Servlet Library</h1></a>
<hr>
<table style="width: 100%; vertical-align: top">
    <tr>
        <td>
            <h2><a href="authorInsert">Nuovo autore</a></h2>
            <h2>Autori disponibili</h2>
        </td>
        <td>
            <h2><a href="genreInsert">Nuovo genere</a></h2>
            <h2>Generi disponibili</h2>
        </td>
        <td>
            <h2><a href="bookInsert">Nuovo libro</a></h2>
            <h2>Libri disponibili</h2>
        </td>
    </tr>
    <tr>
        <td>
            <ul>
                <c:forEach var="autore" items="${autori}">
                    <li>
                        <a href="/author?id=<c:out value="${autore.id}"/>">
                            <c:out value="${autore.cognome}"/>
                            <c:out value="${autore.nome}"/>
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </td>
        <td>
            <ul>
                <c:forEach var="genere" items="${generi}">
                    <li>
                        <a href="/genre?id=<c:out value="${genere.id}"></c:out>">
                            <c:out value="${genere.nome}"/>
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </td>
        <td>
            <ul>
                <c:forEach var="libro" items="${libri}">
                <li>
                    <a href="/book?id=<c:out value="${libro.id}" />">
                        <c:out value="${libro.titolo}" />
                    </a>
                </li>
                </c:forEach>
            </ul>
        </td>
    </tr>
</table>


</body>
</html>
