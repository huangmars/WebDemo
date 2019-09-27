$(function() {
    toPage(1);

})

//页面跳转时，渲染页面，加载数据
function toPage(pn) {
    var APP_PATH = $("#APP_PATH").val();
    $.ajax({
        url : APP_PATH + '/emps',
        data : 'pageNum=' + pn,
        type : 'get',
        success : function(result) {
            // 1.解析并显示员工信息
            buid_emps_table(result);
            // 2.解析并显示分页信息
            buid_page_info(result);
            // 3.解析并显示分页条
            buid_page_line(result);
        }
    })
}

//构建表格，并显示员工信息
function buid_emps_table(result) {
    //注意每次构建前都要清空表格
    $("#emps_table tbody").empty();
    //获取员工数据
    var emps = result.data.pageInfo.list;
    //构建表格
    $.each(emps,function(index, item) {
            // 构建数据
            var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>")
            var empIdTd = $("<td></td>").append(item.empId);
            var empNameTd = $("<td></td>").append(item.empName);
            var empGenderTd = $("<td></td>").append(item.gender == 'M'?'男':'女');
            var empEmailTd = $("<td></td>").append(item.email);
            var deptNameTd = $("<td></td>").append(item.department.deptName);
            // 构建按钮
            var editBtn = $("<button></button>").addClass("btn btn-info edit")
                                                .attr("edit-id", item.empId)
                                                .append($("<span></span>")
                                                .addClass("glyphicon glyphicon-pencil"))
                                                .append("编辑");

            var deleteBtn = $("<button></button>").addClass("btn btn-primary delete")
                                                  .attr("delete-id", item.empId)
                                                  .append($("<span></span>")
                                                  .addClass("glyphicon glyphicon-remove"))
                                                  .append("删除")
                                                  .attr("deleteName", item.empName);

            var btnTd = $("<td></td>").append(editBtn).append(" ").append(deleteBtn);
            $("<tr></tr>").append(checkBoxTd).append(empIdTd)
                          .append(empNameTd).append(empGenderTd)
                          .append(empEmailTd).append(deptNameTd)
                          .append(btnTd).appendTo("#emps_table tbody");
        })
}

// 构建分页信息
function buid_page_info(result) {
    $("#page_info").empty();// 注意每次构建前都要清空分页
    $("#page_info").append("当前第" + result.data.pageInfo.pageNum +
                            "页,共" + result.data.pageInfo.pages +
                            "页,共" + result.data.pageInfo.total + "条记录")
}

// 构建分页条
function buid_page_line(result) {
    $("#page_line").empty();// 注意每次构建前都要清空分页
    var ul = $("<ul></ul>").addClass("pagination")
    // 首页
    firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"));
    // 前一页
    prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;").attr("href", "#"));
    // 如果当前页是第一页,禁止点击
    if (result.data.pageInfo.hasPreviousPage == false) {
        firstPageLi.addClass("disabled");
        prePageLi.addClass("disabled");
    }
    // 跳转首页
    firstPageLi.click(function() {
        toPage(1);
    });
    // 跳转前一页(注意前面虽然禁止了首页跳转,但是只有禁止点击标志,还是可以点击)
    prePageLi.click(function() {
        toPage(result.data.pageInfo.pageNum == 1 ? 1 : result.data.pageInfo.pageNum - 1)
    });
    //添加首页和前一页
    ul.append(firstPageLi).append(prePageLi);

    //页数的生成与跳转
    $.each(result.data.pageInfo.navigatepageNums, function(index, item) {
        var numLi = $("<li></li>").append($("<a></a>").append(item).attr("href", "#"));
        if (result.data.pageInfo.pageNum == item) {numLi.addClass("active");}
        numLi.click(function() {
            toPage(item);
        })
        ul.append(numLi);
    })

    // 下一页
    nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;").attr("href", "#"));
    // 末页
    lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href", "#"));
    // 如果当前页是最后一页禁止点击
    if (result.data.pageInfo.hasNextPage == false) {
        lastPageLi.addClass("disabled");
        nextPageLi.addClass("disabled");
    }
    // 跳转最后一页
    lastPageLi.click(function() {
        toPage(result.data.pageInfo.pages);
    });
    // 跳转下一页(注意前面虽然禁止了末页跳转,但是只有禁止点击标志,还是可以点击,或者在pagehelper的配置中设置reasonable属性)
    nextPageLi.click(function() {
            toPage(result.data.pageInfo.pageNum == result.data.pageInfo.pages ? result.data.pageInfo.pages
                                                        : result.data.pageInfo.pageNum + 1)
    });
    ul.append(nextPageLi).append(lastPageLi);
    var nav = $("<nav></nav>").append(ul);
    $("#page_line").append(nav);
}