package com.huang.Service;
import com.huang.Bean.Employee;
import java.util.List;

public interface EmployeeService {
    public void addEmployee(Employee employee);
    public Employee selectEmployeeById(Integer id);
    public List<Employee> selectAllEmployee();
}
