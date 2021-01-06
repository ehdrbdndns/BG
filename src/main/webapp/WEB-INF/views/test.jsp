<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-08-11
  Time: 오후 5:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <jsp:include page="/resources/include/header.jsp"/>
    <title>Title</title>
</head>
<body>
<h2>잘 나오는 것이여</h2>
<form action="/appRetrieveShopList.app" enctype="multipart/form-data" method="post">
    <input type="text" name="Location">
    <input type="text" name="Location_Range">
    <input type="text" name="Category">
    <input type="text" name="Ways">
    <input type="text" name="Search">
    <input type="text" name="FirstIndex">
    <button>제출</button>
</form>
<form action="/appGetAdvertise.app">
    <button>제출</button>
</form>
<form action="/appClickLikeBtn.app">
    <input type="text" name="User_No">
    <input type="text" name="Like_Type">
    <input type="text" name="Board_No">
    <button>제출</button>
</form>
<form action="/appIsClickLike.app">
    <input type="text" name="User_No">
    <input type="text" name="Like_Type">
    <input type="text" name="Board_No">
    <button>제출</button>
</form>
<form action="/appClickAdvertise.app">
    <input type="text" name="Ad_Type">
    <input type="text" name="Ad_Url">
    <button>제출</button>
</form>
</body>
    <jsp:include page="/resources/include/javascript.jsp"/>
</html>
