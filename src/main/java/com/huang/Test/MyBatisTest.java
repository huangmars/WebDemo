package com.huang.Test;
import com.huang.Bean.Department;
import com.huang.Mapper.DepartmentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;


public class MyBatisTest {

    /*由于mybatis跟spring整合，"Mybatis-Config.xml"配置文件不能加载了，此测试不能用了*/
    @Test
    public void MyBatisTest() throws IOException {
        String resource = "Mybatis-Config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
        Department department = mapper.selectByPrimaryKey(1);
        System.out.println(department.getDeptName());
    }
}
