<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/27/2021
  Time: 1:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyBlog</title>
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/libraries/bootstrap-5.0.0-beta1-dist/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css">
</head>
<body>
<div class="container">
    <div class="d-flex justify-content-center h-100">
        <div class="card">
            <div class="card-header">
                <h3>Sign In</h3>
                <div class="d-flex justify-content-end social_icon">
                    <span><i class="fab fa-facebook-square"></i></span>
                    <span><i class="fab fa-google-plus-square"></i></span>
                    <span><i class="fab fa-twitter-square"></i></span>
                </div>
            </div>
            <div class="card-body">

                <form:form action="adminlogin" modelAttribute="author" method="POST">
                    <form:hidden path="id"/>
                    <div class="input-group form-group" style="margin-bottom: 15px;">
                        <div class="input-group-prepend">
                            <span class="input-group-text" style="height: 38px;"><i class="fas fa-user"></i></span>
                        </div>
                        <form:input path="username"/>
                            <%-- class = "form-control" type="text" placeholder="password"--%>
                    </div>
                    <div class="input-group form-group" style="margin-bottom: 15px;">
                        <div class="input-group-prepend">
                            <span class="input-group-text" style="height: 38px;"><i class="fas fa-key"></i></span>
                        </div>
                        <form:input path="password"/>
                            <%-- <input class = "password" type="password" class="form-control" placeholder="password">--%>
                    </div>
                    <div class="row align-items-center remember" style="margin-bottom: 10px;">
                        <input type="checkbox">Remember Me
                    </div>
                    <div class="form-group">
                        <input type="submit" value="Login" class="btn float-right login_btn">
                    </div>
                </form:form>
            </div>
            <div class="card-footer">
                <div class="d-flex justify-content-center links">
                    Don't have an account?<a href="#">Sign Up</a>
                </div>
                <div class="d-flex justify-content-center">
                    <a href="#">Forgot your password?</a>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>
