$(function() {
    toPage(1);

    $("#btn_emp_add_model").click(function () {
        //1.每次关闭表单后重新打开表单需要清空表单的数据
        $("#emp_add_model_form")[0].reset();
        //2.为姓名输入框绑定一个change事件,发送ajax请求,检测是否用户已经注册
        checkSameEmployee();
        //3.点击新增按钮后，先查询部门信息
        getDepts($("#dId select"));
        //4.弹出模态框
        $("#emp_add_model").modal({
            backdrop:"static"
        });
    });
    
    $("#btn_emp_save").click(function () {
        if (validate()) {
            if ($("#btn_emp_save").attr("ajax-value") == "false") {
                alert("无法插入");
            } else {
                // 点击保存按钮新增用户
                save();
            }
        }
    })

    $(document).on("click", ".edit", function() {
        //1.修改前查出部门信息
        getDepts($("#dId1 select"));
        //2.修改前查出员工信息
        getEmp($(this).attr("edit-id"));
        //3.把员工id添加到保存按钮上去，方便后面保存时使用
        $("#btn-update").attr("edit-id", $(this).attr("edit-id"));
        //4.弹出模态框
        $("#emp_modify_model").modal({
            backdrop:"static"
        });
    })

    $("#btn-update").click(function() {
                // 验证邮箱是否合法
                var email = $("#email1").val();
                var regEmail = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;

                if (!regEmail.test(email)) {
                    show_validate_message($("#email1"), "error", "邮箱格式不正确")
                    return false;
                } else {
                    show_validate_message($("#email1"), "success", "")
                    if ($("#btn-update").attr("ajax-value") == false) {
                        alert("不成功");
                        return false;
                    }
                    // 发送ajax请求保存员工
                    var APP_PATH = $("#APP_PATH").val();
                    $.ajax({
                            url : APP_PATH + "/emp/" + $(this).attr("edit-id"),
                            type : "PUT",
                            data : $("#form2").serialize(),
                            /*data : $("#form2").serialize() + "&_method=PUT",*/
                            success : function(result) {
                                alert(result.msg);
                                $('#emp_modify_model').modal('hide');// 关闭模态框
                                toPage(1)// 回到首页
                            }
                        });
                    return true;
                }

    });

    $(document).on("click", ".delete", function() {// 为每个删除按钮绑定事件
        var flag = confirm("是否删除" + $(this).attr("deleteName") + "?");
        if (flag == true) {
            deleteEmployee($(this));
        }
    });

    $(document).on("click", ".check_item", function() {
        // 判断选中的元素是不是全部,是的话checkAll要勾上
        $("#checkAll").prop("checked", $(".check_item:checked").length == $(".check_item").length);
    });

    $("#checkAll").click(function () {
        $(".check_item").prop("checked",$(this).prop("checked"))
    })

    $("#deleteAll").click(function() {
        if($(".check_item:checked").length!=0){
            deleteAll();
        }else{
            alert("您还未选择任何删除");
        }
    });
});

// 删除员工的信息
function deleteEmployee(element) {
    var APP_PATH = $("#APP_PATH").val();
    $.ajax({
        url : APP_PATH + "/emp/" + element.attr("delete-id"),
        type : "POST",
        data : "_method=delete",
        success : function(result) {
            alert(result.responseMessage);
            toPage(1);// 返回首页
        }

    });
}

// 获取修改员工的信息
function getEmp(id) {
    var APP_PATH = $("#APP_PATH").val();
    $.ajax({
        url : APP_PATH + "/emp/" + id,
        type : "GET",
        success : function(result) {
            console.log(result)
            var empName = result.responseData.emp.empName;
            var email = result.responseData.emp.email;
            var gender = result.responseData.emp.gender;
            var dId = result.responseData.emp.dId;
            $("#empName1").text(empName);
            $("#email1").val(email);
            $("#emp_modify_model input[name=gender]").val([ gender ]);
            $("#emp_modify_model select").select([ dId ]);
        }
    });
}

//保存员工
function save() {
    var APP_PATH = $("#APP_PATH").val();
    $.ajax({
        url : APP_PATH + "/emp",
        type : "POST",
        data : $("#emp_add_model_form").serialize(),
        success : function(result) {
            if (result.responseStatus == 200) {
                //关闭模态框
                $('#emp_add_model').modal('hide');
            } else {
                //alert(result.responseMessage);
                alert(result.responseMessage + result.responseData.error);
            }
        }
    });
}

//为姓名输入框绑定一个change事件,发送ajax请求,检测是否用户已经注册
function checkSameEmployee() {
    $("#empName").change(function() {
        var empName = $("#empName").val();
        var APP_PATH = $("#APP_PATH").val();
        $.ajax({
            url : APP_PATH + "/checkSameEmployee",
            data : {
                "empName" : empName
            },
            type : "POST",
            success : function(result) {
                if (result.responseStatus == 200) {
                    show_validate_message($("#empName"), "success", "");
                    $("#btn-save").attr("ajax-value", true);
                } else {
                    show_validate_message($("#empName"), "error", "用户名不可用");
                    $("#btn-save").attr("ajax-value", false);
                }
            }
        })
    });
}

//校验表单数据
function validate() {
    //验证姓名，但是其实验证的格式时用户名
    var empName = $("#empName").val();
    var regName = /^[\u4E00-\u9FA5A-Za-z]+$/;
    if (!regName.test(empName)) {
        show_validate_message($("#empName"), "error", "姓名格式不正确")
        return false;
    } else {
        show_validate_message($("#empName"), "success", "")
    }

    //验证姓名，但是其实验证的格式时用户名
    var email = $("#email").val();
    var regEmail = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    if (!regEmail.test(email)) {
        show_validate_message($("#email"), "error", "邮箱格式不正确")
        return false;
    } else {
        show_validate_message($("#email"), "success", "")
        if ($("#btn-save").attr("ajax-value") == false) {
            return false;
        }
        return true;
    }
}

//显示校验的结果和信息
function show_validate_message(element, status, msg) {
    clear(element);
    if (status == "success") {
        $(element).parent().addClass("has-success");
    }
    if (status == "error") {
        $(element).parent().addClass("has-error");
        $(element).next("span").text(msg);
    }
}

// 每次显示前要清空
function clear(element) {
    $(element).parent().removeClass("has-success");
    $(element).parent().removeClass("has-error");
    $(element).next("span").empty();
}

//获取所有的部门并且显示出来
function getDepts(element) {
    var APP_PATH = $("#APP_PATH").val();
    $.ajax({
        url : APP_PATH + "/depts",
        type : "GET",
        success : function(result) {
            buildDepts(result, element);
        }
    });
}

// 将查询的部门填充到下拉列表
function buildDepts(result, element) {
    // 注意每次构建前都要清空
    $(element).empty();
    $.each(result.responseData.depts, function(index, item) {
        var deptOption = $("<option></option>").append(item.deptName)
                                               .attr("value", item.deptId)
                                               .appendTo(element);
    })
}

//页面跳转时，渲染页面，加载数据
function toPage(pn) {
    var APP_PATH = $("#APP_PATH").val();
    console.log(APP_PATH);
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
    var emps = result.responseData.pageInfo.list;
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
    $("#page_info").append("当前第" + result.responseData.pageInfo.pageNum +
                            "页,共" + result.responseData.pageInfo.pages +
                            "页,共" + result.responseData.pageInfo.total + "条记录")
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
    if (result.responseData.pageInfo.hasPreviousPage == false) {
        firstPageLi.addClass("disabled");
        prePageLi.addClass("disabled");
    }
    // 跳转首页
    firstPageLi.click(function() {
        toPage(1);
    });
    // 跳转前一页(注意前面虽然禁止了首页跳转,但是只有禁止点击标志,还是可以点击)
    prePageLi.click(function() {
        toPage(result.responseData.pageInfo.pageNum == 1 ? 1 : result.responseData.pageInfo.pageNum - 1)
    });
    //添加首页和前一页
    ul.append(firstPageLi).append(prePageLi);

    //页数的生成与跳转
    $.each(result.responseData.pageInfo.navigatepageNums, function(index, item) {
        var numLi = $("<li></li>").append($("<a></a>").append(item).attr("href", "#"));
        if (result.responseData.pageInfo.pageNum == item) {numLi.addClass("active");}
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
    if (result.responseData.pageInfo.hasNextPage == false) {
        lastPageLi.addClass("disabled");
        nextPageLi.addClass("disabled");
    }
    // 跳转最后一页
    lastPageLi.click(function() {
        toPage(result.responseData.pageInfo.pages);
    });
    // 跳转下一页(注意前面虽然禁止了末页跳转,但是只有禁止点击标志,还是可以点击,或者在pagehelper的配置中设置reasonable属性)
    nextPageLi.click(function() {
            toPage(result.responseData.pageInfo.pageNum == result.responseData.pageInfo.pages
                                                        ? result.responseData.pageInfo.pages
                                                        : result.responseData.pageInfo.pageNum + 1)
    });
    ul.append(nextPageLi).append(lastPageLi);
    var nav = $("<nav></nav>").append(ul);
    $("#page_line").append(nav);
}

// 批量删除
function deleteAll() {
    var empNames = "";
    var delIds = "";
    $.each($(".check_item:checked"), function() {
        empNames += $(this).parents("tr").find("td:eq(2)").text() + ","
        delIds += $(this).parents("tr").find("td:eq(1)").text() + "-";
    })
    empNames = empNames.substring(0, empNames.length - 1);
    delIds =delIds.substring(0, delIds.length - 1);
    var flag = confirm("确认删除" + empNames + "?");
    if (flag) {
        var APP_PATH = $("#APP_PATH").val();
        $.ajax({
            url : APP_PATH + "/emp/" + delIds,
            type : "POST",
            data : "_method=delete",
            success : function(result) {
                alert(result.responseMessage);
                toPage(1);// 返回首页
            }
        });
    }
}