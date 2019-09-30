package com.huang.Service;
import com.huang.Bean.Employee;
import com.huang.Bean.EmployeeExample;
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
    public int addEmployee(Employee employee) {
        return employeeMapper.insertSelective(employee);
    }

    @Transactional(readOnly = true)
    public Employee selectEmployeeById(Integer id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    @Transactional(readOnly = true)
    public List<Employee> selectAllEmployee() {
        return employeeMapper.selectByExampleWithDept(null);
    }

    @Transactional(readOnly = true)
    public boolean checkEmployee(String empname) {
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.createCriteria().andEmpNameEqualTo(empname);
        long count = employeeMapper.countByExample(employeeExample);
        return count == 0;
    }

    @Override
    public int deleteEmployeeById(Integer id) {

        return employeeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteEmployeeBatch(List<Integer> ids) {
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.createCriteria().andEmpIdIn(ids);
        return employeeMapper.deleteByExample(employeeExample);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeMapper.updateByPrimaryKeySelective(employee);
    }


}
