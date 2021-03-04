<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/27/2021
  Time: 1:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyBlog</title>
    http://java.sun.com/jsp/jstl/cor
    <!-- reference our style sheet -->
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/libraries/bootstrap-5.0.0-beta1-dist/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/newpost.css">

</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark ">
    <a class="navbar-brand" href="#">Philip Nguyen Blog</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText"
            aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/new-post">New Post <span class="sr-only"></span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/listpost">List Post</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Edit Post</a>
            </li>
        </ul>
        <span class="navbar-text" style="position: absolute; right: 20px">
            <button class="logout">${author.username}</button>
            <a href="/logout" class="logout">logout</a>
        </span>
    </div>
</nav>
<div class="sidenav">
    <button class="insert_pa">Insert paragraph</button>
    <button class="insert_im">Insert image</button>
    <button class="sub">Submit</button>
    <button class="del">Delete</button>
    <button class="can">Cancel</button>
</div>

<div class="content">
    <table>
        <tr>
            <th>Title</th>
            <th>Subject</th>
            <th>Date</th>
            <th>Action</th>
        </tr>

        <!-- loop over and print our customers -->
        <c:forEach var="temPost" items="${posts}">

            <!-- construct an "update" link with customer id -->
            <c:url var="updateLink" value="/editpost">
                <c:param name="postId" value="${temPost.id}"/>
            </c:url>

            <!-- construct an "delete" link with customer id -->
            <c:url var="deleteLink" value="/delete_post/">
                <c:param name="postId" value="${temPost.id}"/>
            </c:url>

            <tr>
                <td> ${temPost.title} </td>
                <td> ${temPost.subject} </td>
                <td> ${temPost.date} </td>

                <td>
                    <!-- display the update link -->
                    <a href="${updateLink}">Update</a>
                    |
                    <a href="${deleteLink}"
                       onclick="if (!(confirm('Are you sure you want to delete this post?'))) return false">Delete</a>
                </td>

            </tr>

        </c:forEach>

    </table>
</div>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/resources/libraries/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/admin.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/list-post.js"></script>
</body>
</html>
