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
    <script type="text/javascript" src=src="${APP_PATH}/static/js/jquery-3.4.1.min.js" charset="UTF-8"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="col-md-8">
                <h1>员工列表</h1>
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
            <table class="table table-hover">
                <tr>
                    <th>#</th>
                    <th>empName</th>
                    <th>gender</th>
                    <th>email</th>
                    <th>deptName</th>
                    <th>oprate</th>
                </tr>
                <c:forEach items="${pageInfo.list}" var="emp">
                <tr style="font-size:large ">
                    <th>${emp.empId}</th>
                    <th>${emp.empName}</th>
                    <th>${emp.gender=="男"?"男":"女"}</th>
                    <th>${emp.email}</th>
                    <th>${emp.department.deptName}</th>
                    <th>
                        <button class="btn btn-info btn-sm">
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>编辑
                        </button>
                        <button class="btn btn-primary btn-sm">
                            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
                        </button>
                    </th>
                </tr>
                </c:forEach>
            </table>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6">
            当前${pageInfo.pageNum}页,总共${pageInfo.pages}页,共${pageInfo.total}条记录
        </div>
        <div class="col-md-6">
            <nav aria-label="Page navigation">
                <ul class="pagination">

                    <li><a href="${APP_PATH}/emps?pageNum=1">首页</a></li>
                    <!-- 如果是首页则禁止点击前一页 -->
                    <c:if test="${pageInfo.isFirstPage }">
                        <li class="disabled">
                            <a href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <c:if test="${!pageInfo.isFirstPage }">
                        <li>
                            <a href="${APP_PATH}/emps?pageNum=${pageInfo.prePage}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>

                    <c:forEach items="${pageInfo.navigatepageNums}" var="navigatepageNums">
                        <c:if test="${navigatepageNums==pageInfo.pageNum }">
                            <li class="active"><a href="#">${navigatepageNums }</a></li>
                        </c:if>
                        <c:if test="${navigatepageNums!=pageInfo.pageNum }">
                            <li><a href="${APP_PATH}/emps?pageNum=${navigatepageNums}">${navigatepageNums }</a></li>
                        </c:if>
                    </c:forEach>

                    <!-- 如果是尾页则禁止点击前一页 -->
                    <c:if test="${pageInfo.isLastPage }">
                        <li class="disabled">
                            <a href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <c:if test="${!pageInfo.isLastPage }">
                        <li>
                            <a href="${APP_PATH}/emps?pageNum=${pageInfo.nextPage}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <li><a href="${APP_PATH}/emps?pageNum=${pageInfo.pages}">尾页</a></li>
                </ul>
            </nav>
        </div>
    </div>
</div>
</body>


</html>