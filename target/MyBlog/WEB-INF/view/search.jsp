<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/3/2021
  Time: 10:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyBlog</title>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/libraries/bootstrap-5.0.0-beta1-dist/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/blog.css">
</head>
<body>

<div class="header">
    <div class="title">Philip Nguyen</div>
    <div class="subject">
        <div class="sub-subject" >Opinion</div>
        <div class="sub-subject" >Experience</div>
        <div class="sub-subject" >English</div>
        <div class="sub-subject" >Other</div>
    </div>
</div>

<div class="body">
    <form action="/search" method="get">
        <input type="text" class="form-control" name="q" placeholder="Search here...">
    </form>
    <c:forEach var="temPost" items="${posts}">
        <%--   <div class="element">--%>
        <c:url var="link" value="/show-post">
            <c:param name="id" value="${temPost.id}"/>
        </c:url>
        <a class="link" href="${link}">${temPost.title}<input type="hidden" class="id_post" value="${temPost.id}"></a>
        <%-- <a href="/show-post/${temPost.title}" class="link" >${temPost.title}<input type="hidden" class="id_post" value="${temPost.id}"></a>
--%>
        <%--        </div>--%>
    </c:forEach>
</div>
<div class="footer"></div>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/libraries/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/post.js"></script>
</body>
</html>
