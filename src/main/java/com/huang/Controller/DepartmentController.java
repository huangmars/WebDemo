package com.huang.Controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huang.Bean.Department;
import com.huang.Bean.Employee;
import com.huang.Bean.ResponseMessageBean;
import com.huang.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.logging.Logger;


@Controller
public class DepartmentController {

    private Logger logger = Logger.getLogger("DepartmentController.class");

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/depts")
    @ResponseBody
    public ResponseMessageBean selectAllDepartment(){
        List<Department> departments = departmentService.selectAllDepartment();
        logger.info(departments.toString());
        //判断结果，并返回
        if (departments.isEmpty()){
            return ResponseMessageBean.Handlefailure();
        }else {
            return ResponseMessageBean.Handlesuccess().addresponseData("depts",departments);
        }
    }


}
