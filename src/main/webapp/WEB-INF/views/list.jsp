<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>CRUD</title>
    <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <link rel="stylesheet" href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <script type="text/javascript" src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js" charset="UTF-8"></script>
    <script type="text/javascript" src="${APP_PATH}/static/js/jquery-3.4.1.min.js" charset="UTF-8"></script>
    <script type="text/javascript" src="${APP_PATH}/js/list.js" CHARSET="UTF-8"></script>
</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="col-md-8">
                <h1>员工列表111</h1>
            </div>
            <div class="col-md-4 " style="margin-top: 30px;padding-left: 35px">
                <button class=" btn btn-danger btn-sm">
                    <span class="glyphicon glyphicon-plus" aria-hidden="true" ></span>新增
                </button>
                <button class="btn btn-primary btn-sm">
                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
                </button>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover" id="emps_table">
                <thead>
                <tr>
                    <th>#</th>
                    <th>empName</th>
                    <th>gender</th>
                    <th>email</th>
                    <th>deptName</th>
                    <th>oprate</th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6" id="page_info"></div>
        <div class="col-md-6" id="page_line"></div>
    </div>
</div>
</body>
</html>