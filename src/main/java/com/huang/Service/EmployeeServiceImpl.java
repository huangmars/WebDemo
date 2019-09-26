package com.huang.Service;
import com.huang.Bean.Employee;
import com.huang.Mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public void addEmployee(Employee employee) {
        employeeMapper.insertSelective(employee);
    }

    @Transactional(readOnly = true)
    public Employee selectEmployeeById(Integer id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    @Transactional(readOnly = true)
    public List<Employee> selectAllEmployee() {
        return employeeMapper.selectByExampleWithDept(null);
    }
}
