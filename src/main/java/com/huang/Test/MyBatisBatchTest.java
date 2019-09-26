package com.huang.Test;
import com.huang.Bean.Employee;
import com.huang.Mapper.EmployeeMapper;
import com.huang.Service.EmployeeService;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.logging.Logger;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class MyBatisBatchTest {
    private Logger logger = Logger.getLogger("MyBatisBatchTest.class");

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private SqlSession sqlSessionbatch;


    @Test
    public void MyBatisBatchTest01(){
        EmployeeMapper employeeMapper = sqlSessionbatch.getMapper(EmployeeMapper.class);
        for (int i = 1; i < 11; i++) {
			employeeMapper.insertSelective(new Employee(null, "HWYQQ"+i, "F", "huang"+i+"@qq.com", 3));
		}
        logger.info("插入完成");

        List<Employee> employees = employeeMapper.selectByExample(null);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
