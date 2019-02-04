<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Servlet Library - new genre</title>
</head>
<body>
<a href="/"><h1>Servlet Library</h1></a>
<hr>
<center>
    <form action="/<c:out value="${action}"/>" method="post">
        <table width="50%">
            <tr>
                <td colspan="2"><h2>New book</h2></td>
            </tr>
            <tr>

                <td width="25%">Title:</td>
                <td><input style="width: 100%" type="text" name="title" value="<c:out value="${title}"/>"></td>
            </tr>
            <tr>
                <td width="25%">Description:</td>
                <td>
                    <textarea style="width: 100%" name="description"><c:out value="${description}"/></textarea>
                </td>
            </tr>
            <tr>
                <td width="25%">Author:</td>
                <td>
                    <select style="width: 100%" name="selectedAuthor" value="<c:out value="${selectedAuthor}"/>">
                        <c:forEach var="autore" items="${autori}">
                            <option value="${autore.id}">${autore.cognome} ${autore.nome}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td width="25%">Genres:</td>
                <td>
                    <select
                            style="width: 100%"
                            name="selectedGenres"
                            multiple
                            value="<c:out value="${selectedGenres}"/>"
                    >
                        <c:forEach var="genere" items="${generi}">
                            <option value="${genere.id}">${genere.nome}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit">
                    <input type="reset">
                </td>
            </tr>
        </table>
    </form>
</center>
<hr>
<h2>Errori</h2>
<ul>
    <li>Errore 1</li>
    <li>Errore 1</li>
    <li>Errore 1</li>
</ul>

</body>
</html>
