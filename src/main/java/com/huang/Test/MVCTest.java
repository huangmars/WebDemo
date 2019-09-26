package com.huang.Test;
import com.github.pagehelper.PageInfo;
import com.huang.Bean.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations= {"classpath:applicationContext.xml","classpath:applicationContext-Mvc.xml"})
public class MVCTest {

    @Autowired
    WebApplicationContext context;
    MockMvc mockMvc;

    @Before
    public void init() {
        mockMvc= MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testPage() {
        try {
            MvcResult result=mockMvc.perform(MockMvcRequestBuilders.get("/emps")
                                    .param("pageNum","1"))
                                    .andReturn();

            //请求成功后请求域中有pageInfo对象
            MockHttpServletRequest request=result.getRequest();
            PageInfo pageInfo=(PageInfo) request.getAttribute("pageInfo");
            System.out.println("当前页码"+pageInfo.getPageNum());
            System.out.println("总页码数"+pageInfo.getPages());
            System.out.println("总记录数"+pageInfo. getTotal());

            List<Employee> employees=pageInfo.getList();
            for(Employee employee:employees) {
                System.out.println(employee.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
