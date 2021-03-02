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

    <!-- reference our style sheet -->
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/libraries/bootstrap-5.0.0-beta1-dist/css/bootstrap.min.css">
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
    <input class="element title" type="text" placeholder="Title">
    <input class="element subject" type="text" placeholder="Subject">
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/libraries/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/admin.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/new-post.js"></script>
</body>
</html>
