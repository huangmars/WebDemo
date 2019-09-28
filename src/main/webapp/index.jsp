<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>登陆页面</title>
    <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/css/styles.css">
</head>
<body>
    <div class="htmleaf-container">
        <div class="wrapper">
            <div class="container">
                <%--<c:if test="${not empty MESSAGE}">
                </c:if>--%>
                <h3 style="color: red">${param.MESSAGE}</h3>
                <h1>Welcome</h1>
                <form class="form" action="${APP_PATH}/login" method="post">
                    <input type="text" placeholder="Username" name="username">
                    <input type="password" placeholder="Password" name="password">
                    <button type="submit" id="login-button">Login</button>
                </form>
            </div>
            <ul class="bg-bubbles">
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
            </ul>
        </div>
    </div>

    <div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';color:#000000">
        <h1>员工管理系统</h1>
    </div>
</body>
</html>
