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
    <title>Servlet Library - book title</title>
</head>
<body>
<a href="/"><h1>Servlet Library</h1></a>
<hr>
<h2>Book details</h2>
<dl>
    <dt>title</dt>
    <dd>book title</dd>
    <dt>Author</dt>
    <dd><a href="/author/id=id">Author name</a></dd>
    <dt>description</dt>
    <dd>description</dd>
</dl>
<hr>
<h3>Book genres</h3></td>
<p><a href="/genre?id=id">genre name</a></p>
</body>
</html>
