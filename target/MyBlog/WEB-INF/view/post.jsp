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

    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/libraries/bootstrap-5.0.0-beta1-dist/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/blog.css">
</head>
<body>

<div class="header">
    <div class="title">Philip Nguyen</div>
    <div class="subject">
        <div class="sub-subject" ><a href="/blog">Home</a></div>
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
    <c:forEach var="temParagraph" items="${paragraphs}">
    <div class='element1 paragraph'>
            <%--            <c:if test = "${temParagraph.content.contains('.jpg')}">
                            <div class="image" style="background-image: url('/resources/images/${temParagraph.content}');">
                        </c:if>
                            <c:out value = "${salary}"/>

                            <div class='element_content paragraph'>${temParagraph.content}</div>--%>

        <c:choose>
        <c:when test="${temParagraph.content.contains('.jpg')}">
        <div class="image" style="background-image: url('/resources/images/${temParagraph.content}');">
            </c:when>
            <c:otherwise>
                <div class='element_content paragraph'>${temParagraph.content}</div>
            </c:otherwise>
            </c:choose>


        <%--    <input type="hidden" class="paragraph_id" value="${temParagraph.id}">--%>

        </div>
        </c:forEach>
    </div>
    <div class="footer"></div>

    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/libraries/jquery-3.5.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/post.js"></script>
</body>
</html>
