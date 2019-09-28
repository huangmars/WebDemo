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
    <script type="text/javascript" src="${APP_PATH}/static/js/jquery-3.4.1.min.js" charset="UTF-8"></script>
    <link rel="stylesheet" href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <script type="text/javascript" src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js" charset="UTF-8"></script>
    <script type="text/javascript" src="${APP_PATH}/js/list.js" CHARSET="UTF-8"></script>
</head>

<body>
<!-- 这是使用一个小技巧,在外部的js中使用el的值可以先把这个值放到隐藏域中,然后通过element获取 -->
<input type="hidden" id="APP_PATH" value="${APP_PATH }"/>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="col-md-8">
                <h1>员工列表</h1>
            </div>
            <div class="col-md-4 " style="margin-top: 30px;padding-left: 35px">
                <button class=" btn btn-danger btn-sm" id="btn_emp_add_model">
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

<!-- 新增界面(模态框)-->
<div class="modal fade" id="emp_add_model" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">员工添加</h4>
            </div>

            <div class="modal-body">
                <form class="form-horizontal" id="emp_add_model_form">

                    <div class="form-group">
                        <label for="empName" class="col-sm-2 control-label">姓名：</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="empName" name="empName" placeholder="姓名">
                            <span class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="gender" class="col-sm-2 control-label">性别</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender" value="M" checked="checked">男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender" value="F"> 女
                            </label>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="email" class="col-sm-2 control-label">邮箱:</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" id="email" name="email" placeholder="邮箱">
                            <span class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="dId" class="col-sm-2 control-label">部门:</label>
                        <div class="col-sm-10" id="dId">
                            <select class="form-control" name="dId"></select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="btn_emp_save" ajax-value="true">保存</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>