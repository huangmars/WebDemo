package com.huang.Controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huang.Bean.Employee;
import com.huang.Bean.ResponseMessageBean;
import com.huang.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.BindException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;


@Controller
public class EmployeeController {

    private Logger logger = Logger.getLogger("EmployeeController.class");

    @Autowired
    private EmployeeService employeeService;


    /**
     * @param
     * @return Message
     * @description:单个批量删除 单个删除:1 批量删除:1-2-3
     */
    @DeleteMapping(value = "/emp/{ids}")
    @ResponseBody
    public ResponseMessageBean deleteEmployee(@PathVariable("ids") String ids) {
        int count = 0;
        if (ids.contains("-")){
            List<Integer> emp_ids = new ArrayList<>();
            String[] ids_str = ids.split("-");
            for (String id_str :ids_str){
                emp_ids.add(Integer.parseInt(id_str));
            }
            count = employeeService.deleteEmployeeBatch(emp_ids);
        }else {
            count = employeeService.deleteEmployeeById(Integer.parseInt(ids));
        }

        if (count !=0){
            return ResponseMessageBean.Handlesuccess();

        }else {
            return ResponseMessageBean.Handlefailure();
        }
    }

   /* 员工更新 这里ajax请求直接发put请求而不是post请求,那么所有的参数都会获取不到,因为tomcat只会封装post的数据
    也就是说request.getParameter("empId")为空,springmvc也无法封装Bean
    解决方法: 1.发送post方法,通过HiddenHttpMethodFilter
            2.发送put请求,通过HttpPutFormContentFilter*/
    //此处url参数为empId，要与实体类一致，才能封装，否则id不能传递进来，为null
    @PutMapping(value = "/emp/{empId}")
    @ResponseBody
    public ResponseMessageBean UpdateEmployee(Employee employee) {
        logger.info(employee.toString());
        employeeService.updateEmployee(employee);
        return ResponseMessageBean.Handlesuccess();
    }


    @PostMapping(value = "/checkSameEmployee")
    @ResponseBody
    public ResponseMessageBean checkEmployee(String empName){
        boolean res = employeeService.checkEmployee(empName);
        if (res){
            return ResponseMessageBean.Handlesuccess();
        }else {
            return ResponseMessageBean.Handlefailure();
        }
    }

    @GetMapping(value = "/emp/{id}")
    @ResponseBody
    public ResponseMessageBean getEmployee(@PathVariable("id") Integer id){
        Employee employee = employeeService.selectEmployeeById(id);
        if (employee!=null){
            return ResponseMessageBean.Handlesuccess().addresponseData("emp",employee);
        }else {
            return ResponseMessageBean.Handlefailure();
        }
    }

    @PostMapping(value = "/emp")
    @ResponseBody
    public ResponseMessageBean addEmployee(@Valid Employee employee, BindingResult result){
        if (result.hasErrors()){
            HashMap<String,Object> errorHashMap = new HashMap<>();
            for(FieldError fieldError : result.getFieldErrors()){
                errorHashMap.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return ResponseMessageBean.Handlefailure().addresponseData("error",errorHashMap);
        }

        System.out.println(employee.toString());
        int count = employeeService.addEmployee(employee);
        if (count==1){
           return ResponseMessageBean.Handlesuccess();

        }else {
           return ResponseMessageBean.Handlefailure();
        }
    }

    @RequestMapping(value = "/emps")
    @ResponseBody
    public ResponseMessageBean findEmployee(@RequestParam(defaultValue = "1", name = "pageNum") Integer pageNum){
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
