package com.huang.Service;
import com.huang.Bean.Department;
import com.huang.Mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentMapper departmentMapper;

    @Transactional(readOnly = true)
    public List<Department> selectAllDepartment() {
        return departmentMapper.selectByExample(null);
    }
}
