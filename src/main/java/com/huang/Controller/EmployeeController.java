package com.huang.Controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huang.Bean.Employee;
import com.huang.Bean.ResponseMessageBean;
import com.huang.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.logging.Logger;


@Controller
public class EmployeeController {

    private Logger logger = Logger.getLogger("EmployeeController.class");

    @Autowired
    private EmployeeService employeeService;


    @RequestMapping(value = "/emps")
    @ResponseBody
    public ResponseMessageBean findUser(@RequestParam(defaultValue = "1", name = "pageNum") Integer pageNum){
        //创建PageHelper，后面紧跟的查询为分页查询
        PageHelper.startPage(pageNum, 5);
        List<Employee> empsList = employeeService.selectAllEmployee();
        logger.info(empsList.toString());

        //判断结果，并返回
        if (empsList.isEmpty()){
            return ResponseMessageBean.Handlefailure();
        }else {
            //用pageInfo封装查询结果，然后交给页面
            PageInfo pageInfo=new PageInfo(empsList,5);
            return ResponseMessageBean.Handlesuccess().addresponseData("pageInfo",pageInfo);
        }
    }



    /*@RequestMapping(value = "/emps")
    public String findUser(@RequestParam(defaultValue = "1", name = "pageNum") Integer pageNum, Model model){
        //创建PageHelper，后面紧跟的查询为分页查询
        PageHelper.startPage(pageNum, 5);
        List<Employee> empsList = employeeService.selectAllEmployee();
        logger.info(empsList.toString());
        //用pageInfo封装查询结果，然后交给页面
        PageInfo pageInfo = new PageInfo(empsList, 5);
        model.addAttribute("pageInfo",pageInfo);
        return "list";
    }*/
}
