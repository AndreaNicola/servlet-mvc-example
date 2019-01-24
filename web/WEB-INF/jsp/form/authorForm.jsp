<%--
  Created by IntelliJ IDEA.
  User: keybiz
  Date: 23/01/2019
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Servlet Library - new genre</title>
</head>
<body>
<a href="/"><h1>Servlet Library</h1></a>
<hr>
<center>
    <form action="/<c:out value="${action}"/>" method="post">

        <c:if test="${action eq 'authorEdit'}">
            <input type="hidden" value="<c:out value="${id}"/>" name="id">
        </c:if>

        <c:if test="${ not empty errore}">
            <c:out value="${errore}"/>
        </c:if>

        <table width="50%">
            <tr>
                <td colspan="2"><h2>New author</h2></td>
            </tr>
            <tr>
                <td width="25%">Firstname:</td>
                <td><input style="width: 100%" type="text" name="firstname" value="<c:out value="${firstname}"/>"></td>
            </tr>
            <tr>
                <td width="25%">Lastname:</td>
                <td><input style="width: 100%" type="text" name="lastname" value="<c:out value="${lastname}"/>"></td>
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

</body>
</html>
