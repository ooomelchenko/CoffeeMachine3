<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<base href="${pageContext.request.contextPath}/"/>
<html>
<head>
    <title>ADMIN THE BASIS</title>
</head>
<body>

<h1>Hello ADMIN!</h1>
<a href="adminMenu?page=page1" >page1</a>
<a href="adminMenu?page=page2" >page2</a>
<a href="adminMenu?page=page3" >page3</a>
<br/>
<a href="adminMenu?page=page4" >someNotExistedPage</a>
<br/>
<a href="logout">Logout</a>
</body>
</html>